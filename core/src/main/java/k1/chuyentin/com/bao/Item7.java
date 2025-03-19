package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item7 extends MyActor{
    int tybe=7;
    boolean isClickShow = false;
    Item7(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("7.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= 5000 ){
                    if (!isCLickShow){
                        Master.money-=5000;
                        Master.autoplus7=true;
                        Master.sound.play();
                        if (Master.autoplus7=true){
                            Master.autoplusnumber7+=50;
                        }
                        isClickShow = true;
                        if(Master.click7==null) {
                            Master.click7 = new Item7(0, 200, getStage(),7);

                        }else {
                            getStage().addActor(Master.click7);
                        }
                    }else {
                        Master.click7.remove();
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

