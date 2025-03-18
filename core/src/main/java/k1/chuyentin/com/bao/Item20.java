package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item20 extends MyActor{
    int tybe=20;
    boolean isClickShow = false;
    Item20(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("20.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 10000000 ){
                    if (!isCLickShow){
                        Master.money-=10000000;
                        Master.autoplus20=true;
                        if (Master.autoplus20=true){
                            Master.autoplusnumber20+=1000;
                        }
                        isClickShow = true;
                        if(Master.click20==null) {
                            Master.click20 = new Item20(0, 200, getStage(),20);

                        }else {
                            getStage().addActor(Master.click20);
                        }
                    }else {
                        Master.click20.remove();
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

