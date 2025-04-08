package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Item extends MyActor {
    int tybe = 1;

    static public int giatienclick = 100;
    static public int sodiemtangkhiclick = 0;
    static public int solannangcap = 0;
    int e =0;
    Item(float x, float y, Stage s, int tybe) {
        super(x, y, s);
        this.tybe = tybe;
        textureRegion = new TextureRegion(new Texture("m.png"));
        setSize(200, 22);

        addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= giatienclick){
                    solannangcap += 1;
                    e =1;
                }

                if (solannangcap<=11){

                if (e ==1) {

//                    if (solannangcap==1){
//                        textureRegion = new TextureRegion(new Texture("vatpham.png"));
//                    }
                    if (solannangcap==1){
                        textureRegion = new TextureRegion(new Texture("m1.png"));

                    }
                    if (solannangcap==2){
                        textureRegion = new TextureRegion(new Texture("m2.png"));
                    }
                    if (solannangcap==3){
                        textureRegion = new TextureRegion(new Texture("m3.png"));
                    }
                    if (solannangcap==4){
                        textureRegion = new TextureRegion(new Texture("m4.png"));
                    }
                    if (solannangcap==5){
                        textureRegion = new TextureRegion(new Texture("m5.png"));
                    }
                    if (solannangcap==6){
                        textureRegion = new TextureRegion(new Texture("m6.png"));
                    }
                    if (solannangcap==7){
                        textureRegion = new TextureRegion(new Texture("m7.png"));
                    }
                    if (solannangcap==8){
                        textureRegion = new TextureRegion(new Texture("m8.png"));
                    }
                    if (solannangcap==9){
                        textureRegion = new TextureRegion(new Texture("m9.png"));
                    }
                    if (solannangcap==10){
                        textureRegion = new TextureRegion(new Texture("m10.png"));
                    }

                    Master.money -= giatienclick;
                    giatienclick *= 2;
                    Master.sound.play();
                    sodiemtangkhiclick = giatienclick / 25;
                    Master.plus += sodiemtangkhiclick;
                    e =9;
                }
            }}
        });
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.8f));
    }

}

