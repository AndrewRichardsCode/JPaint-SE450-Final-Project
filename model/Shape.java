package model;

import view.interfaces.PaintCanvasBase;

public class Shape
{
    private PaintCanvasBase paintCanvas;

    public Shape(PaintCanvasBase paintCanvas)
    {
        this.paintCanvas = paintCanvas;
    }

    public void DrawRect(int xOrigin, int yOrigin, int width,int  height)
    {
        paintCanvas.getGraphics2D().fillRect(xOrigin, yOrigin, width, height);
    }
}
