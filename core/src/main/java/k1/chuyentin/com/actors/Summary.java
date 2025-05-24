package k1.chuyentin.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import k1.chuyentin.com.screens.BattleScreen;

public class Summary extends Actor {
    Texture texture;
    public Summary(int x, int y, Stage stage) {
        texture = new Texture("summary.png");
        setPosition(x, y);
        setSize(400,250);
        toFront();


    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }

}
