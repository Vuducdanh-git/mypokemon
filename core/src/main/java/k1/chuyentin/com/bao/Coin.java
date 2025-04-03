package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Coin extends MyActor{
    float gravity = 0.5f;
    float dx = 0;
    float dy = 0;
    Sound tap;
    boolean isClicked;
    public Coin(float x, float y, Stage s, boolean isClicked) {
        super(x, y, s);
        this.isClicked = isClicked;
        textureRegion = new TextureRegion(new Texture("coin.png"));
        textureRegion.setRegion(MathUtils.random(0, 5)*32, 0, 32,32);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        if(isClicked) {
            dx = MathUtils.random(-10, 10);
            dy = MathUtils.random(5, 10);
            tap = Gdx.audio.newSound(Gdx.files.internal("tap.wav"));
            tap.play();
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isClicked) {
            dy -= gravity;
            dx *= 0.9;
            moveBy(dx, dy);
        }
        setColor(1,1,1, getColor().a - 0.01f);
        if(getColor().a < 0.01){
            remove();
        }
    }
    @Override
    public boolean remove() {
        if (textureRegion.getTexture() != null) {
            textureRegion.getTexture().dispose(); // Giải phóng texture
        }
        if (tap != null) {
            tap.dispose(); // Giải phóng âm thanh
        }
        return super.remove();
    }

}
