package com.wesley.imagemarker;

import java.util.ArrayList;
import java.util.List;

import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;

public class Material {

	private List<ImageElement> images;
	private List<TextElement> texts;
	
	public Material(){
		images = new ArrayList<ImageElement>();
		texts = new ArrayList<TextElement>();
	}
	
	public Material putImage(ImageElement image){
		images.add(image);
		return this;
	}
	
	public Material putText(TextElement text){
		texts.add(text);
		return this;
	}
	
	public List<ImageElement> getImages(){
		return images;
	}
	public Material setImages(List<ImageElement> images){
		this.images = images;
		return this;
	}
	public List<TextElement> getTexts(){
		return texts;
	}
	public Material setTexts(List<TextElement> texts){
		this.texts = texts;
		return this;
	}


}
