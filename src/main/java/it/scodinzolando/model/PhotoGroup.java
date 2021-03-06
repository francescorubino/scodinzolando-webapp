package it.scodinzolando.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PHOTOGROUP")
public class PhotoGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME", length = 4000)
	private String name;
	
	@Column(name = "DESCRIPTION", length = 4000)
	private String description;

	@OneToMany(mappedBy = "photoGroup", cascade = CascadeType.ALL)
	private List<Photo> photos = new ArrayList<Photo>();

	@Column(name = "FACEBOOK_ID", length = 4000)
	private String facebookId; 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public PhotoGroup() {
		super();
	}

	public PhotoGroup(long id) {
		super();
		this.id = id;
	}

}
