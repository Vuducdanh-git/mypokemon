package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.Utils;
import k1.chuyentin.com.actors.FloatingWords;
import k1.chuyentin.com.actors.Npc;
import k1.chuyentin.com.actors.buttons.No;
import k1.chuyentin.com.actors.buttons.Yes;
import k1.chuyentin.com.common.GameState;

public class NpcScreen implements Screen {
    Stage stage;
    Npc npc;
    Yes yes;
    int say =0;
    No no;
    StartGame game = new StartGame();
    SpriteBatch batch = new SpriteBatch();


    public NpcScreen(StartGame game) {
        stage = new Stage();

        npc = new Npc(Gdx.graphics.getWidth()/2-50,Gdx.graphics.getHeight()/2-50,stage);
        yes = new Yes(stage,200,50,100,100);
        no = new No(stage,400,50,100,100);
        no.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Master(game));
            }
        });
        yes.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                no.remove();
                yes.remove();
            }
        });
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.up = new TextureRegionDrawable(new Texture("but.png"));
        style.fontColor = Color.YELLOW;
        TextButton wrongans2 = new TextButton(Utils.wordList.get(MathUtils.random(1,Utils.wordList.size-1)),style);
        TextButton wrongans = new TextButton(Utils.wordList.get(MathUtils.random(1,Utils.wordList.size-1)),style);
        TextButton wrongans1 = new TextButton(Utils.wordList.get(MathUtils.random(1,Utils.wordList.size-1)),style);
        TextButton rightans = new TextButton(Utils.wordList.get(0),style);

        rightans.setSize(150,100);
        rightans.setPosition(Gdx.graphics.getWidth()/2-rightans.getWidth()/2,300); //Gdx.graphics.getHeight()/2-rightans.getHeight()/2);
        rightans.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                say =1;
                rightans.remove();
                wrongans.remove();
                wrongans2.remove();
                wrongans1.remove();
            }
        });


        wrongans.setSize(150,100);
        wrongans.setPosition(Gdx.graphics.getWidth()/2 - wrongans.getWidth()/2, 100);//Gdx.graphics.getHeight()/2 - wrongans.getHeight()/2);
        wrongans.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                say =2;
                rightans.remove();
                wrongans.remove();
                wrongans2.remove();
                wrongans1.remove();
            }
        });

        wrongans1.setSize(150,100);
        wrongans1.setPosition(Gdx.graphics.getWidth()/4 - wrongans1.getWidth()/2,300);// Gdx.graphics.getHeight()/2 - 2* wrongans1.getHeight()/2);
        wrongans1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                say =2;
                rightans.remove();
                wrongans.remove();
                wrongans2.remove();
                wrongans1.remove();
            }
        });

        wrongans2.setSize(150,100);

        wrongans2.setPosition(Gdx.graphics.getWidth()/4 - wrongans2.getWidth()/2, 100);//Gdx.graphics.getHeight()/2 -  wrongans2.getHeight()/2);
        wrongans2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                say =2;
                rightans.remove();
                wrongans.remove();
                wrongans2.remove();
                wrongans1.remove();
            }
        });
        stage.addActor(rightans);
        stage.addActor(wrongans);
        stage.addActor(wrongans1);
        stage.addActor(wrongans2);


    }
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        stage.act();
        stage.draw();
//        batch.begin();

//        if(say ==1){
//            game.font.draw(batch,"You choose the right answer,I'll give you 20k money for reward",Gdx.graphics.getWidth()/2-50,Gdx.graphics.getHeight()-50);
//            for (int i = 0; i < 5*60; i = i+1) {
//                System.out.println(i);
//            }
//            Master.money +=20000;
//            say =3;
//        }else if(say ==2){
//            game.font.draw(batch,"You choose the wrong answer",Gdx.graphics.getWidth()/2-50,Gdx.graphics.getHeight()-50);
//            for (int i = 0; i < 5*60; i++) {
//                System.out.println(i);
//            }
//            say =3;
//
//        }
//        batch.end();
//        if (say ==3){
//            game.setScreen(new Master(game));
//        }


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
