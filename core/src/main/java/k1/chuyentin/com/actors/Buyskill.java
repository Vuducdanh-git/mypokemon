package k1.chuyentin.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Buyskill extends MyActor {
    public Buyskill(float x, float y, Stage  s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("buy sk.png"));
        setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));
    }
}
