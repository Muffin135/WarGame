import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> storage;

    char cardSuits[] = {'S', 'H', 'D', 'C'};
    char cardRanks[] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};

    public Deck() {

        storage = new ArrayList<>();

    }

    public void generateDeck() {

        for (int i = 0; i < cardSuits.length; i++) {

            for (int j = 0; j < cardRanks.length; j++) {
                storage.add(new Card(cardRanks[j], cardSuits[i]));
            }
        }

    }


    public void addCard(Card x) {

        storage.add(x);

        //System.out.print("Adding card: ");
        //x.printCard();
    }

    public Card dealCard() {

        Card newCard = null;

        if (storage.isEmpty() == true) {
            System.out.print("No more cards to deal");
        }
        else {
            newCard = storage.get(0);
            storage.remove(0);
        }

        //System.out.print("Dealing card: ");
        //newCard.printCard();

        return newCard;
    }

    public void shuffleDeck() {

        Collections.shuffle(storage);

    }

    public int deckSize() {
        int size = storage.size();
        //System.out.println("Deck Size: " + size + "\n");
        return size;
    }

    public String toString() {
        String message = ("Current deck:\n");

        int counter = 0;

        for (int i = 0; i < deckSize(); i++) {
            Card currCard = storage.get(i);
            String cardFace = currCard.toString();
            cardFace = cardFace.split("Card: ")[1];

            message += (cardFace + " ");

            counter++;

            if (counter == 12) {
                message += "\n";
                counter = 0;
            }
        }

        return message;
    }
}
