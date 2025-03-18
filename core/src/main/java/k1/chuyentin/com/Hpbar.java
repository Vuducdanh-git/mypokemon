package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Hpbar extends Actor {
    TextureRegion texture;
    public Hpbar(float x, float y, Stage stage) {
        texture = new TextureRegion(new Texture("hb.png"));
        setPosition(x, y);
        setSize(270, 25);
        stage.addActor(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(Master.myhp > 50){
            setColor(Color.BLUE);
        }else {
            setColor(Color.RED);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1); // Reset lại màu batch để tránh ảnh hưởng đến các Actor khác}
    }
}
