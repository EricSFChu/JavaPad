// MyOval.java
// Declaration of class MyOval.
import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape
{
   // call default superclass constructor
   public MyOval()
   {
   }

   // call superclass constructor passing parameters
   public MyOval(int x1, int y1, int x2, int y2,
      Color color)
   {
      super(x1, y1, x2, y2, color);
   }

   // draw oval
   public void draw(Graphics g)
   {
      g.setColor(getColor());
      
      g.drawOval(getUpperLeftX(), getUpperLeftY(),getWidth(), getHeight());
   }
} // end class MyOval



