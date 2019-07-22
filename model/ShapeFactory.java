package model;

import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;
import java.awt.*;

class ShapeFactory
{
    private Shape shape;

    ShapeFactory(Shape shape)
    {
        this.shape = shape;
    }

    IDrawShapeStrategy setStrategy()
    {
        IDrawShapeStrategy strategy;
        int width = shape.getWidth();
        int height = shape.getHeight();
        int xOrigin = shape.getXOrigin();
        int yOrigin = shape.getYOrigin();
        int[] xValues = shape.getTriangleXValues();
        int[] yValues = shape.getTriangleYValues();
        Color shapePrimaryColor = shape.shapePrimaryColor;
        Color shapeSecondaryColor = shape.shapeSecondaryColor;

        switch(shape.getShapeType())
        {
            case RECTANGLE:     strategy = new RectangleStrategy(width, height, xOrigin, yOrigin, shapePrimaryColor, shapeSecondaryColor);
                                break;
            case TRIANGLE:      strategy = new TriangleStrategy(xValues, yValues, shapePrimaryColor, shapeSecondaryColor);
                                break;
            case ELLIPSE:       strategy = new EllipseStrategy(width, height, xOrigin, yOrigin, shapePrimaryColor, shapeSecondaryColor);
                                break;
            default:            throw new Error();
        }
        return strategy;
    }

    void drawShape(IDrawShapeStrategy strategy, PaintCanvasBase paintCanvas)
    {
        switch(shape.getShadingType())
        {
            case FILLED_IN:             strategy.drawFilledShape(paintCanvas);
                                        break;
            case OUTLINE:               strategy.drawOutlinedShape(paintCanvas);
                                        break;
            case OUTLINE_AND_FILLED_IN: strategy.drawFilledAndOutlinedShape(paintCanvas);
                                        break;
            default:                    throw new Error();
        }
    }
}
