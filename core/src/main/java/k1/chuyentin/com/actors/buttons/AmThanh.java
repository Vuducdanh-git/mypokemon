package k1.chuyentin.com.actors.buttons;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.actors.MyActor;

import static k1.chuyentin.com.StartGame.amthanh;

public class AmThanh extends MyActor {
    public AmThanh(float x, float y, Stage s, Music music) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("am thanh = 100.png"));

        setSize(textureRegion.getRegionWidth()/2+16,textureRegion.getRegionHeight()/2+16);
        setPosition(x, y);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (!amthanh ) {
                    textureRegion = new TextureRegion(new Texture("am thanh = 100.png"));
                    music.setVolume(1f );

                    amthanh = true;
                }else {
                    textureRegion = new TextureRegion(new Texture("am thanh = 0.png"));
                    music.setVolume(0f );
                    amthanh = false;
                }

            }


        });
    }

}
