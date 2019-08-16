package model;

import model.interfaces.ICommand;
import model.interfaces.IShapeDrawer;
import model.interfaces.IUndoRedo;

public class PasteCommand implements ICommand, IUndoRedo
{
    private ShapeList shapeList;

    public PasteCommand(ShapeList shapeList)
    {
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        if(shapeList.copyShapeList != null)
        {
            shapeList.drawCopiedList();

            CommandHistory.add(this);
        }
    }

    @Override
    public void undo()
    {
        for (IShapeDrawer shapeDrawer : shapeList.copyShapeList)
        {
            shapeList.createdShapeList.remove(shapeDrawer);
        }
        shapeList.drawMasterList();
    }

    @Override
    public void redo()
    {
        shapeList.drawCopiedList();
    }
}
