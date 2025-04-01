package k1.chuyentin.com.bao;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.FloatingWords;

public class Pet extends MyActor{
    float w=getWidth();
    float h=getHeight();
    public static int lv=0;
    Pet(Texture texture, float x, float y, Stage s) {
        super(x, y, s);
        setSize(32, 32);

        textureRegion = new TextureRegion(texture);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Master.money++;
                Master.solanclick++;
                Master.levelUp = false;

                Master.money+=Master.plus;
                if (getWidth() < 100){
                    setSize(getWidth()*1.01f, getHeight()*1.01f);
                    w = w*1.01f;
                    h = h*1.01f;
                }
                new Coin(getX() + getWidth()/2, getY() + getHeight()/2, getStage(), true);

                if (!Master.wordSkills.isEmpty()){
                    int ngaunhien = MathUtils.random(0, Master.wordSkills.size-1);
                    String words = Master.wordSkills.get(ngaunhien);
                    new FloatingWords(0,0, getStage(), words);

                    String wordsVN = Master.wordSkillsVN.get(ngaunhien);
                    new FloatingWords(0,0, getStage(), wordsVN);
                }

                addAction(Actions.sequence(
                    Actions.color(new Color(MathUtils.random(0f, 1f),MathUtils.random(0f, 1f),MathUtils.random(0f, 1f),MathUtils.random(0f, 1f))),
                    Actions.delay(0.5f),
                    Actions.color(new Color(1,1,1,1))
                ));
            }
        });
    }

    public void click(){
        Master.solanclick++;
        new Coin(getX() + getWidth()/2, getY() + getHeight()/2, getStage(), true);
        if (!Master.wordSkills.isEmpty()){
            int ngaunhien = MathUtils.random(0, Master.wordSkills.size-1);
            String words = Master.wordSkills.get(ngaunhien);
            new FloatingWords(0,0, getStage(), words);

            String wordsVN = Master.wordSkillsVN.get(ngaunhien);
            new FloatingWords(0,0, getStage(), wordsVN);
        }
        addAction(Actions.sequence(
            Actions.color(new Color(MathUtils.random(0f, 1f),MathUtils.random(0f, 1f),MathUtils.random(0f, 1f),MathUtils.random(0f, 1f))),
            Actions.delay(0.5f),
            Actions.color(new Color(1,1,1,1))
        ));
    }
}
