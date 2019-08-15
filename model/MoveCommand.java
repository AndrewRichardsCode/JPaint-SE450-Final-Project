package model;

import controller.Point;
import model.interfaces.ICommand;
import model.interfaces.IUndoRedo;

public class MoveCommand implements ICommand, IUndoRedo
{
    private Point pointStart;
    private Point pointEnd;
    private ShapeList shapeList;
    private int deltaX;
    private int deltaY;
    private int xStartValue;
    private int yStartValue;
    private int xEndValue;
    private int yEndValue;

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

            deltaX = pointEnd.getX() - pointStart.getX();
            deltaY = pointEnd.getY() - pointStart.getY();

            for (Shape shape : shapeList.selectedShapeList) {
                xStartValue = shape.pointStart.getX();
                yStartValue = shape.pointStart.getY();
                xEndValue = shape.pointEnd.getX();
                yEndValue = shape.pointEnd.getY();

                shape.pointStart = new Point(xStartValue + deltaX, yStartValue + deltaY);
                shape.pointEnd = new Point(xEndValue + deltaX, yEndValue + deltaY);
                shape.setXOrigin();
                shape.setYOrigin();
                shape.setTriangleXValues();
                shape.setTriangleYValues();
                shape.setStrategy();
            }
            shapeList.drawMasterList();
            shapeList.drawSelectedList();

            CommandHistory.add(this);
        }
    }

    @Override
    public void undo()
    {
        for (Shape shape : shapeList.selectedShapeList) {
            xStartValue = shape.pointStart.getX();
            yStartValue = shape.pointStart.getY();
            xEndValue = shape.pointEnd.getX();
            yEndValue = shape.pointEnd.getY();

            shape.pointStart = new Point(xStartValue - deltaX, yStartValue - deltaY);
            shape.pointEnd = new Point(xEndValue - deltaX, yEndValue - deltaY);
            shape.setXOrigin();
            shape.setYOrigin();
            shape.setTriangleXValues();
            shape.setTriangleYValues();
            shape.setStrategy();
        }
        shapeList.drawMasterList();
        shapeList.drawSelectedList();
    }

    @Override
    public void redo()
    {
        for (Shape shape : shapeList.selectedShapeList) {
            xStartValue = shape.pointStart.getX();
            yStartValue = shape.pointStart.getY();
            xEndValue = shape.pointEnd.getX();
            yEndValue = shape.pointEnd.getY();

            shape.pointStart = new Point(xStartValue + deltaX, yStartValue + deltaY);
            shape.pointEnd = new Point(xEndValue + deltaX, yEndValue + deltaY);
            shape.setXOrigin();
            shape.setYOrigin();
            shape.setTriangleXValues();
            shape.setTriangleYValues();
            shape.setStrategy();
        }
        shapeList.drawMasterList();
        shapeList.drawSelectedList();
    }
}
