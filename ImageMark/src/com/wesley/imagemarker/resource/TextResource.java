package com.wesley.imagemarker.resource;

import com.wesley.imagemarker.Coordinate;

public class TextResource {
	
	private String content;
	private FontResource font;
	private Coordinate start;
	private Coordinate end;
	private  boolean  responsive;
	private int direction;
	

	public  TextResource font(String path,Float fontSize){
		return setFont(new FontResource().load(path).setFontSize(fontSize));
	}
	
	public  TextResource start(int x,int y){
		return setStart(new Coordinate(x,y));
	}
	
	public  TextResource end(int x,int y){
		return setEnd(new Coordinate(x,y));
	}

	public  TextResource responsive(boolean responsive){
		return setResponsive(responsive);
	}
	
	public  TextResource direction(int direction){
		return setDirection(direction);
	}
	
	public TextResource load(String content) {
		// TODO Auto-generated method stub
		this.content = content;
		return this;
	}

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


	public Coordinate getStart() {
		return start;
	}

	public TextResource setStart(Coordinate start) {
		this.start = start;
		return this;
	}

	public Coordinate getEnd() {
		return end;
	}

	public TextResource setEnd(Coordinate end) {
		this.end = end;
		return this;
	}

	public boolean isResponsive() {
		return responsive;
	}

	public TextResource setResponsive(boolean responsive) {
		this.responsive = responsive;
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
