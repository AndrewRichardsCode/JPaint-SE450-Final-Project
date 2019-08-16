package model;

import controller.Point;
import model.interfaces.*;

public class DrawCommand implements ICommand, IUndoRedo
{
    private IApplicationState currentState;
    private Point pointStart;
    private Point pointEnd;
    private ShapeList shapeList;
    private ShapeDrawer shapeDrawer;

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
        shapeDrawer = new ShapeDrawer(shape);
        shapeList.createdShapeList.add(shapeDrawer);
        shapeList.drawMasterList();
        CommandHistory.add(this);
    }

    @Override
    public void undo(){
        shapeList.createdShapeList.remove(shapeDrawer);
        shapeList.drawMasterList();
    }

    @Override
    public void redo()
    {
        shapeList.createdShapeList.add(shapeDrawer);
        shapeList.drawMasterList();
    }
}
