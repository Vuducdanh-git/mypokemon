package k1.chuyentin.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class ChuaDuDieuKien extends MyActor {
    public ChuaDuDieuKien(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("ssss.png"));
        setSize(300, 300/2);
        setPosition(Gdx.graphics.getWidth()/2 - getWidth()/2, Gdx.graphics.getHeight()/2-100);
        addAction(Actions.sequence(
            Actions.fadeOut(2),
            Actions.removeActor()
        ));
    }
}
