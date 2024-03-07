package edu.stud.ntnu.idatt2003_oblig3.controllers;

import edu.stud.ntnu.idatt2003_oblig3.models.CardHand;
import edu.stud.ntnu.idatt2003_oblig3.models.DeckOfCards;
import edu.stud.ntnu.idatt2003_oblig3.models.PlayingCard;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MainSceneController {

  @FXML
  private ImageView card1;
  @FXML
  private ImageView card2;
  @FXML
  private ImageView card3;
  @FXML
  private ImageView card4;
  @FXML
  private ImageView card5;
  @FXML
  private TextField cardOfHearts;

  @FXML
  private Button checkHand;

  @FXML
  private Button dealHand;

  @FXML
  private TextField flush;

  @FXML
  private TextField queenOfSpades;

  @FXML
  private TextField sumOfFaces;

  private CardHand hand;

  private final DeckOfCards deck = new DeckOfCards();


  @FXML
  void checkHand(ActionEvent event) {

  }

  @FXML
  void dealHand(ActionEvent event) {
    hand = deck.dealHand(5);
    displayCards();
  }

  @FXML
  private void displayCards() {
    List<ImageView> images = new ArrayList<>();
    images.add(card1);
    images.add(card2);
    images.add(card3);
    images.add(card4);
    images.add(card5);
    for (int i = 0; i < hand.size(); i++) {
      String suit;
      if (hand.getCard(i).getSuit()=='C') {
        suit = "clubs";
      }
      else if (hand.getCard(i).getSuit()=='S') {
        suit = "spades";
      }
      else if (hand.getCard(i).getSuit()=='H') {
        suit = "hearts";
      }
      else {
        suit = "diamonds";
      }
      images.get(i).setImage(new Image("@" + hand.getCard(i) + "_of_" + suit));
    }
  }

}