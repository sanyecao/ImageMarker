package com.wesley.imagemarker;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;

public class Templet {
	private List<ImageResource> images;
	private List<TextResource> texts;
    private Color backgroundColor;
    private ImageResource backgroundImage;
	private Integer width;	
	private Integer height;
	private TextResource signature = new TextResource().load("三叶草").color(Color.black);
	
	public Templet(){
		images = new ArrayList<ImageResource>();
		texts = new ArrayList<TextResource>();
	}

	public Templet width(int width){
		return setWidth(width);
	}
	public Templet images(List<ImageResource> images){
		return setImages(images);
	}
	
	public Templet texts(List<TextResource> texts){
		return setTexts(texts);
	}
	
	public Templet put(ImageResource image){
		images.add(image);
		return this;
	}
	
    public Templet put(TextResource text){
		texts.add(text);
		return this;
	}

	public Templet height(int height){
		return setHeight(height);
	}
	public Templet background(Color color){
		return setBackgroundColor(color);
	}
	public Templet background(ImageResource image){
		return setBackgroundImage(image);
	}
	public Templet signature(TextResource signature){
		return setSignature(signature);
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public Templet setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		return this;
	}
	public ImageResource getBackgroundImage() {
		return backgroundImage;
	}
	public Templet setBackgroundImage(ImageResource backgroundImage) {
		this.backgroundImage = backgroundImage;
		return this;
	}
	public Integer getWidth() {
		return width;
	}
	public Templet setWidth(Integer width) {
		this.width = width;
		return this;
	}
	public Integer getHeight() {
		return height;
	}
	public Templet setHeight(Integer height) {
		this.height = height;
		return this;
	}
	public TextResource getSignature() {
		return signature;
	}
	public Templet setSignature(TextResource signature) {
		this.signature = signature;
		return this;
	}
	public List<ImageResource> getImages() {
		return images;
	}
	public Templet setImages(List<ImageResource> images) {
		this.images = images;
		return this;
	}
	public List<TextResource> getTexts() {
		return texts;
	}
	public Templet setTexts(List<TextResource> texts) {
		this.texts = texts;
		return this;
	}
	
}
