import Methods.XYCoord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Main{
    private static JFrame Window;
    private static int width = 500, height = 700;
    private static Level ActiveLevel;

    private static ComponentListener CL =new ComponentListener() {
        @Override
        public void componentResized(ComponentEvent e) {
            width = Window.getWidth();
            height = Window.getHeight();
            Menu.Resize();
            Window.repaint();
            Window.setSize(width,height);
        }
        @Override
        public void componentMoved(ComponentEvent e) { }
        @Override
        public void componentShown(ComponentEvent e) { }
        @Override
        public void componentHidden(ComponentEvent e) { }
    };

    public static void main(String[] args) {
        LevelData.Init();
        Menu.Init();

        Window = new JFrame();
        Window.setSize(width, height);
        Window.setMinimumSize(new Dimension(400,200));
        Window.setVisible(true);

        Window.add(Menu.getPanel());
        Window.addComponentListener(CL);

        Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void loadMenu(){
        ActiveLevel.stop();
        Window.remove(ActiveLevel);
        CL.componentResized(null);
        Menu.getPanel().setVisible(true);
    }

    public static void loadLevel(int lNum){
        Menu.getPanel().setVisible(false);

        ActiveLevel = new Level(LevelData.getObstacles()[lNum],lNum);
        Window.add(ActiveLevel);
    }

    public static XYCoord getXYS(){
        return new XYCoord(width-17,height-40);
    }
}
