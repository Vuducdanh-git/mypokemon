package k1.chuyentin.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.bao.Item;
import k1.chuyentin.com.bao.Master;

import static k1.chuyentin.com.bao.Master.money;

public class BaloScreen implements Screen {
    Stage stage;
    StartGame game;
    Bth bth;
    Dyamon dia;
    SB slimeball;
    Ender ender;
    SpriteBatch batch;
    public Array<Dyamon> items;
    public Array<SB> items2;
    public Array<Ender> items3;
    public BaloScreen(StartGame game){
        this.game = game;
        stage = new Stage();
        items = new Array<>();
        items2 = new Array<>();
        items3 = new Array<>();
        batch=new SpriteBatch();
        bth = new Bth(stage, 340, 60-30, 200);
        slimeball = new SB(100,400,stage);
        dia = new Dyamon(50,400,stage);
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
        game.font.draw(batch, "" + items.size, 64, Gdx.graphics.getHeight() - 64);
        game.font.draw(batch, "" + items2.size, 120, Gdx.graphics.getHeight() - 64);
        game.font.draw(batch, "" + items3.size, 170, Gdx.graphics.getHeight() - 64);
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

