package designProblems.tictactoe.Models;

import designProblems.tictactoe.Exceptions.IllegalMoveException;
import designProblems.tictactoe.Exceptions.InvalidPlayersException;
import designProblems.tictactoe.Strategies.winningStratergy.WinningStrategy;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Game {
    private static final Integer PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_GAME_STATUS = GameStatus.IN_PROGRESS;
    private static Player winner = null;



    private Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus gameStatus;
    private int nextPlayerIndex = 0;
    private List<WinningStrategy> winningStrategies = new ArrayList<>();
    private static int moveCount = 0;

    public void start() {
        nextPlayerIndex = (int) (Math.random() * players.size());

        //set Game Status
        gameStatus = GameStatus.IN_PROGRESS;

    }

    public void makeMove() {
        // Get next Player and get Move
        BoardCell move = getNextMove();

        //Validate Move
        Boolean isValidMove = validateMove(move);

        //update Board
        board.updateBoard(move);

        //increment moveCount to check for draw
        moveCount += 1;

        //check for a winner
        if (checkWinner(move)){
            gameStatus = GameStatus.FINISHED;
            winner = this.getNextPlayer();
            return;
        }

        //check draw
        if(checkDraw()){
            gameStatus = GameStatus.DRAWN;
            return;
        }

        //update next player
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

    }

    private Boolean validateMove(BoardCell move) {
        if(!board.isEmpty(move.getRow(), move.getColumn())){
           throw new IllegalMoveException("Enter a valid move");
        }
        return true;
    }

    public Player getNextPlayer(){
        return players.get(nextPlayerIndex);
    }

    private BoardCell getNextMove() {
        Player player = players.get(nextPlayerIndex);
        return player.makeMove(board);
    }

    public boolean checkWinner(BoardCell move) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWin(board, move))
                return true;
        }
        return false;
    }

    public Boolean checkDraw() {
        int size = this.board.getSize();
        return moveCount == size * size;
    }


    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private Game game;

        public Builder(){
            game = new Game();
        }

        public Builder withSize(int size){
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player){
            this.game.getPlayers().add(player);
            return this;
        }

        public Builder withStratergies(List<WinningStrategy> winningStrategies){
            this.game.winningStrategies = winningStrategies;
            return this;
        }

        public Game build(){
            boolean isValid = validate();
            if(!isValid){
                throw new InvalidPlayersException("Invalid List of Players");
            }
            Game newGame = new Game();
            newGame.board = game.board;
            newGame.players = game.players;
            newGame.gameStatus = DEFAULT_GAME_STATUS;
            newGame.winningStrategies = game.winningStrategies;

            return newGame;
        }

        private boolean validate() {
            if(game.players.size() != PLAYER_COUNT){
                return false;
            }

            // If symbols are unique
            Set<Symbol> symbols = this.game.players.stream()
                    .map(Player::getSymbol)
                    .collect(Collectors.toSet());

            return symbols.size() == PLAYER_COUNT;
        }

    }
}
