package com.wesley.imagemarker;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.wesley.imagemarker.builder.BookCoverBuilder;
import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;



public class Main {

	public static void main(String[] args){

	     
	     
		try {
			String content = "若天压我，劈开那天，若地拘我，踏碎那地，我等生来自由身，谁敢高高在上.";
			String cover = "f:\\img\\s9026255.jpg";
			String targetFilePath = "f:\\img\\bookcover.jpg";

			Templet templet = BookCoverBuilder.build(content,cover);
			ImageMaker.build(templet,targetFilePath);
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	}
}
