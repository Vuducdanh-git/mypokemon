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
            Master.click3 = new Item3(500, 450, getStage(),3);
            Master.click4 = new Item4(550, 450, getStage(),4);
            Master.click6 = new Item6(400, 400, getStage(),6);
            Master.click7 = new Item7(450, 400, getStage(),7);
            Master.click8 = new Item8(500, 400, getStage(),8);
            Master.click10 = new Item10(600, 400, getStage(),10);
            Master.click11 = new Item11(400, 350, getStage(),11);
            Master.click12 = new Item12(450, 350, getStage(),12);
            Master.click14 = new Item14(550, 350, getStage(),14);
            Master.click15 = new Item15(600, 350, getStage(),15);
            Master.click16 = new Item16(400, 300, getStage(),16);
            Master.click18 = new Item18(500, 300, getStage(),18);
            Master.click19 = new Item19(550, 300, getStage(),19);
            Master.click20 = new Item20(600, 300, getStage(),20);
            Master.click22 = new Item22(450, 250, getStage(),22);
            Master.click23 = new Item23(500, 250, getStage(),23);
            Master.click24 = new Item24(550, 250, getStage(),24);
            Master.skill1 = new Skill1(400, 150, getStage());
            Master.skill2 = new Skill2(450, 150, getStage());
            Master.buyskill = new Buyskill(450,200, getStage());
            Master.egg1 = new Egg1(500,150,getStage());
            Master.egg2 = new Egg2(550,150,getStage());
            Master.egg3 = new Egg3(600,150,getStage());


            getStage().addActor(Master.shop);
            getStage().addActor(Master.buyskill);
            getStage().addActor(Master.skill1);
            getStage().addActor(Master.skill2);
            getStage().addActor(Master.click24);
            getStage().addActor(Master.click23);
            getStage().addActor(Master.click22);
            getStage().addActor(Master.click20);
            getStage().addActor(Master.click19);
            getStage().addActor(Master.click18);
            getStage().addActor(Master.click16);
            getStage().addActor(Master.click15);
            getStage().addActor(Master.click14);
            getStage().addActor(Master.click12);
            getStage().addActor(Master.click11);
            getStage().addActor(Master.click10);
            getStage().addActor(Master.click8);
            getStage().addActor(Master.click7);
            getStage().addActor(Master.click6);
            getStage().addActor(Master.click4);
            getStage().addActor(Master.click3);
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
        Master.click3.remove();
        Master.click4.remove();
        Master.click6.remove();
        Master.click7.remove();
        Master.click8.remove();
        Master.click10.remove();
        Master.click11.remove();
        Master.click12.remove();
        Master.click14.remove();
        Master.click15.remove();
        Master.click16.remove();
        Master.click18.remove();
        Master.click19.remove();
        Master.click20.remove();
        Master.click22.remove();
        Master.click23.remove();
        Master.click24.remove();
        Master.skill1.remove();
        Master.skill2.remove();
        Master.buyskill.remove();

        isShopShow = false;
    }
}
