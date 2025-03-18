package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item6 extends MyActor{
    int tybe=6;
    boolean isClickShow = false;
    Item6(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("6.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 2500 ){
                    if (!isCLickShow){
                        Master.money-=2500;
                        Master.autoplus6=true;
                        if (Master.autoplus6=true){
                            Master.autoplusnumber6+=25;
                        }
                        isClickShow = true;
                        if(Master.click6==null) {
                            Master.click6 = new Item6(0, 200, getStage(),6);

                        }else {
                            getStage().addActor(Master.click6);
                        }
                    }else {
                        Master.click6.remove();
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

