package k1.chuyentin.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Background extends Actor {
    Texture texture;
    public int biome=1;
    public Background(float x, float y, Stage stage) {
        if (biome ==1){
            texture = new Texture("battle.jpg");
        }
        if(biome ==2){
            texture = new Texture("biomemagma.jpg");
        }
        toBack();
        setPosition(x, y);
        setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage.addActor(this);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }

}
