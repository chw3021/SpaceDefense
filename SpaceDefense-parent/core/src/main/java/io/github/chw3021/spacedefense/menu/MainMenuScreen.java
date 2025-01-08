package io.github.chw3021.spacedefense.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MainMenuScreen implements Screen {
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;
    private Skin skin;

    private Game game;

    public MainMenuScreen(Game game) {
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

		TextButton startGameButton = new TextButton("GameStart", skin, "round");
		TextButton settingsButton = new TextButton("Setting", skin, "round");
		TextButton rankingButton = new TextButton("Ranking", skin, "round");

		// 클릭 이벤트 설정
		startGameButton.addListener(new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		        game.setScreen(new StageSelectionScreen(game));
		    }
		});

		settingsButton.addListener(new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		        System.out.println("환경 설정 버튼 클릭됨");
		    }
		});

		rankingButton.addListener(new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		        System.out.println("랭킹 버튼 클릭됨");
		    }
		});

        table.add(startGameButton).fillX().uniformX().pad(10);
        table.row().pad(10, 0, 10, 0);
        table.add(settingsButton).fillX().uniformX().pad(10);
        table.row().pad(10, 0, 10, 0);
        table.add(rankingButton).fillX().uniformX().pad(10);

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
