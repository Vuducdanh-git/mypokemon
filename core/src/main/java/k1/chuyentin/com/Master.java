package k1.chuyentin.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master extends ApplicationAdapter {
    Batch batch;
    Background background;
    Stage stage;
    OrthographicCamera camera;
    Mypoke mypoke;
    Texture texturepo;
    Enepoke enepoke;
    Texture textr;
    Bar1 bar1;
    Bar2 bar2;
    BitmapFont font;
    BitmapFont fonts;


    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 840, 680);
        batch = new SpriteBatch();
        stage = new Stage();
        texturepo = new Texture("veback.png");
        textr = new Texture("beedrill.png");
        mypoke = new Mypoke(texturepo,stage,-7,-4);
        enepoke = new Enepoke(textr,stage,390,280);
        background = new Background(0,0,stage);
        bar2 = new Bar2(30,320,stage);
        bar1 = new Bar1(330,140,stage);
        font = new BitmapFont();
        fonts = new BitmapFont();

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 25;
        fontParameter.color = Color.BLUE;
        fonts = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();

        FreeTypeFontGenerator fontGenerators = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size = 25;
        fontParameters.color = Color.RED;
        font = fontGenerators.generateFont(fontParameters);
        fontGenerators.dispose();


        stage.addActor(background);
        stage.addActor(mypoke);
        stage.addActor(enepoke);
        stage.addActor(bar2);
        stage.addActor(bar1);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.act();
        stage.draw();
        batch.begin();
        fonts.draw(batch,"VENUSAUR LV:MAX", bar1.getX() + 40, bar1.getY()+ 45);
        font.draw(batch,"BEEDRILL LV:MAX", bar2.getX() + 40, bar2.getY()+ 45);
        batch.draw("skill.png",bar1.getX() + 10,bar1.getY()-40);
        batch.end();


    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
