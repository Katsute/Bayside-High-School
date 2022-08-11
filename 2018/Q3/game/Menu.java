import Methods.RelativeCoordinate;
import Methods.XYCoord;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Menu {
    private static JPanel Panel;
    private static int btnWidth = 100, btnHeight = 30;

    public static void Init(){
        Panel = new JPanel();
        Panel.setLayout(null);
    }

    public static void Resize() {
        Panel.removeAll();
        Panel.setSize((int) Main.getXYS().x, (int) Main.getXYS().y);

        for(int index = 0; index < LevelData.getObstacles().length; index ++) {
            JButton LevelBtn = new JButton("Level " + (index + 1));

            RelativeCoordinate RC = new RelativeCoordinate(1, -btnWidth - 10, 0, (index*btnHeight) + (index * 10) + 10);
            XYCoord XY = RC.AttachToXY(Main.getXYS());

            LevelBtn.setBounds( (int) XY.x, (int) XY.y, btnWidth, btnHeight);

            int sIndex = index;
            LevelBtn.addActionListener((ActionEvent e) -> Main.loadLevel(sIndex));
            LevelBtn.setEnabled(true);


            Panel.add(LevelBtn);
        }
    }

    public static JPanel getPanel(){
        return Panel;
    }
}
