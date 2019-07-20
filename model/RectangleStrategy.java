package model;

import controller.Point;
import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

public class RectangleStrategy implements IDrawShapeStrategy
{

    @Override
    public void drawShape(PaintCanvasBase paintCanvas, Point pointStart, Point pointEnd)
    {
        int width;
        int height;
        int xOrigin;
        int yOrigin;

        //---set width and xOrigin---
        if(pointEnd.getX() > pointStart.getX())
        {
            width = pointEnd.getX() - pointStart.getX();
            xOrigin = pointStart.getX();
        }
        else
        {
            width =  pointStart.getX() - pointEnd.getX();
            xOrigin = pointEnd.getX();
        }

        //---set height and yOrigin---
        if (pointEnd.getY() > pointStart.getY())
        {
            height = pointEnd.getY() - pointStart.getY();
            yOrigin = pointStart.getY();
        }
        else
        {
            height = pointStart.getY() - pointEnd.getY();
            yOrigin = pointStart.getY() - height;
        }
        paintCanvas.getGraphics2D().fillRect(xOrigin, yOrigin, width, height);
    }
}
