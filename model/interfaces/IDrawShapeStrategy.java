package model.interfaces;

import view.interfaces.PaintCanvasBase;

public interface IDrawShapeStrategy
{
    void drawFilledShape(PaintCanvasBase paintCanvas);
    void drawOutlinedShape(PaintCanvasBase paintCanvas);
    void drawFilledAndOutlinedShape(PaintCanvasBase paintCanvas);
}
