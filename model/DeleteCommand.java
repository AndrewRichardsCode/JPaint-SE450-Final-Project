package model;

import model.interfaces.ICommand;
import model.interfaces.IShapeDrawer;
import model.interfaces.IUndoRedo;

import java.util.ArrayList;

public class DeleteCommand implements ICommand, IUndoRedo
{
    private ShapeList shapeList;
    private ArrayList<IShapeDrawer> selectedShapeListCopy;

    public DeleteCommand(ShapeList shapeList)
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
            }
            selectedShapeListCopy = shapeList.selectedShapeList;
            shapeList.selectedShapeList = new ArrayList<>();
            shapeList.drawMasterList();
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo()
    {
        shapeList.createdShapeList.addAll(selectedShapeListCopy);
        shapeList.selectedShapeList = selectedShapeListCopy;
        shapeList.drawMasterList();
    }

    @Override
    public void redo()
    {
        for (IShapeDrawer shapeDrawer: selectedShapeListCopy)
        {
            shapeList.createdShapeList.remove(shapeDrawer);
        }
        shapeList.selectedShapeList = new ArrayList<>();
        shapeList.drawMasterList();
    }
}
