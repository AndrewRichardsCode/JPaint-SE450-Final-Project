package model;

import model.interfaces.ICommand;
import model.interfaces.IShapeDrawer;
import model.interfaces.IUndoRedo;

import java.util.ArrayList;

public class UngroupCommand implements ICommand, IUndoRedo
{
    private ShapeList shapeList;
    private ArrayList<IShapeDrawer> groupedShapesCopy;
    private ShapeGroup shapeGroup;

    public UngroupCommand(ShapeList shapeList)
    {
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        if(shapeList.selectedShapeList != null)
        {
            for (IShapeDrawer shapeDrawer: shapeList.selectedShapeList)
            {

                shapeList.createdShapeList.remove(shapeDrawer);
                ArrayList<Shape> shapes = shapeDrawer.getShape();
                if (shapes.size() > 1)
                {
                    groupedShapesCopy = new ArrayList<>();
                    shapeGroup = new ShapeGroup();
                    for (Shape shape: shapes)
                    {
                        ShapeDrawer newShapeDrawer = new ShapeDrawer(shape);
                        shapeList.createdShapeList.add(newShapeDrawer);
                        groupedShapesCopy.add(newShapeDrawer);
                    }
                    for (IShapeDrawer newShapeDrawer : groupedShapesCopy) {
                        shapeGroup.addChild(newShapeDrawer);
                    }
                }
                else
                {
                    for (Shape shape : shapes)
                    {
                        ShapeDrawer newShapeDrawer = new ShapeDrawer(shape);
                        shapeList.createdShapeList.add(newShapeDrawer);
                    }
                }
            }
            shapeList.drawMasterList();
            shapeList.selectedShapeList = new ArrayList<>();
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo()
    {
        shapeList.createdShapeList.removeAll(groupedShapesCopy);
        shapeList.createdShapeList.add(shapeGroup);
        shapeList.selectedShapeList = new ArrayList<>();
        shapeList.drawMasterList();
    }

    @Override
    public void redo()
    {
        shapeList.createdShapeList.remove(shapeGroup);
        shapeList.createdShapeList.addAll(groupedShapesCopy);
        shapeList.selectedShapeList = new ArrayList<>();
        shapeList.drawMasterList();
    }
}
