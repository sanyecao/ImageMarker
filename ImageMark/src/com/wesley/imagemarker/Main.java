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
		String markContent = "��վ�����Ͽ��羰\n ���羰������¥�Ͽ���\n ����װ������Ĵ���\n ��װ���˱��˵���";
		String souchFilePath = "f:\\img\\14800.jpg"; 
		String targetFilePath = "f:\\img\\target.jpg";
		Color markContentColor = Color.black;
		/* ����Ҫ�����ԴͼƬ */  
		 /* ��ȡҪ�����ͼƬ */  
	     ImageResource imageResource = new ImageResource();
	     imageResource.load(souchFilePath);
	     Image image = imageResource.getResource();
	    

	     // Image���Ի��ͼƬ��������Ϣ  
	     int width = image.getWidth(null);  
	     int height = image.getHeight(null);  
	     // Ϊ������ԴͼƬ����ͬ��С��ͼƬ�������Լ����壩  
	     BufferedImage bImage = new BufferedImage(height, height,  
	                     BufferedImage.TYPE_INT_RGB);  
	     // ����2D����  
	     Graphics2D g = bImage.createGraphics();  
	     //����ɫ����
	     g.setPaint(Color.white);
	     g.fillRect(0, 0, height, height);
	     /* ����2D���ʵĻ�����������ɫ */  
	     g.setColor(markContentColor);  
	     /* ����2D���ʵĻ��������ֱ���ɫ */  
	     g.setBackground(Color.white); 
	     
	     /* ����ͼƬ */  
	     g.drawImage(image, 0, 0, null);  
	     char[] chars = markContent.toCharArray();
	     /* --------��Ҫ��ʾ�����ֽ��д���-------------- */  
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
		    /* ����java.awt.Font����ľ�� */  
		     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
		     FontMetrics fm = g.getFontMetrics();
		     //���ֿ�ʼλ��
		     int sx = width+20;
		     int sy = 10;
		     //���ֵ�ǰλ��
		     int cx = sx;
		     int cy = sy;
		     //���ּ��
		     int space = 5;
		     for(char cha : chars){
		    	 Rectangle2D rc = fm.getStringBounds(""+cha, g);
		         System.out.println(rc.getWidth()+":"+rc.getHeight());
		         System.out.println(cha);
		         //�����߶Ȼ���
		         if((int)(cy +rc.getHeight())>height){
		        	 cx = (int)(cx+rc.getWidth()+space);
		        	 cy = sy; 
		         }
		         g.drawString(""+cha, cx, (int) (cy+rc.getHeight()));
		         cy = (int)(cy +rc.getHeight());
		         
		     }

		     g.dispose();// ���ʽ���  
		     FileOutputStream out = new FileOutputStream(targetFilePath);  
		     ImageIO.write(bImage, "jpg", out);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	}
}
