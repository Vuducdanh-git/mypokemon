package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Cross extends Actor {
    Texture texture;

    public Cross(Stage stage , float x, float y, float width, float height) {
        texture = new Texture("cross.png");
        setPosition(x, y);
        setSize(width, height);

    }


    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
