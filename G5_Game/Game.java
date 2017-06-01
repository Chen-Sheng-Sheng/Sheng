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
            Model model = controller.getModel();
            Man player1 = model.getPlayer1();
            Man player2 = model.getPlayer2();
            int maxwidth = model.getBackGroundWidtht();
            int x1 = player1.getX();
            int x2 = player2.getX();
            int w = model.getBackGroundWidtht();
            int w1 = player1.getWidth();
            int w2 = player2.getWidth();
            if(x1<0){player1.setX(0);}
            if(x2<0){player2.setX(0);}
            if(x1>w-100){player1.setX(w-100);}
            if(x2>w-100){player2.setX(w-100);}
        }
    }
}
