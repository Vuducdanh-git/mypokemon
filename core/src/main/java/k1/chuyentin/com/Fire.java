package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import k1.chuyentin.com.bao.MyActor;

public class Fire extends MyActor {
    public Fire(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("fire.png"));

        setPosition(MathUtils.random(0, 200), MathUtils.random(300, 600));
        addAction(Actions.sequence(
            Actions.moveBy(300, -300, 2),
            Actions.removeActor()
        ));
    }
}
