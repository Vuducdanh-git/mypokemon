package k1.chuyentin.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.bao.*;

public class AboutScreen implements Screen {
    StartGame game;
    Stage stage;

    Label.LabelStyle labelStyle = new Label.LabelStyle();
    int time = 0;

    Music music;

    MyActor bg;

    public AboutScreen(StartGame game){
        this.game = game;
        stage = new Stage();

        bg = new BackGround(0, 0, stage);

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 25;
        fontParameter.color = Color.RED;
        BitmapFont font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();

        // Tạo LabelStyle với font tùy chỉnh
        labelStyle.font = font;

        music = Gdx.audio.newMusic(Gdx.files.internal("night_core.wav"));
        music.setLooping(true);
        music.play();

        Utils.setWordList();

    }
    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        time ++;
        if(time % 10 ==0){
            new Coin(MathUtils.random(0, 640), MathUtils.random(0, 480), stage, false).addAction(
                Actions.sequence(
                    Actions.moveTo(320, 240, 2),
                    Actions.removeActor())
            );
        }

        if (time % 20 == 0) {
            Label label = new Label(Utils.wordList.random(), labelStyle);
            label.setPosition(MathUtils.random(0, 640), MathUtils.random(0, 480));
            label.setOrigin(label.getWidth() / 2, label.getHeight() / 2);
            label.setRotation(MathUtils.random(0, 360));
            label.addAction(
                Actions.sequence(
                    Actions.moveTo(320, 240, 2),
                    Actions.removeActor())
            );
            label.addAction(
                Actions.fadeOut(2)
            );

            stage.addActor(label);
        }

        if(time == 60 * 10){
            game.setScreen(new Master(game));
        }


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
