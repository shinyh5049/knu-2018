package kr.ac.knu.lecture.game.blackjack;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rokim on 2018. 5. 26..
 */
public class Hand {
    private Deck deck;
    @Getter
    private List<Card> cardList = new ArrayList<>();
    @Getter
    private int sum = 0;

    public Hand(Deck deck) {
        this.deck = deck;
    }

    public Card drawCard() {
        Card card = deck.drawCard();
        cardList.add(card);
        return card;
    }

    public int getCardSum() {
        sum = cardList.stream().mapToInt(card -> {
            int rank = card.getRank();
            if(rank == 1){
                if((sum + 11) <= 21){
                    return 11;
                }
                else
                    return 1;
            }
            else if(rank > 10) {
                return 10;
            }
            return rank;
        }).sum();

        return sum;
    }

    public void reset() {
        cardList.clear();
    }

}
