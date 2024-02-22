package com.square.game.service.partiegame;

import com.square.game.controller.GameCreationParams;
import com.square.game.controller.dto.GameDTO;
import com.square.game.plugin.ConnectFourPlugin;
import com.square.game.plugin.GamePlugin;
import com.square.game.plugin.TaquinPlugin;
import com.square.game.plugin.TicTacToePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {
    private final Map<String, Game> gameMap = new HashMap<>();



//    @Override
//    public GameDTO getFactoryById(String id) {
//        return switch (id) {
//            case "tictactoe" -> createGameWithPlugin(ticTacToePlugin);
//            case "connectfour" -> createGameWithPlugin(connectFourPlugin);
//            case "taquin" -> createGameWithPlugin(taquinPlugin);
//            default -> createGameWithPlugin(ticTacToePlugin);
//        };
//
//    }
//    @Override
//    public GameDTO getGameDTO(GameCreationParams params) {
//        gameDTO = getFactoryById(params.getTypeGame());
//        Game saveGamesFactory = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
//        gameMap.put(saveGamesFactory.getId().toString(), saveGamesFactory);
//        return new GameDTO(saveGamesFactory.getId().toString(), params.getPlayerCount(), params.getBoardSize());
//    }

    @Override
    public GameDTO getGameById(String gameId) {
        Game game = gameMap.get(gameId);
        return new GameDTO(game.getId().toString(), game.getPlayerIds().size(), game.getBoardSize());
    }



    @Override
    public GameDTO createGameWithPlugin(GamePlugin plugin) {
        Game gameWithplugin = plugin.getFactory().createGame(plugin.getNbPlayer(), plugin.getBoardSize());
        gameMap.put(gameWithplugin.getId().toString(), gameWithplugin);
        return new GameDTO(gameWithplugin.getId().toString(), plugin.getNbPlayer(), plugin.getBoardSize()) ;
    }


}
