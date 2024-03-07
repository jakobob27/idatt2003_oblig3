package edu.stud.ntnu.idatt2003_oblig3.models;

import java.util.Random;

public class DeckOfCards extends CardCollection {
  public DeckOfCards() {
    super();
    for (int i = 0; i < 4; i++) {
      for (int j = 1; j < 14; j++) {
        addCard(new PlayingCard(suit[i], j));
      }
    }
  }

  public CardHand dealHand(int n) {
    if (n > size()) {
      throw new IllegalArgumentException("Not enough cards in the deck");
    }
    if (n < 1) {
      throw new IllegalArgumentException("Invalid amount of cards to deal");
    }
    Random random = new Random();
    CardHand temp = new CardHand();
    for (int i = 0; i < n; i++) {
      PlayingCard randomCard = getCard(random.nextInt(size()));
      temp.addCard(randomCard);
      removeCard(randomCard);
    }
    return temp;
  }

  public static void main(String[] args) {
    DeckOfCards test = new DeckOfCards();
    System.out.println(test.dealHand(6));
    System.out.println(test);
  }
}
