package model;

import controller.Point;
import model.interfaces.ICommand;
import model.interfaces.IShapeDrawer;

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
        if(shapeList.selectedShapeList != null)
        {
            shapeList.copyShapeList = new ArrayList<>();

            for (IShapeDrawer shapeDrawer : shapeList.selectedShapeList)
            {
                ArrayList<Shape> shapes = shapeDrawer.getShape();
                for (Shape shape: shapes)
                {

                    Shape copiedShape = new Shape(shape.currentState, new Point(shape.getWidth(), shape.getHeight()), new Point(0, 0));
                    copiedShape.shapeType = shape.shapeType;
                    copiedShape.shadingType = shape.shadingType;
                    copiedShape.shapePrimaryColor = shape.shapePrimaryColor;
                    copiedShape.shapeSecondaryColor = shape.shapeSecondaryColor;
                    copiedShape.setStrategy();
                    ShapeDrawer copiedShapeDrawer = new ShapeDrawer(copiedShape);
                    shapeList.copyShapeList.add(copiedShapeDrawer);
                }
            }
        }
    }
}
