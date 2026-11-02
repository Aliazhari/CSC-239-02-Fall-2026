import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private final Button[][] buttons = new Button[3][3];

    // Empty cell = "", player = X, computer = O
    private final String[][] board = new String[3][3];

    private Label statusLabel;
    private boolean gameOver = false;

    @Override
    public void start(Stage stage) {

        statusLabel = new Label("Your turn — you are X");
        statusLabel.setFont(Font.font(18));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                board[row][col] = "";

                Button button = new Button("");
                button.setPrefSize(110, 110);
                button.setFont(Font.font(36));

                final int r = row;
                final int c = col;

                button.setOnAction(e -> playerMove(r, c));

                buttons[row][col] = button;
                grid.add(button, col, row);
            }
        }

        Button restartButton = new Button("New Game");
        restartButton.setFont(Font.font(16));
        restartButton.setOnAction(e -> resetGame());

        VBox bottom = new VBox(12, statusLabel, restartButton);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(15));

        BorderPane root = new BorderPane();
        root.setCenter(grid);
        root.setBottom(bottom);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 390, 450);

        stage.setTitle("Tic-Tac-Toe vs Computer");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void playerMove(int row, int col) {

        if (gameOver || !board[row][col].isEmpty()) {
            return;
        }

        makeMove(row, col, "X");

        if (checkGameEnd()) {
            return;
        }

        statusLabel.setText("Computer is thinking...");

        // Find the computer's best move.
        int[] move = findBestMove();

        if (move[0] != -1) {
            makeMove(move[0], move[1], "O");
        }

        checkGameEnd();

        if (!gameOver) {
            statusLabel.setText("Your turn — you are X");
        }
    }

    private void makeMove(int row, int col, String symbol) {
        board[row][col] = symbol;
        buttons[row][col].setText(symbol);
        buttons[row][col].setDisable(true);
    }

    private boolean checkGameEnd() {

        if (hasWon("X")) {
            statusLabel.setText("Congratulations! You win!");
            gameOver = true;
            disableBoard();
            return true;
        }

        if (hasWon("O")) {
            statusLabel.setText("Computer wins! Try again.");
            gameOver = true;
            disableBoard();
            return true;
        }

        if (isBoardFull()) {
            statusLabel.setText("It's a draw!");
            gameOver = true;
            return true;
        }

        return false;
    }

    private boolean hasWon(String symbol) {

        // Check rows and columns.
        for (int i = 0; i < 3; i++) {

            if (board[i][0].equals(symbol)
                    && board[i][1].equals(symbol)
                    && board[i][2].equals(symbol)) {
                return true;
            }

            if (board[0][i].equals(symbol)
                    && board[1][i].equals(symbol)
                    && board[2][i].equals(symbol)) {
                return true;
            }
        }

        // Check diagonals.
        if (board[0][0].equals(symbol)
                && board[1][1].equals(symbol)
                && board[2][2].equals(symbol)) {
            return true;
        }

        return board[0][2].equals(symbol)
                && board[1][1].equals(symbol)
                && board[2][0].equals(symbol);
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setDisable(true);
            }
        }
    }

    // Minimax: find the best move for the computer.
    private int[] findBestMove() {

        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                if (board[row][col].isEmpty()) {

                    board[row][col] = "O";

                    int score = minimax(false);

                    board[row][col] = "";

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = row;
                        bestCol = col;
                    }
                }
            }
        }

        return new int[]{bestRow, bestCol};
    }

    private int minimax(boolean maximizing) {

        if (hasWon("O")) {
            return 10;
        }

        if (hasWon("X")) {
            return -10;
        }

        if (isBoardFull()) {
            return 0;
        }

        if (maximizing) {

            int bestScore = Integer.MIN_VALUE;

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {

                    if (board[row][col].isEmpty()) {
                        board[row][col] = "O";

                        int score = minimax(false);

                        board[row][col] = "";
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }

            return bestScore;

        } else {

            int bestScore = Integer.MAX_VALUE;

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {

                    if (board[row][col].isEmpty()) {
                        board[row][col] = "X";

                        int score = minimax(true);

                        board[row][col] = "";
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }

            return bestScore;
        }
    }

    private void resetGame() {

        gameOver = false;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "";
                buttons[row][col].setText("");
                buttons[row][col].setDisable(false);
            }
        }

        statusLabel.setText("Your turn — you are X");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
