package k1.chuyentin.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Sparkle extends MyActorAnimation{
    Sparkle(Texture texture, float x, float y, Stage s, int cols, int rows,float width, float height) {
        super(texture, x, y, s, cols, rows,width,height);
        animation.setPlayMode(Animation.PlayMode.NORMAL);
        time *=3;

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
