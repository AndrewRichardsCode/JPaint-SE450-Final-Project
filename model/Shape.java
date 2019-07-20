package model;

import model.interfaces.IDrawShapeStrategy;

public class Shape
{

    IDrawShapeStrategy drawShapeStrategy;

    public Shape(IDrawShapeStrategy drawShapeStrategy)
    {
        this.drawShapeStrategy = drawShapeStrategy;
    }
}
