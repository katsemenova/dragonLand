package introScreens;

import guiPractice.Screen;
import guiPractice.components.GraphicMovingComponent;

public class Fog extends GraphicMovingComponent {
	
	private int heightVariance;

	public Fog(int x, int y, int w, int h, String imageLocation, int heightVariance) {
		super(x, y, w, h, imageLocation);
		this.heightVariance = heightVariance;
		setVx(Math.random());
		setVy(0);
		setY(generateYPos());
	}

	@Override
	public void checkBehaviors() {
		if(getX() > Screen.getWidth()){
			setX(-1*this.getWidth());
			setY(generateYPos());
			setVx(Math.random());
			//update();
		}
	}
	
	public int generateYPos(){
		int add = (int) (Math.random() * heightVariance);
		int multiplier = (int) (Math.random() * 2) + 1;
		
		return getY() + (add * multiplier);
	}

}
