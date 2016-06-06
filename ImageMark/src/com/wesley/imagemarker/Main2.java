package com.wesley.imagemarker;

import com.wesley.imagemarker.builder.Love;



public class Main2 {

	public static void main(String[] args){	    	   
			String content = "执子之手与子偕老执子之手与子偕老执子之手与子偕老";
			String targetFilePath = "/data/imagemaker/output/love.jpg";			
			Templet templet = Love.build(content);
			ImageMaker maker = ImageRender.templet(templet);
			maker.build(targetFilePath);				     	     
	}
}
