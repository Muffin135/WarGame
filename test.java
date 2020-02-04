import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        warGame test = new warGame();

        ArrayList<Card> one = new ArrayList<>(4);
        ArrayList<Card> two = new ArrayList<>(4);

        while (true) {
            test.warRound(one, two);
        }

    }
}

