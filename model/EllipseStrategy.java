package model;

import controller.Point;
import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class EllipseStrategy implements IDrawShapeStrategy
{
    private int width;
    private int height;
    private int xOrigin;
    private int yOrigin;

    public EllipseStrategy(int width, int height, int xOrigin, int yOrigin)
    {
        this.width = width;
        this.height = height;
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
    }
    @Override
    public void drawFilledShape(PaintCanvasBase paintCanvas)
    {
        paintCanvas.getGraphics2D().fillOval(xOrigin, yOrigin, width, height);
    }

    @Override
    public void drawOutlinedShape(PaintCanvasBase paintCanvas)
    {
        paintCanvas.getGraphics2D().setStroke(new BasicStroke(5));
        paintCanvas.getGraphics2D().drawOval(xOrigin, yOrigin, width, height);
    }

    @Override
    public void drawFilledAndOutlinedShape(PaintCanvasBase paintCanvas) {

    }
}
