import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class Game {
        int turn;
        int numberOfPlayers;
        int n, m;
        int[][] board;
        int winner;
        Color[] Player;
        graphic Map;


        public void setN(int n){
                this.n = n;
        }
        public void setM(int m) {
                this.m = m;
        }
        public void setNumberOfPlayers(int numberOfPlayers) {
                this.numberOfPlayers = numberOfPlayers;
        }
        public void setBoard() {
                this.board = new int[n][m];
        }
        public void setPlayer() {
                Random rand = new Random();
                for(int i = 0; i < numberOfPlayers ; i++) {
                        int r = rand.nextInt(255), g = rand.nextInt(255), b = rand.nextInt(255);
                        Player[i] = new Color(r, g, b);
                }
        }
        public int getWinner() {
                return winner;
        }

        public Game(int numberOfPlayers, int n, int m){
                setNumberOfPlayers(numberOfPlayers);
                setN(n);
                setM(m);
                setBoard();
                setPlayer();
                turn = 0;
                winner = 0;
                Map = new graphic(n , m);

                ActionListener actionListener = e1 -> {
                        int t = Integer.parseInt(Map.whosTurn.getText());
                        MyJButton src = (MyJButton) e1.getSource();
                        if(board[src.getX()][src.getY()] != 0) {
                                src.setBackground(Player[t]);
                                ChangeTurn();
                        }
                        else{
                                try {
                                        throw new IOException("Select valid place");
                                } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                }
                        }
                };

                for(int i = 0; i < n ; i++)
                        for(int j = 0; j < m; j++)
                                Map.mapButton[i][j].addActionListener(actionListener);
        }

        public void ChangeTurn(){
                CheckForWinner();
                if(winner == 0) {
                        turn++;
                        turn %= numberOfPlayers;
                }else{
                        System.out.println("the winner is the " + winner + "'th person");
                        Map.whosTurn.setText("the winner is the " + winner + "'th person");
                }
        }
        public void CheckForWinner(){
                for(int i = 0; i < n; i++)
                        for(int j = 0; j  + 2 < m; j++)
                                if(board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2])
                                        winner = board[i][j];
                for(int j = 0; j < m; j++)
                        for(int i = 0; i + 2 < n; i++)
                                if(board[i][j] == board[i + 1][j] && board[i + 2][j] == board[i + 2][j])
                                        winner = board[i][j];
                for(int i = 0; i + 2 < n; i++)
                        for(int j = 0; j + 2 < m; j++)
                                if(board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2])
                                        winner = board[i][j];
                for(int i = 2; i < n; i++)
                        for(int j = 2; j < m; j++)
                                if(board[i][j] == board[i - 1][j - 1] && board[i][j] == board[i - 2][j - 2])
                                        winner = board[i][j];
        }
}
