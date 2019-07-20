package controller;

import java.awt.event.*;
import model.*;
import model.interfaces.*;
import view.interfaces.PaintCanvasBase;



public class MouseHandler extends MouseAdapter
{

    private IApplicationState currentState;
    private PaintCanvasBase paintCanvas;
    private Point pointStart;

    public MouseHandler(IApplicationState currentState, PaintCanvasBase paintCanvas)
    {
        this.currentState = currentState;
        this.paintCanvas = paintCanvas;
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
            command = new DrawCommand(currentState, paintCanvas, pointStart, pointEnd);
            command.run();
        }
        else if(currentState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT))
        {
            //new select command
        }
        else if(currentState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE))
        {
            //new move command
        }
    }
}
