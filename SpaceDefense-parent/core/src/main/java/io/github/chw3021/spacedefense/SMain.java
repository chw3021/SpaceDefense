package io.github.chw3021.spacedefense;

import com.badlogic.gdx.Game;

import io.github.chw3021.spacedefense.menu.MainMenuScreen;
import io.github.chw3021.spacedefense.stage.GameScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class SMain extends Game {

    @Override
    public void create() {
        // 게임 시작 시, 처음 화면을 메뉴로 설정
        setScreen(new MainMenuScreen(this));
    }
    
//    // 추가적인 화면 전환을 위한 메서드
//    public void startGame(int stageId) {
//        setScreen(new GameScreen(this, stageId));  // 게임 시작 화면
//    }
//    
//    public void showSettings() {
//        setScreen(new SettingsScreen(this));  // 환경 설정 화면
//    }
//    
//    public void showRankings() {
//        setScreen(new RankingsScreen(this));  // 랭킹 화면
//    }
}