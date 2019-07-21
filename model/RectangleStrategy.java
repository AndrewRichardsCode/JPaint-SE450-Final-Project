package model;

import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class RectangleStrategy implements IDrawShapeStrategy
{
    private int width;
    private int height;
    private int xOrigin;
    private int yOrigin;

    public RectangleStrategy (int width, int height, int xOrigin, int yOrigin)
    {
        this.width = width;
        this.height = height;
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
    }

    @Override
    public void drawFilledShape(PaintCanvasBase paintCanvas)
    {
        paintCanvas.getGraphics2D().fillRect(xOrigin, yOrigin, width, height);
    }

    @Override
    public void drawOutlinedShape(PaintCanvasBase paintCanvas)
    {
        paintCanvas.getGraphics2D().setStroke(new BasicStroke(5));
        paintCanvas.getGraphics2D().drawRect(xOrigin, yOrigin, width, height);
    }

    @Override
    public void drawFilledAndOutlinedShape(PaintCanvasBase paintCanvas)
    {

    }
}
