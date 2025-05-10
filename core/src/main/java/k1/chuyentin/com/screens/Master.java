package k1.chuyentin.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import k1.chuyentin.com.*;
import k1.chuyentin.com.actors.*;
import k1.chuyentin.com.Utils;
import k1.chuyentin.com.actors.buttons.AmThanh;
import k1.chuyentin.com.actors.buttons.NutMenu;
import k1.chuyentin.com.actors.buttons.SaveGame;
import k1.chuyentin.com.enums.ButtonType;
import k1.chuyentin.com.enums.PetStatus;



/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Master implements Screen {

    k1.chuyentin.com.StartGame game;
    private SpriteBatch batch;
    Stage stage;

    public static Sound sound;
    static public  float money = 0;
    static public  float moneygia = 0;
    static int time = 0;

    static public int sodiemtangkhiautoclick = 0;
    static public boolean autoclick = false;

    static public int giatienautoclick = 250;

    public static int plus = 0;

    public Pet pet;
    Egg egg;
    SaveGame saveGame;
    Yvs yvs;

    Background bg;
    Shop shop;
    Balo balo;
    BaloScreen balovatpham;
    AmThanh amthanh;
    boolean isShopShow = false;
    float shopShowTime = 0;

    public static Skill1 skill1;
    static Item click;
    Npc npc;
    static Item2 click2;

    Bar3 bar3;


    ChuaDuDieuKien chuaDuDieuKien;
//
//    static Buyskill buyskill;
    Egg1 egg1;

    public static Array<String> wordSkills = new Array<>();
    public static Array<String> wordSkillsVN = new Array<>();
    ShapeRenderer shapeRenderer;

    BitmapFont font;

    Array<Item> itemPlus;
    Array<Item2> itemAutoClicks;

    Item i1;
    Item i2;
    Item i3;
    Item i4;
    Item i5;
    Item i6;
    Item i7;
    Item i8;
    Item i9;
    Item i10;



    public Master(StartGame game) {
        sound = Gdx.audio.newSound(Gdx.files.internal("ms.wav"));
        this.game = game;
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 20;
        fontParameter.color = Color.WHITE;
        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();
        batch = new SpriteBatch();
        stage = new Stage();
        bg = new Background(0, 0, stage);
        balo = new Balo(stage,5,380);
        saveGame = new SaveGame(5,200,stage);
        amthanh = new AmThanh(5,250,stage,game.music);
        npc = new Npc(5,50,stage);
        npc.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new NpcScreen(game));
            }
        });
        balo.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BaloScreen(game));

            }
        });
        yvs = new Yvs(5,320,stage);
        yvs.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new WordListScreen(game));

            }
        });

        if(!Utils.pets.isEmpty()){
            pet = Utils.pets.get(0);
            pet.setSize(32, 32);
            stage.addActor(pet);
        } else {
            pet = new Pet(new Texture("egg.png"), 0, 0, stage, null);
            Utils.pets.add(pet);
        }
        pet.status = PetStatus.TRANING;
        pet.setPosition(Gdx.graphics.getWidth() / 2 - pet.getWidth() / 2, Gdx.graphics.getHeight() / 2 - pet.getHeight() / 2);

        egg = new Egg(0, 0, stage);
        egg.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (pet.solanclick >= 250) {
                    game.setScreen(game.battleScreen);
                } else {
                    chuaDuDieuKien = new ChuaDuDieuKien(-200, 0, stage);
                    System.out.println("chua du dieu kien");
                }
            }
        });

        bar3 = new Bar3(3,Gdx.graphics.getHeight() - 28,stage);

        shapeRenderer = new ShapeRenderer();

        itemPlus = new Array<>();
        itemAutoClicks = new Array<>();
    }

    @Override
    public void show() {
        stage.addListener(new InputListener() {
            private Actor lastActor = null;

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                Actor actor = stage.hit(x, y, true);

                if (lastActor != null && lastActor instanceof SaveGame && lastActor != actor) {
                    lastActor.setColor(1, 1, 1, 1); // Trả về màu gốc
                }

                if (actor instanceof SaveGame) {
                    actor.setColor(0, 1, 1, 1); // Làm đậm hơn khi chạm vào
                }

                lastActor = actor;
                return super.mouseMoved(event, x, y);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Actor actor = stage.hit(x, y, true);
                if (actor instanceof SaveGame) {
                    actor.setColor(1, 0, 0, 1); // Đổi thành màu đỏ khi nhấn vào
                }
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        time++;
        if (pet.lv == 0){
            bar3.setColor(Color.GREEN);
            bar3.setSize((Gdx.graphics.getWidth() - 2) * pet.solanclick / 50, 25);
        } else if (pet.lv == 1){
            bar3.setColor(Color.BLUE);
            bar3.setSize((Gdx.graphics.getWidth() - 2) * (pet.solanclick - 50) / 50, 25);
        } else if (pet.lv == 2){
            bar3.setColor(Color.RED);
            bar3.setSize((Gdx.graphics.getWidth() - 2) * (pet.solanclick - 100) / 150, 25);
        } else {
            bar3.setColor(Color.RED);
            bar3.setSize(Gdx.graphics.getWidth() - 2, 25);
        }

            if (autoclick) {
                if (time % (60 - click2.solannangcapautoclick*10) == 0) {
                    money += sodiemtangkhiautoclick;
                    pet.click();
                }
            }
//            if (money >= 1000&& money<1000000){
//                money = money/1000;
//                System.out.println("   k");
//            }else if (money >= 1000000&& money<1000000000){
//            money = money/1000000;
//                System.out.println("   M");
//        }else if (money >= 1000000000){
//                money = money/1000000000;
//                System.out.println("   B");
//            }


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
        if (isShopShow) {
            shopShowTime += v;
        } else {
            shopShowTime = 0f; // reset nếu shop tắt
        }


        stage.act();
        stage.draw();

        batch.begin();
        if (money<0) {
            System.out.println("loi roi loi roi");
            font.draw(batch, "$" + moneygia + "   ,hhooli.,uihlulusssdfguuuiuigxzcbgh   loi roi", 0, Gdx.graphics.getHeight() - 32);
        }else
        if (money<=1000&& money>=0) {
            font.draw(batch, "$" + money + "", 0, Gdx.graphics.getHeight() - 32);
        }else
        if (money>=1000&&money<=999999) {
            moneygia = money/1000;
            font.draw(batch, "$" + moneygia + "k", 0, Gdx.graphics.getHeight() - 32);
        }else
        if (money>=999999&&money<=99999999) {
            moneygia=money/10000000;
            font.draw(batch, "$" + moneygia + "M", 0, Gdx.graphics.getHeight() - 32);
        }else
        if (money>=99999999) {
            moneygia=money/1000000000;
            font.draw(batch, "$" + moneygia + "B", 0, Gdx.graphics.getHeight() - 32);
        }


        if (money>2139999999){
            System.out.println("gffhtfkkkkkkkkkkkkkkkkkk");
        }

        if(isShopShow && shopShowTime > 1f){
            font.draw(batch, "" + giatienautoclick + "$  \nFor faster", 490, 230);
            font.draw(batch, "$25K" , 490, 140);
            font.draw(batch, "$5K" , 490, 60);
        }

        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        if(pet.lv == 0){
            shapeRenderer.setColor(Color.GREEN);
        } else if(pet.lv == 1){
            shapeRenderer.setColor(Color.BLUE);
        } else {
            shapeRenderer.setColor(Color.RED);
        }

        shapeRenderer.rect(1, Gdx.graphics.getHeight() - 30, Gdx.graphics.getWidth() - 2, 30);
        shapeRenderer.end();
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

        i1 = new Item(405, 400, stage, 1);
        i2 = new Item(485, 400, stage, 2);
        i3 = new Item(565, 400, stage, 3);

        i4 = new Item(405, 330, stage, 4);
        i5 = new Item(485, 330, stage, 5);
        i6 = new Item(565, 330, stage, 6);

        i7 = new Item(405, 260, stage, 7);
        i8 = new Item(485, 260, stage, 8);
       // i9 = new Item(460, 280, stage, 9);
        i10 = new Item(565, 260, stage, 10);



        if(Master.click2 == null) {
            Master.click2 = new Item2(405, 180, stage, 1);
        } else {
            Master.click2.setX(Gdx.graphics.getWidth());
            Master.click2.addAction(Actions.moveTo(405, 180, 0.5f));
            stage.addActor(Master.click2);
        }

        Master.skill1 = new Skill1(405, 20, stage);
//        Master.buyskill = new Buyskill(450, 200, stage);
        egg1 = new Egg1(405, 100, stage, this);
    }

    public void shopHide() {
        egg1.remove();
        shop.remove();

        i1.remove();
        i2.remove();
        i3.remove();
        i4.remove();
        i5.remove();
        i6.remove();
        i7.remove();
        i8.remove();
        //i9.remove();
        i10.remove();

        click2.remove();

        skill1.remove();
//        buyskill.remove();

        isShopShow = false;
    }
}
