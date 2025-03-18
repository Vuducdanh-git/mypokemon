package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item4 extends MyActor{
    int tybe=4;
    boolean isClickShow = false;
    Item4(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("4.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 1000 ){
                    if (!isCLickShow){
                        Master.money-=1000;
                        Master.autoplus4=true;
                        if (Master.autoplus4=true){
                            Master.autoplusnumber4+=10;
                        }
                        isClickShow = true;
                        if(Master.click4==null) {
                            Master.click4 = new Item4(0, 200, getStage(),4);

                        }else {
                            getStage().addActor(Master.click4);
                        }
                    }else {
                        Master.click4.remove();
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

