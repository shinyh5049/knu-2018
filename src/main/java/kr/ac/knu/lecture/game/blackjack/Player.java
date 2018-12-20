package kr.ac.knu.lecture.game.blackjack;

import kr.ac.knu.lecture.exception.NotEnoughBalanceException;
import lombok.Getter;

/**
 * Created by rokim on 2018. 5. 26..
 */
public class Player {
    @Getter
    private long balance;
    @Getter
    private long currentBet;
    @Getter
    private boolean isPlaying;
    @Getter
    private Hand hand;
    public Card c1, c2;

    public Player(long seedMoney, Hand hand) {
        this.balance = seedMoney;
        this.hand = hand;

        isPlaying = false;
    }

    public void reset() {
        hand.reset();
        isPlaying = false;
    }

    public void placeBet(long bet) {
        if (balance < bet) {
            throw new NotEnoughBalanceException();
        }
        balance -= bet;
        currentBet = bet;

        isPlaying = true;
    }

    public void deal() {
        Card c1 = hand.drawCard();
        Card c2 = hand.drawCard();
    }

    public void win() {
        balance += currentBet * 2;
        currentBet = 0;
    }
    public void blackjack() {
        if ((c1.rank == 1 && c1.suit == Suit.SPADES && c2.rank >= 10) ||
                (c2.rank == 1 && c2.suit == Suit.SPADES && c1.rank >= 10)) {
            balance += currentBet * 1.5;
            currentBet = 0;
        }
    }

    public void tie() {
        balance += currentBet;
        currentBet = 0;
    }

    public void lost() {
        currentBet = 0;
    }

    public Card hitCard() {
        return hand.drawCard();
    }

    public void stand() {
        this.isPlaying = false;
    }

}
