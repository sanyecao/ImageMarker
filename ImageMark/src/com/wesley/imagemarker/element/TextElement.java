package com.wesley.imagemarker.element;

import com.wesley.imagemarker.Coordinate;
import com.wesley.imagemarker.resource.FontResource;
import com.wesley.imagemarker.resource.TextResource;
import com.wesley.imagemarker.resource.TextResource.Direction;

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
		return resource.setFont(new FontResource().load(path,fontSize));
	}
	
	public static TextResource start(int x,int y){
		return resource.setStart(new Coordinate(x,y));
	}
	
	public static TextResource width(int width){
		return resource.setWidth(width);
	}

	public static TextResource height(int height){
		return resource.setHeight(height);
	}

	
	public static TextResource direction(Direction direction){
		return resource.setDirection(direction);
	}

	public TextResource getResource() {
		return resource;
	}	

}
