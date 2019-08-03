package model;

import controller.Point;
import model.interfaces.ICommand;

public class MoveCommand implements ICommand
{
    private Point pointStart;
    private Point pointEnd;
    private ShapeList shapeList;

    public MoveCommand (Point pointStart, Point pointEnd, ShapeList shapeList)
    {
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        if(shapeList.selectedShapeList != null)
        {
            int xStartValue;
            int yStartValue;
            int xEndValue;
            int yEndValue;
            int deltaX = pointEnd.getX() - pointStart.getX();
            int deltaY = pointEnd.getY() - pointStart.getY();

            for (Shape shape : shapeList.selectedShapeList) {
                xStartValue = shape.pointStart.getX();
                yStartValue = shape.pointStart.getY();
                xEndValue = shape.pointEnd.getX();
                yEndValue = shape.pointEnd.getY();

                shape.pointStart = new Point(xStartValue + deltaX, yStartValue + deltaY);
                shape.pointEnd = new Point(xEndValue + deltaX, yEndValue + deltaY);
            }
            shapeList.drawMasterList();
            shapeList.drawSelectedList();
        }
    }
}
