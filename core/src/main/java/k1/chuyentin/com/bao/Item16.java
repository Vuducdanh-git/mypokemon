package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item16 extends MyActor{
    int tybe=16;
    boolean isClickShow = false;
    Item16(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("16.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 500000 ){
                    if (!isCLickShow){
                        Master.money-=500000;
                        Master.autoplus16=true;
                        if (Master.autoplus16=true){
                            Master.autoplusnumber16+=750;
                        }
                        isClickShow = true;
                        if(Master.click16==null) {
                            Master.click16 = new Item16(0, 200, getStage(),16);

                        }else {
                            getStage().addActor(Master.click16);
                        }
                    }else {
                        Master.click16.remove();
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

