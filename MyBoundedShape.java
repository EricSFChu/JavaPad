// MyBoundedShape.java
// Declaration of class MyBoundedShape.
import java.awt.Color;
import java.awt.Graphics;

public abstract class MyBoundedShape extends MyShape
{
   private boolean filled; // whether this shape is filled
   
   // call default superclass constructor
   public MyBoundedShape()
   {
    } 

   // call superclass constructor passing parameters
   public MyBoundedShape(int x1, int y1, int x2, int y2,
      Color color)
   {
      super(x1, y1, x2, y2, color);
   } 

   // get upper left x coordinate
   public int getUpperLeftX()
   {
      return Math.min(getX1(), getX2());
   } 

   // get upper left y coordinate
   public int getUpperLeftY()
   {
      return Math.min(getY1(), getY2());
   }

   // get shape width
   public int getWidth()
   {
      return Math.abs(getX2() - getX1());
   }

   // get shape height
   public int getHeight()
   {
      return Math.abs(getY2() - getY1());
   }

   
} // end class MyBoundedShape

