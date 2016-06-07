package com.wesley.imagemarker.builder;

import java.awt.Color;

import com.wesley.imagemarker.Shadow;
import com.wesley.imagemarker.Templet;
import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;
import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;
import com.wesley.imagemarker.resource.TextResource.Align;
import com.wesley.imagemarker.resource.TextResource.Direction;
import com.wesley.imagemarker.resource.TextResource.Format;

public class Future {
	private static Templet templet;
	private static int width = 380;
	private static int height = 684;
	private static Color bg = Color.black;
	private static String fontPath = "/data/imagemaker/fonts/zh/mnlxj.ttf";
	private static String cover = "/data/imagemaker/images/futurebg.jpg";
	
    public static Templet build(String content){

        TextResource contentResource = TextElement.text(content).font(fontPath, 35f).color(Color.white).shadow(new Shadow(2,2,Color.gray)).align(Align.CENTER).lineHeight(45).wdith(300).height(450).start(40, 140).format(Format.HORIZONAL).direction(Direction.LTR);
        
        ImageResource coverResource = ImageElement.image(cover).start(0,0).responsive(false);
        templet = new Templet().width(width).height(height).background(bg);
        templet.put(contentResource);
        templet.put(coverResource);
    	return templet;
    }

}
