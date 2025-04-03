package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.Skill;

public class ChuaDuDieuKien extends MyActor{
    ChuaDuDieuKien(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("rayboard.png"));
        setSize(100, 50);
        setPosition(Gdx.graphics.getWidth()/2 - getWidth()/2, Gdx.graphics.getHeight()/2);
        addAction(Actions.sequence(
            Actions.fadeOut(2),
            Actions.removeActor()
        ));
    }
}
