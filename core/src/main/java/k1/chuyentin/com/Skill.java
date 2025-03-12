package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Skill extends Actor {
    Texture texture;
    public Skill(Stage stage , float x, float y,float width) {
        texture = new Texture("skill.png");
        setPosition(x, y);
        setSize(width, 30);
        stage.addActor(this);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
