package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BackGround extends MyActor{

    public BackGround(float x, float y , Stage s) {
        super(x, y, s);
        TextureRegion tRegion = new TextureRegion(new Texture("bg1.png"));
        textureRegion = tRegion;
        setSize(480, 480);
        setPosition(Gdx.graphics.getWidth()/2 - getWidth()/2, Gdx.graphics.getHeight()/2 - getHeight()/2);
        setOrigin(getWidth()/2, getHeight()/2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        rotateBy(-0.4f);
    }
}
