package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Board extends Actor {
    Texture texture;
    public Board(float x, float y, Stage stage,int type) {
        setPosition(x, y);
        if(type == 1) {
            texture = new Texture("veboard.png");
        }
        if(type == 2) {
            texture = new Texture("diboard.png");
        }
        if(type == 3) {
            texture = new Texture("genboard.png");
        }
        if(type == 4) {
            texture = new Texture("jiboard.png");
        }
        if(type == 5) {
            texture = new Texture("mboard.png");
        }
        if(type == 6) {
            texture = new Texture("ceboard.png");
        }
        setSize(texture.getWidth()/1.5f, texture.getHeight()/1.5f);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
