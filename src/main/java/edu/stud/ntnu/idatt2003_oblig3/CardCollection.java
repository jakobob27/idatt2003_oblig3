package edu.stud.ntnu.idatt2003_oblig3;

import java.util.ArrayList;

public abstract class CardCollection {
  protected final char[] suit = { 'S', 'H', 'D', 'C' };
  protected final ArrayList<PlayingCard> cardCollection;

  public CardCollection() {
    cardCollection = new ArrayList<>();
  }
  public PlayingCard getCard(int n) {
    if (n<0 || n>cardCollection.size()-1) {
      throw new IllegalArgumentException("Invalid index in the card collection");
    }
    return cardCollection.get(n);
  }

  public void addCard(PlayingCard card) {
    cardCollection.add(card);
  }

  public void removeCard(char suit, int face) {
    cardCollection.removeIf(card -> card.getSuit() == suit && card.getFace() == face);
  }
  public  void removeCard(PlayingCard card) {
    cardCollection.remove(card);
  }
  @Override
  public String toString() {
    return cardCollection.toString();
  }
}
