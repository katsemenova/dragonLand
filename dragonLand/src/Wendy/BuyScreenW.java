package Wendy;

import java.awt.Color;
import java.util.ArrayList;

import dragonComponents.DragonLabel;
import dragonComponents.PriceLabel;
import dragonComponents.ShopBackdrop;
import dragonComponents.ShopLabel;
import game.DragonLand;
import game.ShopScreen;
import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class BuyScreenW extends ShopScreen {

    private ArrayList<Dragon> dragonsInShop;
    private ArrayList<DragonLabel> shoplabels; 
    private DragonLabel label;
    private Dragon[] dragons;
    
    private int price;
    private PriceLabel priceLabel;
   // private Dragon sold;
    private int x;
	private	int y;

	public BuyScreenW(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(ArrayList<Visible> visible) {
		
		dragons = new Dragon[4];
		for(int i= 0; i< dragons.length;i++)
		{
			dragons[i] = new Dragon(50, 50, 50, 50, "Nice Dragon", 100, "img/dragonNine.jpg");
		}
		
		Graphic background=new Graphic(0,0,getWidth(),getHeight(),"img/Grassland.png");
		ShopBackdrop back = new ShopBackdrop(50,50,getWidth()-100,getHeight()-100);
		
		visible.add(background);
		visible.add(back);

		
		Button exit = new Button(getWidth() - 100,  60, 50, 40, "X", new Color(230,195,147), new Action(){
			
			public void act() {
				// TODO Auto-generated method stub
				DragonLand.game.setScreen(DragonLand.homeScreen);
			}
		});
		
		visible.add(exit);
		
		int titleWidth = 100;
		int titleHeight = 65;

		ShopLabel shopTitle = new ShopLabel(60, 60, titleWidth*4, titleHeight, "Dragon Shop");
		
		visible.add(shopTitle);
		
		PriceLabel priceL = new PriceLabel(800,70,50);
		visible.add(priceL.getPriceLabel());
		visible.add(priceL.getCoin());
		
		
		x = 0;
		y = 150;
		
		for(int i = 0; i<dragons.length;i++)
		{
			ShopBackdrop labelBack = new ShopBackdrop(50,y-2,getWidth()-100,getHeight()/7);
			label = new DragonLabel(x,y, dragons[i],"BUY", new Action(){
				
				public void act() {
					// TODO Auto-generated method stub
//					shoplabels.remove(label);
//					dragonsInShop.remove(this);	
//					remove(label);
//					DragonLand.coins -= this.Dragon.getPrice();
					DragonLand.game.setScreen(DragonLand.homeScreen);//was using this for test don't know why doesn't work :(
				}
			});
			//shoplabels.add(label);
			//dragonsInShop.add(dragons[i]);
			//addObject(label);
			visible.add(labelBack);
			visible.add(label.getDragonImg());
			visible.add(label.getDragonName());
			//System.out.println(label.getDragonName().getText());
			visible.add(label.getDragonPrice().getCoin());
			visible.add(label.getDragonPrice().getPriceLabel());
			visible.add(label.getButton());
			
			y = y + DragonLabel.getLabelHeight();
		}	
		
		ClickableGraphic nextPage = new ClickableGraphic(900,550,0.15,"img/Arrow.png");
		nextPage.setAction(new Action(){

			@Override
			public void act() {
				// TODO Auto-generated method stub
				DragonLand.game.setScreen(DragonLand.shopMain);
			}
		});
		visible.add(nextPage);
		
	}
	
}
