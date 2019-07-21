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
    public void run() //throws IOException
    {

        ShapeColor primaryColor = currentState.getActivePrimaryColor();
        ShapeColor secondaryColor = currentState.getActiveSecondaryColor();
        ShapeShadingType shadingType = currentState.getActiveShapeShadingType();

        Shape shape = new Shape(primaryColor, secondaryColor, shadingType, pointEnd, pointStart);
        ShapeFactory factory = new ShapeFactory(shape);

        IDrawShapeStrategy strategy = factory.setStrategy(currentState);
        factory.drawShape(strategy, paintCanvas);

        shapeList.shapeArrayList.add(shape);


    }
}
