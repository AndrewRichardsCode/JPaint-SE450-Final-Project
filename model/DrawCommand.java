package model;

import controller.Point;
import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

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

        ShapeColor selectedPrimaryColor = currentState.getActivePrimaryColor(); //move to constructor
        ShapeColor selectedSecondaryColor = currentState.getActiveSecondaryColor(); //move to constructor
        ShapeShadingType shadingType = currentState.getActiveShapeShadingType(); //move to constructor

        Shape shape = new Shape(selectedPrimaryColor, selectedSecondaryColor, shadingType, pointEnd, pointStart);
        shape.setShapeColor(); //move to shape constructor
        ShapeFactory factory = new ShapeFactory(shape);

        IDrawShapeStrategy strategy = factory.setStrategy(currentState);

        factory.drawShape(strategy, paintCanvas);

        shapeList.createdShapeList.add(shape);
    }
}
