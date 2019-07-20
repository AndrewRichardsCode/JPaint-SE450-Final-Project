package model;

import model.interfaces.IApplicationState;
import model.interfaces.IDrawShapeStrategy;

public class ShapeStrategyFactory
{
    public ShapeStrategyFactory(){}

    public IDrawShapeStrategy setStrategy(IApplicationState currentState)
    {
        IDrawShapeStrategy strategy;
        ShapeType type = currentState.getActiveShapeType();

        switch(type)
        {
            case RECTANGLE:
                strategy = new RectangleStrategy();
                break;
            case TRIANGLE:
                strategy = new TriangleStrategy();
                break;
            case ELLIPSE:
                strategy = new EllipseStrategy();
                break;
            default:
                throw new Error();
        }
        return strategy;
    }
}
