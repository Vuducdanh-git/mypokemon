package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import k1.chuyentin.com.actors.MyActor;

public class HuongDan extends Actor {
    TextureRegion textureRegion;
    public HuongDan(float x, float y, Stage s,int loai) {
        if(loai ==1){
            textureRegion = new TextureRegion(new Texture("hd.png"));
        }
        if(loai ==2){
            textureRegion = new TextureRegion(new Texture("summary.png"));
        }
        setPosition(x, y);
    }
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(1, 1, 1, 1); // Reset lại màu batch để tránh ảnh hưởng đến các Actor khác}
    }
}
