package k1.chuyentin.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import k1.chuyentin.com.screens.BaloScreen;

public class Balo extends Actor {
    Texture texture;
    BaloScreen balovatpham;
    Bth bth;

    public Balo(Stage stage , float x, float y) {
        texture = new Texture("bag.png");
        setPosition(x, y);
        setSize(50, 40);
        stage.addActor(this);
    }


    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
