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

    public int solanclick = 249;
    boolean levelUp = false;
    static Music levelUpSound = Gdx.audio.newMusic(Gdx.files.internal("levelup.wav"));

    public StartGame game;

    Pet(Texture texture, float x, float y, Stage s) {
        super(x, y, s);
        setSize(32, 32);
        setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        // Chọn tên ngẫu nhiên từ danh sách 20 tên có săn
        name = PetName.values()[MathUtils.random(0, PetName.values().length - 1)];
        //name = PetName.SCEPBACK;

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
        levelUp = false;
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
                case LUXBACK -> {
                    textureRegion = new TextureRegion(new Texture("lux1.png"));
                }
                case ZOROBACK -> {
                    textureRegion = new TextureRegion(new Texture("zo1.png"));
                }
                case SCEPBACK -> {
                    textureRegion = new TextureRegion(new Texture("scep1.png"));
                }
                case CHANBACK -> {
                    textureRegion = new TextureRegion(new Texture("chan1.png"));
                }
                case VEBACK -> {
                    textureRegion = new TextureRegion(new Texture("fushigidane.png"));
                }
                case BLASBACK -> {
                    textureRegion = new TextureRegion(new Texture("rua.png"));
                }
                case CHARBACK -> {
                    textureRegion = new TextureRegion(new Texture("rong.png"));
                }
                case GARBACK -> {
                    textureRegion = new TextureRegion(new Texture("gar1.png"));
                }
                case GALLABACK -> {
                    textureRegion = new TextureRegion(new Texture("galla1.png"));
                }
                case DIBACK -> {
                    textureRegion = new TextureRegion(new Texture("dial.png"));
                }
                case MBACK -> {
                    textureRegion = new TextureRegion(new Texture("me.png"));
                }case CEBACK -> {
                    textureRegion = new TextureRegion(new Texture("celi.png"));
                }case JIBACK -> {
                    textureRegion = new TextureRegion(new Texture("jirc.png"));
                }case UNBACK -> {
                    textureRegion = new TextureRegion(new Texture("unk.png"));
                }
                case GENBACK -> {
                    textureRegion = new TextureRegion(new Texture("ges.png"));
                }case GROUBACK -> {
                    textureRegion = new TextureRegion(new Texture("grod.png"));
                }case LUGBACK -> {
                    textureRegion = new TextureRegion(new Texture("lugs.png"));
                }case KYOBACK -> {
                    textureRegion = new TextureRegion(new Texture("kyg.png"));
                }
                case RAYBACK -> {
                    textureRegion = new TextureRegion(new Texture("rayq.png"));
                }case DITTOBACK -> {
                    textureRegion = new TextureRegion(new Texture("ditt.png"));
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
                case DIBACK -> {
                    textureRegion = new TextureRegion(new Texture("dial.png"));
                }
                case LUXBACK -> {
                    textureRegion = new TextureRegion(new Texture("lux2.png"));
                }
                case SCEPBACK -> {
                    textureRegion = new TextureRegion(new Texture("scep2.png"));
                }
                case ZOROBACK -> {
                    textureRegion = new TextureRegion(new Texture("zo1.png"));
                }
                case CHANBACK -> {
                    textureRegion = new TextureRegion(new Texture("chan2.png"));
                }
                case VEBACK -> {
                    textureRegion = new TextureRegion(new Texture("fushigisou.png"));
                }
                case BLASBACK -> {
                    textureRegion = new TextureRegion(new Texture("ruacon.png"));
                }
                case CHARBACK -> {
                    textureRegion = new TextureRegion(new Texture("rongcon.png"));
                }
                case GARBACK -> {
                    textureRegion = new TextureRegion(new Texture("gar2.png"));
                }
                case GALLABACK -> {
                    textureRegion = new TextureRegion(new Texture("galla2.png"));
                }
                case MBACK -> {
                    textureRegion = new TextureRegion(new Texture("me.png"));
                }case CEBACK -> {
                    textureRegion = new TextureRegion(new Texture("celi.png"));
                }case JIBACK -> {
                    textureRegion = new TextureRegion(new Texture("jirc.png"));
                }case UNBACK -> {
                    textureRegion = new TextureRegion(new Texture("unk.png"));
                }
                case GENBACK -> {
                    textureRegion = new TextureRegion(new Texture("ges.png"));
                }case GROUBACK -> {
                    textureRegion = new TextureRegion(new Texture("grod.png"));
                }case LUGBACK -> {
                    textureRegion = new TextureRegion(new Texture("lugs.png"));
                }case KYOBACK -> {
                    textureRegion = new TextureRegion(new Texture("kyg.png"));
                }
                case RAYBACK -> {
                    textureRegion = new TextureRegion(new Texture("rayq.png"));
                }case DITTOBACK -> {
                    textureRegion = new TextureRegion(new Texture("ditt.png"));
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
                case DIBACK -> {
                    textureRegion = new TextureRegion(new Texture("dial.png"));
                }
                case LUXBACK -> {
                    textureRegion = new TextureRegion(new Texture("lux3.png"));
                }
                case SCEPBACK -> {
                    textureRegion = new TextureRegion(new Texture("scep3.png"));
                }
                case ZOROBACK -> {
                    textureRegion = new TextureRegion(new Texture("zo2.png"));
                }
                case CHANBACK -> {
                    textureRegion = new TextureRegion(new Texture("chan3.png"));
                }
                case VEBACK -> {
                    textureRegion = new TextureRegion(new Texture("fushigibana.png"));
                }
                case BLASBACK -> {
                    textureRegion = new TextureRegion(new Texture("rualon.png"));
                }
                case CHARBACK -> {
                    textureRegion = new TextureRegion(new Texture("ronglon.png"));
                }
                case GARBACK -> {
                    textureRegion = new TextureRegion(new Texture("gar3.png"));
                }
                case GALLABACK -> {
                    textureRegion = new TextureRegion(new Texture("galla3.png"));
                }
                case MBACK -> {
                    textureRegion = new TextureRegion(new Texture("me.png"));
                }case CEBACK -> {
                    textureRegion = new TextureRegion(new Texture("celi.png"));
                }case JIBACK -> {
                    textureRegion = new TextureRegion(new Texture("jirc.png"));
                }case UNBACK -> {
                    textureRegion = new TextureRegion(new Texture("unk.png"));
                }
                case GENBACK -> {
                    textureRegion = new TextureRegion(new Texture("ges.png"));
                }case GROUBACK -> {
                    textureRegion = new TextureRegion(new Texture("grod.png"));
                }case LUGBACK -> {
                    textureRegion = new TextureRegion(new Texture("lugs.png"));
                }case KYOBACK -> {
                    textureRegion = new TextureRegion(new Texture("kyg.png"));
                }
                case RAYBACK -> {
                    textureRegion = new TextureRegion(new Texture("rayq.png"));
                }case DITTOBACK -> {
                    textureRegion = new TextureRegion(new Texture("ditt.png"));
                }
            }
            textureRegionNoAnimation = textureRegion;
            setPosition(Gdx.graphics.getWidth() / 2 - getWidth() / 2, Gdx.graphics.getHeight() / 2 - getHeight() / 2);
            // new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());
            Egg1.mone =1;
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
        Texture texture = new Texture("charback.png");
        int cot = 5;
        int hang = 29;

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
            case LUXBACK -> {
                texture = new Texture("luxback.png");
                cot = 5;
                hang = 35;
            }
            case SCEPBACK -> {
                texture = new Texture("scepback.png");
                cot = 5;
                hang = 27;
            }
            case GARBACK -> {
                texture = new Texture("garback.png");
                cot = 5;
                hang = 18;
            }
            case CHARBACK -> {
                texture = new Texture("charback.png");
                cot = 5;
                hang = 29;
            }
            case BLASBACK -> {
                texture = new Texture("blasback.png");
                cot = 5;
                hang = 49;
            }
            case CHANBACK -> {
                texture = new Texture("chanback.png");
                cot = 5;
                hang = 34;
            }
            case ZOROBACK -> {
                texture = new Texture("zoroback.png");
                cot = 5;
                hang = 36;
            }
            case GALLABACK -> {
                texture = new Texture("gallaback.png");
                cot = 5;
                hang = 27;
            }
            case MBACK -> {
                texture = new Texture("mback.png");
                cot = 5;
                hang = 24;//
            }case CEBACK -> {
                texture = new Texture("ceback.png");
                cot = 5;
                hang = 13;//
            }case UNBACK -> {
                texture = new Texture("unback.png");
                cot = 5;
                hang = 19;//
            }
            case GROUBACK -> {
                texture = new Texture("grouback.png");
                cot = 5;
                hang = 21;//
            }case LUGBACK -> {
                texture = new Texture("lugback.png");
                cot = 5;
                hang = 24;
            }case KYOBACK -> {
                texture = new Texture("kyoback.png");
                cot = 5;
                hang = 49;
            }
            case RAYBACK -> {
                texture = new Texture("rayback.png");
                cot = 5;
                hang = 24;//
            }case DITTOBACK -> {
                texture = new Texture("dittoback.png");
                cot = 5;
                hang = 16;//
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
