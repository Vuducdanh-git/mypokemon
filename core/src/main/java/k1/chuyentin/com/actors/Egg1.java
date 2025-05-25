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

public class Egg1 extends MyActor{
    public static int mone =1;
    public Egg1(float x, float y, Stage s, Master master) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("egg2.png"));
        setSize(64,64);
        setPosition(Gdx.graphics.getWidth(), y);
        addAction(Actions.moveTo(x, y, 0.5f));


        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.money >= 25000 && mone == 1) {
                    Master.money -= 25000;
                    mone = 0;
//
//                    int ngaunhien = MathUtils.random(0, Utils.wordList.size-1);
//                    Master.wordSkills.add(Utils.wordList.get(ngaunhien));
//                    Master.wordSkillsVN.add(Utils.wordListVN.get(ngaunhien));


                    master.pet.remove();// xoa con hien tai khoi san khau
                    // Mua 1 qua trung, cho vao dau danh sach
                    Pet pet = new Pet(new Texture("egg2.png"), 0, 0, getStage(), null);
                    Utils.pets.insert(0, pet);
                    master.pet = pet;

                    Master.sound.play();
                    master.pet.solanclick =0;
                    Pet.levelUp = false;
                    Pet.lv =0;
                    master.pet.avoid = 10;
                    master.pet.acc = 50;

                } else {
                    remove();
                }
            }
        });
    }
}
