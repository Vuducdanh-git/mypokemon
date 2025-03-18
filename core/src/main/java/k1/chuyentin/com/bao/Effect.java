package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Effect extends MyActor{

    Effect(float x, float y , Stage s) {
        super(x, y, s);
        TextureRegion tRegion = new TextureRegion(new Texture("effect.png"));
        textureRegion = tRegion;
        setSize(16, 16);
        setPosition(Gdx.graphics.getWidth()/2 - getWidth()/2, Gdx.graphics.getHeight()/2 - getHeight()/2);
        setOrigin(getWidth()/2, getHeight()/2);
        setColor(1,1,1,0.5f);

        addAction(Actions.sequence(
            Actions.moveBy(MathUtils.random(-200, 200), MathUtils.random(-200, 200), 2),
            Actions.removeActor()
        ));
    }
}
