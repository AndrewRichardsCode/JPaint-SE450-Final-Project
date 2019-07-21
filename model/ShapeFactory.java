package model;

import model.interfaces.IApplicationState;
import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

public class ShapeFactory
{
    Shape shape;


    public ShapeFactory(Shape shape)
    {
        this.shape = shape;
    }

    public IDrawShapeStrategy setStrategy(IApplicationState currentState)
    {
        IDrawShapeStrategy strategy;
        ShapeType shapeType = currentState.getActiveShapeType();

        int width = shape.getWidth();
        int height = shape.getHeight();
        int xOrigin = shape.getXOrigin();
        int yOrigin = shape.getYOrigin();

        switch(shapeType)
        {
            case RECTANGLE:
                strategy = new RectangleStrategy(width, height, xOrigin, yOrigin);
                break;
            case TRIANGLE:
                strategy = new TriangleStrategy();
                break;
            case ELLIPSE:
                strategy = new EllipseStrategy(width, height, xOrigin, yOrigin);
                break;
            default:
                throw new Error();
        }
        return strategy;
    }

    public void drawShape(IDrawShapeStrategy strategy, PaintCanvasBase paintCanvas)
    {
        switch(shape.getShadingType())
        {
            case FILLED_IN: strategy.drawFilledShape(paintCanvas);
                            break;
            case OUTLINE:   strategy.drawOutlinedShape(paintCanvas);
                            break;

            case OUTLINE_AND_FILLED_IN: strategy.drawFilledAndOutlinedShape(paintCanvas);
                                        break;
        }
    }



    //EnumMap<Color, ShapeColor> map = new EnumMap<Color, ShapeColor>();
    //paintCanvas.getGraphics2D().setColor(color);
}
