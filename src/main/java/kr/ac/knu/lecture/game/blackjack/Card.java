package kr.ac.knu.lecture.game.blackjack;

import kr.ac.knu.lecture.exception.NoSuchRankException;
import lombok.Data;
import lombok.Getter;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> c8f8a55db2948516935f6e0983ae54572e1f5fa7

/**
 * Created by rokim on 2018. 5. 26..
 */
@Data
public class Card {
    private final int rank;
    @Getter
    private final Suit suit;

    public Card(int rank, Suit suit) {
        if (rank > 13) {
            throw new NoSuchRankException();
        }
        this.rank = rank;
        this.suit = suit;
    }


}
