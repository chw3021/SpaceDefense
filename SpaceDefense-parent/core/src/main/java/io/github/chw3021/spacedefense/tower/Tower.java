package io.github.chw3021.spacedefense.tower;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tower {

    private Texture texture;
    private Vector2 position;
    

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	private Vector2 velocity;

    public Tower(float startX, float startY) {
        texture = new Texture("tower.png"); // core/assets/ 경로에 `enemy.png` 추가
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