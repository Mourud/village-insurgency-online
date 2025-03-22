package com.villageinsurgency.game.model;

import com.villageinsurgency.game.model.constants.GameConstants;
import com.villageinsurgency.game.model.resourcehotspot.Farm;
import com.villageinsurgency.game.model.resourcehotspot.GoldMine;
import com.villageinsurgency.game.model.resourcehotspot.ResourceHotSpot;
import org.json.JSONObject;

import java.util.Objects;

public class Game {

    //fields
    // TODO: Static for gather function in TC, remove TC and gather logic coupling
    public static ResourceHotSpot goldMine;
    public static ResourceHotSpot farm;
    // TODO: Add UUID for game tracking
    private TownCentre playerTown;
    private TownCentre enemyTown;
    public boolean isPlayerTurn;
    //    private TownCentre turnTown;
    private int turnsPlayed;
    private String key;
    private String playerOne;
    private String playerTwo;


    // REQUIRES: valid difficulty
    // MODIFIES: this
    // EFFECTS: makes game depending on difficulty
    public Game() {
        setupGame(GameConstants.EASY_START_POP, GameConstants.EASY_START_RESOURCES, GameConstants.EASY_START_RESOURCES);
    }

    public Game(String playerOne) {
        this.playerOne = playerOne;
        this.isPlayerTurn = true;
        this.turnsPlayed = 0;
        this.playerTown = new TownCentre(GameConstants.EASY_START_POP, GameConstants.EASY_START_RESOURCES, GameConstants.EASY_START_RESOURCES, true);
        this.enemyTown = new TownCentre(GameConstants.EASY_START_POP, GameConstants.EASY_START_RESOURCES, GameConstants.EASY_START_RESOURCES, false);
        goldMine = new GoldMine();
        farm = new Farm();
    }

    public Game(JSONObject j) {

        isPlayerTurn = j.getBoolean("isPlayerTurn");
        turnsPlayed = j.getInt("turnsPlayed");

        JSONObject playerTownJson = j.getJSONObject("playerTown");
        playerTown = new TownCentre(playerTownJson);
        JSONObject enemyTownJson = j.getJSONObject("enemyTown");
        enemyTown = new TownCentre(enemyTownJson);

        JSONObject goldMineJson = j.getJSONObject("goldMine");
        goldMine = new GoldMine(goldMineJson);
        JSONObject farmJson = j.getJSONObject("farm");
        farm = new Farm(farmJson);
    }

    // REQUIRES: (pop, food, gold) >= 0
    // EFFECTS: sets game with give population, food
    private void setupGame(int pop, int food, int gold) {
        isPlayerTurn = true;
        turnsPlayed = 0;
        playerTown = new TownCentre(pop, food, gold, true);
        enemyTown = new TownCentre(pop, food, gold, false);
        goldMine = new GoldMine();
        farm = new Farm();
    }


    public void setTurnsPlayed(int turnsPlayed) {
        this.turnsPlayed = turnsPlayed;
    }

    public void setPlayerTurn(boolean bool) {
        isPlayerTurn = bool;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public ResourceHotSpot getFarm() {
        return farm;
    }

    public ResourceHotSpot getGoldMine() {
        return goldMine;
    }

    public TownCentre getEnemyTown() {
        return enemyTown;
    }

    public TownCentre getPlayerTown() {
        return playerTown;
    }

    public int getTurnsPlayed() { return turnsPlayed; }

    public void updateTowns() {
        getPlayerTown().update();
        getEnemyTown().update();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Game game)) {
            return false;
        }
        return Objects.equals(playerTown, game.playerTown)
                && Objects.equals(enemyTown, game.enemyTown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerTown, enemyTown);
    }

    public void setId(String key) {
        this.key = key;
    }

    public String getId() {
        return key;
    }
}
