package io.github.chw3021.spacedefense.stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

import io.github.chw3021.spacedefense.stage1.Enemy;
import io.github.chw3021.spacedefense.tower.Tower;

public abstract class Stage {
    protected SpriteBatch batch;
    protected Texture background;
    protected ShapeRenderer shapeRenderer;
    protected Array<Enemy> enemies;
    protected Array<Tower> towers;
    protected int gridSize = 40;

    // 스테이지 초기화
    public abstract void initialize();

    // 게임 화면에 그리기
    public abstract void render(float delta);

    public void dispose() {
        batch.dispose();
        background.dispose();
        shapeRenderer.dispose();
        for (Enemy enemy : enemies) {
            enemy.dispose();
        }
        for (Tower tower : towers) {
        	tower.dispose();
        }
    }
}
