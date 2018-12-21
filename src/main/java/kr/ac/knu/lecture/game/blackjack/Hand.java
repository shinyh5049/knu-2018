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
        int sum = 0;
        int aceCount = 0;
        for(int i = 0; i<cardList.size(); i++){
            int rank = cardList.get(i).getRank();
            if(rank > 10) sum+=10;
            else if(rank == 1) aceCount++;
            else sum+=rank;
        }
        if(aceCount>0) {
            if (sum + (aceCount - 1) + 11 <= 21)
                sum += (aceCount - 1) + 11;
            else
                sum += aceCount;
        }
        return sum;
    }

    public void reset() {
        cardList.clear();
    }

}
