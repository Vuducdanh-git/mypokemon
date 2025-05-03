package k1.chuyentin.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Background extends Actor {
    public TextureRegion textureRegion;
    public Background(float x, float y, Stage stage,int biome) {

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
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1); // Reset lại màu batch để tránh ảnh hưởng đến các Actor khác}
    }
}
