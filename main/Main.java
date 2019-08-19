package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseHandler;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = PaintCanvas.getInstance();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        ShapeList shapeList = new ShapeList(paintCanvas);
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList);
        MouseHandler mouse = new MouseHandler(appState, shapeList);

        controller.setup();
        paintCanvas.addMouseListener(mouse);
    }
}
