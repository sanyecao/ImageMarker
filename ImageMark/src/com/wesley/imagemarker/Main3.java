package com.wesley.imagemarker;

import com.wesley.imagemarker.builder.Future;



public class Main3 {

	public static void main(String[] args){	    	   
			String content = "逝去的东西 最好不想最好不念";
			String targetFilePath = "/data/imagemaker/output/future.jpg";			
			Templet templet = Future.build(content);
			ImageMaker maker = ImageRender.templet(templet);
			maker.build(targetFilePath);				     	     
	}
}
