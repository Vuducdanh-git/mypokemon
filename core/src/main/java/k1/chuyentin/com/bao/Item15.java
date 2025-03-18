package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item15 extends MyActor{
    int tybe=15;
    boolean isClickShow = false;
    Item15(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("15.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 250000 ){
                    if (!isCLickShow){
                        Master.money-=250000;
                        Master.autoplus15=true;
                        if (Master.autoplus15=true){
                            Master.autoplusnumber15+=2500;
                        }
                        isClickShow = true;
                        if(Master.click15==null) {
                            Master.click15 = new Item15(0, 200, getStage(),15);

                        }else {
                            getStage().addActor(Master.click15);
                        }
                    }else {
                        Master.click15.remove();
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

