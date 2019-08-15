package model;

import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class ShapeList
{
    private PaintCanvasBase paintCanvas;
    ArrayList <Shape> createdShapeList = new ArrayList<>();
    ArrayList <Shape> selectedShapeList;
    ArrayList <Shape> copyShapeList;

    public ShapeList(PaintCanvasBase paintCanvas)
    {
        this.paintCanvas = paintCanvas;
    }

    void drawMasterList()
    {
        Graphics2D g = paintCanvas.getGraphics2D();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for (Shape shape: createdShapeList)
        {
            ShapeFactory factory = new ShapeFactory(shape);
            factory.drawShape(shape.strategy, paintCanvas);
        }
    }

    void drawSelectedList()
    {
        for (Shape shape: selectedShapeList)
        {
            ShapeType type = shape.getShapeType();
            int XOrigin = shape.getXOrigin();
            int YOrigin = shape.getYOrigin();
            int height = shape.getHeight();
            int width = shape.getWidth();
            int[] xValues = shape.getXValues();
            int[] yValues = shape.getYValues();

            ShapeFactory factory = new ShapeFactory(shape);
            IDrawShapeStrategy strategy = new SelectedShapeDecorator(shape.strategy, XOrigin, YOrigin, height, width, xValues, yValues, type);
            factory.drawShape(strategy, paintCanvas);
        }
    }

    void drawCopiedList()
    {
        for (Shape shape: copyShapeList)
        {
            ShapeFactory factory = new ShapeFactory(shape);
            factory.drawShape(shape.strategy, paintCanvas);
            createdShapeList.add(shape);
        }
    }

    /*void deleteSelectedList()
    {
        for (Shape shape: selectedShapeList)
        {
            createdShapeList.remove(shape);
        }
        selectedShapeList = new ArrayList<>();
    }*/
}
