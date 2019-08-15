package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoRedo;

import java.util.ArrayList;

public class DeleteCommand implements ICommand, IUndoRedo
{
    private ShapeList shapeList;
    private ArrayList<Shape> selectedShapeListCopy;

    public DeleteCommand(ShapeList shapeList)
    {
        this.shapeList = shapeList;
    }

    @Override
    public void run()
    {
        if(shapeList.selectedShapeList != null)
        {
            for (Shape shape: shapeList.selectedShapeList)
            {
                shapeList.createdShapeList.remove(shape);
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
        for (Shape shape: selectedShapeListCopy)
        {
            shapeList.createdShapeList.remove(shape);
        }
        shapeList.selectedShapeList = new ArrayList<>();
        shapeList.drawMasterList();
    }
}
