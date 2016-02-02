/*
 * Class: CS 111B Object-Oriented Methodologies in Java
 * Description: Creates the environment for a drawing board
 * Due date: 12/9/15
 * Name: Eric Chu
 * File name: DrawFrame.java
 * Assignment 10
 */
import javax.swing.*;
import java.awt.*;	//border layout
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawFrame extends JFrame implements ActionListener
{
	private String[] types = {"Line", "Oval", "Rectangle"};
	private String[] colors = {"Black", "Red", "Green" ,"Yellow", "Magenta",
								"Light Gray", "Dark Gray", "Gray", "Orange",
								"Pink", "White", "Cyan", "Blue"};
	private final int WINDOW_WIDTH = 700;  // Width
	private final int WINDOW_HEIGHT = 500; // Height
	private JButton undo = new JButton("Undo");
	private JButton clear = new JButton("Clear");
	private JComboBox shapeType = new JComboBox(types);
	private JComboBox shapeColor = new JComboBox(colors);
	
	private JLabel statusLabel = new JLabel("Coordinates");
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	DrawPanel drawingPane = new DrawPanel(statusLabel);
	
	//*****************************************************************
	//  Constructor for DrawFrame
	//*****************************************************************
	public DrawFrame()
	{
		super("Java Drawings");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	
		buildNorthPanel();
		buildSouthPanel();
		add(northPanel, BorderLayout.NORTH);
		add(drawingPane, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	//*****************************************************************
	//  Method builds the north panel
	//*****************************************************************
	public void buildNorthPanel()
	{
		setLayout(new BorderLayout());
		
		undo.addActionListener(this);
		clear.addActionListener(this);
		northPanel.add(undo);
		northPanel.add(clear);
		ComboBoxListener cB = new ComboBoxListener();
		shapeType.addActionListener(cB);
		northPanel.add(shapeType);
		shapeColor.addActionListener(cB);
		northPanel.add(shapeColor);
		
	}
	//*****************************************************************
	//  Method builds the south panel
	//*****************************************************************
	public void buildSouthPanel()
	{
		southPanel.setBackground(Color.BLUE);
	}
	//*****************************************************************
	//  Represents the listener for buttons implemented by class
	//*****************************************************************
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("Undo"))
		{
			drawingPane.clearLastShape();
		}
		else if (actionCommand.equals("Clear"))
		{
			drawingPane.clearDrawing();
		}
	}
	
	//*****************************************************************
	//  Represents the listener for combo boxes implemented by inner class
	//*****************************************************************
    private class ComboBoxListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent event)
    	{
            JComboBox holdCB = (JComboBox)event.getSource();
            String stringCB = (String)holdCB.getSelectedItem();
    		switch(stringCB)
            {
            	case "Red":
            		drawingPane.setColor(Color.RED);
            		break;
            	case "Black":
            		drawingPane.setColor(Color.BLACK);
            		break;
            	case "Green":
            		drawingPane.setColor(Color.GREEN);
            		break;
            	case "Yellow":
            		drawingPane.setColor(Color.YELLOW);
            		break;
            	case "Blue":
            		drawingPane.setColor(Color.BLUE);
            		break;
            	case "Gray":
            		drawingPane.setColor(Color.GRAY);
            		break;
            	case "Orange":
            		drawingPane.setColor(Color.ORANGE);
            		break;
            	case "Pink":
            		drawingPane.setColor(Color.PINK);
            		break;
            	case "White":
            		drawingPane.setColor(Color.WHITE);
            		break;
            	case "Cyan":
            		drawingPane.setColor(Color.CYAN);
            		break;
            	case "Dark Gray":
            		drawingPane.setColor(Color.DARK_GRAY);
            		break;
            	case "Magenta":
            		drawingPane.setColor(Color.MAGENTA);
            		break;
            	case "Light Gray":
            		drawingPane.setColor(Color.LIGHT_GRAY);
            		break;
            	case "Line":
            		drawingPane.setType(1);
            		break;
            	case "Oval":
            		drawingPane.setType(2);
            		break;
            	case "Rectangle":
            		drawingPane.setType(3);
            		break;
            		
            }
    	}
    }
}
