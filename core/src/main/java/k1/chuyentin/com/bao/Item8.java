package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item8 extends MyActor{
    int tybe=8;
    boolean isClickShow = false;
    Item8(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("8.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 7500 ){
                    if (!isCLickShow){
                        Master.money-=7500;
                        Master.sound.play();
                        Master.autoplus8=true;
                        if (Master.autoplus8=true){
                            Master.autoplusnumber8+=100;
                        }
                        isClickShow = true;
                        if(Master.click8==null) {
                            Master.click8 = new Item8(0, 200, getStage(),8);

                        }else {
                            getStage().addActor(Master.click8);
                        }
                    }else {
                        Master.click8.remove();
                        isClickShow = false;
                    }

                    ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
                }
            }
        });
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));
    }

}

