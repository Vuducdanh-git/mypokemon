package k1.chuyentin.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import k1.chuyentin.com.actors.MyActor;

public class Fire extends MyActor {
    public Fire(float x, float y, Stage s, boolean isHeated,int image) { // isHeated duoc dam hoac bi dam
        super(x, y, s);
        setSize(30,30);
        if(image ==1){
            textureRegion = new TextureRegion(new Texture("fire.png"));
        }
        if(image ==2){
            textureRegion = new TextureRegion(new Texture("leaf.png"));
        }
        if(image ==3){
            textureRegion = new TextureRegion(new Texture("water.png"));
        }

        setPosition(MathUtils.random(0, 200), MathUtils.random(300, 600));
        if(isHeated) {
            setPosition(MathUtils.random(-7, 70), MathUtils.random(-4, 80));
            addAction(Actions.sequence(
                Actions.moveBy(390, 350, 3),
                Actions.removeActor()
            ));
            setRotation(45);
        } else {
            setPosition(MathUtils.random(390, 450), MathUtils.random(280, 350));
            addAction(Actions.sequence(
                Actions.moveBy(-390, -350, 3),
                Actions.removeActor()
            ));
            setRotation(-150);
        }
        setSize(16, 16);
        toFront();
    }
}
