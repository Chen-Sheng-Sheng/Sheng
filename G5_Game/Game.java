import java.awt.*;
public class Game extends Thread
{
    private Thread me;
    private Controller controller;
    public Game(Controller controller)
    {
        this.controller = controller;
        me = this;
    }
    public void run()
       {
           while(Thread.currentThread() == me)
           {
               
           }
       }
}
