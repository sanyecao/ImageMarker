package com.wesley.imagemarker;

import java.util.ArrayList;
import java.util.List;

import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;
import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;

public class Material {

	private List<ImageResource> images;
	private List<TextResource> texts;
	
	public Material(){
		images = new ArrayList<ImageResource>();
		texts = new ArrayList<TextResource>();
	}
	
	public Material putImage(ImageResource image){
		images.add(image);
		return this;
	}
	
	public Material putText(TextResource text){
		texts.add(text);
		return this;
	}
	
	public List<ImageResource> getImages(){
		return images;
	}
	public Material setImages(List<ImageResource> images){
		this.images = images;
		return this;
	}
	public List<TextResource> getTexts(){
		return texts;
	}
	public Material setTexts(List<TextResource> texts){
		this.texts = texts;
		return this;
	}


}
