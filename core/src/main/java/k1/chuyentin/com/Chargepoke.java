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
import k1.chuyentin.com.bao.Utils6;

public class Chargepoke implements Screen {
    StartGame game;
    OrthographicCamera camera;
    Texture texture;
    SpriteBatch batch;
    public static Board board;
    public static Board board2;
    public static Board board3;
    public static Board board4;
    public static Board board5;
    public static Board board6;
    public static Board board7;
    public static Board board8;
    public static Board board9;
    public static Board board10;
    public static Board board11;
    public static Board board12;
    public static Board board13;
    public static Board board14;
    public static Board board15;
    public static Board board16;
    public static Board board17;
    public static Board board18;
    public static Board board19;
    public static Board board20;
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
        float x = 50;
        float y = 300;

        for (int i = 0; i < Utils6.listPoke.size; i++) {
            int type = (int) Utils6.listPoke.get(i);
            Board boardnew = new Board(x,y,stage,type);
            boardnew.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    random=type;
                    game.setScreen(new BattleScreen(game));
                }
            });
            if(i %2==0){
                x+=(boardnew.getWidth()+20);

            }else {
                x -= boardnew.getWidth()+20;
                y-=(boardnew.getHeight()+20);
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
