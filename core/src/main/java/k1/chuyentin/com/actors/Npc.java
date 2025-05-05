package k1.chuyentin.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.screens.BattleScreen;

public class Npc extends MyActor{
    public Npc(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("npc.png"));
        setSize(100, 100);
        s.addActor(this);

    }
}
