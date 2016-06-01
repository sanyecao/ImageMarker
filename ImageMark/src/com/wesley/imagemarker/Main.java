package com.wesley.imagemarker;

import com.wesley.imagemarker.builder.BookCoverBuilder;



public class Main {

	public static void main(String[] args){

	     
	     
		try {
			String content = "若天压我，劈开那天，若地拘我，踏碎那地，我等生来自由身，谁敢高高在上.";
			String cover = "f:\\img\\s9026255.jpg";
			String targetFilePath = "f:\\img\\bookcover.jpg";

			Templet templet = BookCoverBuilder.build(content,cover);
			ImageMaker maker = ImageRender.templet(templet);
			maker.build(targetFilePath);
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	}
}
