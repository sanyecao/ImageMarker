package com.wesley.imagemarker.templet;

import java.awt.Color;

import com.wesley.imagemarker.Material;
import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;
import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;

public class BookCover {

	private Material material;
	
	private String cover;
	
	private String content;
	
	private int w;
	
	private int h;
	
	public BookCover(String cover,String content,int w, int h){
		material = new Material();
		this.cover = cover;
		this.content = content;
		this.w = w;
		this.h = h;
		String fontPath = "f:\\img\\fonts\\fzmw.ttf";
		ImageResource coverElement = ImageElement.image(cover).start(0,0).responsive(false);
		material.putImage(coverElement);	
		TextResource contentElement = TextElement.text(content).font(fontPath, 20f).start(297, 5).direction(1).color(Color.black);
		material.putText(contentElement);
	}

	public Material getMaterial(){
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	
	
	
}
