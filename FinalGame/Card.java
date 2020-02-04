    /*
    Lionel Quintanilla and Nathanael Gastelum
    February 3, 2019
    Purpose: This class contains the Card object of the War game, which includes the rank and suit of the card
    and the necessary methods to use its information
    */

public class Card {

    // Variable that represent the rank and suit of the Card object
    private char suit;
    private char rank;

    // Card(): Constructor method. Takes two characters as its parameters. Does not return.
    public Card(char r, char s) {

        // Creates a new array of characters called "Card", with the two character parameters as its values.
        char[] Card = new char[]{r,s};

        // Sets the rank and suit variables of the object to the  parameters.
        rank = r;
        suit = s;
    }

    // printCard(): Prints out the rank and suit of the current card. Takes no parameters. Returns void.
    public void printCard() {
        // Converts the letter "T" to the number "10" for aesthetic purposes
        if (rank == 'T') {
            // Prints the rank and the suit
            System.out.print("10" + suit + " ");
        }
        else {
            // Prints the rank and the suit
            System.out.print(rank + "" + suit + " ");
        }
    }

    // cardValue(): Gets the value of the card. Takes no parameters. Returns an integer
    public int cardValue() {

        // A rank of Ace will return a value of 11
        if (rank == 'A') {
            return 11;
        }

        // Ranks of 10 through King return a value of 10
        else if (rank == 'T' || rank == 'J' || rank == 'Q' || rank == 'K') {
            return 10;
        }

        // All other characters return face values (e.g 2 - 9)
        else {
            // Parse the character to an integer for ease
            return Character.getNumericValue(rank);
        }
    }

    // toString(): Method for outputting information about the Card object. Takes no parameters. Returns a String object.
    public String toString() {

        // Initializes the String object the information will be placed in
        String message = "Card: ";

        // Adds the same information as the printCard() method
        if (rank == 'T') {
            message += ("10" + suit + " ");
        }
        else {
            message += (rank + "" + suit + " ");
        }

        // Returns the information as a String object
        return message;
    }

}
