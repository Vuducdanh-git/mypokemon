package k1.chuyentin.com.bao;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Egg2 extends MyActor{
    Egg2(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("egg2.png"));
        setSize(32,32);
        setPosition(10000000, 10000000);
        //Gdx.graphics.getWidth() ở trên
      //  addAction(Actions.moveTo(x, y, 0.5f));


        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= 100000) {
                    Master.money -= 100000;
                    Master.wordSkills.add(Utils6.wordList.random());
                    Master.sound.play();
                    if(Master.solanclick >= 250){
                        Master.eggs(2);
                    }

                } else {
                    Master.egg2.remove();
                }
            }
        });
    }
}
