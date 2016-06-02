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
import java.util.List;

import javax.imageio.ImageIO;

import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;
import com.wesley.imagemarker.resource.TextResource.Format;

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
	        FontMetrics fm = g.getFontMetrics();
	        for(ImageResource image : images){
	        	Image img = image.getResource(); 
	            g.setBackground(Color.white); 
	            g.drawImage(img, image.getStart().getX(), image.getStart().getY(), null);  
	        }
	        for(TextResource text : texts){
	        	char[] chars = text.getContent().toCharArray();
	        	if(text.getFont()!=null){
		        	g.setFont(text.getFont().getResource()); 
		        }else{
		        	g.setFont(new Font("宋体",0,10));
		        }
	        	g.setColor(text.getColor()!=null?text.getColor():Color.black);
	        	/* 消除java.awt.Font字体的锯齿 */  
	        	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
	        	
	        	//文字开始位置
	        	int sx = text.getStart().getX();
	        	int sy = text.getStart().getY();
	        	//文字当前位置
	        	int cx = sx;
	        	int cy = sy;
	        	
	        	int cw = 0;
	        	int ch = 0;
	        	//水平方向
	        	if(text.getFormat() == Format.HORIZONAL){
	        		for(char cha : chars){
		        	    Rectangle2D rc = fm.getStringBounds(String.valueOf(cha), g);
		        	    System.out.println(rc.getWidth()+":"+rc.getHeight());
		        	    System.out.println(cha);
		        	    double wordWidth = rc.getWidth() + text.getSpace();
		        	    double wordHeight = rc.getHeight() > text.getLineHeight()?rc.getHeight():text.getLineHeight();
		        	    //超过宽度换行
		        	    if((int)(cw +rc.getWidth())>text.getWidth()){
		        	        cy = (int)(cy + wordHeight);
		        	        ch = (int)(cy + wordHeight);
		        	        cx = sx; 
		        	        cw = 0;
		        	    }
		        	    g.drawString(String.valueOf(cha), cx, (int)(cy + wordHeight));
		        	    cx = (int)(cx + wordWidth); 
		        	    cw = (int)(cw + wordWidth);  
		        	    System.out.println(cw);
		        	}   
	        	}else if(text.getFormat() == Format.VERTICAL){     //垂直 方向
	        		for(char cha : chars){
		        	    Rectangle2D rc = fm.getStringBounds(String.valueOf(cha), g);
		        	    System.out.println(rc.getWidth()+":"+ rc.getHeight());
		        	    System.out.println(cha);
		        	    double wordHeight = rc.getHeight() + text.getSpace();
		        	    double wordWidth = rc.getWidth() > text.getLineHeight()?rc.getWidth():text.getLineHeight();
		        	    //超过高度换行
		        	    if((int)(ch + wordHeight ) > text.getHeight()){
		        	        cx = (int)(cx + wordWidth);
		        	        cy = sy; 
		        	        ch = 0;
		        	    }
		        	    g.drawString(String.valueOf(cha), cx, (int)(cy + wordHeight));
		        	    cy = (int)(cy + wordHeight);  
		        	    ch = (int)(ch + wordHeight);  
		        	}    
	        	} 
	        	    	   
	        }
	        TextResource signature = templet.getSignature();
	        String sign = signature.getContent();
	        if(signature.getFont()!=null){
	        	g.setFont(signature.getFont().getResource()); 
	        }else{
	        	g.setFont(new Font("宋体",0,10));
	        }
        	
        	g.setColor(signature.getColor());
        	/* 消除java.awt.Font字体的锯齿 */  
        	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
        	g.drawString(sign, templet.getWidth()-50, templet.getHeight()-10);   
	        g.dispose();
		    FileOutputStream out = new FileOutputStream(targetPath);  
		    ImageIO.write(bImage, "jpg", out);
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

}
