import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.lang.Thread;
public class Magician extends Man
{
    private ImgSequence standby;
    private ImgSequence moveRight;
    private ImgSequence moveLeft;
    private Image nowImg;
    private String path;
    private int height;
    private int width;
    private int x;
    private int y;
    public Magician()
    {
        path = "img/MagicianPeople/";
        standby = new ImgSequence();
        moveRight = new ImgSequence();
        moveLeft = new ImgSequence();
        height = 300;
        width = 300;
        x = 200;
        y = 300;
        //this.setBackground(null);
        //this.setOpaque(false);
        //setLayout(new BorderLayout());
        //setPreferredSize(new Dimension(width, height));
        try{
            standby.addImge(ImageIO.read(new File(path+"standby1.png")));
            moveRight.addImge(ImageIO.read(new File(path+"walk1_right.png")));
            moveRight.addImge(ImageIO.read(new File(path+"walk1_right.png")));
            moveRight.addImge(ImageIO.read(new File(path+"walk2_right.png")));
            moveRight.addImge(ImageIO.read(new File(path+"walk2_right.png")));
            moveLeft.addImge(ImageIO.read(new File(path+"walk1_left.png")));
            moveLeft.addImge(ImageIO.read(new File(path+"walk1_left.png")));
            moveLeft.addImge(ImageIO.read(new File(path+"walk2_left.png")));
            moveLeft.addImge(ImageIO.read(new File(path+"walk2_left.png")));
        }
        catch (Exception ex) {
            System.out.println("No found Magician!!!!!");
        }
        nowImg = standby.nextImge();
    }
    public void display()
    {
        this.setVisible(true);
        this.repaint();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(nowImg,0,0,width,height,null,null); 
    }
    public int getHeight(){return height;}
    public int getWidth(){return width;}
    public int getX(){return x;}
    public int getY(){return y;}
    public void setHeight(int height){this.height = height;}
    public void setWidth(int width){this.width = width;}
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setNowImg(String status)
    {
        switch(status)
        {
            case "moveRight":
                x+=10;
                nowImg = moveRight.nextImge();
                display();
                break;
            case "moveLeft":
                x-=10;
                nowImg = moveLeft.nextImge();
                display();
                break;
        }
    }
}
