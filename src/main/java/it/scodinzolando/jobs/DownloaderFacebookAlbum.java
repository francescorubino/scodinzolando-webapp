package it.scodinzolando.jobs;

import org.springframework.stereotype.Component;

@Component("downloaderFacebookAlbum")
public class DownloaderFacebookAlbum {

	public void downloadPhoto() {
        System.out.println("Scarico nuove foto da facebook..");
    }
}
