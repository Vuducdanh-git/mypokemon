package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.*;

public class Pet extends MyActor{
    float w=getWidth();
    float h=getHeight();
    public int lv = 0;

    Animation<TextureRegion> animation;
    float time;
    public PetStatus status = PetStatus.TRANING;
    PetName name = PetName.VEBACK;

    TextureRegion textureRegionNoAnimation;

    public int solanclick = 240;
    boolean levelUp = false;
    static Music levelUpSound = Gdx.audio.newMusic(Gdx.files.internal("levelup.wav"));

    public StartGame game;

    Pet(Texture texture, float x, float y, Stage s) {
        super(x, y, s);
        setSize(32, 32);
        // Chọn tên ngẫu nhiên từ danh sách 20 tên có săn
        //name = PetName.values()[MathUtils.random(0, PetName.values().length - 1)];
        name = PetName.VEBACK;

        textureRegionNoAnimation = new TextureRegion(texture);
        textureRegion = textureRegionNoAnimation;

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (status.equals(PetStatus.TRANING)) {
                    Master.money++;
                    solanclick++;
                    levelUp = false;

                    Master.money += Master.plus;
                    if (getWidth() < 100) {
                        setSize(getWidth() * 1.01f, getHeight() * 1.01f);
                        w = w * 1.01f;
                        h = h * 1.01f;
                    }
                    new Coin(getX() + getWidth() / 2, getY() + getHeight() / 2, getStage(), true);

                    if (!Master.wordSkills.isEmpty()) {
                        int ngaunhien = MathUtils.random(0, Master.wordSkills.size - 1);
                        String words = Master.wordSkills.get(ngaunhien);
                        new FloatingWords(0, 0, getStage(), words);

                        String wordsVN = Master.wordSkillsVN.get(ngaunhien);
                        new FloatingWords(0, 0, getStage(), wordsVN);
                    }

                    addAction(Actions.sequence(
                        Actions.color(new Color(MathUtils.random(0f, 1f), MathUtils.random(0f, 1f), MathUtils.random(0f, 1f), MathUtils.random(0f, 1f))),
                        Actions.delay(0.5f),
                        Actions.color(new Color(1, 1, 1, 1))
                    ));
                } else if (status.equals(PetStatus.CHARGE)) {
                    int i = Utils6.pets.indexOf(Pet.this, true);
                    Utils6.pets.swap(i, 0);
                    if(game != null){
                        game.setScreen(new BattleScreen(game));
                    }
                }
            }
        });
    }

    public void click(){
        solanclick++;
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

    @Override
    public void act(float delta) {
        super.act(delta);

        if (solanclick >= 50 && lv == 0 && !levelUp) {
            lv = 1;
            levelUpSound.play();
            levelUp = true;
            textureRegion = new TextureRegion(new Texture("rong.png"));
            switch (name){
                case VEBACK -> {
                    textureRegion = new TextureRegion(new Texture("fushigidane.png"));
                }
                case SCEPBACK -> {
                    textureRegion = new TextureRegion(new Texture("rua.png"));
                }
                case MBACK -> {
                    textureRegion = new TextureRegion(new Texture("rong.png"));
                }
            }
            textureRegionNoAnimation = textureRegion;
            setPosition(Gdx.graphics.getWidth() / 2 - getWidth() / 2, Gdx.graphics.getHeight() / 2 - getHeight() / 2);
            //    new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());
        }

        if (solanclick >= 100 && lv == 1 && !levelUp) {
            levelUpSound.play();
            levelUp = true;
            lv = 2;

            textureRegion = new TextureRegion(new Texture("rongcon.png"));
            switch (name) {
                case VEBACK -> {
                    textureRegion = new TextureRegion(new Texture("fushigisou.png"));
                }
                case SCEPBACK -> {
                    textureRegion = new TextureRegion(new Texture("ruacon.png"));
                }
                case MBACK -> {
                    textureRegion = new TextureRegion(new Texture("rongcon.png"));
                }
            }
            textureRegionNoAnimation = textureRegion;
            setPosition(Gdx.graphics.getWidth() / 2 - getWidth() / 2, Gdx.graphics.getHeight() / 2 - getHeight() / 2);
            // new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

        }

        if (solanclick >= 250 && lv == 2 && !levelUp) {
            levelUpSound.play();
            levelUp = true;
            lv = 3;

            textureRegion = new TextureRegion(new Texture("ronglon.png"));
            switch (name) {
                case VEBACK -> {
                    textureRegion = new TextureRegion(new Texture("fushigibana.png"));
                }
                case SCEPBACK -> {
                    textureRegion = new TextureRegion(new Texture("rualon.png"));
                }
                case MBACK -> {
                    textureRegion = new TextureRegion(new Texture("ronglon.png"));
                }
            }
            textureRegionNoAnimation = textureRegion;
            setPosition(Gdx.graphics.getWidth() / 2 - getWidth() / 2, Gdx.graphics.getHeight() / 2 - getHeight() / 2);
            // new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if(status.equals(PetStatus.ATTACT)){
            time += parentAlpha;
            textureRegion = animation.getKeyFrame(time);
        } else if (status.equals(PetStatus.TRANING)) {
            textureRegion = textureRegionNoAnimation;
        }
    }

    public void setAnimation(){
        setPosition(-7, -4);
        status = PetStatus.ATTACT;
        Texture texture = new Texture("veback.png");
        int cot = 5;
        int hang = 34;

        switch (name){
            case VEBACK -> {
                texture = new Texture("veback.png");
                    cot = 5;
                    hang = 34;
            }
            case DIBACK -> {
                texture =  new Texture("diback.png");
                cot = 5;
                hang = 28;
            }
            case GENBACK -> {
                texture =  new Texture("genback.png");
                cot = 5;
                hang = 36;
            }
            case JIBACK -> {
                texture =  new Texture("jiback.png");
                cot = 5;
                hang = 29;
            }
        }

        setSize(texture.getWidth()/cot*3, texture.getHeight()/(hang-1)*3);
        float speed = 5;
        TextureRegion[][] tam = TextureRegion.split(texture, texture.getWidth()/cot, texture.getHeight()/hang);// đưa tất cả vào danh một danh sách ảnh, vì 6 cột 1 hàng nên sẽ có 6 phần tử: 6 x 1
        TextureRegion[] frames = new TextureRegion[cot*hang-cot];
        int index = 0;
        for (int i = 0; i < hang-1; i++) {
            for (int j = 0; j < cot; j++) {
                frames[index++] = tam[i][j];
            }
        }
        animation = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(speed, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        time = 0;
    }
}
