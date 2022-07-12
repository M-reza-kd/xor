import javax.swing.*;

public class MyJButton extends JButton {
        int x;
        int y;
        public int getX(){
                return this.x;
        }
        public int getY() {
                return y;
        }

        public void setLoc(int x, int y) {
                this.x = x;
                this.y = y;
        }
}
