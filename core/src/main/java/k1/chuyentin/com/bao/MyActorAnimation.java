package k1.chuyentin.com.bao;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyActorAnimation extends MyActor{
    Animation<TextureRegion> animation;

    float time;

    MyActorAnimation(Texture texture, float x, float y, Stage s, int cols, int rows) {
        super(x, y, s);
        setPosition(x, y);
        setSize(texture.getWidth(), texture.getHeight());
        TextureRegion[][] frameBuff = TextureRegion.split(texture, texture.getWidth() / cols, texture.getHeight() / rows);

        TextureRegion[] frames = new TextureRegion[cols * rows - 1];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!((i == (rows-1)) && (j == (cols-1)))) {
                    frames[index++] = frameBuff[i][j];
                }
            }
        }

        animation = new Animation<TextureRegion>(0.05f, frames);

        animation.setPlayMode(Animation.PlayMode.LOOP);

        time = 0;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        textureRegion = animation.getKeyFrame(time);
    }
}
