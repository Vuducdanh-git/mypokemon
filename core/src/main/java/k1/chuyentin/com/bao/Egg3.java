package k1.chuyentin.com.bao;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Egg3 extends MyActor{
    Egg3(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("egg3.png"));
        setSize(32,32);
        setPosition(100000,10000);
     //   addAction(Actions.moveTo(x, y, 0.5f));


        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= 500000) {
                    Master.money -= 500000;
                    Master.wordSkills.add(Utils6.wordList.random());
                    Master.sound.play();
                    if(Master.solanclick >= 250){
                        Master.eggs(3);
                    }
                } else {
                    Master.egg3.remove();
                }
            }
        });
    }
}
