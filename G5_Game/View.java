import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
public class View
{
    private Controller controller;
    private GamePanel gamePanel;
    public View()
    {
        this.controller = null;
        this.gamePanel = new GamePanel();
    }
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    public void refreshTime(int second)
    {
        gamePanel.setUpTime(second);
    }
}
