package controller;

import java.awt.event.*;
import model.*;
import model.interfaces.*;

public class MouseHandler extends MouseAdapter
{

    private IApplicationState currentState;
    private Point pointStart;
    private ShapeList shapeList;

    public MouseHandler(IApplicationState currentState, ShapeList shapeList)
    {
        this.currentState = currentState;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed (MouseEvent e)
    {
        pointStart = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased (MouseEvent e)
    {
        ICommand command;
        Point pointEnd = new Point(e.getX(), e.getY());

        if(currentState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW))
        {
            command = new DrawCommand(currentState, shapeList, pointStart, pointEnd);
            command.run();
        }
        else if(currentState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT))
        {
            command = new SelectCommand(pointStart, pointEnd, shapeList);
            command.run();
        }
        else if(currentState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE))
        {
            command = new MoveCommand(pointStart, pointEnd, shapeList);
            command.run();
        }
    }
}
