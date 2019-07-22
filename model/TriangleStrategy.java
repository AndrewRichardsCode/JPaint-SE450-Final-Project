package model;

import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;
import java.awt.*;

public class TriangleStrategy implements IDrawShapeStrategy
{
    private Color shapePrimaryColor;
    private Color shapeSecondaryColor;
    private int[] xValues;
    private int[] yValues;

    TriangleStrategy (int[] xValues, int[] yValues, Color shapePrimaryColor, Color shapeSecondaryColor)
    {
        this.shapePrimaryColor = shapePrimaryColor;
        this.shapeSecondaryColor = shapeSecondaryColor;
        this.xValues = xValues;
        this.yValues = yValues;
    }

    @Override
    public void drawFilledShape(PaintCanvasBase paintCanvas)
    {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(shapePrimaryColor);
        graphics2d.fillPolygon(xValues, yValues,3);
    }

    @Override
    public void drawOutlinedShape(PaintCanvasBase paintCanvas)
    {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shapePrimaryColor);
        graphics2d.drawPolygon(xValues, yValues, 3);
    }

    @Override
    public void drawFilledAndOutlinedShape(PaintCanvasBase paintCanvas)
    {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(shapePrimaryColor);
        graphics2d.fillPolygon(xValues, yValues, 3);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shapeSecondaryColor);
        graphics2d.drawPolygon(xValues, yValues, 3);
    }
}
