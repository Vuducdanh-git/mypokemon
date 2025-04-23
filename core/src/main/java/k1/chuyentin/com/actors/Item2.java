package k1.chuyentin.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.screens.Master;

import static k1.chuyentin.com.screens.Master.giatienautoclick;

public class Item2 extends MyActor{
    int tybe=2;
    public int solannangcapautoclick=0;
    public Item2(float x, float y, Stage  s,int tybe) {
        super(x, y, s);
        this.tybe=tybe;
        textureRegion = new TextureRegion(new Texture("v3.png"));
        setPosition(Gdx.graphics.getWidth(), y);
        setSize(64, 64);
        addAction(Actions.moveTo(x, y, 0.5f));
        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= giatienautoclick ){

                    if (solannangcapautoclick < 5){
                        solannangcapautoclick++;
                        if (Master.money >= giatienautoclick) {

                            if (solannangcapautoclick==1){
                                textureRegion = new TextureRegion(new Texture("v3.png"));
                            }
                            if (solannangcapautoclick==2){
                                textureRegion = new TextureRegion(new Texture("v7.png"));
                            }
                            if (solannangcapautoclick==3){
                                textureRegion = new TextureRegion(new Texture("v8.png"));
                            }
                            if (solannangcapautoclick==4){
                                textureRegion = new TextureRegion(new Texture("v12.png"));
                            }
//                            if (solannangcapautoclick==5){
//                                textureRegion = new TextureRegion(new Texture("v5.png"));
//                            }
//                            if (solannangcapautoclick==7){
//                                textureRegion = new TextureRegion(new Texture("v7.png"));
//                            }
//                            if (solannangcapautoclick==8){
//                                textureRegion = new TextureRegion(new Texture("v8.png"));
//                            }
//                            if (solannangcapautoclick==9){
//                                textureRegion = new TextureRegion(new Texture("v9.png"));
//                            }
//                            if (solannangcapautoclick==10){
//                                textureRegion = new TextureRegion(new Texture("v10.png"));
//                            }
//                            if (solannangcapautoclick==11){
//                                textureRegion = new TextureRegion(new Texture("v11.png"));
//                            }
//                            if (solannangcapautoclick==12){
//                                textureRegion = new TextureRegion(new Texture("v12.png"));
//                            }
//                            if (solannangcapautoclick==13){
//                                textureRegion = new TextureRegion(new Texture("v13.png"));
//                            }
//                            if (solannangcapautoclick==14){
//                                textureRegion = new TextureRegion(new Texture("v14.png"));
//                            }
//                            if (solannangcapautoclick==15){
//                                textureRegion = new TextureRegion(new Texture("v15.png"));
//                            }
//                            if (solannangcapautoclick==16){
//                                textureRegion = new TextureRegion(new Texture("v16.png"));
//                            }


                        Master.money-= giatienautoclick;
                        Master.autoclick=true;
                        if (Master.autoclick==true) {
                            giatienautoclick *= 100;
                            Master.sound.play();
                            Master.sodiemtangkhiautoclick += giatienautoclick / 1000;
                        }
                }
            }}}
        });
        setPosition(Gdx.graphics.getWidth(), y);
//        addAction(Actions.moveTo(x, y, 0.5f));
    }

}

