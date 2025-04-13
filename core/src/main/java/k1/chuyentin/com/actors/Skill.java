package k1.chuyentin.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.Utils;
import k1.chuyentin.com.screens.Master;
import k1.chuyentin.com.screens.BattleScreen;

public class Skill extends Actor {
    Texture texture;
    public int click =0;
    public int iclick =0;
    public static int r = MathUtils.random(1,10);
    public Skill(Stage stage , float x, float y,float width) {
        texture = new Texture("cf.png");
        setPosition(x, y);
        setSize(width, 30);
        stage.addActor(this);
        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                if (!Master.wordSkills.isEmpty()) {
                    click =1;
                    BattleScreen.quest = MathUtils.random(1,2);
                    if (BattleScreen.quest ==1){
                        r = MathUtils.random(1,10);
                        if (r==1){Utils.specialq.add("special");}
                        if (r==2){Utils.specialq.add("ultimate");}
                        if (r==3){Utils.specialq.add("you");}
                        if (r==4){Utils.specialq.add("tube");}
                        if (r ==5){Utils.specialq.add("connect");}
                        if (r ==6){Utils.specialq.add("reconnect");}
                        if (r==7){Utils.specialq.add("dragon");}
                        if (r==8){Utils.specialq.add("phoneix");}
                        if (r==9){Utils.specialq.add("lion");}
                        if (r==10){Utils.specialq.add("king");}
                    }



                }else {
                    System.out.println("u don't have this skill ");
                }

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
