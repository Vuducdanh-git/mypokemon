package k1.chuyentin.com;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import k1.chuyentin.com.bao.Master;

public class StartGame extends Game {
    BitmapFont font;
    BitmapFont fonts;
    @Override

    public void create() {
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
        setScreen(new AboutScreen(this));

    }

    @Override
    public void render() {
        super.render();
    }
}
