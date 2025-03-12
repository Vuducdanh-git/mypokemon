package k1.chuyentin.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SkillBar extends Actor {
    Texture texture;
    public SkillBar(float x, float y, Stage stage) {
        texture = new Texture("sboard.png");
        setPosition(x, y);
        setSize(280, 130);
        stage.addActor(this);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
