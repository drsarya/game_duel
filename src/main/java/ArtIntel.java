import java.util.ArrayList;
import java.util.List;

public class ArtIntel extends Player {

    public ArtIntel() {
        cardList = Card.generateDeck();
    }

    List<Card> outCards = new ArrayList<>();

    @Override
    public Card makeMove() {
        //   int value = scanner.nextInt();
       /* int value = -10000;
        Card card = new Card(value);
        if (cardList.contains(card)) {
            cardList.remove(card);
            return card;
        }*/
        return cardList.get(0);
    }

    public void addOut(Card card) {
        outCards.add(card);
    }
}
