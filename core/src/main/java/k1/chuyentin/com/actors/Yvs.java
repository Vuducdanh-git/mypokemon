package k1.chuyentin.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Yvs extends MyActor{
    public Yvs(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("yvl.png"));
        setSize(200, 100);
    }
}

