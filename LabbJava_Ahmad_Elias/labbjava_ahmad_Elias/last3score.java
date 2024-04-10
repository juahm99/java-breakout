import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class last3score {
	
	
	private DefaultListModel scores;
	private int nextIndex = 0;
	private JList list;
	private JPanel panel; 
	private JFrame frame;
	
	public last3score() {

	scores = new DefaultListModel<>();
	list = new JList<>(scores);
	panel = new JPanel();
	frame = new JFrame("3 Latest Scores");
	
	 
	
	}
	public void addValue(int score)
	{

	if (scores.size() == 3)
	scores.remove(2);
	scores.add(0, score);

	}
	public void displaylast3Score()
	{

	panel.add(list);
	frame.add(panel);
	frame.setBounds(800, 0, 50, 100);
	frame.setVisible(true);
	frame.setSize(275, 100);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public JFrame getFrame()
	{

	return frame;

	}

	}

