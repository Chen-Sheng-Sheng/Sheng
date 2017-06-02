import java.awt.*;
import java.util.*;
public class Game extends Thread
{
    private Thread me;
    private Controller controller;
    private ArrayList<Man> man;
    public Game(Controller controller)
    {
        this.controller = controller;
        me = this;
        man = new ArrayList<Man>();
    }
}
