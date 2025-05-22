package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import k1.chuyentin.com.actors.MyActor;

public class ButtonClass extends MyActor {
    public ButtonClass(float x, float y, Stage s,int tybe) {
        super(x, y, s);
        if (tybe==6) {
            textureRegion = new TextureRegion(new Texture("l6.png"));
        }else if (tybe==7){
            textureRegion = new TextureRegion(new Texture("l7.png"));
        }else if (tybe==8){
            textureRegion = new TextureRegion(new Texture("yes.png"));
        }
        setSize(64, 64);

    }
}
