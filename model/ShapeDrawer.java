package model;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShapeDrawer;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

class ShapeDrawer implements IShapeDrawer
{
    private Shape shape;

    ShapeDrawer(Shape shape)
    {
        this.shape = shape;
    }

    @Override
    public void drawShape(PaintCanvasBase paintCanvas, IDrawShapeStrategy strategy)
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

    @Override
    public ArrayList<Shape> getShape()
    {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(shape);
        return shapes;
    }
}
