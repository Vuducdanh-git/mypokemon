package k1.chuyentin.com.bao;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Sparkle extends MyActorAnimation{
    Sparkle(Texture texture, float x, float y, Stage s, int cols, int rows) {
        super(texture, x, y, s, cols, rows);
        animation.setPlayMode(Animation.PlayMode.NORMAL);
        time *=2;
    }

    @Override
    public void act(float delta) {
        time += delta;
        textureRegion = animation.getKeyFrame(time);
        if(animation.isAnimationFinished(time)){
            remove();
        }
    }
}
