package edu.stud.ntnu.idatt2003_oblig3;

import java.util.ArrayList;

public class DeckOfCards {
  private final char[] suit = { 'S', 'H', 'D', 'C' };
  private final ArrayList<PlayingCard> deck = new ArrayList<>();

  public DeckOfCards(){
    for (int i = 0; i<4; i++) {
      for (int j=1; j<14; j++) {
        deck.add(new PlayingCard(suit[i], j));
      }
    }
  }

  public static void main(String[] args) {
    DeckOfCards test = new DeckOfCards();
    System.out.println(test.deck);
  }
}
