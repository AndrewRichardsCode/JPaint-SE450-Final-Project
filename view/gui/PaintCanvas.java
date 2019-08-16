package view.gui;

import view.interfaces.PaintCanvasBase;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends PaintCanvasBase
{
    private static PaintCanvas instance = new PaintCanvas();
    private PaintCanvas(){}

    public static PaintCanvas getInstance()
    {
        return instance;
    }

    public Graphics2D getGraphics2D()
    {
        return (Graphics2D)getGraphics();
    }
}
