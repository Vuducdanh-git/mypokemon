package k1.chuyentin.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.bao.Master;
import k1.chuyentin.com.bao.Skill2;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class BattleScreen implements Screen {
    Batch batch;
    OrthographicCamera camera;
    Background background;
    Stage stage;
    Mypoke mypoke;
    Texture texturepo;
    Enepoke enepoke;
    Texture textr;
    Bar1 bar1;
    Bar2 bar2;
    BitmapFont fonts;
    SkillBar skillBar;
    public static float myhp = 100;
    public static float yourhp=100;

    Hpbar hpbarm;
    Hpbar hpbare;
    TextField textField;
    boolean isTextFieldActive = false;
    StartGame game;
    Cyp cyp;
    String mp;
    float truhp = 0;
    Music nen;
    Skill skill;// = new Skill(stage,bar1.getX(),bar1.getY(),bar1.getWidth()/2);
    float trumhp =0;


    public BattleScreen(StartGame game) {
        nen = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
        nen.play();
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 840, 680);
        batch = new SpriteBatch();
        stage = new Stage();
        if(Master.random == 1){
            texturepo = new Texture("veback.png");
            mp = new String("VENUSAUR LV:MAX");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 34, 3);
        }if(Master.random == 2){
            texturepo = new Texture("blasback.png");
            mp = new String("VENUSAUR LV:MAX");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 49, 3);
        }if(Master.random == 3){
            texturepo = new Texture("charback.png");
            mp = new String("Charizard LV:MAX");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 34, 3);
        }



        if (Chargepoke.random == 1) {
            texturepo = new Texture("veback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 34, 3);
            mp = new String("VENUSAUR LV:MAX");


        }if (Chargepoke.random == 2) {
            texturepo = new Texture("diback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 28, 3);
            mp = new String("DIALGA LV:MAX");


        }
        if (Chargepoke.random == 3) {
            texturepo = new Texture("genback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 36, 1);
            mp = new String("GENESECTLV:MAX");

        }
        if (Chargepoke.random == 4) {
            texturepo = new Texture("jiback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 29, 1);
            mp = new String("JIRACHI LV:MAX");
        }
        if (Chargepoke.random == 5) {
            texturepo = new Texture("mback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 24, 1);
            mp = new String("MEW LV:MAX");


        }
        if (Chargepoke.random == 6) {
            texturepo = new Texture("ceback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 13, 1);
            mp = new String("CELEBI LV:MAX");
        }
        if (Chargepoke.random == 7) {
            texturepo = new Texture("blasback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 49, 3);
            mp = new String("BLASTOISE LV:MAX");


        }if (Chargepoke.random == 8) {
            texturepo = new Texture("dittoback.png");
                mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 16, 3);
            mp = new String("DITTO LV:MAX");


        }
        if (Chargepoke.random == 9) {
            texturepo = new Texture("gallaback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 27, 1);
            mp = new String("GALLADE:MAX");

        }
        if (Chargepoke.random == 10) {
            texturepo = new Texture("garback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 18, 1);
            mp = new String("GARCHOMP LV:MAX");
        }
        if (Chargepoke.random == 11) {
            texturepo = new Texture("grouback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 21, 1);
            mp = new String("GROUDON LV:MAX");


        }
        if (Chargepoke.random == 12) {
            texturepo = new Texture("kyoback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 50, 1);
            mp = new String("CELEBI LV:MAX");
        }
        if (Chargepoke.random == 13) {
            texturepo = new Texture("lugback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 24, 1);
            mp = new String("LUGIA LV:MAX");


        }
        if (Chargepoke.random == 14) {
            texturepo = new Texture("luxback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 35, 1);
            mp = new String("LUXURAY LV:MAX");
        }
        if (Chargepoke.random == 15) {
            texturepo = new Texture("rayback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 24, 1);
            mp = new String("RAYQUAZA LV:MAX");


        }
        if (Chargepoke.random == 16) {
            texturepo = new Texture("scepback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 27, 1);
            mp = new String("SCEPTILE LV:MAX");
        }
        if (Chargepoke.random == 17) {
            texturepo = new Texture("unback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 19, 1);
            mp = new String("UNOWN LV:MAX");


        }
        if (Chargepoke.random == 18) {
            texturepo = new Texture("zoroback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 36, 1);
            mp = new String("ZOROARK LV:MAX");
        }
        if (Chargepoke.random == 19) {
            texturepo = new Texture("chanback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 19, 1);
            mp = new String("CHANDELURE LV:MAX");


        }
        if (Chargepoke.random == 20) {
            texturepo = new Texture("charback.png");
            mypoke = new Mypoke(texturepo, stage, -7, -4, 5, 34, 1);
            mp = new String("CHARIZARD LV:MAX");

        }


            textr = new Texture("beedrill.png");

            enepoke = new Enepoke(textr, stage, 390, 280);
            background = new Background(0, 0, stage);
            skillBar = new SkillBar(330, 0, stage);
            hpbarm = new Hpbar(350, 140, stage);
            hpbare = new Hpbar(30, 320, stage);
            bar2 = new Bar2(30, 320, stage);
            bar1 = new Bar1(330, 140, stage);
            skill = new Skill(stage,bar1.getX(),bar1.getY()/2,bar1.getWidth()/2);


            cyp = new Cyp(stage, 340+bar1.getWidth()/2, 60, skillBar.getWidth() / 2);
            cyp.addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                    game.setScreen(new Chargepoke(game));
                }
            });


            stage.addActor(background);
            stage.addActor(skillBar);
            stage.addActor(mypoke);
            stage.addActor(enepoke);
            stage.addActor(bar2);
            stage.addActor(bar1);

            TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
            textFieldStyle.font = game.font;
            textFieldStyle.fontColor = Color.RED;

            textFieldStyle.background = new TextureRegionDrawable(new TextureRegion(new Texture("input.png")));

            // Tạo TextField
            textField = new TextField("", textFieldStyle);
            textField.setSize(220, 50);
            textField.setPosition(370, 6); // Vị trí giữa màn hình
            textField.setVisible(false);

            stage.addActor(textField);

            Gdx.input.setInputProcessor(stage);
        }
    @Override
    public void render ( float v){
        if(myhp > 50){
            hpbarm.setColor(Color.GOLD);}
        if ((BattleScreen.myhp <= 50) && (BattleScreen.myhp >24)) {
            hpbarm.setColor(Color.PURPLE);
        }if (BattleScreen.myhp < 25){
            hpbarm.setColor(Color.RED);
        }

        if(yourhp > 50) {
            hpbare.setColor(Color.GOLDENROD);
        }if ((BattleScreen.yourhp <= 50) && (BattleScreen.yourhp >24)) {
            hpbare.setColor(Color.PURPLE);
        }if (BattleScreen.yourhp < 25){
            hpbare.setColor(Color.RED);
        }

        if (truhp >0){
            truhp -= 1;
            skill.health(1);
        }if(trumhp > 0){
            trumhp -=1;
            skill.healths(1);
        }
        hpbarm.setSize(270f / 100f * myhp, 25);
        hpbare.setSize(270f/100f *yourhp,25);

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.act();
        stage.draw();
        batch.begin();
        game.fonts.draw(batch, mp, bar1.getX() + 40, bar1.getY() + 45);
        game.font.draw(batch, "BEEDRILL LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
        batch.end();
        if (skill.click == 1 && !isTextFieldActive) {
            textField.setVisible(true);
            textField.setText(""); // Xóa nội dung cũ
            stage.setKeyboardFocus(textField);
            isTextFieldActive = true;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && isTextFieldActive) {
            //  lấy nội dung nhập
            String inputText = textField.getText();
            System.out.println(inputText);
            textField.setVisible(false);
            stage.unfocusAll();
            isTextFieldActive = false;
            skill.click =0;

            boolean isHeated = false;
            for (String s: Master.wordSkills){
                if(s.equals(inputText)){
                    truhp = MathUtils.random(20f,30f);
                    isHeated = true;
                    break;
                }
            }
            if(isHeated){
                for (int i = 0; i < 10; i++) {
                    new Fire(0, 0, stage, true);
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    new Fire(0, 0, stage, false);

                }
                trumhp = MathUtils.random(20f,30f);
            }
        }
    }
    @Override
    public void show() {

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

    }
}
