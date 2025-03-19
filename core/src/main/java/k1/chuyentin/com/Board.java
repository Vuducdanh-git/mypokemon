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

        if(type == 7) {
            texture = new Texture("blasboard.png");
        }
        if(type == 8) {
            texture = new Texture("dittoboard.png");
        }
        if(type == 9) {
            texture = new Texture("gallaboard.png");
        }
        if(type == 10) {
            texture = new Texture("garboard.png");
        }
        if(type == 11) {
            texture = new Texture("grouboard.png");
        }
        if(type == 12) {
            texture = new Texture("kyoboard.png");
        }

        if(type == 13) {
            texture = new Texture("lugboard.png");
        }
        if(type == 14) {
            texture = new Texture("luxboard.png");
        }
        if(type == 15) {
            texture = new Texture("rayboard.png");
        }
        if(type == 16) {
            texture = new Texture("scepboard.png");
        }
        if(type == 17) {
            texture = new Texture("unboard.png");
        }
        if(type == 18) {
            texture = new Texture("zoboard.png");
        }

        setSize(texture.getWidth()/1.5f, texture.getHeight()/1.5f);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
