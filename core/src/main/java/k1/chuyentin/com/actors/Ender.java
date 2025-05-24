package k1.chuyentin.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Ender extends Actor {
    Texture texture;
    public Ender(float x, float y, Stage stage,boolean isbt) {
        texture = new Texture("pear.png");
        setPosition(x, y);
        setSize(64, 64);
        if(stage!=null){
            stage.addActor(this);
        }
        if (isbt==true) {
            addAction(Actions.sequence(
                Actions.delay(2),
                Actions.removeActor()
            ));
        }
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
