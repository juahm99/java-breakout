import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Sprite {
	private  Blockbank blocks;
	public int position;
	int balls = 3;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void update(Keyboard keyboard) {
		setY(getY() + Konstant.ball_speedy);
		setX(getX() + Konstant.ball_speedx);
		
		if(getX() >= Konstant.window_width || getX() <= 0) {
			Konstant.ball_speedx = Konstant.ball_speedx*-1;
			setX(getX() + Konstant.ball_speedx);
		}
		if(getY() <= 0) {
			Konstant.ball_speedy = Konstant.ball_speedy*-1;		
			setY(getY() + Konstant.ball_speedy);
		
        }
	}
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.orange);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
		
		graphics.setColor(Color.blue);
		Font newFont = new Font("", Font.HANGING_BASELINE, 15);
    	graphics.setFont(newFont);
		graphics.drawString("Live :" + balls, 100, 570);
	}
		
		public boolean isCollidingPlayer(Player player) {
			Rectangle ballRect = new Rectangle(getX(), getY(), getWidth(), getHeight());
			Rectangle playerRect = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
			
			return ballRect.intersects(playerRect);
			
		}
			public boolean isCollidingBox(Box block) {
				Rectangle ballRect = new Rectangle(getX(), getY(), getWidth(), getHeight());
				Rectangle blockRect = new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHeight());
				
				return ballRect.intersects(blockRect);
				
			}
			public void playerCollision(Player player, Ball ball) {
				if(isCollidingPlayer(player)) {
					Konstant.ball_speedy = Konstant.ball_speedy*-1;
					setY(getY() + Konstant.ball_speedy);
				}
				if(ball.getY()>600) {
			        
			        balls --;
				 }
			
		
	}

}
