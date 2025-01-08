package io.github.chw3021.spacedefense.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import io.github.chw3021.spacedefense.stage.GameScreen;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class StageSelectionScreen implements Screen {
    private Game game;
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;
    private Skin skin;

    public StageSelectionScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        background = new Texture("space_background.png");
        stage = new Stage();

        // Skin과 스타일을 설정
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.top().center();
        table.setFillParent(true);

        // 버튼 생성 (스테이지 1, 2, 3 버튼)
        TextButton stage1Button = new TextButton("Stage 1", skin);
        TextButton stage2Button = new TextButton("Stage 2", skin);
        TextButton stage3Button = new TextButton("Stage 3", skin);

        stage1Button.addListener(new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game, 1)); // 스테이지 1로 게임 시작
		    }
		});

        table.add(stage1Button).fillX().uniformX().pad(10);
        table.row().pad(10, 0, 10, 0);
        table.add(stage2Button).fillX().uniformX().pad(10);
        table.row().pad(10, 0, 10, 0);
        table.add(stage3Button).fillX().uniformX().pad(10);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }
}
