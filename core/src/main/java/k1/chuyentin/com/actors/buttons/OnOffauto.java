package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.actors.Item2;
import k1.chuyentin.com.actors.MyActor;

import static k1.chuyentin.com.StartGame.amthanh;

public class OnOffauto extends MyActor {
    public OnOffauto(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("auto on.png"));
        toFront();
        setSize(textureRegion.getRegionWidth()/16,textureRegion.getRegionHeight()/16);
        setPosition(x, y);

        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));

    }

}
