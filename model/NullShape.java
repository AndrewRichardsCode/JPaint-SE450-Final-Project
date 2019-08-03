package model;

import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

public class NullShape implements IDrawShapeStrategy
{
    @Override
    public void drawFilledShape(PaintCanvasBase paintCanvas){}

    @Override
    public void drawOutlinedShape(PaintCanvasBase paintCanvas){}

    @Override
    public void drawFilledAndOutlinedShape(PaintCanvasBase paintCanvas){}
}
