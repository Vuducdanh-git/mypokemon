package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.*;
import k1.chuyentin.com.actors.*;
import k1.chuyentin.com.enums.PetStatus;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.addAction;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.addListener;

public class BaloScreen implements Screen {
    Stage stage;
    StartGame game;
    Bth bth;
    Diamond dia;
    public static int peachfire =0;
    SB slimeball;
    Ender ender;

    public static int soDia = 0;
    SpriteBatch batch;
    public BaloScreen(StartGame game) {
        this.game = game;
        stage = new Stage();
        batch=new SpriteBatch();
        bth = new Bth(stage, 340, 60-30, 294, 156);
        slimeball = new SB(200,400,stage,false);
        dia = new Diamond(100,400,stage,false);
        ender=new Ender(300,400,stage,false);
        bth.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Master(game));
            }
        });
        float x = 50;
        float y = 300;

        for (int i = 0; i < Utils.pets.size; i++) {

            Pet pet = Utils.pets.get(i);
            pet.setPosition(x, y);
            pet.status = PetStatus.STAT;
            pet.setSize(64, 64);
            pet.game = game;
            stage.addActor(pet);

            if (i % 4 != 0) {
                x += (pet.getWidth() + 20);
            } else {
                x = 50;
                y -= (pet.getHeight() + 20);
            }

        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
        stage.act();
        StartGame.mytime +=v;
        stage.draw();
        BaloScreen.peachfire =0;
        System.out.println(peachfire);
        batch.begin();
        game.font.setColor(1,1,1,1);
        game.font.draw(batch, "" + game.diamonds.size, 100, Gdx.graphics.getHeight() - 64);
        game.font.draw(batch, "" + game.sbs.size, 200, Gdx.graphics.getHeight() - 64);
        game.font.draw(batch, "" + game.enders.size, 300, Gdx.graphics.getHeight() - 64);
        game.font.draw(batch, "" + game.sbs.size, 200, Gdx.graphics.getHeight() - 64);
        game.font.draw(batch, "" + game.enders.size, 300, Gdx.graphics.getHeight() - 64);
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

