package k1.chuyentin.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bar3 extends MyActor {
    public Bar3(float x, float y, Stage stage) {
        super(x, y, stage);
        textureRegion = new TextureRegion(new Texture("hp.png"));
        setPosition(x, y);
        setSize(0, 50);
        stage.addActor(this);
    }
}
