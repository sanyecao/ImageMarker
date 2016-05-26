package com.wesley.imagemarker.resource;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.wesley.imagemarker.Resource;

public class ImageResource implements Resource{

	protected Image image;
	@Override
	public ImageResource load(String path) {
	     ImageIcon imageIcon = new ImageIcon(path);  
	     image = imageIcon.getImage();  
	     return this;
	}

	@Override
	public Image getResource() {
		return image;
	}

}
