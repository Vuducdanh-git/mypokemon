package k1.chuyentin.com.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SB extends Actor {
    Texture texture;
    public SB(float x, float y, Stage stage) {
        texture = new Texture("slimeball.png");
        setPosition(x, y);
        setSize(32, 32);
        stage.addActor(this);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
