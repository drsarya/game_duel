import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter
public class Player {

    protected List<Card> cardList;
    protected int fine = 0;
    private Scanner scanner;

    public Player(Scanner scanner) {
        this.scanner = scanner;
        cardList = Card.generateDeck();
    }

    public Player() {
    }

    public Card makeMove() {
        for (int i = 0; i < cardList.size(); i++) {
            System.out.print(cardList.get(i).getValue());
            if (i < cardList.size() - 1) {
                System.out.print(", ");
            }
        }
        Card card = null;
        boolean bError = true;
        while (bError) {
            try {
                System.out.println();
                int value = scanner.nextInt();
                card = getCard(value);
                cardList.remove(card);
                bError = false;
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
        return card;
    }

    public void addFine(int value) {
        fine += value;
    }

    private Card getCard(int value) {
        for (Card card : cardList) {
            if (card.getValue() == value) {
                return card;
            }
        }
        throw new IllegalArgumentException("Карта не найдена");
    }
}
