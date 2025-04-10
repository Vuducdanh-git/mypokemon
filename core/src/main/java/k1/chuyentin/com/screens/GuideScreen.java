package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.actors.buttons.HuongDan;
import k1.chuyentin.com.actors.buttons.NutMenu;
import k1.chuyentin.com.enums.ButtonType;

public class GuideScreen implements Screen {
    StartGame game;
    Stage stage;
    HuongDan huongDan;
    NutMenu exit;
    GuideScreen(StartGame game){
        this.game = game;
        stage = new Stage();
        huongDan = new HuongDan(0,0,stage);
//        exit = new NutMenu(500, 400 ,stage, ButtonType.EXIT);
//        exit.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                game.setScreen(new MenuScreen(game));
//            }
//        });


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);


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
