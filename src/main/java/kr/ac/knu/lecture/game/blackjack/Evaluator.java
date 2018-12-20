package kr.ac.knu.lecture.game.blackjack;

import java.util.Map;

/**
 * Created by rokim on 2018. 5. 27..
 */
public class Evaluator {
    private Map<String, Player> playerMap;
    private Dealer dealer;

    public Evaluator(Map<String, Player> playerMap, Dealer dealer) {
        this.playerMap = playerMap;
        this.dealer = dealer;
    }

    public boolean evaluate() {
        if (playerMap.values().stream().anyMatch(player -> player.isPlaying())) {
            return false;
        }

        int dealerResult = dealer.getHand().getCardSum();

        if (dealerResult > 21) {
            playerMap.forEach((s, player) -> player.win());

            return true;
        }

        playerMap.forEach((s, player) -> {
            int playerResult = player.getHand().getCardSum();
            if(playerResult <= 21){ //플레이어가 21보다 작을떄
                if(dealerResult >21){ //딜러가 21보다 크면
                    player.win();
                }
                else if(dealerResult == playerResult){ //딜러와 플레이어가 같으면
                    player.tie();
                }
                else if(dealerResult < playerResult) { // 딜러보다 플레이어가 클때
                    player.win();
                }
                else{
                    player.lost();
                }
            }
            else { //플레이어가 21보다 클때
                if (dealerResult >21 ){ //딜러와 플레이어가 같으면)
                    player.tie();
                }
                else if(dealerResult <21){ //딜러의 값이 21보다 작으면
                    player.lost();
                }
            }
        });

        return true;
    }


}
