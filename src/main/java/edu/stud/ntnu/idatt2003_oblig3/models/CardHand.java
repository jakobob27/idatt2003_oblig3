package edu.stud.ntnu.idatt2003_oblig3.models;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardHand extends CardCollection{
  public CardHand() {
    super();
  }


  public int sumOfFaces() {
    int sum = 0;
    for (PlayingCard card : this) {
      sum+=card.getFace();
    }
    return sum;
  }

  public String cardOfHearts() {
    List<PlayingCard> temp = new ArrayList<>();
    for (PlayingCard card : this) {
      if (card.getSuit()=='H') {
        temp.add(card);
      }
    }
    return temp.toString();
  }

  public boolean flush() {
    char suit = getCard(0).getSuit();
    for (PlayingCard card : this) {
      if(suit!=card.getSuit()) {
        return false;
      }
    }
    return true;
  }

  public boolean queenOfSpades() {
    for (PlayingCard card : this) {
      if (card.getSuit()=='S' && card.getFace()==12) {
        return true;
      }
    }
    return false;
  }
}
