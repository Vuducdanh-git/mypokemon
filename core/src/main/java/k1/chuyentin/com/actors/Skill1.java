package k1.chuyentin.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.screens.Master;
import k1.chuyentin.com.Utils;

public class Skill1 extends MyActor{
    public Skill1(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("buy sk.png"));
        setSize(Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/8);
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));


        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= 5000) {

                        Master.money -= 5000;
                        int ngaunhien = MathUtils.random(0, Utils.wordList.size-1);
                        Master.wordSkills.add(Utils.wordList.get(ngaunhien));
                        Master.wordSkillsVN.add(Utils.wordListVN.get(ngaunhien));

                        Master.sound.play();
                     //   Skill.iclick = 1;

                } else {
                    Master.skill1.remove();
                }
            }
    });
    }
}
