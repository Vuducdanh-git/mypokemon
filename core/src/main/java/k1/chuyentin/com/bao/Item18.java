package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item18 extends MyActor{
    int tybe=18;
    boolean isClickShow = false;
    Item18(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("18.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 2500000 ){
                    if (!isCLickShow){
                        Master.money-=2500000;
                        Master.sound.play();
                        Master.autoplus18=true;
                        if (Master.autoplus18=true){
                            Master.autoplusnumber18+=2500;
                        }
                        isClickShow = true;
                        if(Master.click18==null) {
                            Master.click18 = new Item18(0, 200, getStage(),18);

                        }else {
                            getStage().addActor(Master.click18);
                        }
                    }else {
                        Master.click18.remove();
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

