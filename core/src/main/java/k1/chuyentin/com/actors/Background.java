package k1.chuyentin.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Background extends MyActor {
    public Background(float x, float y, Stage stage,int biome) {
        super(x,y,stage);
        if (biome ==1){
            textureRegion = new TextureRegion(new Texture("battle.jpg"));
        }
        if(biome ==2){
            textureRegion = new TextureRegion(new Texture("biomemagma.jpg"));

        }
        toBack();
        setPosition(x, y);
        setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage.addActor(this);
    }
}
