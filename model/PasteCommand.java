package model;

import model.interfaces.ICommand;

public class PasteCommand implements ICommand
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
        }
    }
}
