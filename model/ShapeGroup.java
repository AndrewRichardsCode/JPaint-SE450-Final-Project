package model;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShapeDrawer;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public class ShapeGroup implements IShapeDrawer
{
    ArrayList<IShapeDrawer> children = new ArrayList<>();

    void addChild(IShapeDrawer shapeDrawer)
    {
        children.add(shapeDrawer);
    }

    @Override
    public void drawShape(PaintCanvasBase paintCanvas, IDrawShapeStrategy strategy)
    {
        for (IShapeDrawer child : children)
        {
            child.drawShape(paintCanvas, strategy);
        }
    }

    @Override
    public ArrayList<Shape> getShape()
    {
        ArrayList <Shape> shapes = new ArrayList<>();
        for(IShapeDrawer child : children)
        {
            shapes.addAll(child.getShape());
        }
        return shapes;
    }
}
