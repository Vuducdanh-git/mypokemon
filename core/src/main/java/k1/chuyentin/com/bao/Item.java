package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item extends MyActor{
    int tybe=1;
    boolean isClickShow = false;

    static public int giatienclick=100;
    static public int sodiemtangkhiclick=0;
    Item(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("1.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (  Master.money >= giatienclick ){
                if (!isCLickShow){
                    Master.money-= giatienclick;
                    giatienclick*=2;
                    Master.sound.play();
                    sodiemtangkhiclick = giatienclick/100;
                    Master.plus += sodiemtangkhiclick;
                    isClickShow = true;
                    if(Master.click==null) {
                        Master.click = new Item(0, 200, getStage(),1);

                    }else {
                        getStage().addActor(Master.click);
                    }
                }else {
                    Master.click.remove();
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

