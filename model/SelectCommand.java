package model;

import controller.Point;
import model.interfaces.ICommand;

public class SelectCommand implements ICommand
{
    private ShapeList shapeList;
    private int selectionWidth;
    private int selectionHeight;
    private int selectionX;
    private int selectionY;

    public SelectCommand (Point pointStart, Point pointEnd, ShapeList shapeList)
    {
        this.shapeList = shapeList;
        int pointStartX = pointStart.getX();
        int pointEndX = pointEnd.getX();
        int pointStartY = pointStart.getY();
        int pointEndY = pointEnd.getY();

        if (pointEndX > pointStartX)
        {
            selectionWidth = pointEndX - pointStartX;
            selectionX = pointStartX;
        }
        else
        {
            selectionWidth = pointStartX - pointEndX;
            selectionX = pointEndX;
        }

        if (pointEndY > pointStartY)
        {
            selectionHeight = pointEndY - pointStartY;
            selectionY = pointStartY;
        }
        else
        {
            selectionHeight = pointStartY - pointEndY;
            selectionY = pointStartY - selectionHeight;
        }
    }

    @Override
    public void run()
    {
        int shapeX;
        int shapeY;
        int shapeWidth;
        int shapeHeight;

        for (Shape shape: shapeList.createdShapeList)
        {
            shapeX = shape.pointStart.getX();
            shapeY = shape.pointStart.getY();
            shapeWidth = shape.getWidth();
            shapeHeight = shape.getHeight();

            if( (selectionX < shapeX + shapeWidth)      &&
                (selectionX + selectionWidth > shapeX)  &&
                (selectionY < shapeY + shapeHeight)     &&
                (selectionY + selectionHeight > shapeY))
            {
                shapeList.selectedShapeList.add(shape);
            }
        }
    }
}
