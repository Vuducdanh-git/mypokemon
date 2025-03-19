package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Skill extends Actor {
    Texture texture;
    int click =0;
    public Skill(Stage stage , float x, float y,float width) {
        texture = new Texture("cf.png");
        setPosition(x, y);
        setSize(width, 30);
        stage.addActor(this);
        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                click=1;
            }
        });
    }
    public void health(float damage) {
        BattleScreen.yourhp -= damage;
    }
    public void healths(float damage) {BattleScreen.myhp -= damage;}

    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
