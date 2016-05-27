package com.wesley.imagemarker.element;

import java.awt.Font;

import com.wesley.imagemarker.BaseElement;
import com.wesley.imagemarker.Coordinate;
import com.wesley.imagemarker.Resource;
import com.wesley.imagemarker.resource.TextResource;

public class TextElement extends BaseElement{

	private TextResource resource;
	private Font font;
	public TextElement(TextResource resource, Coordinate start, Coordinate end, boolean responsive) {
		super(resource, start, end, responsive);
		this.resource = resource;
	}
	public Font getFont() {
		return font;
	}
	public TextElement setFont(Font font) {
		this.font = font;
		return this;
	}
	public TextResource getResource() {
		return resource;
	}
	public TextElement setResource(TextResource resource) {
		this.resource = resource;
		return this;
	}
	

}
