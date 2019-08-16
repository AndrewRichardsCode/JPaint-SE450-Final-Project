package model;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShapeDrawer;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class ShapeList
{
    private PaintCanvasBase paintCanvas;
    ArrayList <IShapeDrawer> createdShapeList = new ArrayList<>();
    ArrayList <IShapeDrawer> selectedShapeList;
    ArrayList <IShapeDrawer> copyShapeList;

    public ShapeList(PaintCanvasBase paintCanvas)
    {
        this.paintCanvas = paintCanvas;
    }

    void drawMasterList()
    {
        Graphics2D g = paintCanvas.getGraphics2D();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for (IShapeDrawer shapeDrawer: createdShapeList)
        {
            ArrayList<Shape> shapes = shapeDrawer.getShape();
            for (Shape shape: shapes)
            {
                IDrawShapeStrategy strategy = shape.strategy;
                shapeDrawer.drawShape(paintCanvas, strategy);
            }
        }
    }

    void drawSelectedList()
    {
        for (IShapeDrawer shapeDrawer: selectedShapeList)
        {
            ArrayList<Shape> shapes = shapeDrawer.getShape();
            for (Shape shape: shapes)
            {
                ShapeType type = shape.getShapeType();
                int XOrigin = shape.getXOrigin();
                int YOrigin = shape.getYOrigin();
                int height = shape.getHeight();
                int width = shape.getWidth();
                int[] xValues = shape.getXValues();
                int[] yValues = shape.getYValues();

                IDrawShapeStrategy strategy = new SelectedShapeDecorator(shape.strategy, XOrigin, YOrigin, height, width, xValues, yValues, type);
                shapeDrawer.drawShape(paintCanvas, strategy);
            }
        }
    }

    void drawCopiedList()
    {
        for (IShapeDrawer shapeDrawer: copyShapeList)
        {
            ArrayList<Shape> shapes = shapeDrawer.getShape();
            for (Shape shape: shapes)
            {
                IDrawShapeStrategy strategy = shape.strategy;
                shapeDrawer.drawShape(paintCanvas, strategy);
                createdShapeList.add(shapeDrawer);
            }
        }
    }
}
