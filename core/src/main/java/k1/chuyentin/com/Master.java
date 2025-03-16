package k1.chuyentin.com;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master implements Screen {
    Batch batch;
    OrthographicCamera camera;
    Background background;
    Chargepoke chargepoke;
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
    float yourhp=100;
    Skill skill;
    Hpbar hpbar;
    int random = MathUtils.random(1,6);
    Master master;
    Board board;
    TextField textField;
    boolean isTextFieldActive = false;
    StartGame game;

    public Master(StartGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 840, 680);
        batch = new SpriteBatch();
        stage = new Stage();
        if (random ==1){
            texturepo = new Texture("veback.png");
            mypoke = new Mypoke(texturepo,stage,-7,-4,5,34,3);
        }
        if(random ==2){
            texturepo = new Texture("diback.png");
            mypoke = new Mypoke(texturepo,stage,-7,-4,5,28,3);
        }if (random ==3){
            texturepo = new Texture("genback.png");
            mypoke = new Mypoke(texturepo,stage,-7,-4,5,36,1);
        }
        if(random ==4){
            texturepo = new Texture("jiback.png");
            mypoke = new Mypoke(texturepo,stage,-7,-4,5,29,1);
        }if (random ==5){
            texturepo = new Texture("mback.png");
            mypoke = new Mypoke(texturepo,stage,-7,-4,5,24,1);
        }
        if(random ==6){
            texturepo = new Texture("ceback.png");
            mypoke = new Mypoke(texturepo,stage,-7,-4,5,13,1);
        }

        textr = new Texture("beedrill.png");

        enepoke = new Enepoke(textr,stage,390,280);
        background = new Background(0,0,stage);
        skillBar = new SkillBar(330,0,stage);
        hpbar = new Hpbar(350,140,stage);
        bar2 = new Bar2(30,320,stage);
        bar1 = new Bar1(330,140,stage);
        skill = new Skill(stage,340,60,skillBar.getWidth()/2);

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
    public void render(float v) {
        if (myhp < 100){
            hpbar.setSize(270/100*myhp,25);

        }
        System.out.println(myhp);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.act();
        stage.draw();
        batch.begin();
        game.fonts.draw(batch,"VENUSAUR LV:MAX", bar1.getX() + 40, bar1.getY()+ 45);
        game.font.draw(batch,"BEEDRILL LV:MAX", bar2.getX() + 40, bar2.getY()+ 45);
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
            skill.health(MathUtils.random(20,30));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
            game.setScreen(new Chargepoke(game));
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
