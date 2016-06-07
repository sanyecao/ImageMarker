package com.wesley.imagemarker;

import java.awt.Color;

public class Shadow{
	private int x;
	private int y;
	private Color color;
	public Shadow(int x, int y, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
	public int x(){
		return this.x;
	}
	public int y(){
		return this.y;
	}
	public Color color(){
		return this.color;
	}
}
