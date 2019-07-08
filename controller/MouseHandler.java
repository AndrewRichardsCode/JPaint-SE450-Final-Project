package controller;

import java.awt.event.*;
import model.*;
import model.interfaces.*;
import view.interfaces.PaintCanvasBase;



public class MouseHandler extends MouseAdapter
{

    private IApplicationState currentState;
    private PaintCanvasBase paintCanvas;
    private Point start;
    private Point end;
    private int width;
    private int height;
    private int xOrigin;
    private int yOrigin;


    public MouseHandler(IApplicationState currentState, PaintCanvasBase paintCanvas)
    {
        this.currentState = currentState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void mousePressed (MouseEvent e)
    {
        start = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased (MouseEvent e)
    {
        end = new Point(e.getX(), e.getY());

        if(currentState.getActiveStartAndEndPointMode() == StartAndEndPointMode.DRAW);
        {
            //set width and xOrigin
            if(end.getX() > start.getX())
            {
                width = end.getX() - start.getX();
                xOrigin = start.getX();
            }
            else
                {
                    width =  start.getX() - end.getX();
                    xOrigin = end.getX();
                }

            //set height and yOrigin
            if (end.getY() > start.getY())
            {
                height = end.getY() - start.getY();
                yOrigin = start.getY();
            }
            else
                {
                    height = start.getY() - end.getY();
                    yOrigin = start.getY() - height;
                }

            paintCanvas.getGraphics2D().fillRect(xOrigin, yOrigin, width, height);
        }
    }

    //public void mouseDragged (MouseEvent e) {}
    
}
