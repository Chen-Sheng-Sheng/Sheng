public class Model
{
    private Controller controller;
    private int second;
    private Man player1;
    private Man player2;
    public Model(int second)
    {
        this.second = second;
        this.controller = null;
        player1 = new Magician();
        player2 = new Magician();
    }
    public int getSecond()
    {
        return second;
    }
    public void setSecond(int second)
    {
        this.second = second;
        controller.notifyTime(this);
    }
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    public Man getPlayer1(){return this.player1;}
    public Man getPlayer2(){return this.player2;}
}
