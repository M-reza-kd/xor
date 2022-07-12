import java.awt.*;
import java.util.Random;

public class Game {
        int turn;
        int numberOfPlayers;
        int n, m;
        int[][] board;
        int winner;
        Color[] Player;

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
                turn = -1;
                winner = 0;
        }

        public void ChageTurn(){
                CheckForWinner();
                if(winner == 0) {
                        turn++;
                        turn %= numberOfPlayers;
                }else{
                        System.out.println("the winner is the " + winner + "'th person");
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
