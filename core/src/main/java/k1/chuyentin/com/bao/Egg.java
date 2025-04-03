package k1.chuyentin.com.bao;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.Skill;

public class Egg extends MyActor{
    Egg(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("more button.png"));
        setSize(250, 250/5);
    }
}
