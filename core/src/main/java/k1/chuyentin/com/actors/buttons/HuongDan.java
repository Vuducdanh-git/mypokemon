package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import k1.chuyentin.com.actors.MyActor;

public class HuongDan extends MyActor {
    public HuongDan(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("hd.png"));
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-80);
    }
}
