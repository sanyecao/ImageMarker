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

public class ImageMaker {


	private  Templet templet;
	
	public  ImageMaker templet(Templet templet){
		this.templet = templet;
		return this;
	}
	
	public  ImageMaker build(String targetPath){
		
		try {


			List<ImageResource> images = templet.getImages();
			List<TextResource> texts = templet.getTexts();
			BufferedImage bImage = new BufferedImage(templet.getWidth(), templet.getHeight(), BufferedImage.TYPE_INT_RGB);  
	        Graphics2D g = bImage.createGraphics();  
	        g.setPaint(Color.white);
	        g.fillRect(0, 0, templet.getWidth(), templet.getHeight());
	        for(ImageResource image : images){
	        	Image img = image.getResource(); 
	            g.setBackground(Color.white); 
	            g.drawImage(img, image.getStart().getX(), image.getStart().getY(), null);  
	        }
	        for(TextResource text : texts){
	        	char[] chars = text.getContent().toCharArray();
	        	 g.setFont(text.getFont().getResource()); 
	        	 g.setColor(text.getColor());
	        	    /* 消除java.awt.Font字体的锯齿 */  
	        	     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
	        	     FontMetrics fm = g.getFontMetrics();
	        	     //文字开始位置
	        	     int sx = text.getStart().getX();
	        	     int sy = text.getStart().getY();
	        	     //文字当前位置
	        	     int cx = sx;
	        	     int cy = sy;
	        	     //文字间距
	        	     int space = 5;
	        	     for(char cha : chars){
	        	    	 Rectangle2D rc = fm.getStringBounds(""+cha, g);
	        	         System.out.println(rc.getWidth()+":"+rc.getHeight());
	        	         System.out.println(cha);
	        	         //超过高度换行
	        	         if((int)(cy +rc.getHeight())>templet.getHeight()){
	        	        	 cx = (int)(cx+rc.getWidth()+space);
	        	        	 cy = sy; 
	        	         }
	        	         g.drawString(""+cha, cx, (int) (cy+rc.getHeight()));
	        	         cy = (int)(cy +rc.getHeight());
	        	         
	        	     }

	        	   
	        }
	        g.dispose();
		    FileOutputStream out = new FileOutputStream(targetPath);  
		    ImageIO.write(bImage, "jpg", out);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

}
