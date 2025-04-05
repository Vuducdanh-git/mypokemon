package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

import static k1.chuyentin.com.bao.Item.solannangcap;
import static k1.chuyentin.com.bao.Master.giatienautoclick;

public class Item2 extends MyActor{
    int tybe=2;
    static public int solannangcapautoclick=0;
    Item2(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("2.png"));
        setSize(32, 32);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= giatienautoclick ){
                    solannangcapautoclick+=1;
                    if (solannangcapautoclick<11){
                        if (Master.money >= giatienautoclick) {

                            if (solannangcapautoclick==1){
                                textureRegion = new TextureRegion(new Texture("vatpham11.png"));
                            }
                            if (solannangcapautoclick==2){
                                textureRegion = new TextureRegion(new Texture("vatpham12.png"));
                            }
                            if (solannangcapautoclick==3){
                                textureRegion = new TextureRegion(new Texture("vatpham13.png"));
                            }
                            if (solannangcapautoclick==4){
                                textureRegion = new TextureRegion(new Texture("vatpham14.png"));
                            }
                            if (solannangcapautoclick==5){
                                textureRegion = new TextureRegion(new Texture("vatpham15.png"));
                            }
                            if (solannangcapautoclick==6){
                                textureRegion = new TextureRegion(new Texture("vatpham16.png"));
                            }
                            if (solannangcapautoclick==7){
                                textureRegion = new TextureRegion(new Texture("vatpham17.png"));
                            }
                            if (solannangcapautoclick==8){
                                textureRegion = new TextureRegion(new Texture("vatpham18.png"));
                            }
                            if (solannangcapautoclick==9){
                                textureRegion = new TextureRegion(new Texture("vatpham19.png"));
                            }
                            if (solannangcapautoclick==10){
                                textureRegion = new TextureRegion(new Texture("vatpham20.png"));
                            }


                        Master.money-= giatienautoclick;
                        Master.autoclick=true;
                        if (Master.autoclick==true) {
                            giatienautoclick *= 1.5f;
                            Master.sound.play();
                            Master.sodiemtangkhiautoclick += giatienautoclick / 100;
                        }
                }
            }}}
        });
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));
    }

}

