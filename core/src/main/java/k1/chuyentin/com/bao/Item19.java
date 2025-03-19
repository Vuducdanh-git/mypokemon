package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item19 extends MyActor{
    int tybe=19;
    boolean isClickShow = false;
    Item19(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("19.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 5000000 ){
                    if (!isCLickShow){
                        Master.money-=5000000;
                        Master.sound.play();
                        Master.autoplus19=true;
                        if (Master.autoplus19=true){
                            Master.autoplusnumber19+=750;
                        }
                        isClickShow = true;
                        if(Master.click19==null) {
                            Master.click19 = new Item19(0, 200, getStage(),19);

                        }else {
                            getStage().addActor(Master.click19);
                        }
                    }else {
                        Master.click19.remove();
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

