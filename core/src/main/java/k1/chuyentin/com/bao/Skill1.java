package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Skill1 extends MyActor{
    Skill1(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("skill1.png"));
        setSize(32,32);
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));
        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean isCLickShow = false;
                if (Master.money >= 1) {
                    if (!isCLickShow) {
                        Master.money -= 1;
                        Master.wordSkills.add("hello");
                    } else {
                        getStage().addActor(Master.skill1);
                    }
                } else {
                    Master.skill1.remove();
                }

                ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
            }

    });
    }
}
