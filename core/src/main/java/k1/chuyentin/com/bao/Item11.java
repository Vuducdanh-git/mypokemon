package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item11 extends MyActor{
    int tybe=11;
    boolean isClickShow = false;
    Item11(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("11.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 50000 ){
                    if (!isCLickShow){
                        Master.money-=50000;
                        Master.sound.play();
                        Master.autoplus11=true;
                        if (Master.autoplus11=true){
                            Master.autoplusnumber11+=500;
                        }
                        isClickShow = true;
                        if(Master.click11==null) {
                            Master.click11 = new Item11(0, 200, getStage(),10);

                        }else {
                            getStage().addActor(Master.click11);
                        }
                    }else {
                        Master.click10.remove();
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

