package k1.chuyentin.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Background extends Actor {
    Texture texture;
    public Background(float x, float y, Stage stage) {
        texture = new Texture("battle.jpg");
        setPosition(x, y);
        setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage.addActor(this);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }

}
