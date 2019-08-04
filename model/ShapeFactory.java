package model;

import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

class ShapeFactory
{
    private Shape shape;

    ShapeFactory(Shape shape)
    {
        this.shape = shape;
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
