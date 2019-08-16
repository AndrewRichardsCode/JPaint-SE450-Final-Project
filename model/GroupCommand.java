package model;

import model.interfaces.ICommand;
import model.interfaces.IShapeDrawer;
import model.interfaces.IUndoRedo;

import java.util.ArrayList;

public class GroupCommand implements ICommand, IUndoRedo
{
    private ShapeList shapeList;
    private ShapeGroup shapeGroup;

    public GroupCommand(ShapeList shapeList)
    {
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        if(shapeList.selectedShapeList != null)
        {
            shapeGroup = new ShapeGroup();
            for (IShapeDrawer shapeDrawer: shapeList.selectedShapeList)
            {
                shapeList.createdShapeList.remove(shapeDrawer);

                shapeGroup.addChild(shapeDrawer);
            }
            shapeList.createdShapeList.add(shapeGroup);
            shapeList.drawMasterList();
            shapeList.selectedShapeList = new ArrayList<>();
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo()
    {
        shapeList.createdShapeList.remove(shapeGroup);
        ArrayList<IShapeDrawer> shapes =  shapeGroup.children;
        shapeList.createdShapeList.addAll(shapes);
        shapeList.selectedShapeList = new ArrayList<>();
        shapeList.drawMasterList();
    }

    @Override
    public void redo()
    {
        ArrayList<IShapeDrawer> shapes =  shapeGroup.children;
        shapeList.createdShapeList.removeAll(shapes);
        shapeList.createdShapeList.add(shapeGroup);
        shapeList.selectedShapeList = new ArrayList<>();
        shapeList.drawMasterList();
    }
}
