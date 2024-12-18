package io.github.chw3021.spacedefense.stage1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;

    public Enemy(float startX, float startY) {
        Pixmap originalPixmap = new Pixmap(Gdx.files.internal("enemy.png"));
        
        // 새 크기 설정 (예: 50x50)
        Pixmap resizedPixmap = new Pixmap(50, 50, originalPixmap.getFormat());
        resizedPixmap.drawPixmap(originalPixmap,
                                 0, 0, originalPixmap.getWidth(), originalPixmap.getHeight(),
                                 0, 0, resizedPixmap.getWidth(), resizedPixmap.getHeight());
        
        texture = new Texture(resizedPixmap); // core/assets/ 경로에 `enemy.png` 추가
        position = new Vector2(startX, startY);
        velocity = new Vector2(10, 0); // x 방향으로 초당 100px 이동
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
