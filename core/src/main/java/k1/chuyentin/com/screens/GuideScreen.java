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
    Stage stages;
    HuongDan huongDan;
    NutMenu exit;
    GuideScreen(StartGame game){
        this.game = game;
        stages = new Stage();
        exit = new NutMenu(500, 400 ,stages, ButtonType.EXIT);

        huongDan = new HuongDan(0,22,stages);
        huongDan.setSize(640, 480-80);
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });

        stages.addActor(exit);
        stages.addActor(huongDan);


    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stages);
    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(Color.BLACK);




        stages.act();
        stages.draw();

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
