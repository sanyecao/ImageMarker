package com.wesley.imagemarker;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.AttributedString;

import javax.imageio.ImageIO;

import com.wesley.imagemarker.resource.FontResource;
import com.wesley.imagemarker.resource.ImageResource;



public class Main {

	public static void main(String[] args){
		String markContent = "你站在桥上看风景\n 看风景的人在楼上看你\n 明月装饰了你的窗子\n 你装饰了别人的梦";
		String souchFilePath = "f:\\img\\14800.jpg"; 
		String targetFilePath = "f:\\img\\target.jpg";
		Color markContentColor = Color.black;
		/* 构建要处理的源图片 */  
		 /* 获取要处理的图片 */  
	     ImageResource imageResource = new ImageResource();
	     imageResource.load(souchFilePath);
	     Image image = imageResource.getResource();
	    

	     // Image可以获得图片的属性信息  
	     int width = image.getWidth(null);  
	     int height = image.getHeight(null);  
	     // 为画出与源图片的相同大小的图片（可以自己定义）  
	     BufferedImage bImage = new BufferedImage(height, height,  
	                     BufferedImage.TYPE_INT_RGB);  
	     // 构建2D画笔  
	     Graphics2D g = bImage.createGraphics();  
	     //画白色背景
	     g.setPaint(Color.white);
	     g.fillRect(0, 0, height, height);
	     /* 设置2D画笔的画出的文字颜色 */  
	     g.setColor(markContentColor);  
	     /* 设置2D画笔的画出的文字背景色 */  
	     g.setBackground(Color.white); 
	     
	     /* 画出图片 */  
	     g.drawImage(image, 0, 0, null);  
	     char[] chars = markContent.toCharArray();
	     /* --------对要显示的文字进行处理-------------- */  
	     AttributedString ats = new AttributedString(markContent);  
	     
	     
		try {
			FontResource fontResource = new FontResource();
			fontResource.setFontSize(20.0f);
			fontResource.load("f:\\img\\fonts\\yygmb.ttf");
			Font dynamicFontPt = fontResource.getResource();
			
			/*Font dynamicFont;
			dynamicFont = Font.createFont(Font.TRUETYPE_FONT, new File("f:\\img\\fonts\\yygmb.ttf"));
			Font dynamicFontPt = dynamicFont.deriveFont(1,20.0f);*/
		     
		     g.setFont(dynamicFontPt);  
		    /* 消除java.awt.Font字体的锯齿 */  
		     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
		     FontMetrics fm = g.getFontMetrics();
		     //文字开始位置
		     int sx = width+20;
		     int sy = 10;
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
		         if((int)(cy +rc.getHeight())>height){
		        	 cx = (int)(cx+rc.getWidth()+space);
		        	 cy = sy; 
		         }
		         g.drawString(""+cha, cx, (int) (cy+rc.getHeight()));
		         cy = (int)(cy +rc.getHeight());
		         
		     }

		     g.dispose();// 画笔结束  
		     FileOutputStream out = new FileOutputStream(targetFilePath);  
		     ImageIO.write(bImage, "jpg", out);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	}
}
