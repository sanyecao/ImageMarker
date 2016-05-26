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
	
	public BookCover(String cover,String content){
		this.cover = cover;
		this.content = content;
		ImageResource image = new ImageResource();
		image.load(cover);
		Coordinate start = new Coordinate(0,0);
		ImageElement coverElement = new ImageElement(image,start,null,true);
		material.putImage(coverElement);
		TextResource text = new TextResource();
		text.load(content);
		FontResource font = new FontResource();
		String fontPath = "f:\\img\\fonts\\zhanghaishan.ttf";
		font.load(fontPath).setFontSize(20f);;
		text.setFont(font);
		TextElement contentElement = new TextElement(text,null,null,true);
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

	
	
	
}
