package k1.chuyentin.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Enepoke extends Actor {
    Animation<TextureRegion> animation;
    float time;

    public Enepoke(Texture texture, Stage apps, float x, float y) {
        setPosition(x, y);
        setOrigin(getWidth() / 2, getHeight() / 2);
        int cot = 5;
        int hang = 12;
        setSize(texture.getWidth() / cot * 2, texture.getHeight() / hang * 2);
        float speed = 5;
        TextureRegion[][] tam = TextureRegion.split(texture, texture.getWidth() / cot, texture.getHeight() / hang);// đưa tất cả vào danh một danh sách ảnh, vì 6 cột 1 hàng nên sẽ có 6 phần tử: 6 x 1
        TextureRegion[] frames = new TextureRegion[cot * hang];
        int index = 0;
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                frames[index++] = tam[i][j];
            }
        }
        animation = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(speed, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        time = 0;
        setOrigin(getWidth() / 2, getHeight() / 2);
    }

    public void draw(Batch batch, float parentAlpha) {
        time += parentAlpha;
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);
        TextureRegion currentFrame = animation.getKeyFrame(time);
        batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), 1, 1, getRotation());
        batch.setColor(1, 1, 1, 1);
    }
}
