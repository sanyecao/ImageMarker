package com.wesley.imagemarker.element;

import com.wesley.imagemarker.Coordinate;
import com.wesley.imagemarker.resource.FontResource;
import com.wesley.imagemarker.resource.TextResource;

public final class TextElement{

	private static TextResource resource;
	public TextElement(TextResource resource, Coordinate start, Coordinate end, boolean responsive) {
		TextElement.resource = resource;
	}
	
	public static TextResource text(String content){
		resource = new TextResource().load(content);
		return resource;
	}
	
	public static TextResource font(String path,Float fontSize){
		return resource.setFont(new FontResource().load(path).setFontSize(fontSize));
	}
	
	public static TextResource start(int x,int y){
		return resource.setStart(new Coordinate(x,y));
	}
	
	public static TextResource end(int x,int y){
		return resource.setEnd(new Coordinate(x,y));
	}

	public static TextResource responsive(boolean responsive){
		return resource.setResponsive(responsive);
	}
	
	public static TextResource direction(int direction){
		return resource.setDirection(direction);
	}

	public TextResource getResource() {
		return resource;
	}	

}
