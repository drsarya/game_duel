import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Card {
    private final int value;
    private final static int count = 12;

    public Card(int value) {
        this.value = value;
    }

    public static List<Card> generateDeck() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cards.add(new Card(i));
        }
        return cards;
    }
}
