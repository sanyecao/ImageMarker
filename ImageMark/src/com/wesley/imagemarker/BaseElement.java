package com.wesley.imagemarker;

public class BaseElement {
	private Resource resource;
	private Coordinate start;
	private Coordinate end;
	private boolean  responsive;
	public BaseElement(Resource resource,Coordinate start,Coordinate end,boolean responsive){
		this.resource = resource;
		this.start = start;
		this.end = end;
		this.responsive = responsive;
	}
	public Resource getResource() {
		return resource;
	}
	public BaseElement setResource(Resource resource) {
		this.resource = resource;
		return this;
	}
	public Coordinate getStart() {
		return start;
	}
	public BaseElement setStart(Coordinate start) {
		this.start = start;
		return this;
	}
	public Coordinate getEnd() {
		return end;
	}
	public BaseElement setEnd(Coordinate end) {
		this.end = end;
		return this;
	}
	public boolean isResponsive() {
		return responsive;
	}
	public BaseElement setResponsive(boolean responsive) {
		this.responsive = responsive;
		return this;
	}

	
}
