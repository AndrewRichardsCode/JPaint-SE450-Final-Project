package model;

import controller.Point;

public class Shape
{
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private Point pointEnd;
    private Point pointStart;

    private int width;
    private int height;
    private int xOrigin;
    private int yOrigin;

    Shape(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, Point pointEnd, Point pointStart)
    {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
        this.pointEnd = pointEnd;
        this.pointStart = pointStart;
    }

    int getWidth ()
    {
        if (pointEnd.getX() > pointStart.getX()) {
            width = pointEnd.getX() - pointStart.getX();
        } else {
            width = pointStart.getX() - pointEnd.getX();
        }
        return width;
    }

    int getHeight()
    {
        if (pointEnd.getY() > pointStart.getY()) {
            height = pointEnd.getY() - pointStart.getY();
        } else {
            height = pointStart.getY() - pointEnd.getY();
        }
        return height;
    }

    int getXOrigin()
    {
        if (pointEnd.getX() > pointStart.getX())
        {
            xOrigin = pointStart.getX();
        }
        else {
            xOrigin = pointEnd.getX();
        }
        return xOrigin;
    }

    int getYOrigin() {
        if (pointEnd.getY() > pointStart.getY())
        {
            yOrigin = pointStart.getY();
        }
        else {
            yOrigin = pointStart.getY() - height;
        }
        return yOrigin;
    }

    ShapeShadingType getShadingType()
    {
        return shadingType;
    }

    ShapeColor getPrimaryColor()
    {
        return primaryColor;
    }

    ShapeColor getSecondaryColor()
    {
        return secondaryColor;
    }
}
