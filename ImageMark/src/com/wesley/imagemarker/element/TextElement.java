package com.wesley.imagemarker.element;

import java.awt.Font;

import com.wesley.imagemarker.BaseElement;
import com.wesley.imagemarker.Coordinate;
import com.wesley.imagemarker.Resource;

public class TextElement extends BaseElement{

	private Font font;
	public TextElement(Resource resource, Coordinate start, Coordinate end, boolean responsive) {
		super(resource, start, end, responsive);
	}
	public Font getFont() {
		return font;
	}
	public TextElement setFont(Font font) {
		this.font = font;
		return this;
	}
	

}
