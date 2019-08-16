package model.interfaces;

import model.Shape;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public interface IShapeDrawer
{
    void drawShape(PaintCanvasBase paintCanvas, IDrawShapeStrategy strategy);
    ArrayList<Shape> getShape();
}
