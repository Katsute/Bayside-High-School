import Methods.PolarCoord;
import Methods.RelativeCoordinate;
import Methods.XYCoord;
import Obstacles.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Level extends JPanel implements KeyListener, ActionListener{
    private XYCoord MainXYS = Main.getXYS();
    // Timer (ms)
    private Timer timer = new Timer(10,this);
    // User
    private Color UserColor = new Color(85,85,255);
    private Ellipse2D User = new Ellipse2D.Double( (MainXYS.x/2) - 25,25,50,50);
    // Overlay
    private int UserLives = 3;
    private JLabel LivesTextBox, LevelTextBox;
    private JButton MainBtn;
    // Obstacles
    private Obstacle[] Obstacles;
    // Safezone / Target
    private int safezone = 90;
    private double rate = 5;
    private Rectangle2D Target = new Rectangle2D.Double(0,MainXYS.y-10,MainXYS.x,10);
    private Rectangle2D UpperSafezone = new Rectangle2D.Double(0,0,MainXYS.y,safezone);
    private Rectangle2D LowerSafezone = new Rectangle2D.Double(0,MainXYS.y-safezone,MainXYS.x,safezone);

    // Init
    public Level(Obstacle[] Obstacles, int level){
        this.Obstacles = Obstacles;
        this.MainXYS = Main.getXYS();

        this.setLayout(null);
        XYCoord XYP; // XY Position
        JButton MainBtn = new JButton("Main Menu");
            XYP = new RelativeCoordinate(0,5,0,5).AttachToXY(MainXYS);
            MainBtn.setBounds((int) XYP.x,(int) XYP.y,100,25);
            MainBtn.addActionListener((ActionEvent e) -> Main.loadMenu());
            MainBtn.setEnabled(true);
            this.MainBtn = MainBtn;
            this.add(MainBtn);
        JLabel LifeNum = new JLabel("Lives: " + UserLives);
            XYP = new RelativeCoordinate(0.5,-50,0,5).AttachToXY(MainXYS);
            LifeNum.setBounds( (int) XYP.x,(int) XYP.y,100,25);
            LifeNum.setEnabled(true);
            LivesTextBox = LifeNum;
            this.add(LifeNum);
        JLabel LevelNum = new JLabel("Level: " + level);
            XYP = new RelativeCoordinate(1,-105,0,5).AttachToXY(MainXYS);
            LevelNum.setBounds((int) XYP.x, (int) XYP.y,100,25);
            LevelNum.setEnabled(true);
            LevelTextBox = LevelNum;
            this.add(LevelNum);

        this.addKeyListener(this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        XYCoord XYP; // XY Position
        XYP = new RelativeCoordinate(0.5,-50,0,5).AttachToXY(MainXYS);
            LivesTextBox.setBounds((int) XYP.x,(int) XYP.y,100,25);
        XYP = new RelativeCoordinate(1,-105,0,5).AttachToXY(MainXYS);
            LevelTextBox.setBounds((int) XYP.x,(int) XYP.y,100,25);

        G2D.setColor(new Color(85,255,85)); // Target Color

        XYCoord XYS; // XY Size
        XYS = new RelativeCoordinate(1,0,0,10).AttachToXY(MainXYS);
        XYP = new RelativeCoordinate(0,0,1,-10).AttachToXY(MainXYS);
            Target.setRect(XYP.x,XYP.y,XYS.x,XYS.y);
            G2D.fill(Target);

        G2D.setColor(Color.BLACK); // Safezone Color
        XYS = new RelativeCoordinate(1,0,0,safezone).AttachToXY(MainXYS);
        XYP = new RelativeCoordinate(0,0,1,-safezone).AttachToXY(MainXYS);
            LowerSafezone.setRect(XYP.x,XYP.y,XYS.x,XYS.y);
            G2D.draw(LowerSafezone);
        XYS = new RelativeCoordinate(1,0,0,safezone).AttachToXY(MainXYS);
        XYP = new RelativeCoordinate(0,0,0,0).AttachToXY(MainXYS);
            UpperSafezone.setRect(XYP.x,XYP.y,XYS.x,XYS.y);
            G2D.draw(UpperSafezone);

        G2D.setColor(UserColor); // User Color
        G2D.fill(User);

        for(int index = 0; index < Obstacles.length; index++){
            Obstacle LoopObstacle = Obstacles[index];
            G2D.setColor(LoopObstacle.getColor());
            G2D.fill(LoopObstacle.getObstacle());
        }

        LivesTextBox.setText("Lives: " + UserLives);
        if(UserLives <= 0){
            Main.loadMenu();
        }
        grabFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        this.MainXYS = Main.getXYS();
        if(User.intersects(Target)){
            Main.loadMenu();
        }

        XYCoord NextXY = new XYCoord(User.getX(),User.getY());

        for(int index = 0; index < Obstacles.length; index++){
            Obstacle LoopObstacle = Obstacles[index];

            double MaxX = LoopObstacle.getObstacle().getBounds2D().getMaxX();
            double MaxY = LoopObstacle.getObstacle().getBounds2D().getMaxY();
            if(LoopObstacle.hasLinearPath()){
                LoopObstacle.setXY(LoopObstacle.getXY().x + LoopObstacle.getXV_DV(), LoopObstacle.getXY().y + LoopObstacle.getYV_PR());


                if (MaxX > MainXYS.x) {             // Right bounds
                    LoopObstacle.setXV_DV(Math.abs(LoopObstacle.getXV_DV()) * -1);
                } else if (LoopObstacle.getXY().x < 0) {                    // Left bounds
                    LoopObstacle.setXV_DV(Math.abs(LoopObstacle.getXV_DV()));
                }

                if (MaxY > MainXYS.y - safezone) { // Lower bounds
                    LoopObstacle.setYV_PR(Math.abs(LoopObstacle.getYV_PR()) * -1);
                } else if (LoopObstacle.getXY().y < safezone) {             // Upper bounds
                    LoopObstacle.setYV_PR(Math.abs(LoopObstacle.getYV_PR()));
                }

                if(LoopObstacle.isIntersecting(Obstacles)){
                    LoopObstacle.setXV_DV(LoopObstacle.getXV_DV()*-1);
                    LoopObstacle.setYV_PR(LoopObstacle.getYV_PR()*-1);
                }
            }else{
                LoopObstacle.CurrentDegree += LoopObstacle.getXV_DV();
                PolarCoord NextPolarCoord = new PolarCoord( LoopObstacle.CurrentDegree + LoopObstacle.getXV_DV(), LoopObstacle.getYV_PR());
                XYCoord NextXYCoord = NextPolarCoord.toXY();

                NextXYCoord.x += LoopObstacle.getxOffset();
                NextXYCoord.y += LoopObstacle.getyOffset();

                LoopObstacle.setXY(NextXYCoord);
            }


            if(User.intersects(LoopObstacle.getXY().x,LoopObstacle.getXY().y,LoopObstacle.getObstacle().getBounds2D().getWidth(),LoopObstacle.getObstacle().getBounds2D().getHeight())){
                NextXY.x = (MainXYS.x/2) - 25;
                NextXY.y = 25;
                UserLives--;
            }

            User.setFrame(NextXY.x,NextXY.y,User.getWidth(),User.getHeight());
        }
        repaint();
    }

    public void stop(){
        timer.stop();
    }

    @Override
    public void keyTyped(KeyEvent e) { keyPressed(e);}

    @Override
    public void keyPressed(KeyEvent e) {
        this.MainXYS = Main.getXYS();
        int Key = e.getKeyCode();
        double NextX = User.getX(), NextY = User.getY();

        if(
                (Key == KeyEvent.VK_W || Key == KeyEvent.VK_UP) &&
                (User.getY() - rate > 0)
            ) {
            NextY -= rate;
        }else if(
                (Key == KeyEvent.VK_S || Key == KeyEvent.VK_DOWN) &&
                ( User.getMaxY() + rate < MainXYS.y )
            ){
                NextY += rate;
        }else if(
                (Key == KeyEvent.VK_A || Key == KeyEvent.VK_LEFT) &&
                (User.getX() - rate > 0)
            ){
            NextX -= rate;
        }else if(
                (Key == KeyEvent.VK_D || Key == KeyEvent.VK_RIGHT) &&
                ( (User.getMaxX() + rate) < MainXYS.x)
            ){ // D / >
            NextX += rate;
        }

        User.setFrame(NextX,NextY,User.getWidth(),User.getHeight());
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}
