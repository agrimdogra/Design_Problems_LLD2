package designProblems.tictactoe.Controller;

import designProblems.tictactoe.Exceptions.IllegalBoardSizeException;
import designProblems.tictactoe.Factory.PlayingStrategyFactory;
import designProblems.tictactoe.Models.*;
import designProblems.tictactoe.Strategies.winningStratergy.WinningStrategy;
import designProblems.tictactoe.Strategies.winningStratergy.WinningStrategyFactory;
import designProblems.tictactoe.Strategies.winningStratergy.WinningTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    private static final int MIN_BOARD_SIZE = 3;
    public static final Scanner scanner = new Scanner(System.in);
    public static List<WinningStrategy> winningStrategies = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        HumanPlayer humanPlayer = getUserInput();

        //Get Board Size
        int sizeOfBoard = getBoardSize();

        // Get possible winning options from user.
        List<WinningTypes> winningTypes = getWinningOptions();
        winningStrategies = WinningStrategyFactory.getWinningStrategies(winningTypes);


        Player opponentPlayer = getOpponent(humanPlayer);


        //Create Game
        Game game = createGame(sizeOfBoard, humanPlayer, opponentPlayer, winningStrategies);
        game.start();

        while (game.getGameStatus() == GameStatus.IN_PROGRESS){
            //using player just to print details
            Player player = game.getNextPlayer();
            System.out.println("Next player: " + player.getSymbol() );

            //Make move
            game.makeMove();
            game.getBoard().printBoard();

        }

        printResult(game);


    }

    private static void printResult(Game game) {
        switch (game.getGameStatus()){
            case DRAWN -> System.out.println("No winner possible, its a Draw" );
            case FINISHED -> System.out.println("Game finished : " + game.getNextPlayer().getSymbol() +" won !!" );
        }


    }


    private static Game createGame(int sizeOfBoard, HumanPlayer humanPlayer, Player opponentPlayer, List<WinningStrategy> winningStrategies) {
        return Game.builder()
                .withSize(sizeOfBoard)
                .withPlayer(humanPlayer)
                .withPlayer(opponentPlayer)
                .withStratergies(winningStrategies)
                .build();
    }

    private static Player getOpponent(HumanPlayer humanPlayer) {

        // Get Opponent Type from user and check if it is not correct  Bot or Human.
        OpponentType opponentType = getOpponentFromUser();

        // If bot player get a valid Difficulty level and return new Bot player.
        if (opponentType == OpponentType.B) {
            Level difficultyLevel = getDifficultyLevel();
            return createBotPlayer(humanPlayer.getSymbol(), difficultyLevel);
        }
        return createHumanPlayer();
    }

    private static int getBoardSize() {
        System.out.println("Enter board size");
        int size = scanner.nextInt();
        if (size >= MIN_BOARD_SIZE)
            return size;
        else {
            throw new IllegalBoardSizeException("Enter a size >= 3");
        }
    }

    // Get User Input  and do basic Initialization for Game creation
    private static HumanPlayer getUserInput() {
        // Get name from User.
        System.out.println("Enter the name ");
        String name = scanner.nextLine();

        // Get email from user.
        System.out.println("Enter the EmailId");
        String email = scanner.nextLine();

        // Get Symbol from user and check if it is not correct.
        Symbol s = getSymbolFromUser();
        return new HumanPlayer(s,name, email, null);
    }




    private static HumanPlayer createHumanPlayer() {
        HumanPlayer humanPlayer = getUserInput();
        return humanPlayer;
    }

    private static Player createBotPlayer(Symbol s, Level difficultyLevel) {
        return BotPlayer.BotPlayerBuilder()
                .setSymbol(s)
                .level(difficultyLevel)
                .stratergy(PlayingStrategyFactory.getPlayingStrategy(difficultyLevel))
                .build();
    }

    private static List<WinningTypes> getWinningOptions() {
        scanner.nextLine();
        List<WinningTypes> winOptions = new ArrayList<>();
        for (WinningTypes winningType : WinningTypes.values()){
            System.out.println( "Do you want a " + winningType + " win?  (Y/N)");
            String inp = scanner.nextLine();
            if(inp.equalsIgnoreCase("Y"))
                winOptions.add(winningType);
        }
        return winOptions;
    }

    private static Level getDifficultyLevel() {
        boolean isValidLevel = false;
        Level level = null;
        do {
            System.out.println("Enter difficulty level for the game ( EASY or MEDIUM or HARD  ) ");
            try {
                level = Level.valueOf(scanner.nextLine());
                isValidLevel = true;
            }
            catch (IllegalArgumentException e){
                System.out.println("Please choose a correct Difficulty Level ( EASY or MEDIUM or HARD  ) ");
            }
        } while (!isValidLevel);
        return level;
    }

    private static OpponentType getOpponentFromUser() {
        boolean isValidOpponent = false;
        OpponentType opponentType = null;
        do {
            System.out.println("Press H to play vs another Player or press B to play against bot");
            try{
                opponentType = OpponentType.valueOf(scanner.nextLine());
                isValidOpponent = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Please choose a correct opponent Human (H) or Bot (B)");
            }
        } while(!isValidOpponent);

        return opponentType;
    }

    private static Symbol getSymbolFromUser() {
        boolean symbolChosen = false;
        Symbol symbol = null;
        do{
            System.out.println("Choose a Symbol from ( 0, X )");
            try{
                symbol = Symbol.valueOf(scanner.nextLine());
                symbolChosen = true;
            }
            catch (IllegalArgumentException e){
                System.out.println("You entered a wrong symbol.Please choose from the given list of symbols ( 0, X )");
            }
        } while (!symbolChosen);
        return symbol;
    }
}
