package com.villageinsurgency.game.services;

import com.villageinsurgency.game.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GameService {

    // TODO: Consider Concurrent Hashmaps
    private final HashMap<String, Game> gameSessions;
    private final JdbcTemplate jdbcTemplate;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public GameService(JdbcTemplate jdbcTemplate, SimpMessagingTemplate messagingTemplate){
        this.gameSessions = new HashMap<>();
        this.jdbcTemplate = jdbcTemplate;
        this.messagingTemplate = messagingTemplate;
    }

    public String createGame(String username) {

        if (gameSessions.containsKey(username)) {
            return "Error: Player already has an active game.";
        }
        Game game = new Game(username);
        gameSessions.put(username, game);
        // TODO: Use UUIDs or something good for Spring
        return String.format("Game created successfully: %s", game.getId());    }

    public String joinGame(int gameKey, String p2) {
        return "";
    }
}


//    private void mouseHandle(MouseEvent e) {
//        Position mousePos = new Position((int) e.getSceneX(), (int) e.getSceneY());
//        TownCentre player = game.getPlayerTown();
//        TownCentre op = game.getEnemyTown();
//        if (game.isPlayerTurn()) {
//            moveOrder(player, op, mousePos);
//        } else {
//            moveOrder(op, player, mousePos);
//        }
//        update();
//    }

//    public ResponseEntity<String> joinGame(int id, String p2) {
//        if (id < 0) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid game id");
//        }
//        String sql = "SELECT status FROM Games WHERE id = ?";
//        String status = jdbcTemplate.queryForObject(sql, String.class, id);
//        if (status != null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid game id");
//        }
//        sql = "UPDATE Games SET p2 = ? WHERE id = ?";
//        int rowsAffected = jdbcTemplate.update(sql, p2, id);
//
//        if (rowsAffected == 0) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
//        } else {
//            sql = "UPDATE Games SET status = ? WHERE id = ?";
//            jdbcTemplate.update(sql, "in progress", id);
//            return ResponseEntity.ok("Joined game: " + id);
//
//        }
//    }
//
//
////    private void moveOrder(TownCentre player, TownCentre op, Position mousePos) {
////        if ((selected == (null))) {
////            if (player.findPerson(mousePos) != null) {
////                selected = player.findPerson(mousePos);
////                game.setTurnsPlayed(game.getTurnsPlayed() + 1);
////            }
////        } else {
////            selected.walkTo(mousePos.getPosX(), mousePos.getPosY());
////            Person opponent = op.findPerson(mousePos);
////            game.setTurnsPlayed(game.getTurnsPlayed() + 1);
////            if (opponent != null) {
////                selected.attack(opponent);
////            }
////            selected = null;
////        }
////    }
//
//    public String getGameObjectJsonById(int id) {
//        String sql = "SELECT json FROM Games WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> rs.getString("json"), id);
//    }
//
//    private void checkGameOver() {
////        if (game.getEnemyTown().getRegistry().isEmpty()) {
//////            TheMythsOfUbc.setScene(setGameEnd("BLUE"));
////        } else if (game.getPlayerTown().getRegistry().isEmpty()) {
//////            TheMythsOfUbc.setScene(setGameEnd("RED"));
////        }
//    }
//
//    private void update() {
//        if (!gameStart) {
//            setTurnLimit();
//            gameStart = !gameStart;
//        }
//        if (game.getTurnsPlayed() >= turnLimit) {
//            game.setPlayerTurn(!game.isPlayerTurn());
//            incrementResources();
//            game.setTurnsPlayed(0);
//            setTurnLimit();
//        }
//        game.updateTowns();
////        prepareToUpdatePlayerPosition(TheMythsOfUbc.setScene(render(game)));
//        checkGameOver();
//    }
//
//    private void incrementResources() {
//        if (game.isPlayerTurn()) {
//            game.getPlayerTown().incrementResources();
//        } else {
//            game.getEnemyTown().incrementResources();
//        }
//    }
//
//    private void setTurnLimit() {
//        if (game.isPlayerTurn()) {
//            turnLimit = 2 * game.getPlayerTown().getPopSize();
//        } else {
//            turnLimit = 2 * game.getEnemyTown().getPopSize();
//        }
//    }
//
////    public void makeNewGame(String s) {
////        game = new Game();
////        update();
////    }
//
//    public ResponseEntity<String> createUnit(int gameKey, String type, String user) {
//        ResponseEntity<String> ret = null;
//        if (gameKey < 0) {
//            ret = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid game key");
//        }
//        String presql = "SELECT p1, p2, json FROM Games WHERE id = ?";
//        String p1 = "";
//        String p2 = "";
//        String json = "";
//
//        Map<String, Object> result = jdbcTemplate.queryForMap(presql, gameKey);
//        p1 = (String) result.get("p1");
//        p2 = (String) result.get("p2");
//        json = (String) result.get("json");
//
//        Game game = GameParser.parse(json);
//        if (game.isPlayerTurn() && user.equals(p1)) {
//            TownCentre town = game.getPlayerTown();
//            boolean success = town.procreateVillager();
//            if (success) {
//                String newJson = String.valueOf(JSonifier.gameToJson(game));
//                String sql = "UPDATE Games SET json = ? WHERE id = ?";
//                jdbcTemplate.update(sql, newJson, gameKey);
//                ret = ResponseEntity.ok("Unit created successfully");
//            } else {
//                ret = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not enough resources");
//            }
//        } else if (!game.isPlayerTurn() && user.equals(p2)) {
//            TownCentre town = game.getEnemyTown();
//            boolean success = town.procreateVillager();
//            if (success) {
//                String newJson = String.valueOf(JSonifier.gameToJson(game));
//                String sql = "UPDATE Games SET json = ? WHERE id = ?";
//                jdbcTemplate.update(sql, newJson, gameKey);
//                ret = ResponseEntity.ok("Unit created successfully");
//            } else {
//                ret = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not enough resources");
//            }
//        } else {
//            ret = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not your turn");
//        }
//
//        return ret;
//    }
//}
