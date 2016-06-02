package com.wesley.imagemarker.resource;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontResource{

	protected Font font;
	private Float fontSize = 12f;

	public FontResource load(String path,Float fontSize) {
		Font dynamicFont;
		try {
			dynamicFont = Font.createFont(Font.TRUETYPE_FONT, new File(path));
			font = dynamicFont.deriveFont(1,fontSize);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return this;
		
	}

	public Font getResource() {
		return font;
	}
	
	public Float getFontSize(){
		return fontSize;
	}
	
	public FontResource setFontSize(Float fontSize){
		this.fontSize = fontSize;
		return this;
	}

}
