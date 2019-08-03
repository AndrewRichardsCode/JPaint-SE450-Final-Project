package model;

import controller.Point;
import model.interfaces.ICommand;

import java.util.ArrayList;

public class CopyCommand implements ICommand
{
    private ShapeList shapeList;

    public CopyCommand(ShapeList shapeList)
    {
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        shapeList.copyShapeList = new ArrayList<>();

        for (Shape shape: shapeList.selectedShapeList)
        {
            Shape copiedShape = new Shape(shape.currentState, new Point(shape.width, shape.height), new Point(0,0));
            copiedShape.shapeType = shape.shapeType;
            copiedShape.shadingType = shape.shadingType;
            copiedShape.shapePrimaryColor = shape.shapePrimaryColor;
            copiedShape.shapeSecondaryColor = shape.shapeSecondaryColor;
            shapeList.copyShapeList.add(copiedShape);
        }
    }
}
