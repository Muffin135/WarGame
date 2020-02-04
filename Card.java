public class Card {

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

    public String toString() {
        String message = "Card: ";

        if (rank == 'T') {
            message += ("10" + suit + " ");
        }
        else {
            message += (rank + "" + suit + " ");
        }

        return message;
    }

}
