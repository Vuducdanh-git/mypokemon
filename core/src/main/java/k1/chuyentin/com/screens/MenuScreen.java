package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.actors.buttons.NutMenu;
import k1.chuyentin.com.enums.ButtonType;

public class MenuScreen implements Screen {
    Stage stage;
    StartGame game;
    NutMenu play;
    NutMenu continute;
    NutMenu guide;
    NutMenu exit;

    MenuScreen(StartGame game){
     this.game=game;
     stage = new Stage();
     play = new NutMenu(200, 380, stage, ButtonType.PLAY);
     play.setX(Gdx.graphics.getWidth()/2 - play.getWidth()/2);

     play.addListener(new ClickListener(){
         @Override
         public void clicked(InputEvent event, float x, float y) {
             game.setScreen(new ChoiceScreen(game));
         }
     });
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
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
