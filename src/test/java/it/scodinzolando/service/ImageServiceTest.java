package it.scodinzolando.service;

import it.scodinzolando.ScodinzolandoWebappApplication;
import it.scodinzolando.model.Photo;
import it.scodinzolando.model.PhotoGroup;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ScodinzolandoWebappApplication.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@WebAppConfiguration
public class ImageServiceTest {

	@Inject
	private ImageService imageService;
	
	@Inject
	private PhotoGroupService photoGroupService;
	
	private static final int IMG_WIDTH_BIG = 800;
	private static final int IMG_HEIGHT_BIG = 800;
	private static final int IMG_WIDTH_MEDIUM = 400;
	private static final int IMG_HEIGHT_MEDIUM = 400;

	BufferedImage originalImage;

	@Before
	public void setup() throws IOException {
		originalImage = ImageIO.read(new File("/home/maria/Immagini/foto1.jpg"));

	}

	@Test
	public void test() throws IOException {
		int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		Dimension dimension = imageService.getScaledDimension(originalImage.getWidth(), originalImage.getHeight(), IMG_WIDTH_BIG, IMG_HEIGHT_BIG );

		BufferedImage resizeImageJpg = imageService.resizeImage(originalImage, type, (int) dimension.getWidth(), (int) dimension.getHeight());
		ImageIO.write(resizeImageJpg, "jpg", new File("/home/maria/Immagini/foto1_resize.jpg"));

		BufferedImage resizeImagePng = imageService.resizeImage(originalImage, type, (int) dimension.getWidth(), (int) dimension.getHeight());
		ImageIO.write(resizeImagePng, "png", new File("/home/maria/Immagini/foto1_resize.png"));

		BufferedImage resizeImageHintJpg = imageService.resizeImageWithHint(originalImage,type, (int) dimension.getWidth(), (int) dimension.getHeight());
		ImageIO.write(resizeImageHintJpg, "jpg", new File("/home/maria/Immagini/foto1_resize_hint.jpg"));

		BufferedImage resizeImageHintPng = imageService.resizeImageWithHint(originalImage,type, (int) dimension.getWidth(), (int) dimension.getHeight());
		ImageIO.write(resizeImageHintPng, "png", new File("/home/maria/Immagini/foto1_resize_hint.png"));

	}
	
	@Test
	public void testLoadPhoto() throws IOException{
		String dir = "/home/maria/Immagini"; 
		File root = new File(dir);
		for(File folder : root.listFiles()){
			if(folder.isDirectory()){
				int counter = 0;
				PhotoGroup gruppo = new PhotoGroup();
				String folderName = folder.getName();
				gruppo.setName(folderName);
				gruppo.setDescription(folder.getAbsolutePath());
				FilenameFilter filter = new FilenameFilter() {
					
					@Override
					public boolean accept(File dir, String name) {
						return name.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
					}
				};
				for(File file : folder.listFiles(filter)){
					System.out.print("File: " + file.getAbsolutePath() + "...");
					String where = String.format("/tmp/%s", folderName.replaceAll(" ", "_"));
					new File(where).mkdir();
					String filename = String.format("foto_%s.jpg", counter++);
					String path = String.format("%s/%s", where, filename);
					
					createImages(file, where, filename, path);
					
					Photo photo = new Photo();
					photo.setName(filename);
					photo.setPath(String.format("img/scodinzolando/%s", path.replaceFirst("/tmp/", "")));
					photo.setDescription(folderName);
					photo.setPhotoGroup(gruppo);
					gruppo.getPhotos().add(photo);
					System.out.println("    ...Done!");
				}
				
				photoGroupService.createPhotoGroup(gruppo);
			}
		}
	}

	private void createImages(File file, String where, String filename, String path) throws IOException {
		BufferedImage fileImage = ImageIO.read(file);
		int type = fileImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : fileImage.getType();
		
		Dimension dimension = imageService.getScaledDimension(fileImage.getWidth(), fileImage.getHeight(), IMG_WIDTH_BIG, IMG_HEIGHT_BIG);
		BufferedImage resizeImageHintJpg = imageService.resizeImageWithHint(fileImage,type, (int) dimension.getWidth(), (int) dimension.getHeight());
		ImageIO.write(resizeImageHintJpg, "jpg", new File(path));
		
		dimension = imageService.getScaledDimension(fileImage.getWidth(), fileImage.getHeight(), IMG_WIDTH_MEDIUM, IMG_HEIGHT_MEDIUM);
		resizeImageHintJpg = imageService.resizeImageWithHint(fileImage,type, (int) dimension.getWidth(), (int) dimension.getHeight());
		ImageIO.write(resizeImageHintJpg, "jpg", new File(String.format("%s/%s", where, filename.replace(".jpg", "_medium.jpg"))));
	}

	
}
