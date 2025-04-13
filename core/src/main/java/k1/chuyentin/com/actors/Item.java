package k1.chuyentin.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.screens.Master;

public class Item extends MyActor {

    int giatienclick = 100;
    int sodiemtangkhiclick = 1;
    public Item(float x, float y, Stage s, int type) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("itemPlus1.png"));

        switch (type){
            case 1 -> textureRegion = new TextureRegion(new Texture("itemPlus1.png"));
            case 2 -> textureRegion = new TextureRegion(new Texture("ball.png"));
        }

        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());

        giatienclick = (int) (100* (Math.pow(type, type)));

        addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= giatienclick){
                    sodiemtangkhiclick = giatienclick/50;
                    Master.plus += sodiemtangkhiclick;
                }
            }
        });
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.8f));
    }

}

