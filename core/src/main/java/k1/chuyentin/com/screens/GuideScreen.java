package k1.chuyentin.com.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.actors.buttons.HuongDan;

public class GuideScreen implements Screen {
    StartGame game;
    Stage stage;
    HuongDan huongDan;
    GuideScreen(StartGame game){
        this.game = game;
        stage = new Stage();
        huongDan = new HuongDan(0,0,stage);


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
        huongDan = new HuongDan(0,0,stage);

        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
