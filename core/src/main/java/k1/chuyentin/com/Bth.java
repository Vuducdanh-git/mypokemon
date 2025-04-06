package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bth extends Actor {
    Texture texture;

    public Bth(Stage stage , float x, float y, float width) {
        texture = new Texture("bth.png");
        setPosition(x, y);
        setSize(width-width/3, 30);
        stage.addActor(this);

    }

    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
