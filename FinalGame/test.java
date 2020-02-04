import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        Card newCard = new Card('A','S');
        System.out.println(newCard.toString());

        Deck newDeck = new Deck();
        newDeck.generateDeck();
        System.out.println(newDeck.toString());

        warGame newGame = new warGame();
        System.out.println(newGame.toString());

    }
}

