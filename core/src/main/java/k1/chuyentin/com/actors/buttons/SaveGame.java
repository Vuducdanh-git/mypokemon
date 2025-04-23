package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import k1.chuyentin.com.actors.MyActor;

public class SaveGame extends MyActor {
    public SaveGame(float x, float y, Stage s) {
        super(x,y,s);
        textureRegion = new TextureRegion(new Texture("savegame.png"));
        setSize(textureRegion.getRegionWidth()/2,textureRegion.getRegionHeight()/2);
        setPosition(x, y);
    }
}
