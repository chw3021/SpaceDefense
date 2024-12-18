package io.github.chw3021.spacedefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

import io.github.chw3021.spacedefense.stage1.Enemy;
import io.github.chw3021.spacedefense.tower.Tower;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
    private SpriteBatch batch;
    private Texture background;
    private Array<Enemy> enemies;
    private ShapeRenderer shapeRenderer;
    private Array<Tower> towers; // 타워 위치 저장

    private int gridSize = 40; // 셀 크기 (40px)
    
    @Override
    public void show() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        background = new Texture(Gdx.files.internal("space_background.png"));
        
        // 적 초기화
        enemies = new Array<>();
        enemies.add(new Enemy(0, 200)); // 초기 위치 (x: 0, y: 200)

        towers = new Array<>();
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {
                    int gridX = screenX / gridSize * gridSize;
                    int gridY = (Gdx.graphics.getHeight() - screenY) / gridSize * gridSize;
                    towers.add(new Tower(gridX, gridY));
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // 적 업데이트 및 렌더링
        for (Enemy enemy : enemies) {
            enemy.update(delta);
            enemy.render(batch);
        }
        for (Tower tower : towers) {
        	tower.render(batch);
        }
        
        batch.end();

        // 그리드 렌더링
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0, 1, 0, 1); // 녹색 그리드
        for (int x = 0; x < Gdx.graphics.getWidth(); x += gridSize) {
            for (int y = 0; y < Gdx.graphics.getHeight(); y += gridSize) {
                shapeRenderer.rect(x, y, gridSize, gridSize);
            }
        }
        shapeRenderer.end();
    }
    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        for (Enemy enemy : enemies) {
            enemy.dispose();
        }
        shapeRenderer.dispose();
    }

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}