import java.util.ArrayList;
import java.util.Collections;

    /*
   Lionel Quintanilla and Nathanael Gastelum
   February 3, 2019
   Purpose: This class contains the Deck object of the War game, which is used for the original 52-card deck
   and the decks used by the players. A Deck is capable of the normal functions such as dealing, adding, and
   seeing how many cards it has.
   */

public class Deck {

    // Declares the array list that will hold the cards themselves. The array list contains the Card object type .
    private ArrayList<Card> storage;

    // The possible suits and ranks for a card. Used to generate cards
    char cardSuits[] = {'S', 'H', 'D', 'C'};
    char cardRanks[] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};

    // Deck(): Constructor method. Creates a new deck. Takes no parameters. Does not return.
    public Deck() {

        // Initializes an empty array list
        storage = new ArrayList<>();

    }

    // generateDeck(): Method for creating a 52-card deck. Takes no parameters. Returns void.
    public void generateDeck() {

        // Iterates through the suits one at a time
        for (int i = 0; i < cardSuits.length; i++) {

            // Iterates through the ranks one at a time, for each suit
            for (int j = 0; j < cardRanks.length; j++) {
                // Adds a card to the deck with current rank and suit
                storage.add(new Card(cardRanks[j], cardSuits[i]));
            }
        }

    }

    // addCard(Card x): Method for adding a card to a deck. Takes a Card object as its parameter. Returns void.
    public void addCard(Card x) {

        // Adds the card to the front of the array list
        storage.add(x);

    }

    // dealCard(): Method for dealing a card from a deck. Takes no parameters. Returns a Card object.
    public Card dealCard() {

        // Initializes a new card
        Card newCard = null;

        // Will print an error message if the deck is empty
        if (storage.isEmpty() == true) {
            System.out.print("No more cards to deal");
        }

        // If the deck is empty, then a card will be dealt
        else {
            // Sets the new card to the top card in the array list
            newCard = storage.get(0);
            // Removes that card from the deck
            storage.remove(0);
        }

        // Returns the card
        return newCard;
    }

    // shuffleDeck(): Method for shuffling a deck. Takes no parameters. Returns void.
    public void shuffleDeck() {

        // Uses the "shuffle" function from the Collections library to shuffle the array list
        Collections.shuffle(storage);

    }

    // deckSize(): Method for getting the current size of a deck. Takes no parameters. Returns an integer.
    public int deckSize() {
        // Gets the size of the array list
        int size = storage.size();

        // Returns the size as an integer
        return size;
    }

    // toString(): Method for outputting information about the Deck object. Takes no parameters. Returns a String object.
    public String toString() {
        // Initializes the String object the information will be placed in
        String message = ("Deck: ");

        // Places the size of the deck in the information
        message += (deckSize() + " cards\n");

        int counter = 0;

        // Places the current deck in a rectangular printout in the information
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

        // Returns the String of information
        return message;
    }
}
