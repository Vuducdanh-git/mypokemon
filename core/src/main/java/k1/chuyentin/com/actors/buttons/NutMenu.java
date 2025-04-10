package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.actors.MyActor;
import k1.chuyentin.com.enums.ButtonType;

public class NutMenu extends MyActor {
    public NutMenu(float x, float y, Stage s, ButtonType type) {
        super(x, y, s);

        switch (type){
            case PLAY -> textureRegion = new TextureRegion(new Texture("1.png"));
            case CONTINUE -> textureRegion = new TextureRegion(new Texture("2.png"));
            case GUIDE -> textureRegion = new TextureRegion(new Texture("3.png"));
        }
        setSize(64, 64);
    }
}
