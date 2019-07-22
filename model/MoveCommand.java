package model;

import controller.Point;
import model.interfaces.ICommand;

//import java.io.IOException;

public class MoveCommand implements ICommand
{
    private Point pointStart;
    private Point pointEnd;

    public MoveCommand (Point pointStart, Point pointEnd)
    {
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
    }

    @Override
    public void run() //throws IOException
    {

        //clear canvas
        //loop through selected shapes list and offset start/end point(get the difference in end and start values)
        //loop through created shapes list, create factory object, and redraw all shapes

    }
}
