// MyRect.java
// Declaration of class MyRect.
import java.awt.Color;
import java.awt.Graphics;

public class MyRect extends MyBoundedShape
{
   // call default superclass constructor
   public MyRect()
   {
   } 

   // call superclass constructor passing parameters
   public MyRect(int x1, int y1, int x2, int y2,
      Color color)
   {
      super(x1, y1, x2, y2, color);
   }

   // draw rectangle
   public void draw(Graphics g)
   {
      g.setColor(getColor());
      
      g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
   } 
} // end class MyRect
