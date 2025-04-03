package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bar3 extends Actor {
    Texture texture;
    public Bar3(float x, float y, Stage stage) {
        texture = new Texture("hb.png");
        setPosition(x, y);
        setSize(0, 50);
        stage.addActor(this);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
