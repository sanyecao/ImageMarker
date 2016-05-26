package com.wesley.imagemarker.resource;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import com.wesley.imagemarker.Resource;

public class FontResource implements Resource{

	protected Font font;
	private Float fontSize;
	@Override
	public FontResource load(String path) {
		Font dynamicFont;
		try {
			dynamicFont = Font.createFont(Font.TRUETYPE_FONT, new File("f:\\img\\fonts\\yygmb.ttf"));
			font = dynamicFont.deriveFont(1,this.fontSize);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return this;
		
	}

	@Override
	public Font getResource() {
		return font;
	}
	
	public Float getFontSize(){
		return fontSize;
	}
	
	public void setFontSize(Float fontSize){
		this.fontSize = fontSize;
	}

}
