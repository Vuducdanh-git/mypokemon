package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item2 extends MyActor{
    int tybe=2;
    boolean isClickShow = false;
    Item2(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("2.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 100 ){
                    if (!isCLickShow){
                        Master.money-=100;
                        Master.autoplus2=true;
                        if (Master.autoplus2=true){
                            Master.autoplusnumber2+=1;
                        }
                        isClickShow = true;
                        if(Master.click2==null) {
                            Master.click2 = new Item2(0, 200, getStage(),2);

                        }else {
                            getStage().addActor(Master.click2);
                        }
                    }else {
                        Master.click2.remove();
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

