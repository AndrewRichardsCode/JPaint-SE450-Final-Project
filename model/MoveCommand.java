package model;

import controller.Point;
import model.interfaces.ICommand;
import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;


public class MoveCommand implements ICommand
{
    private Point pointStart;
    private Point pointEnd;
    private PaintCanvasBase paintCanvas;
    private ShapeList shapeList;

    public MoveCommand (Point pointStart, Point pointEnd, PaintCanvasBase paintCanvas, ShapeList shapeList)
    {
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        Graphics2D g = paintCanvas.getGraphics2D();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0,paintCanvas.getWidth(), paintCanvas.getHeight());

        int deltaX = pointEnd.getX() - pointStart.getX();
        int deltaY = pointEnd.getY() - pointStart.getY();

        for (Shape shape: shapeList.selectedShapeList)
        {
            int xStartValue = shape.pointStart.getX();
            int yStartValue = shape.pointStart.getY();
            int xEndValue = shape.pointEnd.getX();
            int yEndValue = shape.pointEnd.getY();

            shape.pointStart = new Point (xStartValue + deltaX, yStartValue + deltaY);
            shape.pointEnd = new Point (xEndValue + deltaX, yEndValue + deltaY);
        }

        for (Shape shape: shapeList.createdShapeList)
        {
            ShapeFactory factory = new ShapeFactory(shape);
            IDrawShapeStrategy strategy = factory.setStrategy();
            factory.drawShape(strategy, paintCanvas);
        }
    }
}
