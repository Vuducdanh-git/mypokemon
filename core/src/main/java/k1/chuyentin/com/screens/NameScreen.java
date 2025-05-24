package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.actors.Fire;
import k1.chuyentin.com.actors.Skill;

public class NameScreen implements Screen {
    TextField textField;
    k1.chuyentin.com.StartGame game;
    Stage stage;
    boolean ika =true;
    public static String inputText;
    SpriteBatch batch;
    NameScreen(StartGame game) {
        this.game = game;
        stage = new Stage();
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = game.font;
        textFieldStyle.fontColor = Color.BLACK;

        textFieldStyle.background = new TextureRegionDrawable(new TextureRegion(new Texture("input.png")));

        // Tạo TextField
        textField = new TextField("", textFieldStyle);
        textField.setSize(440, 50);
        textField.setPosition(Gdx.graphics.getWidth()/2-220, Gdx.graphics.getHeight()/2-25); // Vị trí giữa màn hình
        textField.setVisible(false);

        stage.addActor(textField);
        batch = new SpriteBatch();


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.act();
        stage.draw();
        batch.begin();
        game.fontf.draw(batch,"What is your name?",100,Gdx.graphics.getHeight()/2+80);

        if(ika==true){
            textField.setVisible(true);
            textField.setText(""); // Xóa nội dung cũ
            stage.setKeyboardFocus(textField);
            ika = false;
        }
        else if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER))&&(textField.getText().length()<21)) {
            inputText = textField.getText();
            System.out.println(inputText);
            textField.setVisible(false);
            stage.unfocusAll();
            System.out.println(inputText);
            ika = true;
            game.setScreen(new Master(game));
        }else if((Gdx.input.isKeyPressed(Input.Keys.ENTER))&&(textField.getText().length()>20)){
            textField.setVisible(true);
            textField.setText(""); // Xóa nội dung cũ
            stage.setKeyboardFocus(textField);
            ika = false;
        }
        System.out.println(inputText);
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
