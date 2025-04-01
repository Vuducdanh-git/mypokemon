package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.*;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Master implements Screen {

    k1.chuyentin.com.StartGame game;
    private SpriteBatch batch;
    Stage stage;

    static String skillHello;
    static Sound sound;
    static boolean autoplus1 = false;
    static boolean autoplus2 = false;
    static boolean autoplus3 = false;
    static boolean autoplus4 = false;
    static boolean autoplus5 = false;
    static boolean autoplus6 = false;
    static boolean autoplus7 = false;
    static boolean autoplus8 = false;
    static boolean autoplus9 = false;
    static boolean autoplus10 = false;
    static boolean autoplus11 = false;
    static boolean autoplus12 = false;
    static boolean autoplus13 = false;
    static boolean autoplus14 = false;
    static boolean autoplus15 = false;
    static boolean autoplus16 = false;
    static boolean autoplus17 = false;
    static boolean autoplus18 = false;
    static boolean autoplus19 = false;
    static boolean autoplus20 = false;
    static boolean autoplus21 = false;
    static boolean autoplus22 = false;
    static boolean autoplus23 = false;
    static boolean autoplus24 = false;


    static public int money = 100000;
    static int time = 0;
    static public int giatienclick=0;
    static public int sodiemtangkhiclick=0;
    static public int giatienauclick=0;
    static int solanclick = 250;
    static int autoplusnumber1 = 0;
    static int autoplusnumber2 = 0;
    static int autoplusnumber3 = 0;
    static int autoplusnumber4 = 0;
    static int autoplusnumber5 = 0;
    static int autoplusnumber6 = 0;
    static int autoplusnumber7 = 0;
    static int autoplusnumber8 = 0;
    static int autoplusnumber9 = 0;
    static int autoplusnumber10 = 0;
    static int autoplusnumber11 = 0;
    static int autoplusnumber12 = 0;
    static int autoplusnumber13 = 0;
    static int autoplusnumber14 = 0;
    static int autoplusnumber15 = 0;
    static int autoplusnumber16 = 0;
    static int autoplusnumber17 = 0;
    static int autoplusnumber18 = 0;
    static int autoplusnumber19 = 0;
    static int autoplusnumber20 = 0;
    static int autoplusnumber21 = 0;
    static int autoplusnumber22 = 0;
    static int autoplusnumber23 = 0;
    static int autoplusnumber24 = 0;


    static int plus = 0;


    static Pet pet;
    Egg egg;

    Skill1 kinang;
    Skill2 skill;




    Background bg;
    static Shop shop;
    static int use = 0;

    static Skill1 skill1;
    static Item click;
    static Skill2 skill2;
    static Item2 click2;
    static Item3 click3;
    static Item4 click4;
    static Item6 click6;
    static Item7 click7;
    static Item8 click8;
    static Item10 click10;
    static Item11 click11;
    static Item12 click12;
    static Item14 click14;
    static Item15 click15;
    static Item16 click16;
    static Item18 click18;
    static Item19 click19;
    static Item20 click20;
    static Item22 click22;
    static Item23 click23;
    static Item24 click24;
    static Buyskill buyskill;
    static Egg1 egg1;
    static Egg2 egg2;
    static Egg3 egg3;
    static int iegg;
    static public int random = MathUtils.random(1, 3);

    public static Array<String> wordSkills = new Array<>();
    public static Array<String> wordSkillsVN = new Array<>();
    public static boolean levelUp = false;
    Sound levelUpSound;

    BitmapFont font;

    public Master(StartGame game) {
        this.game = game;
        sound = Gdx.audio.newSound(Gdx.files.internal("ms.wav"));
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 32;
        fontParameter.color = Color.WHITE;
        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();
        batch = new SpriteBatch();
        stage = new Stage();
        bg = new Background(0, 0, stage);

        skill1 = new Skill1(0, Gdx.graphics.getHeight()/2, stage);
        skill2 = new Skill2(0, Gdx.graphics.getHeight()/2, stage);
        Master.skill1.remove();
        Master.skill2.remove();
        pet = new Pet(new Texture("egg.png"), 0, 0, stage);
        pet.setPosition(Gdx.graphics.getWidth() / 2 - pet.getWidth() / 2, Gdx.graphics.getHeight() / 2 - pet.getHeight() / 2);

        egg = new Egg(0, 0, stage);
        egg.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (solanclick >= 250){
                    game.setScreen(new BattleScreen(game));
                }
                else{
                    System.out.println("chưa đủ click để tiến hóa");
                }
            }
        });

        levelUpSound = Gdx.audio.newSound(Gdx.files.internal("levelup.wav"));

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        pet.setPosition(Gdx.graphics.getWidth() / 2 - pet.getWidth() / 2, Gdx.graphics.getHeight() / 2 - pet.getHeight() / 2);

        time++;
        if(iegg ==0) {
            if(pet.lv == 3){
                if (random == 2) {
                    pet.textureRegion = new TextureRegion(new Texture("rualon.png"));
                }
                if (random == 3) {
                    pet.textureRegion = new TextureRegion(new Texture("ronglon.png"));
                }
                if (random == 1) {
                    pet.textureRegion = new TextureRegion(new Texture("fushigibana.png"));

                }
                pet.setPosition(Gdx.graphics.getWidth() / 2 - pet.getWidth() / 2, Gdx.graphics.getHeight() / 2 - pet.getHeight() / 2);
            }
            if (solanclick >= 50 && pet.lv==0 && !levelUp) {
                pet.lv=1;
                levelUpSound.play();
                levelUp = true;
                if (random == 1) {
                    pet.textureRegion = new TextureRegion(new Texture("fushigidane.png"));
                }
                if (random == 2) {
                    pet.textureRegion = new TextureRegion(new Texture("rua.png"));


                }
                if (random == 3) {
                    pet.textureRegion = new TextureRegion(new Texture("rong.png"));
                }
                pet.setPosition(Gdx.graphics.getWidth() / 2 - pet.getWidth() / 2, Gdx.graphics.getHeight() / 2 - pet.getHeight() / 2);
                //    new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }

            if (solanclick >= 250 && pet.lv==2 && !levelUp) {
                levelUpSound.play();
                levelUp = true;
                pet.lv=3;

                if (random == 2) {
                    pet.textureRegion = new TextureRegion(new Texture("rualon.png"));
                    Utils6.listPoke.add(7);
                }
                if (random == 3) {
                    pet.textureRegion = new TextureRegion(new Texture("ronglon.png"));
                    Utils6.listPoke.add(20);


                }
                if (random == 1) {
                    pet.textureRegion = new TextureRegion(new Texture("fushigibana.png"));

                    Utils6.listPoke.add(1);
                }
                pet.setPosition(Gdx.graphics.getWidth() / 2 - pet.getWidth() / 2, Gdx.graphics.getHeight() / 2 - pet.getHeight() / 2);
                // new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }
            if (solanclick >= 100 && pet.lv==1&& !levelUp) {
                levelUpSound.play();
                levelUp = true;
                pet.lv=2;

                if (random == 2) {
                    pet.textureRegion = new TextureRegion(new Texture("ruacon.png"));
                }
                if (random == 3) {
                    pet.textureRegion = new TextureRegion(new Texture("rongcon.png"));
                }
                if (random == 1) {
                    pet.textureRegion = new TextureRegion(new Texture("fushigisou.png"));
                }

                pet.setPosition(Gdx.graphics.getWidth() / 2 - pet.getWidth() / 2, Gdx.graphics.getHeight() / 2 - pet.getHeight() / 2);
                // new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }
        }
        if(iegg ==1) {
            if (pet.lv == 3){
                if (random == 1){

                    pet.textureRegion=new TextureRegion(new Texture("fushigibana.png"));
                }
                if (random == 2){
                    pet.textureRegion=new TextureRegion(new Texture("rualon.png"));

                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("ronglon.png"));

                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan3.png"));

                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar3.png"));

                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux3.png"));

                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo2.png"));
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep3.png"));}
            }
            if (solanclick <51){
                pet.textureRegion = new TextureRegion(new Texture("egg1.png"));
            }
            if (solanclick >= 51&& pet.lv==0 && !levelUp) {

                random = MathUtils.random(1,8);
                levelUpSound.play();
                levelUp = true;
                pet.lv=1;
                if (random == 1){
                    pet.textureRegion=new TextureRegion(new Texture("fushigidane.png"));

                }
                if (random == 2){
                    pet.textureRegion=new TextureRegion(new Texture("rua.png"));
                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("rong.png"));
                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan1.png"));
                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar1.png"));
                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux1.png"));
                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo1.png"));
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep1.png"));
                }
                //   new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }
            if(solanclick >= 100&& pet.lv==1 ){
                levelUpSound.play();
                levelUp = true;
                pet.lv=2;

                if (random == 1){
                    pet.textureRegion=new TextureRegion(new Texture("fushigisou.png"));
                }
                if (random == 2){
                    pet.textureRegion=new TextureRegion(new Texture("ruacon.png"));
                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("rongcon.png"));
                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan2.png"));
                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar2.png"));
                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux2.png"));
                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo2.png"));
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep2.png"));
                }
                //  new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }
            if ((solanclick >=250)&&(use ==1)&& pet.lv==2){
                use =0;
                levelUpSound.play();
                levelUp = true;
                pet.lv=3;
                if (random == 1){
                    Utils6.listPoke.add(1);
                    pet.textureRegion=new TextureRegion(new Texture("fushigibana.png"));
                }
                if (random == 2){
                    Utils6.listPoke.add(7);
                    pet.textureRegion=new TextureRegion(new Texture("rualon.png"));

                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("ronglon.png"));
                    Utils6.listPoke.add(20);
                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan3.png"));
                    Utils6.listPoke.add(19);
                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar3.png"));
                    Utils6.listPoke.add(10);
                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux3.png"));
                    Utils6.listPoke.add(14);
                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo2.png"));
                    Utils6.listPoke.add(18);
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep3.png"));
                    Utils6.listPoke.add(16);
                }
                //  new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }

        }
        if(iegg ==2) {
            if (solanclick <51){
                pet.textureRegion = new TextureRegion(new Texture("egg1.png"));
            }
            if (solanclick == 51){
                random = MathUtils.random(1,8);

                if (random == 1){
                    pet.textureRegion=new TextureRegion(new Texture("fushigidane.png"));

                }
                if (random == 2){
                    pet.textureRegion=new TextureRegion(new Texture("rua.png"));
                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("rong.png"));
                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan1.png"));
                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar1.png"));
                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux1.png"));
                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo1.png"));
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep1.png"));
                }
                //   new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }
            if(solanclick == 100){


                if (random == 1){
                    pet.textureRegion=new TextureRegion(new Texture("fushigisou.png"));
                }
                if (random == 2){
                    pet.textureRegion=new TextureRegion(new Texture("ruacon.png"));
                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("rongcon.png"));
                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan2.png"));
                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar2.png"));
                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux2.png"));
                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo2.png"));
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep2.png"));
                }
                //  new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }
            if ((solanclick >=250)&&(use ==2)){
                use =0;
                if (random == 1){
                    Utils6.listPoke.add(1);
                    pet.textureRegion=new TextureRegion(new Texture("fushigibana.png"));
                }
                if (random == 2){
                    Utils6.listPoke.add(7);
                    pet.textureRegion=new TextureRegion(new Texture("rualon.png"));

                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("ronglon.png"));
                    Utils6.listPoke.add(20);
                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan3.png"));
                    Utils6.listPoke.add(19);
                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar3.png"));
                    Utils6.listPoke.add(10);
                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux3.png"));
                    Utils6.listPoke.add(14);
                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo2.png"));
                    Utils6.listPoke.add(18);
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep3.png"));
                    Utils6.listPoke.add(16);
                }
                //  new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }

        }
        if(iegg ==3) {
            if (solanclick <51){
                pet.textureRegion = new TextureRegion(new Texture("egg1.png"));
            }
            if (solanclick == 51){
                random = MathUtils.random(1,8);

                if (random == 1){
                    pet.textureRegion=new TextureRegion(new Texture("fushigidane.png"));

                }
                if (random == 2){
                    pet.textureRegion=new TextureRegion(new Texture("rua.png"));
                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("rong.png"));
                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan1.png"));
                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar1.png"));
                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux1.png"));
                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo1.png"));
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep1.png"));
                }
                //   new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }
            if(solanclick == 100){


                if (random == 1){
                    pet.textureRegion=new TextureRegion(new Texture("fushigisou.png"));
                }
                if (random == 2){
                    pet.textureRegion=new TextureRegion(new Texture("ruacon.png"));
                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("rongcon.png"));
                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan2.png"));
                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar2.png"));
                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux2.png"));
                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo2.png"));
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep2.png"));
                }
                //  new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }
            if ((solanclick >=250)&&(use ==3)){
                use =0;
                if (random == 1){
                    Utils6.listPoke.add(1);
                    pet.textureRegion=new TextureRegion(new Texture("fushigibana.png"));
                }
                if (random == 2){
                    Utils6.listPoke.add(7);
                    pet.textureRegion=new TextureRegion(new Texture("rualon.png"));

                }
                if (random == 3){
                    pet.textureRegion=new TextureRegion(new Texture("ronglon.png"));
                    Utils6.listPoke.add(20);
                }
                if (random == 4){
                    pet.textureRegion=new TextureRegion(new Texture("chan3.png"));
                    Utils6.listPoke.add(19);
                }
                if (random == 5){
                    pet.textureRegion=new TextureRegion(new Texture("gar3.png"));
                    Utils6.listPoke.add(10);
                }
                if (random == 6){
                    pet.textureRegion=new TextureRegion(new Texture("lux3.png"));
                    Utils6.listPoke.add(14);
                }
                if (random == 7){
                    pet.textureRegion=new TextureRegion(new Texture("zo2.png"));
                    Utils6.listPoke.add(18);
                }
                if (random == 8){
                    pet.textureRegion=new TextureRegion(new Texture("scep3.png"));
                    Utils6.listPoke.add(16);
                }
                //  new Sparkle(pet.getX() - pet.getHeight()+10, pet.getY()-pet.getHeight()+10, stage, 8, 8,pet.textureRegion.getRegionWidth(),pet.getHeight());

            }

        }
        if (time % 60 == 0) {
            if (autoplus2 == true) {
                money += autoplusnumber2;
                pet.click();
            }
            if (autoplus3 == true) {
                money += autoplusnumber3;
                pet.click();
            }
            if (autoplus4 == true) {
                money += autoplusnumber4;
                pet.click();
            }
            if (autoplus5 == true) {
                money += autoplusnumber5;
                pet.click();
            }
            if (autoplus6 == true) {
                money += autoplusnumber6;
                pet.click();
            }
            if (autoplus7 == true) {
                money += autoplusnumber7;
                pet.click();
            }
            if (autoplus8 == true) {
                money += autoplusnumber8;
                pet.click();
            }
            if (autoplus9 == true) {
                money += autoplusnumber9;
                pet.click();
            }
            if (autoplus10 == true) {
                money += autoplusnumber10;
                pet.click();
            }
            if (autoplus11 == true) {
                money += autoplusnumber11;
                pet.click();
            }
            if (autoplus12 == true) {
                money += autoplusnumber12;
                pet.click();
            }
            if (autoplus13 == true) {
                money += autoplusnumber13;
                pet.click();
            }
            if (autoplus14 == true) {
                money += autoplusnumber14;
                pet.click();
            }
            if (autoplus15 == true) {
                money += autoplusnumber15;
                pet.click();
            }
            if (autoplus16 == true) {
                money += autoplusnumber16;
                pet.click();
            }
            if (autoplus17 == true) {
                money += autoplusnumber17;
                pet.click();
            }
            if (autoplus18 == true) {
                money += autoplusnumber18;
                pet.click();
            }
            if (autoplus19 == true) {
                money += autoplusnumber19;
                pet.click();
            }
            if (autoplus20 == true) {
                money += autoplusnumber20;
                pet.click();
            }
            if (autoplus21 == true) {
                money += autoplusnumber21;
                pet.click();
            }
            if (autoplus22 == true) {
                money += autoplusnumber22;
                pet.click();
            }
            if (autoplus23 == true) {
                money += autoplusnumber23;
                pet.click();
            }
            if (autoplus24 == true) {
                money += autoplusnumber24;
                pet.click();
            }

        }

        if (time % 20 == 0) {
            new Effect(0, 0, stage); // tạo hieu ung cho vui
        }
        Vector2 mouse = new Vector2();
        mouse.set(Gdx.input.getX(), Gdx.input.getY());
        stage.getViewport().unproject(mouse);
        if(mouse.x > 400 && !egg.isShopShow){
            egg.showShop();


        } else if(mouse.x < 400 && egg.isShopShow) {
            egg.shopHide();
        }

        stage.act();
        stage.draw();

        batch.begin();
        font.draw(batch, "coin: " + money, 0, Gdx.graphics.getHeight() - 32);
        font.draw(batch, "clicknumber: " + solanclick, 0, Gdx.graphics.getHeight() );
        batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    public static void eggs(int i){
        if (i ==1){
            pet.textureRegion=new TextureRegion(new Texture("egg1.png"));
            iegg =1;
            use =1;
        }if (i ==2){
            pet.textureRegion=new TextureRegion(new Texture("egg2.png"));
            iegg =1;
            use =1;
        }if (i ==3){
            pet.textureRegion=new TextureRegion(new Texture("egg3.png"));
            iegg =1;
            use =1;
        }
        pet.lv =0;
        pet.setPosition(Gdx.graphics.getWidth() / 2 - pet.getWidth() / 2, Gdx.graphics.getHeight() / 2 - pet.getHeight() / 2);
        solanclick = 0;
    }
}
