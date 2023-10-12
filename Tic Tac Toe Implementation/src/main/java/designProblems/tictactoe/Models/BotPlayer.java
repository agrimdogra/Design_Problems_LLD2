package designProblems.tictactoe.Models;

import designProblems.tictactoe.Strategies.moveStratergy.MoveStartegy;
import designProblems.tictactoe.Strategies.moveStratergy.RandomPlayingStrategy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString

public class BotPlayer extends Player{
    private Level level;
    private MoveStartegy moveStartergy;
    public BotPlayer(Symbol symbol, Level level, MoveStartegy moveStartergy){
        super(symbol);
        this.level = level;
        this.moveStartergy = moveStartergy;
    }

    private BotPlayer(){}

    @Override
    public BoardCell makeMove(Board board) {
        BoardCell cell =  moveStartergy.makeMove(board);
        cell.setSymbol(this.getSymbol());
        return cell;
    }

    public static Builder BotPlayerBuilder(){
        return new Builder();
    }

    /**
     * Implementing Builder pattern
     */
    public static class Builder{
        private BotPlayer botPlayer;

        public Builder() {
            this.botPlayer = new BotPlayer();
        }

        public Builder X(){
            this.botPlayer.setSymbol(Symbol.X);
            return this;
        }

        public Builder O(){
            this.botPlayer.setSymbol(Symbol.O);
            return this;
        }

        public Builder level(Level level){
            this.botPlayer.level = level;
            return this;
        }

        public Builder setSymbol(Symbol symbol){
            List<Symbol> unusedSymbols = Arrays.stream(Symbol.values()).toList().stream()
                    .filter(sym-> !(sym == symbol) )
                    .toList();
            int randomNum = (int) (Math.random() * unusedSymbols.size());
            this.botPlayer.setSymbol(unusedSymbols.get(randomNum));
            return this;
        }
        public Builder strategy(){
            this.botPlayer.moveStartergy = new RandomPlayingStrategy();
            return this;
        }

        public Builder stratergy(MoveStartegy moveStartergy){
            this.botPlayer.moveStartergy = new RandomPlayingStrategy();
            return this;
        }

        public BotPlayer build(){
            BotPlayer newBotPlayer = new BotPlayer();
            newBotPlayer.setSymbol(botPlayer.getSymbol());
            newBotPlayer.level = botPlayer.level;
            newBotPlayer.moveStartergy = botPlayer.moveStartergy;
            return newBotPlayer;
        }

    }
}
