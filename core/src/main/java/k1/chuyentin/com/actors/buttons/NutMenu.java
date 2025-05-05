package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.Gdx;
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
            case PLAY -> textureRegion = new TextureRegion(new Texture("start.png"));
            case CONTINUE -> textureRegion = new TextureRegion(new Texture("continue.png"));
            case GUIDE -> textureRegion = new TextureRegion(new Texture("GUIDE.png"));
            case EXIT -> textureRegion = new TextureRegion(new Texture("exit.png"));
        }
        setSize(Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/5);
    }
}
