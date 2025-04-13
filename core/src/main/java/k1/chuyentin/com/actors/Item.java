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
        textureRegion = new TextureRegion(new Texture("itemplus2.png"));


        switch (type){
            case 1 -> textureRegion = new TextureRegion(new Texture("itemplus.png"));
            case 2 -> textureRegion = new TextureRegion(new Texture("itemplus2.png"));
            case 3 -> textureRegion = new TextureRegion(new Texture("itemplus3.png"));
            case 4 -> textureRegion = new TextureRegion(new Texture("itemplus4.png"));
            case 5 -> textureRegion = new TextureRegion(new Texture("itemplus5.png"));
            case 6 -> textureRegion = new TextureRegion(new Texture("itemplus6.png"));
            case 7 -> textureRegion = new TextureRegion(new Texture("itemplus7.png"));
            case 8 -> textureRegion = new TextureRegion(new Texture("itemplus8.png"));
            case 9 -> textureRegion = new TextureRegion(new Texture("itemplus9.png"));
            case 10 -> textureRegion = new TextureRegion(new Texture("itemplus10.png"));

        }

        setSize(64, 64);

        giatienclick = (int) (100* (Math.pow(type, type))/type/type/type);

        addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= giatienclick){
                    Master.money -= giatienclick;
                    sodiemtangkhiclick = giatienclick/50;
                    Master.plus += sodiemtangkhiclick;
                }
            }
        });
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));
    }

}

