package main;

import main.monster.GreenSlime;

import java.awt.Point;
import java.util.Arrays;
import java.util.Random;

public class AssetSetter {
    GamePanel gamePanel;

    private final int MAX_X_POSITION = 620;
    private final int MIN_X_POSITION = 80;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setMonster() {
        Random random = new Random();

        // GreenSlimeインスタンスを設定する回数をランダムに決定
        int numberOfMonsters = random.nextInt(6) + 1; // 1から6の間のランダムな数

        for (int i = 0; i < numberOfMonsters; i++) {
            gamePanel.monsterGreenSlime[i] = createGreenSlime(random);
        }
    }

    private GreenSlime createGreenSlime(Random random) {
        int screenY = (gamePanel.getScreenHeight() / 2) - gamePanel.getTileSize();
        Point[] positions = new Point[6];

        for (int i = 0; i < positions.length; i++) {
            int screenX = random.nextInt(MAX_X_POSITION - MIN_X_POSITION + 1) + MIN_X_POSITION;
            positions[i] = new Point(screenX, screenY);
        }

        return new GreenSlime(gamePanel, positions);
    }
}
