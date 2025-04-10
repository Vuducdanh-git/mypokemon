package k1.chuyentin.com;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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
import k1.chuyentin.com.bao.Master;
import k1.chuyentin.com.bao.Pet;
import k1.chuyentin.com.bao.Utils6;

import static k1.chuyentin.com.Chargepoke.random;

/** {@link ApplicationListener} implementation shared by all platforms. */
public class BattleScreen implements Screen {
    Batch batch;
    OrthographicCamera camera;
    Background background;
    Stage stage;
    Pet pet;
  //  Mypoke mypoke = new Mypoke(new Texture("veback.png"), stage, -7, -4, 5, 34, 3);
    Texture texturepo;
    Enepoke enepoke;
    Texture textr;
    Bar1 bar1;
    Bar2 bar2;
    SkillBar skillBar;
    public static float myhp = 100;
    public static float yourhp=100;
    Bth bth;

    Hpbar hpbarm;
    Hpbar hpbare;
    TextField textField;
    boolean isTextFieldActive = false;
    StartGame game;
    Cyp cyp;
    public static String mp = "";
    float truhp = 0;
    Boss boss;
    Music nen;
    Texture btr;
    Skill skill;// = new Skill(stage,bar1.getX(),bar1.getY(),bar1.getWidth()/2);
    float trumhp =0;
    int lose =0;
    int time =0;
    boolean test=false;
    int random =0;


    public BattleScreen(StartGame game) {
        nen = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));
        nen.play();

        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 840, 680);
        batch = new SpriteBatch();
        stage = new Stage();
        pet = Utils6.pets.get(0);
        pet.setAnimation();




            textr = new Texture("beedrill.png");
            btr = new Texture("arc.png");

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

            bth = new Bth(stage, 340+bar1.getWidth()/2-30, 60-30, skillBar.getWidth() / 2);
            bth.addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                    game.setScreen(new Master(game));
                }
            });




            boss = new Boss(btr,stage,390,290);
            stage.addActor(background);
            stage.addActor(skillBar);
            stage.addActor(pet);
            stage.addActor(enepoke);
            stage.addActor(bar2);
            stage.addActor(bar1);
            //stage.addActor(boss);

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
        float alpha = 1.0f;
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
        game.font.draw(batch, "BEEDRILL LV:MAX", bar2.getX() + 40, bar2.getY() + 45);
        if (myhp <=0){
            lose =1;
        }
        if (yourhp <=0){
            lose =2;
        }
        if (lose ==1){
            time ++;

            if(time <60*5){
                alpha = 1.0f - (float)time/(60*2);
                game.font.setColor(1,1,1,alpha);
                game.font.draw(batch, "OH NO!You lose 10000 money", Gdx.graphics.getWidth()/2-150, Gdx.graphics.getHeight()/2);

            }else {
                time =0;
                lose =0;
            }
            myhp = 100;

            Master.money -=10000;



        }
        if(lose ==2){
            if (test == false){
                random = MathUtils.random(1,3);
                test = true;
                if (random ==1){
                    game.diamonds.add(new Diamond(Gdx.graphics.getWidth()/2-32/2,Gdx.graphics.getHeight()/2 -32/2,stage));

                }
                if(random ==2){
                    game.enders.add(new Ender(Gdx.graphics.getWidth()/2-32/2,Gdx.graphics.getHeight()/2 -32/2,stage));
                }
                if (random ==3){
                    game.sbs.add(new SB(Gdx.graphics.getWidth()/2-32/2,Gdx.graphics.getHeight()/2 -32/2,stage));
                }
            }
            yourhp =100;
            time ++;
            if(time <60*2){
                alpha = 1.0f - (float)time/(60*2);
                game.font.setColor(1,1,1,alpha);
                game.font.draw(batch, "congratulation!You get 10000 money and you get 1 special item", Gdx.graphics.getWidth()/2-300, Gdx.graphics.getHeight()-30);


            }else {

                Master.money +=10000;





                time =0;
                lose =0;
            }
        }



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
                    isHeated = true;
                    break;
                }
            }
            if(isHeated){
                truhp = inputText.length()*2;
                for (int i = 0; i < 10; i++) {
                    new Fire(0, 0, stage, true);
                }
            } else {
                trumhp = MathUtils.random(20f,30f);
                for (int i = 0; i < 10; i++) {
                    new Fire(0, 0, stage, false);
                }
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
