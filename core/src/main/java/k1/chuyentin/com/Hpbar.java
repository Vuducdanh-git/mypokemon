package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Hpbar extends Actor {
    Texture texture;
    public Hpbar(float x, float y, Stage stage) {
        texture = new Texture("hb.png");
        setPosition(x, y);
        setSize(270, 25);
        stage.addActor(this);
    }

    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
