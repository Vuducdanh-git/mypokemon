package k1.chuyentin.com.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.StartGame;
import k1.chuyentin.com.Utils;
import k1.chuyentin.com.actors.*;
import k1.chuyentin.com.actors.buttons.AmThanh;
import k1.chuyentin.com.actors.buttons.Cross;


/**
 * {@link ApplicationListener} implementation shared by all platforms.
 */
public class BattleScreen implements Screen {
    Batch batch;
    Background background;
    Stage stage;
    Pet pet;

    Enepoke enepoke;
    Texture textr;
    Bar1 bar1;
    Bar2 bar2;
    SkillBar skillBar;
    int dodgechanceenemy;
    int dodgechancemy;
    AmThanh amThanh;
    public static float myhp = 100;
    public static float yourhp = 100;
    Bth bth;
    Cross cross;
    Hpbar hpbarm;
    Hpbar hpbare;
    TextField textField;
    boolean isTextFieldActive = false;
    int dodge = 0;
    StartGame game;
    Cyp cyp;
    int charge = 0;
    float truhp = 0;
    Ender ender;
    SB slimeball;



    Texture btr;
    Skill skill;
    float trumhp = 0;
    int lose = 0;
    int time = 0;
    Summary summary;
    boolean test = false;
    int random = 0;

    public static int quest = 2;
    int times;
    int inmap = 1;
    public static int waitss;
    public int kill = 0;
    int enrandom = 1;
    float yourhps;
    int tu =0;
    public static int i =0;
    public static int is=0;
    int timer;
    int tpq=0;
    public static int tpqt = 2100000002;
    int check=0;
    int timet=0;

    public BattleScreen(StartGame game) {
        this.game = game;
        stage = new Stage();
        game.nen = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));

        btr = new Texture("arc.png");
        background = new Background(0, 0, stage);
        textr = new Texture("beedrill.png");
        enepoke = new Enepoke(textr, stage, 390, 280, 12);

    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        game.nen.play();
        game.nen.setLooping(true);

        pet = Utils.pets.get(0);
        pet.setAnimation();

        if(background.getStage() == null){
            stage.addActor(background);
        }
        if(enepoke.getStage() == null){
            stage.addActor(enepoke);
        }
        skillBar = new SkillBar(330, 0, stage);
        hpbarm = new Hpbar(350, 140, stage);
        hpbare = new Hpbar(30, 320, stage);
        bar2 = new Bar2(30, 320, stage);
        bar1 = new Bar1(330, 140, stage);
        ender = new Ender(520,180,stage,false);
        slimeball = new SB(570,180,stage,false);
        skill = new Skill(stage, bar1.getX(), bar1.getY() / 2-20, skillBar.getWidth() / 2 - 30, 30);
        stage.addActor(skillBar);
        stage.addActor(pet);
        stage.addActor(bar2);
        stage.addActor(bar1);


        cyp = new Cyp(stage, 340 + bar1.getWidth() / 2, 60, skillBar.getWidth() / 2);
        cyp.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(i ==1){

                }else {
                    isTextFieldActive = false;
                    skill.click = 0;
                    waitss = 0;
                    skill.qa = 0;
                    game.setScreen(new Chargepoke(game));
                }


            }
        });

        bth = new Bth(stage, 340 + bar1.getWidth() / 2, 10, 130, 50);
        bth.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(i ==1){

                }else {
                    isTextFieldActive = false;
                    skill.click = 0;
                    waitss = 0;
                    skill.qa = 0;
                    game.setScreen(new Master(game));
                }


            }
        });

        //stage.addActor(boss);
        amThanh = new AmThanh(5, 400, stage, game.nen);
        summary = new Summary(80,150,stage);
        cross = new Cross(stage,10000000,300,50,50);

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = game.font;
        textFieldStyle.fontColor = Color.BLACK;


        textFieldStyle.background = new TextureRegionDrawable(new TextureRegion(new Texture("input.png")));

        // Tạo TextField
        textField = new TextField("", textFieldStyle);
        textField.setSize(220, 50);
        textField.setPosition(370, 6); // Vị trí giữa màn hình
        textField.setVisible(false);

        stage.addActor(textField);

        if (game.amthanh) {
            game.nen.setVolume(1f);
        } else {
            game.nen.setVolume(0f);
        }
        if(Master.wordSkills.size >0) {
            stage.addActor(skill);
        }else {
            skill.remove();
        }

        yourhps = 100;
        cross.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                waitss =0;
                cross.toBack();
                summary.toBack();
                i =0;
                tu =0;
                is =0;
                if (inmap == 1) {
                    enrandom = MathUtils.random(1, 5);
                    if (enrandom == 1) {
                        enepoke.remove();
                        textr = new Texture("beedrill.png");
                        enepoke = new Enepoke(textr, stage, 390, 280, 12);
                    }
                    if (enrandom == 2) {
                        enepoke.remove();
                        textr = new Texture("celebi.png");
                        enepoke = new Enepoke(textr, stage, 390, 280, 13);

                    }
                    if (enrandom == 3) {
                        enepoke.remove();
                        textr = new Texture("ditto.png");
                        enepoke = new Enepoke(textr, stage, 390, 260, 16);
                    }
                    if (enrandom == 4) {
                        enepoke.remove();
                        textr = new Texture("galla.png");
                        enepoke = new Enepoke(textr, stage, 390, 250, 27);
                    }
                    if (enrandom == 5) {
                        enepoke.remove();
                        textr = new Texture("un.png");
                        enepoke = new Enepoke(textr, stage, 390, 280, 19);

                    }
                }
            }
        });
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        System.out.println(StartGame.diamonds.size);
        StartGame.mytime +=v;
        float alphase = 1.0f;
        float alpha = 1.0f;
        float alphas = 1.0f;
        ender.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if (game.enders.size>5){
                    game.enders.size-=5;

                    pet.avoid += 15;
                }
            }
        });
        slimeball.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if (game.sbs.size>10){
                    game.sbs.size-=10;
                    pet.acc += 15;
                }
            }
        });
        if (myhp > 50) {
            hpbarm.setColor(Color.RED);
        }
        if ((BattleScreen.myhp <= 50) && (BattleScreen.myhp > 24)) {
            hpbarm.setColor(Color.LIGHT_GRAY);
        }
        if (BattleScreen.myhp < 25) {
            hpbarm.setColor(Color.RED);
        }
        if (yourhp > 50) {
            hpbare.setColor(Color.RED);
        }
        if ((BattleScreen.yourhp <= 50) && (BattleScreen.yourhp > 24)) {
            hpbare.setColor(Color.LIGHT_GRAY);

        }
        if (BattleScreen.yourhp < 25) {
            hpbare.setColor(Color.RED);
        }
        if (truhp > 0) {
            truhp -= 1;
            skill.health(1);
        }
        if (trumhp > 0) {
            trumhp -= 1;
            skill.healths(1);
        }
        hpbarm.setSize(270f / 100f * myhp, 25);
        hpbare.setSize(270f / yourhps * yourhp, 25);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.act();
        stage.draw();
        batch.begin();
        game.font.setColor(Color.BLACK);
        game.font.draw(batch,"You have studied for a total of "+(int)StartGame.mytime+" seconds",0,Gdx.graphics.getHeight()-10);
        game.font.setColor(Color.WHITE);
        if (inmap == 1) {
            if (enrandom == 1) {
                game.name.setColor(Color.CHARTREUSE);
                game.name.draw(batch, "BEEDRILL LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
            if (enrandom == 2) {
                game.name.setColor(Color.GREEN);
                game.name.draw(batch, "CELEBI LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
            if (enrandom == 3) {
                game.name.setColor(Color.LIGHT_GRAY);
                game.name.draw(batch, "DITTO LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
            if (enrandom == 4) {
                game.name.setColor(Color.GREEN);
                game.name.draw(batch, "GALLADE LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
            if (enrandom == 5) {
                game.name.setColor(Color.LIGHT_GRAY);
                game.name.draw(batch, "UNKNOW LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
        }
        if (inmap == 2) {
            if (enrandom == 1) {
                game.name.setColor(Color.RED);
                game.name.draw(batch, "CHARIZARD LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
            if (enrandom == 2) {
                game.name.setColor(Color.PURPLE);
                game.name.draw(batch, "CHANDELURE LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
            if (enrandom == 3) {
                game.name.setColor(Color.FIREBRICK);
                game.name.draw(batch, "GROUDON LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
            if (enrandom == 4) {
                game.name.setColor(Color.BROWN);
                game.name.draw(batch, "GARCHOMP LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
            if (enrandom == 5) {
                game.name.setColor(Color.LIGHT_GRAY);
                game.name.draw(batch, "UNKNOW LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
            }
        }


        if (myhp <= 0) {
            lose = 1;
        }
        if (yourhp <= 0) {
            lose = 2;
        }
        if (lose == 1) {
            waitss = 5;
            time++;
            myhp = 100;
            if (time < 60 * 2) {
                alpha = 1.0f - (float) time / (60 * 2);
                game.fonts.setColor(1, 1, 1, alpha);
                game.fonts.draw(batch, "OH NO!You lose 10000 money", Gdx.graphics.getWidth() / 2 - 150, Gdx.graphics.getHeight() / 2);
            } else {
                waitss = 0;
                time = 0;
                lose = 0;
                Master.money -= 10000;

            }
        }
        if(i ==1){
            game.font.draw(batch,"" + tu,Gdx.graphics.getWidth()/2+60,Gdx.graphics.getHeight()/2+50);
        }
        if(is ==2){
            game.font.draw(batch,"typing",Gdx.graphics.getWidth()/2+60,Gdx.graphics.getHeight()/2);
        }
        if (lose == 2) {
            if (!test) {
                int random = MathUtils.random(1, 3);
                test = true;
                if (random == 1) {
                    game.diamonds.add(new Diamond(Gdx.graphics.getWidth() / 2 - 64 / 2, Gdx.graphics.getHeight() / 2 - 64 / 2, stage, true));

                }
                if (random == 2) {
                    game.enders.add(new Ender(Gdx.graphics.getWidth() / 2 - 64 / 2, Gdx.graphics.getHeight() / 2 - 64 / 2, stage, true));
                }
                if (random == 3) {
                    game.sbs.add(new SB(Gdx.graphics.getWidth() / 2 - 64 / 2, Gdx.graphics.getHeight() / 2 - 64 / 2, stage, true));
                }
            }
            System.out.println(tpqt);
            yourhp = 100;
            time++;
            if (time < 60 * 2) {
                alpha = 1.0f - (float) time / (60 * 2);
                game.fonts.setColor(1, 1, 1, alpha);
                game.fonts.draw(batch, "congratulation!You get 10000 money and you get 1 special item", Gdx.graphics.getWidth() / 2 - 300, Gdx.graphics.getHeight() - 30);
            } else {
                if(tpq < tpqt){
                    tpqt = tpq;
                    is =2;
                }
                tpq =0;
                waitss =2;
                stage.addActor(summary);
                stage.addActor(cross);
                summary.toFront();
                cross.toFront();
                cross.setPosition(520,300);
                i =1;
                time = 0;
                waitss = 0;
                test = false;
                Master.money += 10000;
                lose = 0;
                kill++;
                yourhp +=50;
                yourhps = yourhp;

                if ((charge == 0) && (kill == 5)) {
                    background.textureRegion = new TextureRegion(new Texture("biomemagma.jpg"));
                    charge = 1;
                    inmap = 2;

                    myhp = 100;
                    Utils.setWordList7();
                    enrandom = MathUtils.random(1, 5);
                    if (enrandom == 1) {
                        enepoke.remove();
                        textr = new Texture("char.png");
                        enepoke = new Enepoke(textr, stage, 390, 280, 29);


                    }
                    if (enrandom == 2) {
                        enepoke.remove();
                        textr = new Texture("chan.png");
                        enepoke = new Enepoke(textr, stage, 390, 280, 34);


                    }
                    if (enrandom == 3) {
                        enepoke.remove();
                        textr = new Texture("grou.png");
                        enepoke = new Enepoke(textr, stage, 390, 280, 20);


                    }
                    if (enrandom == 4) {
                        enepoke.remove();
                        textr = new Texture("gar.png");


                        enepoke = new Enepoke(textr, stage, 390, 280, 18);

                    }
                    if (enrandom == 5) {
                        enepoke.remove();
                        textr = new Texture("un.png");
                        enepoke = new Enepoke(textr, stage, 390, 280, 19);


                    }
                }


            }

        }
        if (quest == 1) {
            times++;

            if (times < 60 * 4.5f) {
                alphas = 1.0f - (float) times / (60 * 4.5f);
                game.font.setColor(1, 1, 1, alphas);
                if (Skill.r == 1) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ:đặc biệt", 150, 320);

                }
                if (Skill.r == 2) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ:tối thượng", 150, 320);
                }
                if (Skill.r == 3) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ:bạn", 150, 320);

                }
                if (Skill.r == 4) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ:ống nước", 150, 320);

                }
                if (Skill.r == 5) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ:kết nối", 150, 320);
                }
                if (Skill.r == 6) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ:mất kết nối", 150, 320);

                }
                if (Skill.r == 7) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ:con rồng", 150, 320);
                }
                if (Skill.r == 8) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ:chim phượng hoàng", 150, 320);

                }
                if (Skill.r == 9) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ:con sư tử", 150, 320);
                }
                if (Skill.r == 10) {
                    game.font.draw(batch, "nghĩa tiếng anh của từ : vua", 150, 320);
                }
            } else {
                trumhp = 20;
                quest = 2139;
                Skill.qa =0;
                //  lấy nội dung nhập
                String inputText = textField.getText();
                System.out.println(inputText);
                textField.setVisible(false);
                stage.unfocusAll();
                isTextFieldActive = false;
                skill.click = 0;
                waitss =0;


            }

        }


        if (dodge == 1) {
            time++;
            if (time < 60 * 2) {
                alphase = 1.0f - (float) time / (60 * 2);
                game.fonts2.setColor(1, 1, 1, alphase);
                game.fonts2.draw(batch, "Miss!", enepoke.getX(), enepoke.getY() - 25);
                waitss = 2;
            } else {
                time = 0;
                waitss = 0;
                dodge = 0;
            }
        }
        if (dodge == 2) {
            time++;
            if (time < 60 * 2) {
                alphase = 1.0f - (float) time / (60 * 2);
                game.fonts2.setColor(1, 1, 1, alphase);
                game.fonts2.draw(batch, "you dodged the attack!", 0, 300);
                waitss = 2;
            } else {
                time = 0;
                waitss = 0;
                dodge = 0;
            }
        }
        batch.end();
        if(check ==1){
            timet +=1;
            if(timet % 60 ==1){
                timer ++;
            }
        }else {
            timet =0;
        }

        if ((quest > 1)&&(waitss == 0)) {
            if (skill.click == 1 && !isTextFieldActive) {
                textField.setVisible(true);
                textField.setText(""); // Xóa nội dung cũ
                stage.setKeyboardFocus(textField);
                isTextFieldActive = true;
                check =1;
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && isTextFieldActive ) {
                Skill.qa = 0;
                check =0;
                tpq += timer;
                timer =0;
                //  lấy nội dung nhập
                String inputText = textField.getText();
                System.out.println(inputText);
                textField.setVisible(false);
                stage.unfocusAll();
                isTextFieldActive = false;
                skill.click = 0;
                waitss = 0;
                boolean isHeated = false;
                for (String s : Master.wordSkills) {
                    if (s.equals(inputText)) {
                        isHeated = true;
                        break;
                    }
                }
                if (isHeated) {
                    tu +=1;
                    int a = MathUtils.random(1,3);
                    for (int i = 0; i < 10; i++) {
                        new Fire(0, 0, stage, true,a);

                    }

                    dodgechanceenemy = MathUtils.random(1, 100);
                    if (dodgechanceenemy <= pet.acc) {
                        truhp = inputText.length() * 2;
                        pet.acc -= 2;

                    } else {
                        truhp = 0;
                        pet.acc += 5;
                        dodge = 1;
                    }

                } else {
                    int a =MathUtils.random(1,3);
                    for (int i = 0; i < 10; i++) {
                        new Fire(0, 0, stage, false,a);
                    }
                    dodgechancemy = MathUtils.random(1, 100);
                    if (dodgechancemy > pet.avoid) {
                        trumhp = MathUtils.random(20f, 30f);
                        pet.avoid += 5;

                    } else {
                        trumhp = 0;
                        pet.avoid -= 5;
                        dodge = 2;
                    }
                }
                Skill.qa = 0;

            }
        }
        if ((quest == 1)&&(waitss == 0)) {
            if (skill.click == 1 && !isTextFieldActive) {
                textField.setVisible(true);
                textField.setText(""); // Xóa nội dung cũ
                stage.setKeyboardFocus(textField);
                isTextFieldActive = true;
                check =1;
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && isTextFieldActive) {
                Skill.qa = 0;
                check =0;
                tpq += timer;
                timer =0;
                //  lấy nội dung nhập
                String inputText = textField.getText();
                System.out.println(inputText);
                textField.setVisible(false);
                stage.unfocusAll();
                isTextFieldActive = false;
                skill.click = 0;

                times = 0;
                quest = 5;
                boolean isHeated = false;
                if (inputText.isEmpty()) {
                    int a = MathUtils.random(1,3);
                    for (int i = 0; i < 10; i++) {
                        new Fire(0, 0, stage, false,a);
                    }
                    dodgechancemy = MathUtils.random(1, 100);
                    if (dodgechancemy > pet.avoid) {
                        trumhp = MathUtils.random(20f, 30f);
                        pet.avoid += 5;

                    } else {
                        trumhp = 0;
                        pet.avoid -= 5;
                        dodge = 2;
                    }
                } else {
                    for (String s : Utils.specialq) {
                        if (s.equals(inputText)) {
                            isHeated = true;
                            break;
                        }

                    }
                    if (!isHeated) {
                        int a = MathUtils.random(1,3);
                        for (int i = 0; i < 10; i++) {
                            new Fire(0, 0, stage, false,a);
                        }
                        dodgechancemy = MathUtils.random(1, 100);
                        if (dodgechancemy > pet.avoid) {
                            trumhp = MathUtils.random(20f, 30f);
                            pet.avoid += 5;

                        } else {
                            trumhp = 0;
                            pet.avoid -= 5;
                            dodge = 2;
                        }

                    } else {
                        tu +=1;

                        int a = MathUtils.random(1,3);
                        for (int i = 0; i < 10; i++) {
                            new Fire(0, 0, stage, true,a);
                        }

                        dodgechanceenemy = MathUtils.random(1, 100);
                        if (dodgechanceenemy <= pet.acc) {
                            truhp = inputText.length() * 2;
                            pet.acc -= 2;

                        } else {
                            truhp = 0;
                            pet.acc += 5;
                            dodge = 1;
                        }
                    }
                }
                Utils.specialq.removeIndex(0);
            }

        }
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
        game.nen.stop();
        stage.clear();
    }

    @Override
    public void dispose() {

    }
}
