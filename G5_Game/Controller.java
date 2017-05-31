import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
public class Controller
{
    private Model model;
    private View viewer;
    private Counter counter;
    public Controller(Model model,View viewer)
    {
        this.model = model;
        this.viewer = viewer;
        model.setController(this);
        viewer.setController(this);
        viewer.setPanel();
        counter = new Counter(this);
        counter.start();
    }
    public Model getModel()
    {
        return model;
    }
    public void notifyTime(Model model)
    {
        viewer.refreshTime(model.getSecond());
    }
    public Man getPlayer1(){return model.getPlayer1();}
    public Man getPlayer2(){return model.getPlayer2();}
}
