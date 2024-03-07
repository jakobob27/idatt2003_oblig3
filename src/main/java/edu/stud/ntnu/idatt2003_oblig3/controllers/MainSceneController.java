package edu.stud.ntnu.idatt2003_oblig3.controllers;

import edu.stud.ntnu.idatt2003_oblig3.App;
import edu.stud.ntnu.idatt2003_oblig3.models.CardHand;
import edu.stud.ntnu.idatt2003_oblig3.models.DeckOfCards;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
  private TextField flush;

  @FXML
  private TextField queenOfSpades;

  @FXML
  private TextField sumOfFaces;

  private CardHand hand;

  private DeckOfCards deck = new DeckOfCards();


  @FXML
  void checkHand(ActionEvent event) {
    if (hand == null) {
      return;
    }
    sumOfFaces.setText(String.valueOf(hand.sumOfFaces()));
    cardOfHearts.setText(hand.cardOfHearts());
    if (hand.flush()) {
      flush.setText("Yes");
    } else {
      flush.setText("No");
    }

    if (hand.queenOfSpades()) {
      queenOfSpades.setText("Yes");
    } else {
      queenOfSpades.setText("No");
    }

  }

  @FXML
  void dealHand(ActionEvent event) {
    try {
      hand = deck.dealHand(5);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

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
      if (hand.getCard(i).getSuit() == 'C') {
        suit = "clubs";
      } else if (hand.getCard(i).getSuit() == 'S') {
        suit = "spades";
      } else if (hand.getCard(i).getSuit() == 'H') {
        suit = "hearts";
      } else {
        suit = "diamonds";
      }
      String imageName = hand.getCard(i).getFace() + "_of_" + suit + ".png";
      String path = Objects.requireNonNull(App.class.getResource(imageName)).toString();
      images.get(i).setImage(new Image(path));
    }
  }

  public void shuffleDeck(ActionEvent actionEvent) {
    deck = new DeckOfCards();
    System.out.println("Shuffled the cards");
  }
}