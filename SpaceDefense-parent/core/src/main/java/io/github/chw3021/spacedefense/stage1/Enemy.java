package io.github.chw3021.spacedefense.stage1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;

    public Enemy(float startX, float startY) {
        texture = new Texture("enemy.png"); // core/assets/ 경로에 `enemy.png` 추가
        position = new Vector2(startX, startY);
        velocity = new Vector2(100, 0); // x 방향으로 초당 100px 이동
    }

    public void update(float delta) {
        position.x += velocity.x * delta; // 경로를 따라 이동
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
    }
}
