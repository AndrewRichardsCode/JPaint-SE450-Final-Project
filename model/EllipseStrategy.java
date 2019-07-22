package model;

import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;
import java.awt.*;

public class EllipseStrategy implements IDrawShapeStrategy
{
    private int width;
    private int height;
    private int xOrigin;
    private int yOrigin;
    private Color shapePrimaryColor;
    private Color shapeSecondaryColor;

    EllipseStrategy(int width, int height, int xOrigin, int yOrigin, Color shapePrimaryColor, Color shapeSecondaryColor)
    {
        this.width = width;
        this.height = height;
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.shapePrimaryColor = shapePrimaryColor;
        this.shapeSecondaryColor = shapeSecondaryColor;
    }
    @Override
    public void drawFilledShape(PaintCanvasBase paintCanvas)
    {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(shapePrimaryColor);
        graphics2d.fillOval(xOrigin, yOrigin, width, height);
    }

    @Override
    public void drawOutlinedShape(PaintCanvasBase paintCanvas)
    {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shapePrimaryColor);
        graphics2d.drawOval(xOrigin, yOrigin, width, height);
    }

    @Override
    public void drawFilledAndOutlinedShape(PaintCanvasBase paintCanvas) {

        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(shapePrimaryColor);
        graphics2d.fillOval(xOrigin, yOrigin, width, height);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shapeSecondaryColor);
        graphics2d.drawOval(xOrigin, yOrigin, width, height);
    }
}
