package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.actors.Bth;
import k1.chuyentin.com.actors.FloatingWords;
import k1.chuyentin.com.screens.Wlsword;
import k1.chuyentin.com.actors.buttons.MLen;
import k1.chuyentin.com.actors.buttons.MXuong;
import k1.chuyentin.com.actors.buttons.NutMenu;
import k1.chuyentin.com.enums.ButtonType;

public class WordListScreen implements Screen {
    Stage stage;
    Stage noMoveStage;
    Bth exit;
    MLen len;
    MXuong xuong;
    Wlsword wlsword;
    int repet =0;
    int y =25;
    int x =0;
    long time=0;

    public WordListScreen(StartGame game){
        stage = new Stage();
        noMoveStage = new Stage();

        exit = new Bth(noMoveStage, Gdx.graphics.getWidth()-100 ,50,100,50);
        exit.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Master(game));
            }
        });
        if (!Master.wordSkills.isEmpty()) {
            String words = Master.wordSkills.get(repet);
            new Wlsword(-10000, 0, stage, words);

            String wordsVN = Master.wordSkillsVN.get(repet);
            new Wlsword(-1000, 0, stage, wordsVN);
        }
        len = new MLen(noMoveStage,Gdx.graphics.getWidth()-100 ,240,Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/8);
        xuong = new MXuong(noMoveStage,Gdx.graphics.getWidth()-100 ,150,Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/8);
        noMoveStage.addActor(exit);

        len.addListener(new ClickListener(){
            @Override

            public void clicked(InputEvent event, float x, float y) {
                stage.getViewport().getCamera().position.y += 25;
            }
        });


        xuong.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.getViewport().getCamera().position.y -= 25;
            }
        });

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(noMoveStage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
        stage.act();
        stage.draw();
        time++;
        if (time % 30 == 0) {
            if (Master.wordSkills.size >repet) {
                String words = Master.wordSkills.get(repet);
                String wordsVN = Master.wordSkillsVN.get(repet);
                new Wlsword(x, Gdx.graphics.getHeight()-y, stage, words+" : "+wordsVN);
                y +=25;
                repet++;

            }
        }

        noMoveStage.act();
        noMoveStage.draw();

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
        stage.clear();
    }

    @Override
    public void dispose() {

    }
}

