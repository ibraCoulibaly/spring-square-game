package com.square.game.service.partiegame;

import com.square.game.controller.GameCreationParams;
import com.square.game.controller.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {
    private final TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
    private final ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();
    private final TaquinGameFactory taquinGameFactory  = new TaquinGameFactory();
    private final Map<String, Game> gameMap = new HashMap<>();

    @Override
    public GameFactory getFactoryById(String id) {
        return switch (id) {
            case "tictactoe" -> ticTacToeGameFactory;
            case "connectfour" -> connectFourGameFactory;
            case "taquin" -> taquinGameFactory;
            default -> ticTacToeGameFactory;
        };

    }
    @Override
    public GameDTO getGameDTO(GameCreationParams params) {
        GameFactory gameFactory = getFactoryById(params.getTypeGame());
        Game saveGamesFactory = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
        gameMap.put(saveGamesFactory.getId().toString(), saveGamesFactory);
        return new GameDTO(saveGamesFactory.getId().toString(), params.getPlayerCount(), params.getBoardSize());
    }

    @Override
    public GameDTO getGameById(String gameId) {
        Game game = gameMap.get(gameId);
        return new GameDTO(game.getId().toString(), game.getPlayerIds().size(), game.getBoardSize());
    }

}
