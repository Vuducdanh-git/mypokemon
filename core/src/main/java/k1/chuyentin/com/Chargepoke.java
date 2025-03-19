package k1.chuyentin.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.bao.Utils;

public class Chargepoke implements Screen {
    StartGame game;
    OrthographicCamera camera;
    Texture texture;
    SpriteBatch batch;
    Board board;
    Board board2;
    Board board3;
    Board board4;
    Board board5;
    Board board6;
    Board board7;
    Board board8;
    Board board9;
    Board board10;
    Board board11;
    Board board12;
    Board board13;
    Board board14;
    Board board15;
    Board board16;
    Board board17;
    Board board18;
    Board board19;
    Board board20;
    static int random;

    Stage stage;
    public Chargepoke(StartGame game){
        stage = new Stage();
        this.game = game;
        texture = new Texture("choose.png");
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = this.game.font;
        style.fontColor = Color.ROYAL;

        TextButton returnButton = new TextButton("Return", style);
        returnButton.setSize(200,350);
        returnButton.setPosition(640 - 200,10);
        returnButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new BattleScreen(game));
            }
        });
        batch = new SpriteBatch();

        for (int type: Utils.listPoke){
            if (type == 1){
                board = new Board(50,100,stage,1);
                board.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=1;
                        game.setScreen(new BattleScreen(game));
                    }
                });
                stage.addActor(board);
            }
            if(type == 2){
                board2 = new Board(50,200,stage,2);
                board2.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=2;
                        game.setScreen(new BattleScreen(game));
                    }
                });
                stage.addActor(board2);
            }
            if (type == 3){
                board3 = new Board(50,300,stage,3);
                board3.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=3;
                        game.setScreen(new BattleScreen(game));
                    }
                });
                stage.addActor(board3);
            }
            if(type == 4){
                board4 = new Board(250,100,stage,4);
                board4.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=4;
                        game.setScreen(new BattleScreen(game));
                    }
                });
                stage.addActor(board4);
            }
            if (type == 5){
                board5 = new Board(250,200,stage,5);
                board5.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=5;
                        game.setScreen(new BattleScreen(game));
                    }
                });
                stage.addActor(board5);

            }
            if(type == 6){
                board6 = new Board(250,300,stage,6);
                board6.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=6;
                        game.setScreen(new BattleScreen(game));
                    }
                });
                stage.addActor(board6);
            }
            if (type == 7){
                board7 = new Board(50,100,stage,7);
                board7.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=7;
                        game.setScreen(new BattleScreen(game));
                    }
                });
                stage.addActor(board7);


            }
            if(type == 8){
                board8 = new Board(50,200,stage,8);
                board8.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=8;
                        game.setScreen(new BattleScreen(game));
                    }
                });
                stage.addActor(board8);
            }
            if (type == 9){
                board9 = new Board(50,300,stage,9);
                board9.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=9;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board9);
            }
            if(type == 10){
                board10 = new Board(250,100,stage,10);
                board10.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=10;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board10);
            }
            if (type == 11){
                board11 = new Board(250,200,stage,11);
                board11.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=11;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board11);
            }
            if (type == 12){
                board12 = new Board(250,300,stage,12);
                board12.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=12;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board12);
            }
            if(type == 13){
                board13 = new Board(50,100,stage,13);
                board13.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=11;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board13);
            }
            if (type == 14){
                board14 = new Board(50,200,stage,14);
                board14.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=14;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board14);
            }
            if(type == 15){
                board15 = new Board(50,300,stage,15);
                board15.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=15;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board15);
            }
            if (type == 16){
                board16 = new Board(250,100,stage,16);
                board16.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=11;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board16);
            }
            if(type == 17){
                board17 = new Board(250,200,stage,17);
                board17.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=11;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board17);
            }
            if(type == 18){
                board18 = new Board(250,300,stage,18);
                board18.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=11;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board18);
            }
            if(type == 19){
                board19 = new Board(250,200,stage,19);
                board19.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=19;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board19);
            }
            if(type == 20){
                board20 = new Board(250,300,stage,20);
                board20.addListener(new ClickListener(){
                    public void clicked(InputEvent event, float x, float y) {
                        random=20;
                        game.setScreen(new BattleScreen(game));
                    }
                });stage.addActor(board20);
            }


        }







        stage.addActor(returnButton);


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {

        batch.begin();
        batch.draw(texture, 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.end();
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
