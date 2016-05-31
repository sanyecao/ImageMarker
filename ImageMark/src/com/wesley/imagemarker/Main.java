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

import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;
import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;
import com.wesley.imagemarker.templet.BookCover;



public class Main {

	public static void main(String[] args){

	     
	     
		try {
			String content = "因为我想活着，我不能掩藏我心中的本欲，正如我心中爱你美丽,又怎能嘴上装四大皆空。";
			String cover = "f:\\img\\14800.jpg";
			String targetFilePath = "f:\\img\\bookcover.jpg";
			int w = 573;
			int h = 573;
			BookCover bookCover = new BookCover(cover,content,w,h);
			List<ImageResource> images = bookCover.getMaterial().getImages();
			List<TextResource> texts = bookCover.getMaterial().getTexts();
			BufferedImage bImage = new BufferedImage(bookCover.getW(), bookCover.getH(),  BufferedImage.TYPE_INT_RGB);  
	        Graphics2D g = bImage.createGraphics();  
	        g.setPaint(Color.white);
	        g.fillRect(0, 0, bookCover.getW(), bookCover.getH());
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
	        	         if((int)(cy +rc.getHeight())>bookCover.getH()){
	        	        	 cx = (int)(cx+rc.getWidth()+space);
	        	        	 cy = sy; 
	        	         }
	        	         g.drawString(""+cha, cx, (int) (cy+rc.getHeight()));
	        	         cy = (int)(cy +rc.getHeight());
	        	         
	        	     }

	        	   
	        }
	        g.dispose();
		    FileOutputStream out = new FileOutputStream(targetFilePath);  
		    ImageIO.write(bImage, "jpg", out);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	}
}
