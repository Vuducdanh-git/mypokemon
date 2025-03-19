package k1.chuyentin.com.bao;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Pet extends MyActor{
    Pet(Texture texture, float x, float y, Stage s) {
        super(x, y, s);
        setSize(32, 32);
        textureRegion = new TextureRegion(texture);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Master.money++;
                Master.solanclick++;

                    Master.money+=Master.plus;

                setSize(getWidth()*1.01f, getHeight()*1.01f);
                new Coin(getX() + getWidth()/2, getY() + getHeight()/2, getStage(), true);
                addAction(Actions.sequence(
                    Actions.color(new Color(MathUtils.random(0f, 1f),MathUtils.random(0f, 1f),MathUtils.random(0f, 1f),MathUtils.random(0f, 1f))),
                    Actions.delay(0.5f),
                    Actions.color(new Color(1,1,1,1))
                ));
                addAction(Actions.sequence(

                ));
            }
        });
    }
}
