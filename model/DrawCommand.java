package model;

import controller.Point;
import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

public class DrawCommand implements ICommand
{
    private IApplicationState currentState;
    private PaintCanvasBase paintCanvas;
    private Point pointStart;
    private Point pointEnd;
    private ShapeList shapeList;

    public DrawCommand (IApplicationState currentState, ShapeList shapeList, PaintCanvasBase paintCanvas, Point pointStart, Point pointEnd)
    {
        this.currentState = currentState;
        this.paintCanvas = paintCanvas;
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        Shape shape = new Shape(currentState, pointEnd, pointStart);
        //ShapeFactory factory = new ShapeFactory(shape);
        //IDrawShapeStrategy strategy = factory.setStrategy();
        //factory.drawShape(strategy, paintCanvas);
        shapeList.createdShapeList.add(shape);
        shapeList.drawMasterList();
    }
}
