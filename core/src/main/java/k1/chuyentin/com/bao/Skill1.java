package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.Skill;

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
                if (Master.money >= 1000) {

                        Master.money -= 1000;
                        int ngaunhien = MathUtils.random(0,Utils6.wordList.size-1);
                        Master.wordSkills.add(Utils6.wordList.get(ngaunhien));
                        Master.wordSkillsVN.add(Utils6.wordListVN.get(ngaunhien));

                        Master.sound.play();
                     //   Skill.iclick = 1;

                } else {
                    Master.skill1.remove();
                }
            }
    });
    }
}
