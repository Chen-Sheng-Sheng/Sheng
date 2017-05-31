import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
public class Controller
{
    private Model model;
    private View viewer;
    private Counter counter;
    private Game game;
    public Controller(Model model,View viewer)
    {
        this.model = model;
        this.viewer = viewer;
        model.setController(this);
        viewer.setController(this);
        viewer.setPanel();
        counter = new Counter(this);
        game = new Game(this);
        counter.start();
        game.start();
    }
    public Model getModel()
    {
        return model;
    }
    public void notifyTime(Model model)
    {
        viewer.refreshTime(model.getSecond());
    }
}
