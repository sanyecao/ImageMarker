package com.wesley.imagemarker.element;

import com.wesley.imagemarker.BaseElement;
import com.wesley.imagemarker.Coordinate;
import com.wesley.imagemarker.Resource;
import com.wesley.imagemarker.resource.ImageResource;

public class ImageElement extends BaseElement{
	private ImageResource resource;
	public ImageElement(ImageResource resource, Coordinate start, Coordinate end, boolean responsive) {
		super(resource, start, end, responsive);
		this.resource = resource;
	}

	public ImageResource getResource() {
		return resource;
	}
}
