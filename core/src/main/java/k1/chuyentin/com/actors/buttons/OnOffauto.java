package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.actors.Item2;
import k1.chuyentin.com.actors.MyActor;

import static k1.chuyentin.com.StartGame.amthanh;

public class OnOffauto extends MyActor {
    public OnOffauto(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("am thanh = 100.png"));

        setSize(textureRegion.getRegionWidth()/2+16,textureRegion.getRegionHeight()/2+16);
        setPosition(x, y);


    }

}
