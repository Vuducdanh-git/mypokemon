package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import k1.chuyentin.com.bao.MyActor;

public class Fire extends MyActor {
    public Fire(float x, float y, Stage s, boolean isHeated) { // isHeated duoc dam hoac bi dam
        super(x, y, s);
        setSize(30,30);
        textureRegion = new TextureRegion(new Texture("fire.png"));
        setPosition(MathUtils.random(0, 200), MathUtils.random(300, 600));
        if(isHeated) {
            addAction(Actions.sequence(
                Actions.moveBy(400, -200, 2),
                Actions.removeActor()
            ));
            setRotation(-45);
        } else {
            addAction(Actions.sequence(
                Actions.moveBy(0, -300, 2),
                Actions.removeActor()
            ));
            setRotation(-90);
        }
        setSize(16, 16);
        toFront();
    }
}
