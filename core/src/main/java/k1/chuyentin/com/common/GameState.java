package k1.chuyentin.com.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import k1.chuyentin.com.Utils;
import k1.chuyentin.com.actors.Pet;
import k1.chuyentin.com.screens.Master;

public class GameState {
    public float money = 0;
    public Array<PetforSave> petforSaves = new Array<>();
    public int plus = 0;
    public Array<String> wordSkills = new Array<>();
    public Array<String> wordSkillsVN = new Array<>();
    public int giatienautoclick = 0;
    public int sodiemtangkhiautoclick = 0;
    public GameState(){}

    public GameState(float money, Array<PetforSave> petforSaves, int plus, Array<String> wordSkills, Array<String> wordSkillsVN, int giatienautoclick, int sodiemautoclick) {
        this.money = money;
        this.petforSaves = petforSaves;
        this.plus = plus;
        this.wordSkills = wordSkills;
        this.wordSkillsVN = wordSkillsVN;
        this.giatienautoclick = giatienautoclick;
        this.sodiemtangkhiautoclick = sodiemautoclick;
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
        for (PetforSave p: gameState.petforSaves) {
            Pet pet = new Pet(new Texture("egg.png"), 0, 0, null, p.name);
            pet.solanclick = p.solanclick;
            Utils.pets.add(pet);
        }
    }

}
