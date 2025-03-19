package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item22 extends MyActor{
    int tybe=22;
    boolean isClickShow = false;
    Item22(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("22.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 100000000 ){
                    if (!isCLickShow){
                        Master.money-=100000000;
                        Master.autoplus22=true;
                        Master.sound.play();
                        if (Master.autoplus22=true){
                            Master.autoplusnumber22+=1000000;
                        }
                        isClickShow = true;
                        if(Master.click22==null) {
                            Master.click22 = new Item22(0, 200, getStage(),22);

                        }else {
                            getStage().addActor(Master.click22);
                        }
                    }else {
                        Master.click22.remove();
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

