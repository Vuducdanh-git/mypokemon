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
    public ButtonClass(float x, float y, Stage s,int tybe) {
        super(x, y, s);
        if (tybe==6) {
            textureRegion = new TextureRegion(new Texture("l6.png"));
        }else if (tybe==7){
            textureRegion = new TextureRegion(new Texture("l7.png"));
        }
        setSize(64, 64);

    }
}
