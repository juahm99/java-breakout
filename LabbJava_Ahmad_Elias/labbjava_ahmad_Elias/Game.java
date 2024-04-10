import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Game {
	
	private Player player;
    private Ball ball;
    private Blockbank blocks;
	private Box box;
    private int balls = 3;
    private Blockbank score;
    private boolean GameOver = false;
    private highScore high;
    private last3score latest;
    private JFrame frame;
    private JButton button;
	public Game(GameBoard board) {
		
		
		blocks = new Blockbank();
        player = new Player(400, 565, 120, 10);
        ball = new Ball(400, 265, 15, 15);
        high = new highScore();
        latest = new last3score();
        score = new Blockbank();
        
        latest.displaylast3Score();
        high.displayHighscore();
        
		
	}

	public void update(Keyboard keyboard) {
		
		if ((blocks.getscore() >= 133 || ball.balls == 0) && !GameOver) {
            GameOver = true;
            
            if(blocks.getscore() > 1) {
            	high.addValue(blocks.getscore());
            	 latest.addValue(blocks.getscore());
                 
            }
            
        
        }
		
		if (!GameOver) {
	        player.update(keyboard);
	        ball.update(keyboard);
	        ball.playerCollision(player, ball);
	        blocks.blockCollision(ball);

	        if (ball.getY() > 600) {
	            ball.setY(265);
	            ball.setX(400);
	            balls--;
	        }
		}
		
		if (GameOver && keyboard.isKeyDown(Key.Space)) {
		    GameOver = false;
		    balls = 3;
		    blocks.setscore(0);
		    blocks.resetBlockPositions();
		    player = new Player(400, 565, 120, 10);
		    ball = new Ball(400, 265, 15, 15);
		}
		
		
		
	}

	public void draw(Graphics2D graphics) {
		
		 player.draw(graphics);
		    ball.draw(graphics);
	        blocks.draw(graphics);
	        if (blocks.getscore() == 133 || ball.balls == 0) {
	        	graphics.setColor(Color.red);
	        	Font newFont = new Font("", Font.HANGING_BASELINE, 20);	        	graphics.setFont(newFont);
	            graphics.drawString("Good Job", 400, 350);
	            graphics.drawString("Score:" + blocks.getscore(), 400, 400);
	            graphics.drawString("Press (spase) to restart", 400, 450);
	        }
	}
}
