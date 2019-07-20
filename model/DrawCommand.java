package model;

import controller.Point;
import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

//import java.io.IOException;

public class DrawCommand implements ICommand
{
    private IApplicationState currentState;
    private PaintCanvasBase paintCanvas;
    private Point pointStart;
    private Point pointEnd;

    public DrawCommand (IApplicationState currentState, PaintCanvasBase paintCanvas, Point pointStart, Point pointEnd)
    {
        this.currentState = currentState;
        this.paintCanvas = paintCanvas;
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
    }

    @Override
    public void run() //throws IOException
    {
        ShapeStrategyFactory factory = new ShapeStrategyFactory();
        Shape shape = new Shape(factory.setStrategy(currentState));
        shape.drawShapeStrategy.drawShape(paintCanvas, pointStart, pointEnd);
    }
}
