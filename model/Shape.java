package model;

import controller.Point;
import model.interfaces.IApplicationState;
import model.interfaces.IDrawShapeStrategy;

import java.awt.*;
import java.util.EnumMap;

class Shape
{
    IDrawShapeStrategy strategy;
    ShapeShadingType shadingType;
    ShapeType shapeType;
    Point pointEnd;
    Point pointStart;
    private ShapeColor selectedPrimaryColor;
    private ShapeColor selectedSecondaryColor;
    Color shapePrimaryColor;
    Color shapeSecondaryColor;
    IApplicationState currentState;
    private int xOrigin;
    private int yOrigin;
    private int width;
    private int height;
    private int[] xValues = new int[3];
    private int[] yValues = new int[3];

    Shape(IApplicationState currentState, Point pointEnd, Point pointStart)
    {
        this.currentState = currentState;
        selectedPrimaryColor = currentState.getActivePrimaryColor();
        selectedSecondaryColor = currentState.getActiveSecondaryColor();
        shadingType = currentState.getActiveShapeShadingType();
        shapeType = currentState.getActiveShapeType();
        this.pointEnd = pointEnd;
        this.pointStart = pointStart;

        setColors();
        setWidth();
        setHeight();
        setXOrigin();
        setYOrigin();
        setTriangleXValues();
        setTriangleYValues();
        setStrategy();
    }

    private void setWidth ()
    {
        if (pointEnd.getX() > pointStart.getX())
            { width = pointEnd.getX() - pointStart.getX(); }
        else
            { width = pointStart.getX() - pointEnd.getX(); }
    }
    int getWidth()
    {
        return width;
    }

    private void setHeight()
    {
        if (pointEnd.getY() > pointStart.getY())
            { height = pointEnd.getY() - pointStart.getY(); }
        else
            { height = pointStart.getY() - pointEnd.getY(); }
    }

    int getHeight()
    {
        return height;
    }

    void setXOrigin()
    {
        if (pointEnd.getX() > pointStart.getX())
            { xOrigin = pointStart.getX(); }
        else
            { xOrigin = pointEnd.getX(); }
    }
    int getXOrigin()
    {
        return xOrigin;
    }

    void setYOrigin()
    {
        if (pointEnd.getY() > pointStart.getY())
            { yOrigin = pointStart.getY(); }
        else
            { yOrigin = pointStart.getY() - height; }
    }
    int getYOrigin()
    {
        return yOrigin;
    }

    ShapeShadingType getShadingType()
    {
        return shadingType;
    }

    ShapeType getShapeType() {return shapeType;}

    void setTriangleXValues ()
    {
        xValues[0] = pointStart.getX();
        xValues[1] = pointEnd.getX();
        if (pointEnd.getX() > pointStart.getX())
            { xValues[2] = pointStart.getX() + width; }
        else
            { xValues[2] = pointEnd.getX(); }
    }

    int [] getXValues()
    {
        return xValues;
    }

    void setTriangleYValues ()
    {
        yValues[0] = pointStart.getY();
        yValues[1] = pointEnd.getY();
        if (pointEnd.getY() > pointStart.getY())
            { yValues[2] = pointEnd.getY() - height; }
        else
            { yValues[2] = pointEnd.getY() + height; }
    }

    int [] getYValues()
    {
        return yValues;
    }

    void setStrategy()
    {
        switch(shapeType)
        {
            case RECTANGLE:     strategy = new RectangleStrategy(width, height, xOrigin, yOrigin, shapePrimaryColor, shapeSecondaryColor);
                break;
            case TRIANGLE:      strategy = new TriangleStrategy(xValues, yValues, shapePrimaryColor, shapeSecondaryColor);
                break;
            case ELLIPSE:       strategy = new EllipseStrategy(width, height, xOrigin, yOrigin, shapePrimaryColor, shapeSecondaryColor);
                break;
            default:            throw new Error();
        }
    }

    private void setColors()
    {
        EnumMap<ShapeColor, Color> colorMap = new EnumMap <>(ShapeColor.class);
        colorMap.put(ShapeColor.BLACK, Color.BLACK);
        colorMap.put(ShapeColor.BLUE, Color.BLUE);
        colorMap.put(ShapeColor.CYAN, Color.CYAN);
        colorMap.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        colorMap.put(ShapeColor.GRAY, Color.GRAY);
        colorMap.put(ShapeColor.GREEN, Color.GREEN);
        colorMap.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        colorMap.put(ShapeColor.MAGENTA, Color.MAGENTA);
        colorMap.put(ShapeColor.ORANGE, Color.ORANGE);
        colorMap.put(ShapeColor.PINK, Color.PINK);
        colorMap.put(ShapeColor.RED, Color.RED);
        colorMap.put(ShapeColor.WHITE, Color.WHITE);
        colorMap.put(ShapeColor.YELLOW, Color.YELLOW);
        shapePrimaryColor = colorMap.get(selectedPrimaryColor);
        shapeSecondaryColor = colorMap.get(selectedSecondaryColor);

    }
}
