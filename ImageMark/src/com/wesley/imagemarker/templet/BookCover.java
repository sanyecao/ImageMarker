package com.wesley.imagemarker.templet;

import com.wesley.imagemarker.Coordinate;
import com.wesley.imagemarker.Material;
import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;
import com.wesley.imagemarker.resource.FontResource;
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
		ImageResource image = new ImageResource();
		image.load(cover);
		Coordinate start = new Coordinate(0,0);
		ImageElement coverElement = new ImageElement(image,start,null,true);
		material.putImage(coverElement);
		TextResource text = new TextResource();
		text.setDirection(2);
		text.load(content);
		FontResource font = new FontResource();
		String fontPath = "f:\\img\\fonts\\方正宋刻本秀楷简体 - 副本.ttf";
		font.load(fontPath).setFontSize(20f);;
		text.setFont(font);
		TextElement contentElement = new TextElement(text,null,null,true);
		contentElement.setStart(new Coordinate(263,20));
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
