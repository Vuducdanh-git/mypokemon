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

        board = new Board(50,100,stage,1);
        board2 = new Board(50,200,stage,2);
        board3 = new Board(50,300,stage,3);
        board4 = new Board(250,100,stage,4);
        board5 = new Board(250,200,stage,5);
        board6 = new Board(250,300,stage,6);

        board.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                random=1;
                game.setScreen(new BattleScreen(game));
            }
        });
        board2.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                random=2;
                game.setScreen(new BattleScreen(game));
            }
        });
        board3.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                random=3;
                game.setScreen(new BattleScreen(game));
            }
        });
        board4.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                random=4;
                game.setScreen(new BattleScreen(game));
            }
        });
        board5.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                random=5;
                game.setScreen(new BattleScreen(game));
            }
        });
        board6.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                random=6;
                game.setScreen(new BattleScreen(game));
            }
        });

        stage.addActor(returnButton);
        stage.addActor(board);
        stage.addActor(board6);
        stage.addActor(board2);
        stage.addActor(board3);
        stage.addActor(board4);
        stage.addActor(board5);
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
