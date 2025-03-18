package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item24 extends MyActor{
    int tybe=24;
    boolean isClickShow = false;
    Item24(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("24.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 1000000000 ){
                    if (!isCLickShow){
                        Master.money-=1000000000;
                        Master.autoplus24=true;
                        if (Master.autoplus24=true){
                            Master.autoplusnumber24+=10000000;
                        }
                        isClickShow = true;
                        if(Master.click24==null) {
                            Master.click24 = new Item24(0, 200, getStage(),24);

                        }else {
                            getStage().addActor(Master.click24);
                        }
                    }else {
                        Master.click24.remove();
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

