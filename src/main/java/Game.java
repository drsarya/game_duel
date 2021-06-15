import java.util.Scanner;

public class Game {

    private Player playerOne;
    private ArtIntel aiPlayer;
    private Scanner scanner;

    private void initGame() {
        scanner = new Scanner(System.in);
        playerOne = new Player(scanner);
        aiPlayer = new ArtIntel();
    }

    public Game() {
        initGame();
    }

    public void game() throws InterruptedException {
        boolean state = true;
        while (playerOne.getCardList().size() > 0) {
            Card one, two;

            if (state) {
                System.out.println("Ход игрока");
                one = playerOne.makeMove();
                System.out.println("ИИ защищается");
                Thread.sleep(1000);
                two = aiPlayer.makeMove(false);
                System.out.println("Выбор сделан! Игрок: " + one.getValue() + ", ИИ: " + two.getValue());
            } else {
                System.out.println("Ход ИИ");
                Thread.sleep(1000);
                one = aiPlayer.makeMove(true);
                System.out.println("Игрок защищается");
                two = playerOne.makeMove();
                System.out.println("Выбор сделан! ИИ: " + one.getValue() + ", Игрок: " + two.getValue());
            }
            takeFine(one, two, state);
            System.out.println();
            aiPlayer.addOut(one);
            state = !state;
        }
        getWinner();
    }

    private void takeFine(Card one, Card two, boolean state) {
        int value = one.getValue() - two.getValue();
        if (value > 0) {
            if (state) {
                //ходит игрок
                System.out.println("ИИ получает штраф: " + value);
                aiPlayer.addFine(value);
            } else {
                //ходит ИИ
                System.out.println("Игрок получает штраф: " + value);
                playerOne.addFine(value);
            }
        }
    }

    private void getWinner() {
        if (playerOne.getFine() > aiPlayer.getFine()) {
            System.out.println("ИИ выиграл со счётом: " + playerOne.getFine() + " " + aiPlayer.getFine());
        } else if (playerOne.getFine() < aiPlayer.getFine()) {
            System.out.println("Игрок выиграл: " + aiPlayer.getFine() + " " + playerOne.getFine());
        } else {
            System.out.println("Ничья: " + aiPlayer.getFine() + " " + playerOne.getFine());
        }
    }
}
