package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.Skill;

public class Egg1 extends MyActor{
    Egg1(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("egg1.png"));
        setSize(32,32);
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));


        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= 10000) {
                    Master.money -= 10000;
                    Master.wordSkills.add(Utils.wordList.random());
                    Master.sound.play();
                    if(Master.solanclick >= 250){
                        Master.eggs(1);
                    }

                } else {
                    Master.egg1.remove();
                }
            }
        });
    }
}
