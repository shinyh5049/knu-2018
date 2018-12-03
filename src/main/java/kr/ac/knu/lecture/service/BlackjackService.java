package kr.ac.knu.lecture.service;

import kr.ac.knu.lecture.domain.User;
import kr.ac.knu.lecture.game.blackjack.Deck;
import kr.ac.knu.lecture.game.blackjack.GameRoom;
<<<<<<< HEAD
import kr.ac.knu.lecture.repository.userRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
=======
import kr.ac.knu.lecture.repository.UserRepository;
import lombok.AllArgsConstructor;
>>>>>>> c8f8a55db2948516935f6e0983ae54572e1f5fa7
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by rokim on 2018. 11. 30..
 */
@Service
@AllArgsConstructor
public class BlackjackService {
<<<<<<< HEAD
    private final userRepository userRepository;
=======
    private final UserRepository userRepository;
>>>>>>> c8f8a55db2948516935f6e0983ae54572e1f5fa7
    private final int DECK_NUMBER = 1;
    private final Map<String, GameRoom> gameRoomMap = new HashMap<>();

    public GameRoom createGameRoom(User user) {
        Deck deck = new Deck(DECK_NUMBER);

        GameRoom gameRoom = new GameRoom(deck);
        gameRoom.addPlayer(user.getName(), user.getAccount());

        gameRoomMap.put(gameRoom.getRoomId(), gameRoom);

        return gameRoom;
    }

    public GameRoom joinGameRoom(String roomId, User user) {
        // multi player Game 이 아니므로 필요가 없다.
        return null;
    }

    public void leaveGameRoom(String roomId, User user) {
        gameRoomMap.get(roomId).removePlayer(user.getName());
    }

    public GameRoom getGameRoom(String roomId) {
        return gameRoomMap.get(roomId);
    }

    public GameRoom bet(String roomId, User user, long bet) {
        GameRoom gameRoom = gameRoomMap.get(roomId);

        gameRoom.reset();
        gameRoom.bet(user.getName(), bet);
        gameRoom.deal();

        return gameRoom;
    }

    public GameRoom hit(String roomId, User user) {
        GameRoom gameRoom = gameRoomMap.get(roomId);

        gameRoom.hit(user.getName());

        updateGameResult(gameRoom);
        return gameRoom;
    }

    public GameRoom stand(String roomId, User user) {
        GameRoom gameRoom = gameRoomMap.get(roomId);

        gameRoom.stand(user.getName());
        gameRoom.playDealer();

        updateGameResult(gameRoom);
        return gameRoom;
    }

    private void updateGameResult(GameRoom gameRoom) {
<<<<<<< HEAD
        if(gameRoom.isFinished()){
            gameRoom.getPlayerList().forEach((loginId,player)->{
                User playUser = userRepository.findById(loginId).orElseThrow(()->new RuntimeException());
                playUser.setAccount(player.getBalance());
=======
        if (gameRoom.isFinished()) {
            gameRoom.getPlayerList().forEach((loginId, player) -> {
                User playUser = userRepository.findById(loginId).orElseThrow(() -> new RuntimeException());
                playUser.setAccount(player.getBalance());

>>>>>>> c8f8a55db2948516935f6e0983ae54572e1f5fa7
                userRepository.save(playUser);
            });
        }
    }
<<<<<<< HEAD


=======
>>>>>>> c8f8a55db2948516935f6e0983ae54572e1f5fa7
}
