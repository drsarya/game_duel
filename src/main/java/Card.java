import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Card {
    private final int value;
    private final static int count = 3;

    public Card(int value) {
        if (value >= 0 && value < count) {
            this.value = value;
        } else throw new IllegalArgumentException("Недопустимое значение карты");
    }

    public static List<Card> generateDeck() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cards.add(new Card(i));
        }
        return cards;
    }
}
