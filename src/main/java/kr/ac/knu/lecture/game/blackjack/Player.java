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
    @Getter
    private boolean isBlackjack = false;
    @Getter
    private boolean isDouble = false;

    public Player(long seedMoney, Hand hand) {
        this.balance = seedMoney;
        this.hand = hand;
        isDouble = false;
        isBlackjack = false;
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
        hand.drawCard();
        hand.drawCard();
        if (hand.getCardSum() == 11) {
            isBlackjack = true;
            stand();
        }
    }
    public void setDouble() {
        isDouble = true;
    }

    public void win() {
        if (isBlackjack) {
            balance += currentBet * 1.5;
        }
        else if (isDouble) {
            balance += currentBet * 4;
        }
        else {
            balance += currentBet * 2;
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
        int sum = hand.getCardSum();
        if(sum > 21){
            stand();
        }

        return hand.drawCard();

    }

    public void stand() {
        this.isPlaying = false;
    }

}
