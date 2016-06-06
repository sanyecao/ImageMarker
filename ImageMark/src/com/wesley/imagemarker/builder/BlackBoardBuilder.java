package com.wesley.imagemarker.builder;

import java.awt.Color;

import com.wesley.imagemarker.Templet;
import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;
import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;
import com.wesley.imagemarker.resource.TextResource.Direction;
import com.wesley.imagemarker.resource.TextResource.Format;

public class BlackBoardBuilder {
	private static Templet templet;
	private static int width = 500;
	private static int height = 750;
	private static Color bg = Color.black;
	private static String fontPath = "/data/imagemaker/fonts/zh/senty.ttf";
	
    public static Templet build(String content){
    	String cover = "/data/imagemaker/templates/templateb/1.jpg";
        TextResource contentResource = TextElement.text(content).font(fontPath, 26f).space(20).color(Color.white).lineHeight(38).wdith(400).height(450).start(50, 250).format(Format.HORIZONAL).direction(Direction.LTR);
        //TextResource titleResource = TextElement.text(title).font(fontPath, 10f).color(Color.gray).wdith(150).height(450).start(440, 5).format(Format.VERTICAL).direction(Direction.LTR);
        ImageResource coverResource = ImageElement.image(cover).start(0,0).responsive(false);
        templet = new Templet().width(width).height(height).background(bg);
        templet.put(contentResource);
        templet.put(coverResource);
    	return templet;
    }

}
