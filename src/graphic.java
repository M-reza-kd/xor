import javax.swing.*;
import java.awt.*;

public class graphic{
        MyJButton[][] mapButton;
        JLabel whosTurn = new JLabel();
        JFrame frame = new JFrame();
        JPanel panel;
        public graphic(int n,int m){
                Font font = new Font("SansSerif", Font.BOLD | Font.ITALIC, 50);
                panel = new JPanel();
                whosTurn.setFont(font);
                frame.setLayout(null);
                panel.setLayout(new GridLayout(n , m));
                frame.setBounds(0,0,800,900);
                mapButton = new MyJButton[n][m];
                for(int i = 0 ; i < n; i++)
                        for(int j = 0 ; j < m; j++) {
                                mapButton[i][j] = new MyJButton();
                                mapButton[i][j].setLOC(i , j);
                        }
                whosTurn.setBounds(0,0,800,100);
                panel.setBounds(0, 100, 800, 800);
                whosTurn.setText("1");
                frame.add(whosTurn);
                frame.add(panel);
                frame.repaint();
                frame.revalidate();
        }
}
