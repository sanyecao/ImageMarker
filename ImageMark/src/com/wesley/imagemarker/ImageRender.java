package com.wesley.imagemarker;

public class ImageRender {

	private Templet templet;
	
	public ImageRender templet(Templet templet){
		this.templet = templet;
		return this;
	}

	public Templet getTemplet() {
		return templet;
	}

	public void setTemplet(Templet templet) {
		this.templet = templet;
	}

}
