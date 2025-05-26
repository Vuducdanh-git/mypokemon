package k1.chuyentin.com.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.Utils;
import k1.chuyentin.com.actors.*;
import k1.chuyentin.com.screens.BattleScreen;
import k1.chuyentin.com.screens.Master;
import k1.chuyentin.com.screens.NameScreen;

public class GameState {
    public float money = 0;
    public Array<PetforSave> petforSaves = new Array<>();
    public int plus = 0;
    public Array<String> wordSkills = new Array<>();
    public Array<String> wordSkillsVN = new Array<>();
    public int giatienautoclick = 0;
    public int sodiemtangkhiautoclick = 0;
    public boolean autoclick = false;
    public float time =0;
    public int sp =0;
    public int diamond;
    public int sbs;
    public int ender;
    public String ten = "";
    public GameState(){}

    public GameState(float money, Array<PetforSave> petforSaves, int plus, Array<String> wordSkills, Array<String> wordSkillsVN, int giatienautoclick, int sodiemautoclick,float time,String ten,int sp,boolean autoclick,int diamon,int sbs,int ender) {
        this.money = money;
        this.petforSaves = petforSaves;
        this.plus = plus;
        this.wordSkills = wordSkills;
        this.wordSkillsVN = wordSkillsVN;
        this.giatienautoclick = giatienautoclick;
        this.sodiemtangkhiautoclick = sodiemautoclick;
        this.time = time;
        this.ten = ten;
        this.sp = sp;
        this.autoclick = autoclick;
        this.diamond = diamon;
        this.sbs = sbs;
        this.ender = ender;
    }

    public void save() {
        Json json = new Json();
        String jsonString = json.toJson(this);

        FileHandle fileHandle = Gdx.files.local("data.json") ;
        fileHandle.writeString(jsonString,false, "UTF-8");
    }
    public void loadGame() {
        FileHandle file = Gdx.files.local("data.json");
        if (!file.exists()) {
            // do nothing
        } else {
            Json json = new Json();
            GameState saveGame = json.fromJson(GameState.class, file.readString("UTF-8"));
            loadData(saveGame);
        }
    }
    private void loadData(GameState gameState){
        Master.money = gameState.money;
        Master.plus = gameState.plus;
        Master.wordSkills = gameState.wordSkills;
        Master.wordSkillsVN = gameState.wordSkillsVN;
        Master.giatienautoclick = gameState.giatienautoclick;
        Master.sodiemtangkhiautoclick = gameState.sodiemtangkhiautoclick;
        StartGame.mytime = gameState.time;
        NameScreen.inputText = gameState.ten;
        BattleScreen.tpqt = gameState.sp;
        Master.autoclick = gameState.autoclick;
        for (int i = 0; i < gameState.diamond; i++) {
            StartGame.diamonds.add(new Diamond(-100,-100,null,false));
        }
        for (int i = 0; i < gameState.sbs; i++) {
            StartGame.sbs.add(new SB(-100,-100,null,false));
        }
        for (int i = 0; i < gameState.ender; i++) {
            StartGame.enders.add(new Ender(-100,-100,null,false));
        }
        for (PetforSave p: gameState.petforSaves) {
            if(gameState.petforSaves.size >0){
                Pet pet = new Pet(new Texture("egg.png"), 0, 0, null, p.name);
                pet.solanclick = p.solanclick;
                pet.levelUp = false;
                pet.lv = p.lv;
                pet.setTextureRegion(p.lv, p.name);
                Utils.pets.add(pet);
            }

        }
    }

}
