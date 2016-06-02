package com.wesley.imagemarker;

import com.wesley.imagemarker.builder.BookCoverBuilder;



public class Main {

	public static void main(String[] args){	    	   
			String content = "若天压我，劈开那天，若地拘我，踏碎那地，我等生来自由身，谁敢高高在上.";
			String title = "悟空传·今何在";
			String cover = "/data/imagemaker/images/s9026255.jpg";
			String targetFilePath = "/data/imagemaker/output/bookcover.jpg";			
			Templet templet = BookCoverBuilder.build(content,cover,title);
			ImageMaker maker = ImageRender.templet(templet);
			maker.build(targetFilePath);				     	     
	}
}
