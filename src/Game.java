import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class Game {
        int turn, n, m, numberOfPlayers, winner;
        int[][] board;
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
                Player = new Color[numberOfPlayers];
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
                winner = -1;
                Map = new graphic(n , m);
                Map.frame.setBounds(100,100,800,900);
                ActionListener actionListener = e1 -> {
                        MyJButton src = (MyJButton) e1.getSource();
                        if(board[src.getx()][src.gety()] != -1)
                                try {
                                        throw new IOException("select another loc");
                                } catch (IOException e) {
                                        throw new RuntimeException(e);
                                }
                        else {
                                src.setBackground(Player[turn]);
                                board[src.getx()][src.gety()] = turn;
                                ChangeTurn();
                        }
                };
                for(int i = 0; i < n ; i++)
                        for(int j = 0; j < m; j++){
                                MyJButton temp = Map.mapButton[i][j];
                                temp.addActionListener(actionListener);
                                Map.panel.add(temp);
                                board[i][j] = -1;
                        }
                Map.frame.setVisible(true);
        }

        public void ChangeTurn(){
                CheckForWinner();
                if(winner == -1) {
                        turn++;
                        turn %= numberOfPlayers;
                        Map.whosTurn.setText(String.valueOf(turn + 1));
                } else if  (winner == -2) {
                        Map.whosTurn.setText("pot");
                } else{
                        System.out.println("the winner is the " + (winner + 1) + "'th person");
                        Map.whosTurn.setText("the winner is the " + (winner + 1) + "'th person");
                }
        }
        public void CheckForWinner(){
                for(int i = 0; i < n; i++)
                        for(int j = 0; j  + 2 < m; j++)
                                if(board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] != -1)
                                        winner = board[i][j];
                for(int j = 0; j < m; j++)
                        for(int i = 0; i + 2 < n; i++)
                                if(board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] != -1)
                                        winner = board[i][j];
                for(int i = 0; i + 2 < n; i++)
                        for(int j = 0; j + 2 < m; j++)
                                if(board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && board[i][j] != -1)
                                        winner = board[i][j];
                for(int i = 2; i < n; i++)
                        for(int j = 2; j < m; j++)
                                if(board[i][j] == board[i - 1][j - 1] && board[i][j] == board[i - 2][j - 2] && board[i][j] != -1)
                                        winner = board[i][j];

                boolean flag = false;
                for(int i = 0 ; i < n; i++)
                        for(int j = 0; j < m ; j++)
                                if (board[i][j] == -1) {
                                        flag = true;
                                        break;
                                }
                if(!flag)
                        winner = -2;
        }
}
