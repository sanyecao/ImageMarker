package com.wesley.imagemarker.builder;

import java.awt.Color;

import com.wesley.imagemarker.Templet;
import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;
import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;
import com.wesley.imagemarker.resource.TextResource.Align;
import com.wesley.imagemarker.resource.TextResource.Direction;
import com.wesley.imagemarker.resource.TextResource.Format;

public class Love {
	private static Templet templet;
	private static int width = 700;
	private static int height = 1244;
	private static Color bg = Color.black;
	private static String fontPath = "/data/imagemaker/fonts/zh/swsfxfjt.ttf";
	private static String cover = "/data/imagemaker/images/bg2.jpg";
	
    public static Templet build(String content){
        TextResource contentResource = TextElement.text(content).font(fontPath, 54f).color(new Color(100,100,100)).align(Align.LEFT).lineHeight(58).wdith(600).height(450).start(50, 740).format(Format.HORIZONAL).direction(Direction.LTR);
        
        ImageResource coverResource = ImageElement.image(cover).start(0,0).responsive(false);
        templet = new Templet().width(width).height(height).background(bg);
        templet.put(contentResource);
        templet.put(coverResource);
    	return templet;
    }

}
