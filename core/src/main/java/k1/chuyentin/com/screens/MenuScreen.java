package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.actors.buttons.NutMenu;
import k1.chuyentin.com.common.GameState;
import k1.chuyentin.com.enums.ButtonType;

public class MenuScreen implements Screen {
    Stage stage;
    StartGame game;
    NutMenu play;
    NutMenu continute;
    NutMenu guide;
    Texture image;
    SpriteBatch batch;
    NutMenu exit;

    MenuScreen(StartGame game){
     this.game=game;
     image=new Texture("nen.jpg");
     stage = new Stage();
     batch = new SpriteBatch();
     guide = new NutMenu(200, 380, stage, ButtonType.GUIDE);
     guide.setX(Gdx.graphics.getWidth()/2 - guide.getWidth()/2);

     guide.addListener(new ClickListener(){
         @Override
         public void clicked(InputEvent event, float x, float y) {
             game.setScreen(new GuideScreen(game));
         }
     });
        play = new NutMenu(200, 250, stage, ButtonType.PLAY);
        play.setX(Gdx.graphics.getWidth()/2 - guide.getWidth()/2);

        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new ChoiceScreen(game));
            }
        });
        continute = new NutMenu(200, 130, stage, ButtonType.CONTINUE);
        continute.setX(Gdx.graphics.getWidth()/2 - guide.getWidth()/2);

        continute.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                GameState gameState = new GameState();
                gameState.loadGame();
                game.setScreen(new Master(game));
            }
        });
        exit = new NutMenu(200, 20 ,stage, ButtonType.EXIT);
        exit.setX(Gdx.graphics.getWidth()/2 - guide.getWidth()/2);

        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();

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
        batch.begin();
        batch.draw(image,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
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
        stage.clear();
    }

    @Override
    public void dispose() {

    }
}
