/*
 * Class: CS 111B Object-Oriented Methodologies in Java
 * Description: The panel that shapes are drawn on
 * Due date: 12/9/15
 * Name: Eric Chu
 * File name: DrawPanel.java
 * Assignment 10
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class DrawPanel extends JPanel
{
	MyShape [] arrayOfShapes;
	int mouseX, mouseXinit, mouseXlabel;
    int mouseY, mouseYinit, mouseYlabel;
	int shapeCount;
	int shapeType;
	MyShape currentShape = null;
	private Color currentColor;
	JLabel statusLabel;
	Graphics g;
	JPanel drawingBoard = new JPanel();
	
	//*****************************************************************
	//  Constructor
	//*****************************************************************
	public DrawPanel(JLabel statusLabel)
	{
		
		this.statusLabel = statusLabel;
		arrayOfShapes = new MyShape[100];
		shapeCount = 0;
		shapeType = 1;
		currentShape = null;
		currentColor = Color.BLACK;
		setBackground(Color.WHITE);
		add(statusLabel);
		
		MouseThings m = new MouseThings();
		addMouseListener(m);
		addMouseMotionListener(m);
		setVisible(true);
	}
	//*****************************************************************
	//  Overridden abstract method for painting from Graphics library
	//*****************************************************************
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int index= 0; index < shapeCount; index++)
		{
			arrayOfShapes[index].draw(g);
			if(currentShape != null)
				currentShape.draw(g);
		}
	}
	//*****************************************************************
	//  Setter for the shape type
	//*****************************************************************
	public void setType(int shapeType)
	{
		this.shapeType = shapeType;
	}
	//*****************************************************************
	//  Setter for the color
	//*****************************************************************
	public void setColor(Color currentColor)
	{
		this.currentColor = currentColor;
		
	}
	//*****************************************************************
	//  Method to clear the last shape
	//*****************************************************************
	public void clearLastShape()
	{
		arrayOfShapes[shapeCount -1] = null; //remove reference to object
		if (shapeCount > 0)
			shapeCount--;	
		repaint();
	}
	//*****************************************************************
	//  Method to clear all shapes
	//*****************************************************************
	public void clearDrawing()
	{
		shapeCount = 0;
		repaint();
	}
	
	//*****************************************************************
	//  Represents a listener for Mouse movement and clicks
	//*****************************************************************
	private class MouseThings implements MouseMotionListener, MouseListener
	{
		//*****************************************************************
		//  not needed but requires overriding
		//*****************************************************************
		public void mouseClicked(MouseEvent e) {
			
		}


		public void mouseEntered(MouseEvent e) {

		}


		public void mouseExited(MouseEvent e) {
			
		}
		
		//*****************************************************************
		//  method listens for mouse press
		//*****************************************************************
		public void mousePressed(MouseEvent e) {
			int num = shapeType;
			switch (num)
			{
				case 1: currentShape = new MyLine();
						break;
				case 2: currentShape = new MyOval();
						break;
				case 3: currentShape = new MyRect();
						break;
			}
			mouseXinit = e.getX();
	        mouseYinit = e.getY();
	        currentShape.setColor(currentColor);
	        currentShape.setX1(mouseXinit);
	        currentShape.setY1(mouseYinit);
		}

		//*****************************************************************
		//  method listens for mouse press release
		//*****************************************************************
		public void mouseReleased(MouseEvent e) {
			mouseX = e.getX();
	        mouseY = e.getY();
	        currentShape.setX2(mouseX);
	        currentShape.setY2(mouseY);
			arrayOfShapes[shapeCount] = currentShape;
			shapeCount++;
			currentShape = null;
			repaint();
			
		}

		//*****************************************************************
		//  method listens for mouse drag
		//*****************************************************************
		public void mouseDragged(MouseEvent e) {
	        currentShape.setX2(e.getX());
	        currentShape.setY2(e.getY());
	        statusLabel.setText(e.getX() + " " + e.getY() + " " + shapeCount);
	        repaint();
		}

		//*****************************************************************
		//  method listens for mouse movement
		//*****************************************************************
		public void mouseMoved(MouseEvent e) {
			mouseXlabel = e.getX();
	        mouseYlabel = e.getY();
	        statusLabel.setText(mouseXlabel + " " + mouseYlabel);
		}
		
	}
}
