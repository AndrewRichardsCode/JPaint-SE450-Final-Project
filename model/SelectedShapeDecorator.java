package model;

import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class SelectedShapeDecorator implements IDrawShapeStrategy {
    private IDrawShapeStrategy strategy;

    private int width;
    private int height;
    private int xOrigin;
    private int yOrigin;
    private int[] xValues;
    private int[] yValues;
    private ShapeType type;
    private Stroke stroke = new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);


    SelectedShapeDecorator(IDrawShapeStrategy strategy, int XOrigin, int YOrigin, int height, int width, int[] xValues, int[] yValues, ShapeType type) {
        this.strategy = strategy;

        this.width = width;
        this.height = height;
        this.xOrigin = XOrigin;
        this.yOrigin = YOrigin;
        this.xValues = xValues;
        this.yValues = yValues;
        this.type = type;
    }

    @Override
    public void drawFilledShape(PaintCanvasBase paintCanvas)
    {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);

        switch (type)
        {
            case RECTANGLE:     graphics2d.drawRect(xOrigin, yOrigin, width, height);
                break;
            case TRIANGLE:      graphics2d.drawPolygon(xValues, yValues, 3);
                break;
            case ELLIPSE:       graphics2d.drawOval(xOrigin, yOrigin, width, height);
                break;
            default:            throw new Error();

        }
        strategy.drawFilledShape(paintCanvas);
    }

    @Override
    public void drawOutlinedShape(PaintCanvasBase paintCanvas)
    {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        switch (type)
        {
            case RECTANGLE:     graphics2d.drawRect(xOrigin, yOrigin, width, height);
                break;
            case TRIANGLE:      graphics2d.drawPolygon(xValues, yValues, 3);
                break;
            case ELLIPSE:       graphics2d.drawOval(xOrigin, yOrigin, width, height);
                break;
            default:            throw new Error();

        }
        strategy.drawOutlinedShape(paintCanvas);
    }

    @Override
    public void drawFilledAndOutlinedShape(PaintCanvasBase paintCanvas)
    {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        switch (type)
        {
            case RECTANGLE:     graphics2d.drawRect(xOrigin, yOrigin, width, height);
                break;
            case TRIANGLE:      graphics2d.drawPolygon(xValues, yValues, 3);
                break;
            case ELLIPSE:       graphics2d.drawOval(xOrigin, yOrigin, width, height);
                break;
            default:            throw new Error();

        }
        strategy.drawFilledAndOutlinedShape(paintCanvas);
    }
}
