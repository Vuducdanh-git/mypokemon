package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.bao.MyActor;
import k1.chuyentin.com.bao.Utils6;

public class NutMenu extends MyActor {
    public NutMenu(float x, float y, Stage s,int tybe) {
        super(x, y, s);
        if (tybe==1) {
            textureRegion = new TextureRegion(new Texture("1.png"));
        }else if (tybe==7){
            textureRegion = new TextureRegion(new Texture("2.png"));
        }else if (tybe==8){
            textureRegion = new TextureRegion(new Texture("3.png"));
        }
        setSize(64, 64);
        addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
            if (tybe==1){
            }

            }
            });


    }
}
