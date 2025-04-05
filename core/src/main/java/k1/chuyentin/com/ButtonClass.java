package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.bao.MyActor;
import k1.chuyentin.com.bao.Utils6;

public class ButtonClass extends MyActor {
    public ButtonClass(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("19.png"));
        setSize(64, 64);

    }
}
