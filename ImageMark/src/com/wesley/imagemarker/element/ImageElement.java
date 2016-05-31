package com.wesley.imagemarker.element;

import com.wesley.imagemarker.resource.ImageResource;

public final class ImageElement {
	private static ImageResource resource;
	public ImageElement() {
	}

	public static ImageResource image(String path){
		resource = new ImageResource().load(path);
		return resource;
	}
	public ImageResource getResource() {
		return resource;
	}
}
