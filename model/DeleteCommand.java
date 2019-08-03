package model;

import model.interfaces.ICommand;

public class DeleteCommand implements ICommand
{
    private ShapeList shapeList;

    public DeleteCommand(ShapeList shapeList)
    {
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        if(shapeList.selectedShapeList != null)
        {
            shapeList.deleteSelectedList();
            shapeList.drawMasterList();
        }
    }
}
