package it.scodinzolando.utils;

import it.scodinzolando.model.Photo;

public class FacebookTranslator {

	public static Photo fbToPhoto(org.springframework.social.facebook.api.Photo fbPhoto){
		Photo photo = new Photo();
		photo.setPath(fbPhoto.getSource());
		photo.setName(fbPhoto.getName());
		return photo;
	}
}
