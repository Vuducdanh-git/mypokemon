package k1.chuyentin.com.bao;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
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

    static Sound sound;

    static public int money = 100000000;
    static int time = 0;

    static public int sodiemtangkhiautoclick = 0;
    static public boolean autoclick = false;

    static public int giatienautoclick = 250;

    static int plus = 0;

    public Pet pet;
    Egg egg;

    Background bg;
    Shop shop;
    boolean isShopShow = false;
    static int use = 0;

    static Skill1 skill1;
    static Item click;
    static Item2 click2;
    Bar3 bar3;


    ChuaDuDieuKien chuaDuDieuKien;

    static Buyskill buyskill;
    Egg1 egg1;

    public static Array<String> wordSkills = new Array<>();
    public static Array<String> wordSkillsVN = new Array<>();

    BitmapFont font;

    public Master(StartGame game) {

        sound = Gdx.audio.newSound(Gdx.files.internal("ms.wav"));
        this.game = game;
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 32;
        fontParameter.color = Color.WHITE;
        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();
        batch = new SpriteBatch();
        stage = new Stage();
        bg = new Background(0, 0, stage);
        bar3 = new Bar3(0,Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/4,stage);

        if(!Utils6.pets.isEmpty()){
            pet = Utils6.pets.get(0);
            pet.setSize(32, 32);
            stage.addActor(pet);
        } else {
            pet = new Pet(new Texture("egg.png"), 0, 0, stage);
            Utils6.pets.add(pet);
        }
        pet.status = PetStatus.TRANING;
        pet.setPosition(Gdx.graphics.getWidth() / 2 - pet.getWidth() / 2, Gdx.graphics.getHeight() / 2 - pet.getHeight() / 2);

        egg = new Egg(0, 0, stage);
        egg.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (pet.solanclick >= 250) {
                    game.setScreen(new BattleScreen(game));
                } else {
                    chuaDuDieuKien = new ChuaDuDieuKien(-100, 0, stage);
                    System.out.println("chua du dieu kien");
                }
            }
        });

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
        bar3.setSize(290f / 100f * Pet.solanclick, 25);
        if (time % 60 == 0) {
            if (autoclick == true) {
                money += sodiemtangkhiautoclick;
                pet.click();
            }

        }

        if (time % 20 == 0) {
            new Effect(0, 0, stage); // tạo hieu ung cho vui
        }
        Vector2 mouse = new Vector2();
        mouse.set(Gdx.input.getX(), Gdx.input.getY());
        stage.getViewport().unproject(mouse);
        if (mouse.x > 400 && !isShopShow) {
            showShop();


        } else if (mouse.x < 400 && isShopShow) {
            shopHide();
        }

        stage.act();
        stage.draw();

        batch.begin();
        font.draw(batch, "coin: " + money, 0, Gdx.graphics.getHeight() - 32);
        font.draw(batch, "clicknumber: " + pet.solanclick, 0, Gdx.graphics.getHeight());
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

    public void showShop() {
        isShopShow = true;

        shop = new Shop(400, 0, stage);
        if(Master.click == null){
            Master.click = new Item(400, 450, stage, 1);
        } else {
            Master.click.setX(Gdx.graphics.getWidth());
            Master.click.addAction(Actions.moveTo(400, 450, 0.5f));
            stage.addActor(Master.click);
        }
        if(Master.click2 == null) {
            Master.click2 = new Item2(400, 350, stage, 2);
        } else {
            Master.click2.setX(Gdx.graphics.getWidth());
            Master.click2.addAction(Actions.moveTo(400, 350, 0.5f));
            stage.addActor(Master.click2);
        }

        Master.skill1 = new Skill1(400, 150, stage);
        Master.buyskill = new Buyskill(450, 200, stage);
        egg1 = new Egg1(500, 150, stage, this);
    }

    public void shopHide() {
        egg1.remove();
        shop.remove();

        click.remove();
        click2.remove();

        skill1.remove();
        buyskill.remove();

        isShopShow = false;
    }
}
