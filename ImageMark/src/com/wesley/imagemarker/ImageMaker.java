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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;
import com.wesley.imagemarker.resource.TextResource.Align;
import com.wesley.imagemarker.resource.TextResource.Format;

public class ImageMaker {


	private  Templet templet;
	
	public  ImageMaker templet(Templet templet){
		this.templet = templet;
		return this;
	}
	
	private List<Map<String,Object>> analyzeContent(Graphics2D g,TextResource text){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		char[] chars = text.getContent().toCharArray();
		if(text.getFont()!=null){
        	g.setFont(text.getFont().getResource()); 
        }else{
        	g.setFont(new Font("宋体",0,10));
        }
		int tw = text.getWidth();
		int th = text.getHeight();
		FontMetrics fm = g.getFontMetrics();
		String line = "";
		Double lw = 0d;
		Double lh = 0d;
		for(char cha : chars){
			Rectangle2D rc = fm.getStringBounds(String.valueOf(cha), g);
			if(text.getFormat() == Format.HORIZONAL){
				if((lw+rc.getWidth())>tw){ //换行
					Map<String,Object> data = new HashMap<String,Object>();
					data.put("width", lw);
					data.put("height", lh);
					data.put("content", line);
					list.add(data);
					lw = 0d;
					line = "";
				}
				line +=String.valueOf(cha);
				lh = rc.getHeight();
				lw+=(rc.getWidth()+text.getSpace());
			}else{
				if((lh+rc.getHeight())>th){ //换行
					Map<String,Object> data = new HashMap<String,Object>();
					data.put("width", lw);
					data.put("height", lh);
					data.put("content", line);
					list.add(data);
					lh = 0d;
					line = "";
				}
				line +=String.valueOf(cha);
				lh += (rc.getHeight()+text.getSpace());
				lw = rc.getWidth();
			}
			
			
		}
		if(!line.isEmpty()){
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("width", lw);
			data.put("height", lh);
			data.put("content", line);
			list.add(data);
		}
		
		
		return list;
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
	        	List<Map<String,Object>> list =  analyzeContent(g, text);
	        	System.out.println(list.size());
	        	//水平方向
	        	FontMetrics fm = g.getFontMetrics();
	        	if(text.getFormat() == Format.HORIZONAL){
	        		for(Map<String,Object> line : list){
	        			double lineHeight = (double)line.get("height");
	        			double lineWidth = (double)line.get("width");
	        			System.out.println(lineWidth);
	        			int x = cx;
	        			if(text.getAlgin() == Align.CENTER){
	        				x = x + (int)((double)text.getWidth()-lineWidth)/2;
	        			}
	        			char[] lchars = line.get("content").toString().toCharArray();
	        			for(char cha : lchars){
			        	    Rectangle2D rc = fm.getStringBounds(String.valueOf(cha), g);
			        	    System.out.println(rc.getWidth()+":"+rc.getHeight());
			        	    System.out.println(cha);
			        	    double wordWidth = rc.getWidth() + text.getSpace();
			        	    double wordHeight = rc.getHeight() > text.getLineHeight()?rc.getHeight():text.getLineHeight();

			        	    g.drawString(String.valueOf(cha), x, (int)(cy + wordHeight));
			        	    x = (int)(x + wordWidth); 

	        			}
	        			
	        			cy += lineHeight;
	        		}
	 
	        	}else if(text.getFormat() == Format.VERTICAL){     //垂直 方向
	        		for(Map<String,Object> line : list){
	        			double textHeight = (double)line.get("height");
	        			char[] lchars = line.get("content").toString().toCharArray();
	        			int y = cy;
	        			if(text.getAlgin() == Align.CENTER){
	        				y = y + (int)((text.getHeight()-textHeight)/2);
	        			}
	        			
	        			int ww = 0;
	        			
	        			for(char cha : lchars){
			        	    Rectangle2D rc = fm.getStringBounds(String.valueOf(cha), g);
			        	    System.out.println(rc.getWidth()+":"+ rc.getHeight());
			        	    System.out.println(cha);
			        	    double _wordHeight = rc.getHeight() + text.getSpace();
			        	    double _wordWidth = rc.getWidth() > text.getLineHeight()?rc.getWidth():text.getLineHeight();
			        	   
			        	    g.drawString(String.valueOf(cha), cx, (int)(y + _wordHeight));
			        	    y = (int)(y + _wordHeight);   
			        	    ww = (int)_wordWidth;
			        	} 
	        			cx += ww;
	        			
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
	        FontMetrics fm = g.getFontMetrics();
	        Rectangle2D rc = fm.getStringBounds(sign, g);
    	    System.out.println(rc.getWidth()+":"+ rc.getHeight());
        	g.setColor(signature.getColor());
        	/* 消除java.awt.Font字体的锯齿 */  
        	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
        	g.drawString(sign, templet.getWidth()-40, templet.getHeight()-3);   
	        g.dispose();
		    FileOutputStream out = new FileOutputStream(targetPath);  
		    ImageIO.write(bImage, "jpg", out);
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

}
