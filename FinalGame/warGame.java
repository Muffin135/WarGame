import java.util.ArrayList;

    /*
    Lionel Quintanilla and Nathanael Gastelum
    February 3, 2019
    Purpose: This class contains the main functionality of the War game, including setting up the game environment and
    the logic for how to play each type of round
    */

public class warGame {

    // Initializes the original deck that cards will be distributed from
    Deck gameDeck = new Deck();
    // Initializes the two decks that represent the players
    Deck playerOne = new Deck();
    Deck playerTwo = new Deck();

    // warGame(): Constructor method. Takes no parameters. Does not return.
    public warGame() {

        // Adds 52 cards to the original deck
        gameDeck.generateDeck();

        // Shuffles the 52 card deck
        gameDeck.shuffleDeck();

        // Gets the size of the deck
        int gameDeckSize = gameDeck.deckSize();

        // Divides the deck's size by 2 to get the number of cards per player
        int cardsPerPlayer = gameDeckSize/2;


        // Deals however many cards are needed to Player 1's deck
        for (int k = 0; k < cardsPerPlayer; k++) {
            Card newCard = gameDeck.dealCard();
            playerOne.addCard(newCard);
        }

        // Deals however many cards are needed to Player 2's deck
        for (int h = 0; h < cardsPerPlayer; h++) {
            Card newCard = gameDeck.dealCard();
            playerTwo.addCard(newCard);
        }

    }

    // normalRound(): Method that plays a normal round of War. Takes no parameters. Returns void.
    public void normalRound() {

        // Checks to see if Player 1's Deck is empty. If it is, the game ends and Player 2 wins.
        if (playerOne.deckSize() == 0) {
            System.out.print("---------------------------------------------------\n");
            System.out.print("Player 1 has ran out of cards. Player 2 wins!\n");
            System.out.print("---------------------------------------------------\n");
            System.exit(0);
        }

        // Checks to see if Player 2's Deck is empty. If it is, the game ends and Player 1 wins.
        if (playerTwo.deckSize() == 0) {
            System.out.print("---------------------------------------------------\n");
            System.out.print("Player 2 has ran out of cards. Player 1 wins!\n");
            System.out.print("---------------------------------------------------\n");
            System.exit(0);
        }

        // Text "divider" to indicate a new round
        System.out.print("---------------------------------------------------\n");
        System.out.print("NEW ROUND\n\n");

        // Deals and shows Player 1's card for the round
        Card playerOneCard = playerOne.dealCard();
        int playerOneValue = playerOneCard.cardValue();
        System.out.print("Player 1's card: ");
        playerOneCard.printCard();
        System.out.print("\n");

        // Deals and shows Player 2's card for the round
        Card playerTwoCard = playerTwo.dealCard();
        int playerTwoValue = playerTwoCard.cardValue();
        System.out.print("Player 2's card: ");
        playerTwoCard.printCard();

        // If the two cards are equal in value, the game will launch a War round
        if (playerOneValue == playerTwoValue) {

            // Creates empty array lists of capacity 4 for the War round
            // See the warRound() method for why this is necessary
            ArrayList<Card> empty1 = new ArrayList<>(4);
            ArrayList<Card> empty2 = new ArrayList<>(4);

            // Starts a new War round with empty array lists and listens for an integer indicating the winner
            int warWinner = warRound(empty1, empty2);

            // If the integer is 1, then Player 1 won and they are given the 2 cards from the original normal round
            // Note: At this point, the player would have already been given the cards from the War round(s) they won
            if (warWinner == 1) {
                playerOne.addCard(playerOneCard);
                playerOne.addCard(playerTwoCard);
            }
            // If the integer is not 1, then Player 2 won and they are given the 2 cards from the original normal round
            // Note: At this point, the player would have already been given the cards from the War round(s) they won
            else {
                playerTwo.addCard(playerOneCard);
                playerTwo.addCard(playerTwoCard);
            }

        }

        // If the cards are not equal, then the game will do a normal comparison

        // If Player 1's card has a higher value, they win the round and the two cards for the round
        else if (playerOneValue > playerTwoValue) {
            System.out.print("\n\nPlayer 1 has the higher value. Player 1 wins the round.\n");
            playerOne.addCard(playerOneCard);
            playerOne.addCard(playerTwoCard);
        }
        // If Player 2's card has a higher value, they win the round and the two cards for the round
        else {
            System.out.print("\n\nPlayer 2 has the higher value. Player 2 wins the round.\n");
            playerTwo.addCard(playerOneCard);
            playerTwo.addCard(playerTwoCard);
        }

    }

    // The method warRound plays a War round of War, which involves comparing 4 cards at a time with the same rules
    // Note: It is possible that in a War round the cards are all equal. In that case, another War round will be
    // needed. In this case, the new War round will need the cards from the previous War round in order to reward
    // the winner. To do this with one method, warRound() accepts two array lists containing the cards from the
    // previous round as parameters. The first War round launched from the normalRound() method passes two empty array
    // lists as a loophole to represent a lack of previous cards.

    // warRound(): Method for playing a War round. Takes two array lists as parameters. Returns an integer.
    public int warRound(ArrayList<Card> playerOnePrev, ArrayList<Card> playerTwoPrev) {

        // Text to indicate a new War round
        System.out.print("\n\nCARDS ARE EQUAL. STARTING WAR:");

        // Creates array lists of capacity 4 for the cards to be played in the War round
        ArrayList<Card> playerOneWarCards = new ArrayList<>(4);
        ArrayList<Card> playerTwoWarCards = new ArrayList<>(4);

        // Checks to see if Player 1's Deck is empty. If it is, the game ends and Player 2 wins.
        if (playerOne.deckSize() == 0) {
            System.out.print("\n\n---------------------------------------------------\n");
            System.out.print("Player 1 has ran out of cards. Player 2 wins!\n");
            System.out.print("---------------------------------------------------\n");
            System.exit(0);
        }

        // Checks to see if Player 2's Deck is empty. If it is, the game ends and Player 1 wins.
        if (playerTwo.deckSize() == 0) {
            System.out.print("\n\n---------------------------------------------------\n");
            System.out.print("Player 2 has ran out of cards. Player 1 wins!\n");
            System.out.print("---------------------------------------------------\n");
            System.exit(0);
        }

        System.out.print("\n\nPlayer 1's War cards: ");

        // If not, Player 1 deals their 4 cards for the War round
        for (int i = 3; i >= 0; i--) {

            // If the player runs out of cards in the middle of dealing, they lose as usual
            if (playerOne.deckSize() == 0) {
                System.out.print("\n\n---------------------------------------------------\n");
                System.out.print("Player 1 has ran out of cards. Player 2 wins!\n");
                System.out.print("---------------------------------------------------\n");
                System.exit(0);
            }

            // The fourth card is played face-up
            else if (i == 0){
                Card newCard = playerOne.dealCard();
                playerOneWarCards.add(newCard);
                newCard.printCard();
            }

            // All other card are played face down
            else {
                Card newCard = playerOne.dealCard();
                playerOneWarCards.add(newCard);
                System.out.print("xx ");
            }
        }

        // If not, Player 2 deals their 4 cards for the War round
        System.out.print("\nPlayer 2's War cards: ");

        for (int j = 3; j >= 0; j--) {

            // If the player runs out of cards in the middle of dealing, they lose as usual
            if (playerTwo.deckSize() == 0) {
                System.out.print("\n---------------------------------------------------\n");
                System.out.print("Player 2 has ran out of cards. Player 1 wins!\n");
                System.out.print("---------------------------------------------------\n");
                System.exit(0);
            }

            // The fourth card is played face-up
            else if (j == 0){
                Card newCard = playerTwo.dealCard();
                playerTwoWarCards.add(newCard);
                newCard.printCard();
            }
            // All other cards are played face down
            else {
                Card newCard = playerTwo.dealCard();
                playerTwoWarCards.add(newCard);
                System.out.print("xx ");
            }
        }

        // Starts the index for comparing the War cards
        int index = playerOneWarCards.size() - 1;
        // Starts the boolean for checking if all the War cards are equal
        boolean allEqual = false;

        // Gets the first pair of cards to compare
        Card currCardOne = playerOneWarCards.get(index);
        Card currCardTwo = playerTwoWarCards.get(index);

        // Will continue to compare pairs of cards while the pairs are equal
        while (currCardOne.cardValue() == currCardTwo.cardValue() && index >= 0) {

            System.out.print("\n\n");

            // If the index is 0, the game has gotten to the last pair of War cards and all the cards are equal
            if (index == 0) {
                // Sets the flag to true
                allEqual = true;
            }

            // Shows the current pair being compared
            System.out.print("Player 1's War Card: ");
            currCardOne.printCard();
            System.out.print("\n");

            System.out.print("Player 2's War Card: ");
            currCardTwo.printCard();
            System.out.print("\n");

            // Moves the index
            index--;
        }

        // Sets the integer for the winner
        int winner = 0;

        // If all the War cards were equal, then a new War round is needed
        if (allEqual== true) {
            // Starts a new War round, and passes the cards from the this round to add to the pool of cards
            int nextWarRound = warRound(playerOneWarCards, playerTwoWarCards);

            // If the war of that War round is Player 1, then it gives Player 1 the cards from the previous round
            if (nextWarRound == 1) {
                winner = 1;

                // Adds cards from previous round (if there is one)
                for (int i = 0; i < playerOnePrev.size(); i++) {
                    playerOne.addCard(playerOnePrev.get(i));
                    playerOne.addCard(playerTwoPrev.get(i));
                }

            }

            // If the war of that War round is Player 2, then it gives Player 2 the cards from the previous round
            if (nextWarRound == 2) {
                winner = 2;

                // Adds cards from previous rounds (if any)
                for (int i = 0; i < playerTwoPrev.size(); i++) {
                    playerTwo.addCard(playerOnePrev.get(i));
                    playerTwo.addCard(playerTwoPrev.get(i));
                }
            }

            // Note: the the last two instructions only apply when there are 3+ rounds, since in a 1-to-2 round War
            // the previous cards will be awarded in a normal comparison
        }

        // If there is a pair of War Cards that are equal, it does a normal comparison
        else {

            // The card comparison is the same as a normal round

            System.out.print("\n\n");

            System.out.print("Player 1's War Card: ");
            currCardOne.printCard();
            System.out.print("\n");

            System.out.print("Player 2's War Card: ");
            currCardTwo.printCard();
            System.out.print("\n");

            if (currCardOne.cardValue() > currCardTwo.cardValue()) {

                System.out.print("\nPlayer 1 has the higher value. Player 1 wins the War round.\n");

                for (int i = 0; i < playerOneWarCards.size(); i++) {
                    playerOne.addCard(playerOneWarCards.get(i));
                    playerOne.addCard(playerTwoWarCards.get(i));
                }

                // Also rewards cards from previous round (if there is one)
                for (int i = 0; i < playerOnePrev.size(); i++) {
                    playerOne.addCard(playerOnePrev.get(i));
                    playerOne.addCard(playerTwoPrev.get(i));
                }

                // Sets Player 1 as the winner
                winner = 1;
            }

            else {
                System.out.print("\nPlayer 2 has the higher value. Player 2 wins the War round.\n");

                for (int i = 0; i < playerOneWarCards.size(); i++) {
                    playerTwo.addCard(playerOneWarCards.get(i));
                    playerTwo.addCard(playerTwoWarCards.get(i));
                }

                // Also rewards cards from previous round (if there is one) rounds (if any)
                for (int i = 0; i < playerTwoPrev.size(); i++) {
                    playerTwo.addCard(playerOnePrev.get(i));
                    playerTwo.addCard(playerTwoPrev.get(i));
                }

                // Sets Player 2 as the winner
                winner = 2;
            }
        }

        // Returns the integer indicating the winner
        return winner;
    }

    // toString(): Method for outputting information about the warGame object. Takes no parameters. Returns a String object.
    public String toString() {
        // Initializes the String object with information
        String message = ("Game status:\n");
        // Adds the size of Player 1's deck to the information
        message += ("Player 1's Cards: " + playerOne.deckSize() + "\n");
        // Adds the size of Player 2's deck to the information
        message += ("Player 2's Cards: " + playerTwo.deckSize() + "\n");

        // Returns the String with information
        return message;
    }

}
