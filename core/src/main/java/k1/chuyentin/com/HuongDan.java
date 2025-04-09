package k1.chuyentin.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import k1.chuyentin.com.bao.MyActor;

public class HuongDan extends MyActor {
    HuongDan(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("shop.png"));
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));
    }
}
