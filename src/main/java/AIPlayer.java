import java.util.List;

public class AIPlayer extends Player {
    private List<Card> outCards;

    public AIPlayer() {
        cardList = Card.generateDeck();
        outCards = Card.generateDeck();
    }

    public void addRivalInfo(Card card) {
        outCards.remove(card);
    }

    public Card makeMove(boolean state) {
        //true - attack
        //false - defence
        int sum = getAverage();
        Card card;
        for (int i = 0; i < cardList.size(); i++) {
            if (state) {
                if (cardList.get(i).getValue() > sum && i + 1 < cardList.size()) {
                    card = cardList.get(i + 1);
                    cardList.remove(card);
                    return card;
                }
            } else {
                if (cardList.get(i).getValue() >= sum) {
                    card = cardList.get(i);
                    cardList.remove(card);
                    return card;
                }
            }
        }
        card = cardList.get(cardList.size() - 1);
        cardList.remove(card);
        return card;
    }

    private int getAverage() {
        double sum = 0;
        for (Card card : outCards) {
            sum += card.getValue();
        }
        sum /= outCards.size();
        return (int) Math.round(sum);
    }
}
