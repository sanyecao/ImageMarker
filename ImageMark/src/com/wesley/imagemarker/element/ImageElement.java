package com.wesley.imagemarker.element;

import com.wesley.imagemarker.BaseElement;
import com.wesley.imagemarker.Coordinate;
import com.wesley.imagemarker.Resource;

public class ImageElement extends BaseElement{

	public ImageElement(Resource resource, Coordinate start, Coordinate end, boolean responsive) {
		super(resource, start, end, responsive);
	}

}
