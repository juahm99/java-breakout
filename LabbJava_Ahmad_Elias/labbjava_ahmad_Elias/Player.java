import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Sprite {

	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	@Override
	public void update(Keyboard keyboard) {
		if(keyboard.isKeyDown(Key.Right)) {
			setX(getX()+15);
		}else if(keyboard.isKeyDown(Key.Left)) {
			setX(getX()-15);
		}
		
		if(getX() + getWidth() >= Konstant.window_width) {
			setX(Konstant.window_width - getWidth());
		}
		else if(getX() <= 0) {
			setX(0);
		}
		
	}                         


	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.white);
		graphics.fillRect(getX(),getY(),getWidth(),getHeight());
	}

}
