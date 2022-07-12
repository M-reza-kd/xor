import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class graphic extends JComponent {
        MyJButton[][] mapButton;
        JTextField whosTurn;

        public graphic(int n,int m){
                this.setLayout(null);
                this.setBounds(100,100,800,900);
                mapButton = new MyJButton[n][m];
                for(int i = 0 ; i < n; i++)
                        for(int j = 0 ; j < m; j++) {
                                mapButton[i][j] = new MyJButton();
                                mapButton[i][j].setLoc(i , j);
                                mapButton[i][j].setBackground(Color.WHITE);
                        }

                this.add(mapButton, n, m);
                whosTurn.setBounds(0,0,800,100);
                whosTurn.setText("1");
                this.add(whosTurn);


        }

        private void add(JButton[][] mapButton,int n, int m) {
                int h = 800 / n, w = 800 / m;
                for(int i = 0; i < n ; i++)
                        for(int j = 0; j < m; j++) {
                                mapButton[i][j].setBounds(100 + i * h, j * w, w, h);
                                this.add(mapButton[i][j]);
                        }
        }
}
