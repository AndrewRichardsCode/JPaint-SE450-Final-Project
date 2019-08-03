package model;

import model.interfaces.IDrawShapeStrategy;
import view.interfaces.PaintCanvasBase;

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
        for (Shape shape: createdShapeList)
        {
            ShapeFactory factory = new ShapeFactory(shape);
            IDrawShapeStrategy strategy = factory.setStrategy();
            factory.drawShape(strategy, paintCanvas);
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
            int[] xValues = shape.getTriangleXValues();
            int[] yValues = shape.getTriangleYValues();

            ShapeFactory factory = new ShapeFactory(shape);
            IDrawShapeStrategy strategy = new SelectedShapeDecorator(factory.setStrategy(), XOrigin, YOrigin, height, width, xValues, yValues, type);
            factory.drawShape(strategy, paintCanvas);
        }
    }

    void drawCopiedList()
    {
        for (Shape shape: copyShapeList)
        {
            ShapeFactory factory = new ShapeFactory(shape);
            IDrawShapeStrategy strategy = factory.setStrategy();
            factory.drawShape(strategy, paintCanvas);
            createdShapeList.add(shape);
        }
    }

    void deleteSelectedList()
    {
        for (Shape shape: selectedShapeList)
        {
            ShapeFactory factory = new ShapeFactory(shape);
            IDrawShapeStrategy strategy = new NullShape();

        }

    }
}
