package com.wesley.imagemarker.resource;

import com.wesley.imagemarker.Resource;

public class TextResource implements Resource{
	
	private String content;
	private FontResource font;
	private int x;
	private int y;
	private int direction;
	

	@Override
	public TextResource load(String content) {
		// TODO Auto-generated method stub
		this.content = content;
		return this;
	}

	@Override
	public Object getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContent() {
		return content;
	}

	public TextResource setContent(String content) {
		this.content = content;
		return this;
	}

	public FontResource getFont() {
		return font;
	}

	public TextResource setFont(FontResource font) {
		this.font = font;
		return this;
	}

	public int getX() {
		return x;
	}

	public TextResource setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	public TextResource setY(int y) {
		this.y = y;
		return this;
	}

	public int getDirection() {
		return direction;
	}

	public TextResource setDirection(int direction) {
		this.direction = direction;
		return this;
	}
	

}
