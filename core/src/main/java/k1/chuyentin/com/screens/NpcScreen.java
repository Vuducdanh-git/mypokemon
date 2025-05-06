package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.Utils;

import k1.chuyentin.com.actors.Notification;
import k1.chuyentin.com.actors.Npc;
import k1.chuyentin.com.actors.buttons.No;
import k1.chuyentin.com.actors.buttons.Yes;

public class NpcScreen implements Screen {
    Stage stage;
    Npc npc;
    Yes yes;
    int say =0;
    No no;

    int a ;
    int wrongansr;
    int wrongansr1;
    int wrongansr2;
    int s=0;



    public NpcScreen(StartGame game) {
        stage = new Stage();

        npc = new Npc(Gdx.graphics.getWidth()/2-50,Gdx.graphics.getHeight()/2-50,stage);




        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.up = new TextureRegionDrawable(new Texture("but.png"));
        style.fontColor = Color.RED;




        new Notification(Gdx.graphics.getWidth()/2-50,400,stage,"Yes or No").addAction(Actions.sequence(
            Actions.fadeOut(2f),
            Actions.run( () ->{
                yes = new Yes(stage,100,50,150,100);
                no = new No(stage,400,50,150,100);
                no.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y) {
                        game.setScreen(new Master(game));
                    }
                });
                yes.addListener(new ClickListener() {
                    public void clicked(InputEvent event, float x, float y) {
                        if((Master.wordSkills.isEmpty()) || (Master.wordSkills.size ==1) || (Master.wordSkills.size ==2) || (Master.wordSkills.size ==3)) {
                            yes.remove();
                            no.remove();
                            new Notification(180,400,stage,"Nad,You don't have enough skill").addAction(Actions.sequence(
                                Actions.fadeOut(2f),
                                Actions.run( () ->{
                                    game.setScreen(new Master(game));
                                }),
                                Actions.removeActor()
                            ));
                        }else {
                            no.remove();
                            yes.remove();

                            npc.remove();
                            s=1;
                            a= MathUtils.random(0,Master.wordSkills.size-1);
                            if(a == Master.wordSkills.size-1){
                                a = (Master.wordSkills.size-1)-4;
                            }
                            wrongansr = MathUtils.random(a+1,Master.wordSkills.size-1);
                            int b = wrongansr;
                            if (b == Master.wordSkills.size - 1) {
                                b = Master.wordSkills.size-MathUtils.random(1,Master.wordSkills.size-2);
                            }
                            wrongansr1 = b;
                            int c = wrongansr1;
                            if((c == Master.wordSkills.size-1)||(b == Master.wordSkills.size-1)){
                                wrongansr = Master.wordSkills.size-MathUtils.random(1,Master.wordSkills.size-2);
                            }else {
                                wrongansr2 = MathUtils.random(c+1,Master.wordSkills.size-1);
                            }
                                TextButton wrongans = new TextButton(Master.wordSkills.get(wrongansr),style);
                                TextButton wrongans1 = new TextButton(Master.wordSkills.get(wrongansr1),style);
                                TextButton wrongans2 = new TextButton(Master.wordSkills.get(wrongansr2),style);
                                TextButton rightans = new TextButton(Master.wordSkills.get(a),style);

                                rightans.setSize(150,100);
                                rightans.setPosition(100,200); //Gdx.graphics.getHeight()/2-rightans.getHeight()/2);
                                rightans.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y){
                                        say =1;
                                        rightans.remove();
                                        wrongans.remove();
                                        wrongans2.remove();
                                        wrongans1.remove();
                                        new Notification(200,200,stage,"You choose a right answer").addAction(Actions.sequence(
                                            Actions.fadeOut(2f),
                                            Actions.run( () ->{
                                                game.setScreen(new Master(game));
                                            }),
                                            Actions.removeActor()
                                        ));


                                    }
                                });


                                wrongans.setSize(150,100);
                                wrongans.setPosition(100, 100);//Gdx.graphics.getHeight()/2 - wrongans.getHeight()/2);
                                wrongans.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y){
                                        say =2;
                                        rightans.remove();
                                        wrongans.remove();
                                        wrongans2.remove();
                                        wrongans1.remove();

                                        new Notification(200,200,stage,"You choose a wrong answer").addAction(Actions.sequence(
                                            Actions.fadeOut(2f),
                                            Actions.run( () ->{
                                                game.setScreen(new Master(game));
                                            }),
                                            Actions.removeActor()
                                        ));

                                    }
                                });

                                wrongans1.setSize(150,100);
                                wrongans1.setPosition(400,200);// Gdx.graphics.getHeight()/2 - 2* wrongans1.getHeight()/2);
                                wrongans1.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y){
                                        say =2;
                                        rightans.remove();
                                        wrongans.remove();
                                        wrongans2.remove();
                                        wrongans1.remove();
                                        new Notification(200,200,stage,"You choose a wrong answer").addAction(Actions.sequence(
                                            Actions.fadeOut(2f),
                                            Actions.run( () ->{
                                                game.setScreen(new Master(game));
                                            }),
                                            Actions.removeActor()
                                        ));
                                    }
                                });

                                wrongans2.setSize(150,100);

                                wrongans2.setPosition(400, 100);//Gdx.graphics.getHeight()/2 -  wrongans2.getHeight()/2);
                                wrongans2.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y){
                                        say =2;
                                        rightans.remove();
                                        wrongans.remove();
                                        wrongans2.remove();
                                        wrongans1.remove();
                                        new Notification(200,200,stage,"You choose a wrong answer").addAction(Actions.sequence(
                                            Actions.fadeOut(2f),
                                            Actions.run( () ->{
                                                game.setScreen(new Master(game));
                                            }),
                                            Actions.removeActor()
                                        ));

                                    }
                                });
                                new Notification(20, 400, stage, "nghĩa tiếng ảnh của từ:" + Master.wordSkillsVN.get(a));
                                if(s ==1){
                                    stage.addActor(rightans);
                                    stage.addActor(wrongans);
                                    stage.addActor(wrongans1);
                                    stage.addActor(wrongans2);
                                }
                        }
                    }
                });
            }),
            Actions.removeActor()

        ));


    }
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }
    public void render(float delta) {
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
