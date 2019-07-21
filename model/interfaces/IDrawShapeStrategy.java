package model.interfaces;

import controller.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IDrawShapeStrategy
{
    void drawFilledShape(PaintCanvasBase paintCanvas);
    void drawOutlinedShape(PaintCanvasBase paintCanvas);
    void drawFilledAndOutlinedShape(PaintCanvasBase paintCanvas);
}
