package model;

import controller.Point;
import model.interfaces.*;

public class DrawCommand implements ICommand
{
    private IApplicationState currentState;
    private Point pointStart;
    private Point pointEnd;
    private ShapeList shapeList;

    public DrawCommand (IApplicationState currentState, ShapeList shapeList, Point pointStart, Point pointEnd)
    {
        this.currentState = currentState;
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        Shape shape = new Shape(currentState, pointEnd, pointStart);
        shapeList.createdShapeList.add(shape);
        shapeList.drawMasterList();
    }
}
