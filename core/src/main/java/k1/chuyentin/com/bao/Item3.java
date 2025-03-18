package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item3 extends MyActor{
    int tybe=3;
    boolean isClickShow = false;
    Item3(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("3.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 500 ){
                    if (!isCLickShow){
                        Master.money-=500;
                        Master.autoplus3=true;
                        if (Master.autoplus3=true){
                            Master.autoplusnumber3+=5;
                        }
                        isClickShow = true;
                        if(Master.click3==null) {
                            Master.click3 = new Item3(0, 200, getStage(),3);

                        }else {
                            getStage().addActor(Master.click3);
                        }
                    }else {
                        Master.click3.remove();
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

