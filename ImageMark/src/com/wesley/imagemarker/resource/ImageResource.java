package com.wesley.imagemarker.resource;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.wesley.imagemarker.Resource;

public class ImageResource implements Resource{

	protected Image image;
	@Override
	public void load(String path) {
	     ImageIcon imageIcon = new ImageIcon(path);  
	     image = imageIcon.getImage();  
	}

	@Override
	public Image getResource() {
		return image;
	}

}
