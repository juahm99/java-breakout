import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

public class Blockbank {
    
    private ArrayList<Box> blocks;
    int score = 0;
    private boolean blocksCreated = false;
    
    public int getscore() {
		
			return score ;
		
	}
	public void setscore(int x) {
		score=x;
	}

	    public Blockbank() {
	        if (!blocksCreated) {
	            blocks = new ArrayList<>();
	            createBlocks();
	            blocksCreated = true;
	        }
	    }

	    void createBlocks() {
	    	
	        for (int j = 0; j < 15; j++) {
	            Box redBlock = new Box(2 + Konstant.blockXspace, Konstant.blockYspace, 60, 40, Color.red);
	            blocks.add(redBlock);
	            Konstant.blockXspace += 62;
	        }
	        
	        Konstant.blockXspace = 0;
	        Konstant.blockYspace += 44;

	        
	        for (int k = 0; k < 15; k++) {
	            Box blueBlock = new Box(2 + Konstant.blockXspace, Konstant.blockYspace, 60, 40, Color.blue);
	            blocks.add(blueBlock);
	            Konstant.blockXspace += 62;
	        }
       
	        Konstant.blockXspace = 0;    
	        Konstant.blockYspace += 44;
	       
	        for (int i = 0; i < 15; i++) {
	            Box greenBlock = new Box(2 + Konstant.blockXspace, Konstant.blockYspace, 60, 40, Color.green);
	            blocks.add(greenBlock);
	            Konstant.blockXspace += 62;
	        }
	    }
	    public void resetBlockPositions() {
	        blocks.clear(); // Rensa befintliga block

	        int initialX = 2; // Ursprunglig X-position för första blocket
	        int initialY = 0; // Ursprunglig Y-position
	        int x = initialX;
	        int y = initialY;

	        for (int j = 0; j < 15; j++) {
	            Box redBlock = new Box(x, y, 60, 40, Color.red);
	            blocks.add(redBlock);
	            x += 62; 
	        }

	        x = initialX;
	        y += 44;

	        for (int k = 0; k < 15; k++) {
	            Box blueeBlock = new Box(x, y, 60, 40, Color.blue);
	            blocks.add(blueeBlock);
	            x += 62; 
	        }
	        
	        x = initialX;
	        y += 44;

	        for (int i = 0; i < 15; i++) {
	            Box greenBlock = new Box(x, y, 60, 40, Color.green);
	            blocks.add(greenBlock);
	            x += 62; 
	        }
	    }

    public void blockCollision(Ball ball) {
        for (int i = 0; i < blocks.size(); i++) {
            if (ball.isCollidingBox(blocks.get(i))) {
                Konstant.ball_speedy = Konstant.ball_speedy * -1;
                ball.setY(ball.getY() + Konstant.ball_speedy);

                    if(blocks.get(i).getColor() == Color.blue) {
                    blocks.get(i).setColor(Color.green);
                    score += 2;
                } else if(blocks.get(i).getColor() == Color.blue) {
                	blocks.get(i).setColor(Color.green);
                	 score += 2;
                }
                
                else if (blocks.get(i).getColor() == Color.green) {
                    score += 1;
                    blocks.remove(i);
                }

                    if (blocks.get(i).getColor() == Color.red) {
                        blocks.get(i).setColor(Color.blue);
                        score +=3;
                    }
            }
        }
        
       
    }

    public void draw(Graphics2D graphics) {
    	
        for (Box b : blocks) {
            b.draw(graphics);
        }
        
        Font newFont = new Font("", Font.HANGING_BASELINE, 15);
    	graphics.setFont(newFont);
        graphics.drawString("SCORE :" + score, 20, 570);
        
    }
}
