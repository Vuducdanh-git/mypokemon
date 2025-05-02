package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import k1.chuyentin.com.Utils;
import k1.chuyentin.com.actors.MyActor;
import k1.chuyentin.com.actors.Pet;
import k1.chuyentin.com.common.GameState;
import k1.chuyentin.com.common.PetforSave;
import k1.chuyentin.com.screens.Master;

public class SaveGame extends MyActor {
    public SaveGame(float x, float y, Stage s) {
        super(x,y,s);
        textureRegion = new TextureRegion(new Texture("savegame.png"));
        setSize(textureRegion.getRegionWidth()/2,textureRegion.getRegionHeight()/2);
        setPosition(x, y);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Array<PetforSave> petforSaves = new Array<>();
                for(Pet p: Utils.pets){
                    petforSaves.add(new PetforSave(p.name, p.solanclick));
                }
                GameState gameState = new GameState(Master.money, petforSaves, Master.plus, Master.wordSkills, Master.wordSkillsVN, Master.giatienautoclick, Master.sodiemtangkhiautoclick);
                gameState.save();
                System.out.println("save success!!");
            }
        });
    }
}
