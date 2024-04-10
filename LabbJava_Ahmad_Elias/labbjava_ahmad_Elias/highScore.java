import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

public class highScore {
    private DefaultListModel<String> high;
    private JList<String> list;
    private JPanel panel;
    private JFrame frame;

    public highScore() {
        high = new DefaultListModel<>();
        list = new JList<>(high);
        panel = new JPanel(new GridLayout(1,1));
        frame = new JFrame("Highscore");

       
    }

    public void addValue(int value) {
        String name = askUserName();
        if (name != null) {
            high.addElement(name + ": " + value);
            sortList();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid name! Please enter a name (1-3 characters).");
        }
    }

    private String askUserName() {
        String name;
        do {
            name = JOptionPane.showInputDialog(frame, "Enter your name (1-3 characters):");
            if (name == null || name.isEmpty() || name.length() > 3) {
                JOptionPane.showMessageDialog(frame, "Invalid name! Please enter a name (1-3 characters).");
            }
        } while (name == null || name.isEmpty() || name.length() > 3);
        return name;
    }

    private void sortList() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < high.size(); i++) {
            temp.add(high.get(i));
        }
        Collections.sort(temp, (s1, s2) -> {
            int score1 = Integer.parseInt(s1.substring(s1.lastIndexOf(":") + 2));
            int score2 = Integer.parseInt(s2.substring(s2.lastIndexOf(":") + 2));
            return Integer.compare(score2, score1);
        });
        high.clear();
        for (String element : temp) {
            high.addElement(element);
        }
    }

    public void displayHighscore() {
    	 JScrollPane scrollPane = new JScrollPane(list);
         panel.add(scrollPane);
         frame.add(panel);
         frame.setBounds(800, 90, 50, 100);
         frame.setSize(275, 400);
         
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
