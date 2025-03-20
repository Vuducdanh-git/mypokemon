package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.bao.Master;

public class Bth extends Actor {
    Texture texture;
    public static int click =0;

    public Bth(Stage stage , float x, float y, float width) {
        texture = new Texture("bth.png");
        setPosition(x, y);
        setSize(width, 30);
        stage.addActor(this);

    }

    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
