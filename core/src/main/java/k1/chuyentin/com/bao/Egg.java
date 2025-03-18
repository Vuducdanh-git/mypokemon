package k1.chuyentin.com.bao;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Egg extends MyActor{
    boolean isShopShow = false;
    Egg(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("more button.png"));
        setSize(32, 32);

//        addListener(new ClickListener(){
//
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                if (!isShopShow) {
//                    showShop();
//                } else {
//                    shopHide();
//                }
//            }
//        });

    }

    public void showShop(){
            isShopShow = true;
            //                if(Master.shop==null) {
            Master.shop = new Shop(400, 0, getStage());
            Master.click = new Item(400, 450, getStage(),1);
            Master.click2 = new Item2(450, 450, getStage(),2);
            Master.click3 = new Item3(500, 450, getStage(),3);
            Master.click4 = new Item4(550, 450, getStage(),4);
            Master.click5 = new Item5(600, 450, getStage(),5);
            Master.click6 = new Item6(400, 400, getStage(),6);
            Master.click7 = new Item7(450, 400, getStage(),7);
            Master.click8 = new Item8(500, 400, getStage(),8);
            Master.click9 = new Item9(550, 400, getStage(),9);
            Master.click10 = new Item10(600, 400, getStage(),10);
            Master.click11 = new Item11(400, 350, getStage(),11);
            Master.click12 = new Item12(450, 350, getStage(),12);
            Master.click13 = new Item13(500, 350, getStage(),13);
            Master.click14 = new Item14(550, 350, getStage(),14);
            Master.click15 = new Item15(600, 350, getStage(),15);
            Master.click16 = new Item16(400, 300, getStage(),16);
            Master.click17 = new Item17(450, 300, getStage(),17);
            Master.click18 = new Item18(500, 300, getStage(),18);
            Master.click19 = new Item19(550, 300, getStage(),19);
            Master.click20 = new Item20(600, 300, getStage(),20);
            Master.click21 = new Item21(400, 250, getStage(),21);
            Master.click22 = new Item22(450, 250, getStage(),22);
            Master.click23 = new Item23(500, 250, getStage(),23);
            Master.click24 = new Item24(550, 250, getStage(),24);

            getStage().addActor(Master.shop);
            getStage().addActor(Master.click24);
            getStage().addActor(Master.click23);
            getStage().addActor(Master.click22);
            getStage().addActor(Master.click21);
            getStage().addActor(Master.click20);
            getStage().addActor(Master.click19);
            getStage().addActor(Master.click18);
            getStage().addActor(Master.click17);
            getStage().addActor(Master.click16);
            getStage().addActor(Master.click15);
            getStage().addActor(Master.click14);
            getStage().addActor(Master.click13);
            getStage().addActor(Master.click12);
            getStage().addActor(Master.click11);
            getStage().addActor(Master.click10);
            getStage().addActor(Master.click9);
            getStage().addActor(Master.click8);
            getStage().addActor(Master.click7);
            getStage().addActor(Master.click6);
            getStage().addActor(Master.click5);
            getStage().addActor(Master.click4);
            getStage().addActor(Master.click3);
            getStage().addActor(Master.click2);
            getStage().addActor(Master.click);
    }

    public void shopHide(){
        Master.shop.remove();
        Master.click.remove();
        Master.click2.remove();
        Master.click3.remove();
        Master.click4.remove();
        Master.click5.remove();
        Master.click6.remove();
        Master.click7.remove();
        Master.click8.remove();
        Master.click9.remove();
        Master.click10.remove();
        Master.click11.remove();
        Master.click12.remove();
        Master.click13.remove();
        Master.click14.remove();
        Master.click15.remove();
        Master.click16.remove();
        Master.click17.remove();
        Master.click18.remove();
        Master.click19.remove();
        Master.click20.remove();
        Master.click21.remove();
        Master.click22.remove();
        Master.click23.remove();
        Master.click24.remove();

        isShopShow = false;
    }
}
