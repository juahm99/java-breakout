import java.awt.Color;
import java.awt.Graphics2D;

public class Box extends Sprite {

	private Color color;
	public Box(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color = color;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
		
	}
	
	public void setColor(Color color) {
		this.color = color;

	}
	
	public Color getColor() {
		return color;
	}

}
