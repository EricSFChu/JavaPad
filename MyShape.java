//MyShape.java
// Declaration of class MyShape.
import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape
{
   private int x1; // x coordinate of first endpoint
   private int y1; // y coordinate of first endpoint
   private int x2; // x coordinate of second endpoint
   private int y2; // y coordinate of second endpoint
   private Color color; // color of this shape

   // default constructor initializes values with 0
   public MyShape()
   {
      this(0, 0, 0, 0, Color.BLACK); // call constructor to set values
   } 

   // constructor
   public MyShape(int x1, int y1, int x2, int y2, Color color)
   {
      this.x1 = (x1 >= 0 ? x1 : 0);
      this.y1 = (y1 >= 0 ? y1 : 0);
      this.x2 = (x2 >= 0 ? x2 : 0);
      this.y2 = (y2 >= 0 ? y2 : 0);
      this.color = color;
   } 

   // set the x-coordinate of the first point
   public void setX1(int x1)
   {
      this.x1 = (x1 >= 0 ? x1 : 0);
   }

   // get the x-coordinate of the first point
   public int getX1()
   {
      return x1;
   } 

   // set the x-coordinate of the second point
   public void setX2(int x2)
   {
      this.x2 = (x2 >= 0 ? x2 : 0);
   }

   // get the x-coordinate of the second point
   public int getX2()
   {
      return x2;
   } 

   // set the y-coordinate of the first point
   public void setY1(int y1)
   {
      this.y1 = (y1 >= 0 ? y1 : 0);
   } 
   
   // get the y-coordinate of the first point
   public int getY1()
   {
      return y1;
   }

   // set the y-coordinate of the second point
   public void setY2(int y2)
   {
      this.y2 = (y2 >= 0 ? y2 : 0);
   } 

   // get the y-coordinate of the second point
   public int getY2()
   {
      return y2;
   } 

   // set the color
   public void setColor(Color color)
   {
      this.color = color;
   }

   // get the color
   public Color getColor()
   {
      return color;
   } 

   // abstract draw method
   public abstract void draw(Graphics g);
} // end class MyShape
