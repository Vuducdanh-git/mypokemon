package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.actors.buttons.ButtonClass;
import k1.chuyentin.com.Utils;

public class ChoiceScreen implements Screen {
    StartGame game;
    Stage stage;
    ButtonClass lop6;
    ButtonClass lop7;
    SpriteBatch batch;
    ChoiceScreen(StartGame game){
        this.game = game;
        stage = new Stage();
        batch = new SpriteBatch();
        lop6 = new ButtonClass(200, Gdx.graphics.getHeight()/2 - 32, stage,6);
        lop6.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Utils.setWordList6();
                game.setScreen(new Master(game));
            }
        });
        lop7 = new ButtonClass(400, Gdx.graphics.getHeight()/2 - 32, stage,7);
        lop7.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Utils.setWordList7();
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
        game.font.draw(batch, "Do you want to raise Pokémon and battle with ", 100, 400);
        game.font.draw(batch, "             grade 6 or 7 vocabulary?        ", 100, 370);
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
