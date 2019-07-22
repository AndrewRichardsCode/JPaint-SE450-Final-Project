package model;

import controller.Point;

import java.awt.*;

import java.util.EnumMap;

public class Shape
{
    private ShapeColor selectedPrimaryColor;
    private ShapeColor selectedSecondaryColor;
    private ShapeShadingType shadingType;
    private Point pointEnd;
    Point pointStart;
    Color shapePrimaryColor;
    Color shapeSecondaryColor;

    private int width;
    private int height;
    private int[] xValues = new int[3];
    private int[] yValues = new int[3];

    Shape(ShapeColor selectedPrimaryColor, ShapeColor selectedSecondaryColor, ShapeShadingType shadingType, Point pointEnd, Point pointStart)
    {
        this.selectedPrimaryColor = selectedPrimaryColor;
        this.selectedSecondaryColor = selectedSecondaryColor;
        this.shadingType = shadingType;
        this.pointEnd = pointEnd;
        this.pointStart = pointStart;
    }

    int getWidth ()
    {
        if (pointEnd.getX() > pointStart.getX())
            { width = pointEnd.getX() - pointStart.getX(); }
        else
            { width = pointStart.getX() - pointEnd.getX(); }
        return width;
    }

    int getHeight()
    {
        if (pointEnd.getY() > pointStart.getY())
            { height = pointEnd.getY() - pointStart.getY(); }
        else
            { height = pointStart.getY() - pointEnd.getY(); }
        return height;
    }

    int getXOrigin()
    {
        int xOrigin;
        if (pointEnd.getX() > pointStart.getX())
            { xOrigin = pointStart.getX(); }
        else
            { xOrigin = pointEnd.getX(); }
        return xOrigin;
    }

    int getYOrigin()
    {
        int yOrigin;
        if (pointEnd.getY() > pointStart.getY())
            { yOrigin = pointStart.getY(); }
        else
            { yOrigin = pointStart.getY() - height; }
        return yOrigin;
    }

    ShapeShadingType getShadingType()
    {
        return shadingType;
    }

    void setShapeColor() //move to constructor
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

    int [] getTriangleXValues ()
    {
        xValues[0] = pointStart.getX();
        xValues[1] = pointEnd.getX();
        if (pointEnd.getX() > pointStart.getX())
            { xValues[2] = pointStart.getX() + width; }
        else
            { xValues[2] = pointEnd.getX(); }
        return xValues;
    }

    int [] getTriangleYValues ()
    {
        yValues[0] = pointStart.getY();
        yValues[1] = pointEnd.getY();
        if (pointEnd.getY() > pointStart.getY())
            { yValues[2] = pointEnd.getY() - height; }
        else
            { yValues[2] = pointEnd.getY() + height; }
        return yValues;
    }
}
