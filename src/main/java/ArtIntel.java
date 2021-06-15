import java.util.List;

public class ArtIntel extends Player {
    private List<Card> outCards;

    public ArtIntel() {
        cardList = Card.generateDeck();
        outCards = Card.generateDeck();
    }

    public void addOut(Card card) {
        outCards.remove(card);
    }

    public Card makeMove(boolean state) {
        //true - attack
        //false - defence
        int sum = getAverage();

        for (int i = 0; i < cardList.size(); i++) {
            if (state) {
                if (cardList.get(i).getValue() > sum && i + 1 < cardList.size())
                    return cardList.get(i + 1);
            } else {
                if (cardList.get(i).getValue() >= sum)
                    return cardList.get(i);
            }
        }
        return cardList.get(cardList.size() - 1);
    }

    private int getAverage() {
        double sum = 0;
        for (Card card : outCards) {
            sum += card.getValue();
        }
        sum /= cardList.size();
        return (int) Math.round(sum);
    }
}
