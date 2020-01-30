import java.util.Collections;
import java.util.ArrayList;

public class war {

    public static void main(String[] args) {


        warGame fullGame = new warGame();

        while (true) {
            fullGame.normalRound();
        }
    }


    private static class Card {

        private char suit;
        private char rank;

        // Card constructor; takes two characters as its parameters
        public Card(char r, char s) {

            // Creates a new array of characters called "Card", with the two character parameters as its values
            char[] Card = new char[]{r,s};

            // Sets the rank and suit variables of the class to the rank and suit values of the current card
            rank = r;
            suit = s;
        }

        public void printCard() {
            if (rank == 'T') {
                System.out.print("10" + suit + " ");
            }
            else {
                System.out.print(rank + "" + suit + " ");
            }
        }

        public int cardValue() {

            if (rank == 'A') {
                return 11;
            }

            else if (rank == 'T' || rank == 'J' || rank == 'Q' || rank == 'K') {
                return 10;
            }

            else {
                return Character.getNumericValue(rank);
            }
        }

    }

    private static class Deck {

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
    }

    private static class warGame {

        Deck gameDeck = new Deck();
        Deck playerOne = new Deck();
        Deck playerTwo = new Deck();


        public warGame() {

            gameDeck.generateDeck();

            gameDeck.shuffleDeck();

            int gameDeckSize = gameDeck.deckSize();

            int cardsPerPlayer = gameDeckSize/2;


            for (int k = 0; k < cardsPerPlayer; k++) {
                Card newCard = gameDeck.dealCard();
                playerOne.addCard(newCard);
                //newCard.printCard();
            }

            int playerOneDeckSize = playerOne.deckSize();

            System.out.println("Player 1 Deck Size: " + playerOneDeckSize + "\n");

            for (int h = 0; h < cardsPerPlayer; h++) {
                Card newCard = gameDeck.dealCard();
                playerTwo.addCard(newCard);
                //newCard.printCard();
            }

            int playerTwoDeckSize = playerTwo.deckSize();

            System.out.println("Player 2 Deck Size: " + playerTwoDeckSize + "\n");

        }

        public void normalRound() {

            if (playerOne.deckSize() == 0) {
                System.out.print("---------------------------------------------------\n");
                System.out.print("Player 1 has ran out of cards. Player 2 wins!\n");
                System.out.print("---------------------------------------------------\n");
                System.exit(0);
            }
            if (playerTwo.deckSize() == 0) {
                System.out.print("---------------------------------------------------\n");
                System.out.print("Player 2 has ran out of cards. Player 1 wins!\n");
                System.out.print("---------------------------------------------------\n");
                System.exit(0);
            }

            System.out.print("---------------------------------------------------\n");
            System.out.print("NEW ROUND\n\n");

            Card playerOneCard = playerOne.dealCard();
            int playerOneValue = playerOneCard.cardValue();
            System.out.print("Player 1's card: ");
            playerOneCard.printCard();
            System.out.print("\n");

            Card playerTwoCard = playerTwo.dealCard();
            int playerTwoValue = playerTwoCard.cardValue();
            System.out.print("Player 2's card: ");
            playerTwoCard.printCard();


            if (playerOneValue == playerTwoValue) {
                int warWinner = warRound();

                if (warWinner == 1) {
                    playerOne.addCard(playerOneCard);
                    playerOne.addCard(playerTwoCard);
                }
                else {
                    playerTwo.addCard(playerOneCard);
                    playerTwo.addCard(playerTwoCard);
                }

            }
            else if (playerOneValue > playerTwoValue) {
                System.out.print("\n\nPlayer 1 has the higher value. Player 1 wins the round.\n");
                playerOne.addCard(playerOneCard);
                playerOne.addCard(playerTwoCard);
            }
            else {
                System.out.print("\n\nPlayer 2 has the higher value. Player 2 wins the round.\n");
                playerOne.addCard(playerOneCard);
                playerOne.addCard(playerTwoCard);
            }



            System.out.print("\nPlayer 1 Deck Size: " + playerOne.deckSize());
            System.out.print("\nPlayer 2 Deck Size: " + playerTwo.deckSize() + "\n");


        }

        private int warRound() {

            System.out.print("\n\nCARDS ARE EQUAL. STARTING WAR:");

            if (playerTwo.deckSize() == 0) {
                System.out.print("\n\n---------------------------------------------------\n");
                System.out.print("Player 2 has ran out of cards. Player 1 wins!\n");
                System.out.print("---------------------------------------------------\n");
                System.exit(0);
            }

            Card[] playerOneWarCards = new Card[5];
            Card[] playerTwoWarCards = new  Card[5];

            System.out.print("\n\nPlayer 1's cards: xx xx xx xx xx");

            for (int i = 0; i < 5; i++) {

                if (playerOne.deckSize() == 0) {
                    System.out.print("\n\n---------------------------------------------------\n");
                    System.out.print("Player 1 has ran out of cards. Player 2 wins!\n");
                    System.out.print("---------------------------------------------------\n");
                    System.exit(0);
                }
                else {
                    Card newCard = playerOne.dealCard();
                    playerOneWarCards[i] = newCard;
                }
            }

            System.out.print("\nPlayer 2's cards: xx xx xx xx xx\n");

            for (int j = 0; j < 5; j++) {

                if (playerTwo.deckSize() == 0) {
                    System.out.print("\n---------------------------------------------------\n");
                    System.out.print("Player 1 has ran out of cards. Player 2 wins!\n");
                    System.out.print("---------------------------------------------------\n");
                    System.exit(0);
                }
                else {
                    Card newCard = playerTwo.dealCard();
                    playerTwoWarCards[j] = newCard;
                }
            }

            int index = 0;
            boolean allEqual = false;

            while (playerOneWarCards[index].cardValue() == playerTwoWarCards[index].cardValue() && index < 5) {

                if (index == 4) {
                    allEqual = true;
                }

                index++;

            }

            int winner = 0;

            if (allEqual== true) {
                warRound();
            }

            else {
                if (playerOneWarCards[index].cardValue() > playerTwoWarCards[index].cardValue()) {
                    System.out.print("\n\nPlayer 1 has the higher value. Player 1 wins the War round.\n");

                    for (int i = 0; i < 5; i++) {
                        playerOne.addCard(playerOneWarCards[index]);
                        playerOne.addCard(playerTwoWarCards[index]);
                    }

                    winner = 1;
                }
                else {
                    System.out.print("\n\nPlayer 2 has the higher value. Player 2 wins the War round.\n");

                    for (int i = 0; i < 5; i++) {
                        playerOne.addCard(playerOneWarCards[index]);
                        playerOne.addCard(playerTwoWarCards[index]);
                    }

                    winner = 2;
                }
            }

            return winner;
        }


    }


}
