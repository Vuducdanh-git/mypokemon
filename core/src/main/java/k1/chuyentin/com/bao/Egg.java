package k1.chuyentin.com.bao;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import k1.chuyentin.com.Skill;

public class Egg extends MyActor{
    boolean isShopShow = false;
    Egg(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("more button.png"));
        setSize(250, 250/5);
    }

    public void showShop(){
            isShopShow = true;
            //                if(Master.shop==null) {
            Master.shop = new Shop(400, 0, getStage());
            Master.click = new Item(400, 450, getStage(),1);
            Master.click2 = new Item2(450, 450, getStage(),2);
            Master.skill1 = new Skill1(400, 150, getStage());
            Master.buyskill = new Buyskill(450,200, getStage());
            Master.egg1 = new Egg1(500,150,getStage());
            Master.egg2 = new Egg2(550,150,getStage());
            Master.egg3 = new Egg3(600,150,getStage());


            getStage().addActor(Master.shop);
            getStage().addActor(Master.buyskill);
            getStage().addActor(Master.skill1);

            getStage().addActor(Master.click2);
            getStage().addActor(Master.click);
            getStage().addActor(Master.egg1);
            getStage().addActor(Master.egg2);
            getStage().addActor(Master.egg3);
    }

    public void shopHide(){
        Master.egg1.remove();
        Master.egg2.remove();
        Master.egg3.remove();
        Master.shop.remove();
        Master.click.remove();
        Master.click2.remove();

        Master.skill1.remove();
        Master.buyskill.remove();

        isShopShow = false;
    }
}
