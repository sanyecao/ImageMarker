package com.wesley.imagemarker.resource;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.wesley.imagemarker.Coordinate;

public class ImageResource {

	protected Image image;
	private Coordinate start;
	private Coordinate end;
	private boolean  responsive;
	
	public ImageResource start(int x,int y){
		this.start = new Coordinate(x,y);
		return this;
	}
	public ImageResource end(int x,int y){
		this.end = new Coordinate(x,y);
		return this;
	}
	public ImageResource responsive(boolean responsive){
		this.responsive = responsive;
		return this;
	}

	public ImageResource load(String path) {
	     ImageIcon imageIcon = new ImageIcon(path);  
	     image = imageIcon.getImage();  
	     return this;
	}

	public Image getResource() {
		return image;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Coordinate getStart() {
		return start;
	}
	public void setStart(Coordinate start) {
		this.start = start;
	}
	public Coordinate getEnd() {
		return end;
	}
	public void setEnd(Coordinate end) {
		this.end = end;
	}
	public boolean isResponsive() {
		return responsive;
	}
	public void setResponsive(boolean responsive) {
		this.responsive = responsive;
	}

}
