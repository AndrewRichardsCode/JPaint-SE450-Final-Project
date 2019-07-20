package model.interfaces;

import controller.Point;
import view.interfaces.PaintCanvasBase;

public interface IDrawShapeStrategy
{
    void drawShape(PaintCanvasBase paintCanvas, Point startPoint, Point endPoint);
}
