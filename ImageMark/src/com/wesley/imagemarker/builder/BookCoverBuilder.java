package com.wesley.imagemarker.builder;

import java.awt.Color;

import com.wesley.imagemarker.Templet;
import com.wesley.imagemarker.element.ImageElement;
import com.wesley.imagemarker.element.TextElement;
import com.wesley.imagemarker.resource.ImageResource;
import com.wesley.imagemarker.resource.TextResource;
import com.wesley.imagemarker.resource.TextResource.Direction;
import com.wesley.imagemarker.resource.TextResource.Format;

public class BookCoverBuilder {
	private static Templet templet;
	private static int width = 460;
	private static int height = 460;
	private static Color bg = Color.black;
	private static String fontPath = "/data/imagemaker/fonts/zh/fzmw.ttf";
	
    public static Templet build(String content,String cover,String title){
        TextResource contentResource = TextElement.text(content).font(fontPath, 20f).space(5).color(Color.black).lineHeight(28).wdith(150).height(450).start(292, 5).format(Format.VERTICAL).direction(Direction.LTR);
        TextResource titleResource = TextElement.text(title).font(fontPath, 10f).color(Color.gray).wdith(150).height(450).start(440, 5).format(Format.VERTICAL).direction(Direction.LTR);
        ImageResource coverResource = ImageElement.image(cover).start(0,0).responsive(false);
        templet = new Templet().width(width).height(height).background(bg);
        templet.put(contentResource).put(titleResource);
        templet.put(coverResource);
    	return templet;
    }

}
