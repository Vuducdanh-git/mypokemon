package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item12 extends MyActor{
    int tybe=12;
    boolean isClickShow = false;
    Item12(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("12.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 75000 ){
                    if (!isCLickShow){
                        Master.money-=75000;
                        Master.autoplus12=true;
                        if (Master.autoplus12=true){
                            Master.autoplusnumber12+=750;
                        }
                        isClickShow = true;
                        if(Master.click12==null) {
                            Master.click12 = new Item12(0, 200, getStage(),12);

                        }else {
                            getStage().addActor(Master.click12);
                        }
                    }else {
                        Master.click12.remove();
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

