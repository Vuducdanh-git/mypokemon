package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.*;
import k1.chuyentin.com.actors.Bth;
import k1.chuyentin.com.actors.Diamond;
import k1.chuyentin.com.actors.Ender;
import k1.chuyentin.com.actors.SB;

public class BaloScreen implements Screen {
    Stage stage;
    StartGame game;
    Bth bth;
    Diamond dia;
    SB slimeball;
    Ender ender;
    SpriteBatch batch;
    public BaloScreen(StartGame game){
        this.game = game;
        stage = new Stage();
        batch=new SpriteBatch();
        bth = new Bth(stage, 340, 60-30, 294, 156);
        slimeball = new SB(100,400,stage);
        dia = new Diamond(50,400,stage);
        ender=new Ender(150,400,stage);
        bth.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Master(game));
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
        batch.begin();
        game.font.setColor(1,1,1,1);
        game.font.draw(batch, "" + game.diamonds.size, 64, Gdx.graphics.getHeight() - 64);
        game.font.draw(batch, "" + game.sbs.size, 120, Gdx.graphics.getHeight() - 64);
        game.font.draw(batch, "" + game.enders.size, 170, Gdx.graphics.getHeight() - 64);
        batch.end();
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

