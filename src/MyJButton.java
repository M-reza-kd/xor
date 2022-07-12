import javax.swing.*;

public class MyJButton extends JButton {
        int x;
        int y;

        public int getx(){
                return this.x;
        }
        public int gety() {
                return y;
        }


        public void setLOC(int x, int y) {
                this.x = x;
                this.y = y;
        }
}
