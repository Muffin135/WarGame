public class war {

    /*
    Lionel Quintanilla and Nathanael Gastelum
    February 3, 2019
    Purpose: This program plays a card game called War, in which players begin with equal amounts of cards and compete
    in rounds where each player takes the top card from their deck and compares it to other players' cards. The player
    with the highest value card wins the round and adds all the card in that round to their deck. If all the players
    have cards with the same value, a special "War" round is played where each player draws four cards instead of one
    and compares their four cards one at a time until someone wins.
    Inputs: This programs does not take any user inputs.
    Outputs: Text which displays information about the game, such as the cards in play, the type of round, and the
    winner for each round or the game.
     */

    public static void main(String[] args) {

        // Sets up a new game of War
        warGame fullGame = new warGame();

        // The program will continue to play a round of War until the program exits
        while (true) {
            fullGame.normalRound();
        }
    }

}
