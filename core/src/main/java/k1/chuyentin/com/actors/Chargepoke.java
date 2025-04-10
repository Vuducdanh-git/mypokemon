package k1.chuyentin.com.actors;

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
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.Utils;
import k1.chuyentin.com.enums.PetStatus;
import k1.chuyentin.com.screens.BattleScreen;

public class Chargepoke implements Screen {
    StartGame game;
    OrthographicCamera camera;
    Texture texture;
    SpriteBatch batch;
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

        for (int i = 0; i < Utils.pets.size; i++) {
            Pet pet = Utils.pets.get(i);
            pet.setPosition(x, y);
            pet.status = PetStatus.CHARGE;
            pet.setSize(64, 64);
            pet.game = game;
            stage.addActor(pet);

            if(i % 2 == 0){
                x+=(pet.getWidth()+20);
            }else {
                x -= pet.getWidth()+20;
                y-=(pet.getHeight()+20);
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
