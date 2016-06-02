package com.wesley.imagemarker.resource;

import java.awt.Color;

import com.wesley.imagemarker.Coordinate;
/**
 * 
 * @author zen
 *
 */
public class TextResource {
	/**
	 * The text to draw
	 */
	private String content;
	/**
	 * The font recource 
	 */
	private FontResource font;
	/**
	 * color of the text
	 */
	private Color color;
	/**
	 * start coordinate of text
	 */
	private Coordinate start;
	/**
	 * max width of the text
	 */
	private int width;
	/**
	 * max height of the text
	 */
	private int height;
	/**
	 * text align values(Align.LEFT,Align.RIGHT,Align.CENTER)
	 */
	private Align algin = Align.LEFT;
	/**
	 * Write direction of the text values(Direction.LTR,Direction.RTL)
	 */
	private Direction direction = Direction.LTR;
	/**
	 * Format of the text values(Format.VERTICL,Format.HORIZONAL)
	 */
	private Format format = Format.HORIZONAL;
	
	/**
	 * 
	 * @author wesley
	 *
	 */
	public enum Align{
		LEFT, RIGHT, CENTER
	}
	/**
	 * 
	 * @author wesley
	 *
	 */
	public enum Direction{
		LTR, RTL
	}
	/**
	 * 
	 * @author wesley
	 *
	 */
	public enum Format{
		VERTICAL, HORIZONAL
	}

	
	
	public  TextResource font(String path,Float fontSize){
		return setFont(new FontResource().load(path,fontSize));
	}
	
	public  TextResource start(int x,int y){
		return setStart(new Coordinate(x,y));
	}
	
	public  TextResource wdith(int width){
		return setWidth(width);
	}
	
	public  TextResource height(int height){
		return setHeight(height);
	}

	public TextResource align(Align align){
		return setAlgin(align);
	}

	
	public  TextResource color(Color color){
		return setColor(color);
	}
	
	public  TextResource direction(Direction direction){
		return setDirection(direction);
	}
	
	public TextResource load(String content) {
		this.content = content;
		return this;
	}

	public Object getResource() {
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

	public int getWidth() {
		return width;
	}

	public TextResource setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public TextResource setHeight(int height) {
		this.height = height;
		return this;
	}


	public Direction getDirection() {
		return direction;
	}

	public TextResource setDirection(Direction direction) {
		this.direction = direction;
		return this;
	}

	public Color getColor() {
		return color;
	}

	public TextResource setColor(Color color) {
		this.color = color;
		return this;
	}

	public Align getAlgin() {
		return algin;
	}

	public TextResource setAlgin(Align algin) {
		this.algin = algin;
		return this;
	}

	public Format getFormat() {
		return format;
	}

	public TextResource setFormat(Format format) {
		this.format = format;
		return this;
	}
	

}
