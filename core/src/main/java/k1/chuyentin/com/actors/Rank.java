package k1.chuyentin.com.actors;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.actors.MyActor;

import static k1.chuyentin.com.StartGame.amthanh;

public class Rank extends MyActor {
    public Rank(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("1.png"));

        setSize(textureRegion.getRegionWidth()/4,textureRegion.getRegionHeight()/4);
        setPosition(x, y);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (StartGame.diamonds.size>=5&&StartGame.diamonds.size<10){
            textureRegion = new TextureRegion(new Texture("2.png"));
        }
        if (StartGame.diamonds.size>=10&&StartGame.diamonds.size<25){
            textureRegion = new TextureRegion(new Texture("3.png"));
        }
        if (StartGame.diamonds.size>=25&&StartGame.diamonds.size<60){
            textureRegion = new TextureRegion(new Texture("4.png"));
        }
        if (StartGame.diamonds.size>=60&&StartGame.diamonds.size<100){
            textureRegion = new TextureRegion(new Texture("5.png"));
        }
        if (StartGame.diamonds.size>=100&&StartGame.diamonds.size<200){
            textureRegion = new TextureRegion(new Texture("6.png"));
        }
        if (StartGame.diamonds.size>=200&&StartGame.diamonds.size<1000){
            textureRegion = new TextureRegion(new Texture("7.png"));
        }
//        if (StartGame.diamonds.size>=500&&StartGame.diamonds.size<1000){
//            textureRegion = new TextureRegion(new Texture("6.png"));
//        }
    }
}
