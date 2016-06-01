package com.wesley.imagemarker;

public class ImageRender {

	private static ImageMaker imageMaker;
	private static Templet templet;
	
	public static ImageMaker templet(Templet templet){
		imageMaker = new ImageMaker().templet(templet);
		return imageMaker;
	}

	public Templet getTemplet() {
		return templet;
	}


}
