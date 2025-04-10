package k1.chuyentin.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Ender extends Actor {
    Texture texture;
    public Ender(float x, float y, Stage stage) {
        texture = new Texture("pear.png");
        setPosition(x, y);
        setSize(32, 32);
        stage.addActor(this);
        addAction(Actions.sequence(
            Actions.delay(2),
            Actions.removeActor()
        ));
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
