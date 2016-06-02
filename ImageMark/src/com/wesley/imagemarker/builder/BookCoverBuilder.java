package com.wesley.imagemarker.builder;

import java.awt.Color;

import com.wesley.imagemarker.Templet;
import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;
import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;
import com.wesley.imagemarker.resource.TextResource.Direction;

public class BookCoverBuilder {
	private static Templet templet;
	private static int width = 460;
	private static int height = 460;
	private static Color bg = Color.black;
	private static String fontPath = "/data/imagemaker/fonts/zh/msjhbd.ttc";
	
    public static Templet build(String content,String cover){
        TextResource contentResource = TextElement.text(content).font(fontPath, 20f).color(Color.black).wdith(150).height(450).start(277, 5).direction(Direction.LTR);
        ImageResource coverResource = ImageElement.image(cover).start(0,0).responsive(false);
        templet = new Templet().width(width).height(height).background(bg);
        templet.put(contentResource);
        templet.put(coverResource);
    	return templet;
    }

}
