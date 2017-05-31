import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.lang.Thread;
public class GamePanel extends JPanel implements KeyListener
{
    private Image backGroundImage;
    private TimePanel timePanel;
    private StatusPanel statusPanel;
    private Man player1;
    private Man player2;
    private int backGroundHeight;
    private int backGroundWidth;
    private JFrame jframe;
    private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public GamePanel()
    {
        String path = "img/";
        backGroundHeight = (int)(screenSize.getHeight());
        backGroundWidth = (int)screenSize.getWidth();
        try {
            this.setLayout(null);
            setPreferredSize(new Dimension(backGroundWidth, backGroundHeight));
            
            timePanel = new TimePanel();
            timePanel.setBounds((int)(backGroundWidth*0.48), 10, 70, 70);
            
            statusPanel = new StatusPanel();
            statusPanel.setBounds(10, 10, (int)(backGroundWidth*0.96), (int)(backGroundHeight*0.9));
            
            player1 = new Magician();
            player1.setBounds(player1.getX(),player1.getY(),player1.getWidth(),player1.getHeight());
        

            player2 = new Magician();
            player2.setBounds(player2.getX(),player2.getY(),player2.getWidth(),player2.getHeight());
            
            backGroundImage = ImageIO.read(new File(path+"background0.jpg"));//讀取背景圖片

            add(timePanel);//加入Panel
            add(statusPanel);
            add(player1);
            add(player2);
        }
        catch (Exception ex) {
              System.out.println("No found Imge!!!!!");
        }
        jframe = new JFrame("G5_JAVA_GAME");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(backGroundWidth,backGroundHeight);
        jframe.setContentPane(this);
        jframe.validate();
        jframe.setVisible(true);
        addKeyListener(this);
        jframe.addWindowListener(new WindowAdapter()
        {
           public void windowActivated( WindowEvent e){ 
               GamePanel.this.requestFocusInWindow(); //it is necessary to keep the keyboard event can be accept
            } 
           public void windowOpened( WindowEvent e){ 
               GamePanel.this.requestFocusInWindow(); //it is necessary to keep the keyboard event can be accept
           } 
        });
        this.requestFocusInWindow();
    }
    public void setUpTime(int second)
    {
        timePanel.setUp(second);
    }
    void display() 
    {
       this.setVisible(true);
       this.repaint();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //display the image(src, x, y, width, height, color, observer_call_back)
        g.drawImage(backGroundImage,0,0,backGroundWidth,backGroundHeight,null,null); 
    }
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                player1.setNowImg("moveRight");
                display();
                break;
            case KeyEvent.VK_A:
                player1.setNowImg("moveLeft");
                display();
                break;
            case KeyEvent.VK_RIGHT:
                player2.setNowImg("moveRight");
                display();
                break;
            case KeyEvent.VK_LEFT:
                player2.setNowImg("moveLeft");
                display();
                break;
        }
    }
    public void keyReleased(KeyEvent e){}
}
