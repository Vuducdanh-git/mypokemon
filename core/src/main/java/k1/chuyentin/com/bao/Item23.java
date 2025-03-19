package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item23 extends MyActor{
    int tybe=23;
    boolean isClickShow = false;
    Item23(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("23.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 750000000 ){
                    if (!isCLickShow){
                        Master.money-=750000000;
                        Master.autoplus23=true;
                        Master.sound.play();
                        if (Master.autoplus23=true){
                            Master.autoplusnumber23+=7500000;
                        }
                        isClickShow = true;
                        if(Master.click23==null) {
                            Master.click23 = new Item23(0, 200, getStage(),23);

                        }else {
                            getStage().addActor(Master.click23);
                        }
                    }else {
                        Master.click23.remove();
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

