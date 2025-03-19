package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item10 extends MyActor{
    int tybe=10;
    boolean isClickShow = false;
    Item10(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("10.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 25000 ){
                    if (!isCLickShow){
                        Master.money-=25000;
                        Master.sound.play();
                        Master.autoplus10=true;
                        if (Master.autoplus10=true){
                            Master.autoplusnumber10+=250;
                        }
                        isClickShow = true;
                        if(Master.click10==null) {
                            Master.click10 = new Item10(0, 200, getStage(),10);

                        }else {
                            getStage().addActor(Master.click10);
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

