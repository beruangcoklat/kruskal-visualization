import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class Main implements ActionListener {

	private JFrame frame = new JFrame();
	private JButton btnGenerate, btnKruskal;
	private JSpinner spinNode;
	private MainPanel main_panel = new MainPanel();
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		main_panel.setPreferredSize(new Dimension(500, 500));
		
		frame.setTitle("Kruskal");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(main_panel, BorderLayout.CENTER);
		frame.add(southPanel(), BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.pack();
	}
	
	private JPanel southPanel(){
		JPanel panel = new JPanel();
		btnGenerate = new JButton("Generate");
		btnKruskal = new JButton("Kruskal");
		spinNode = new JSpinner();
		spinNode.setPreferredSize(new Dimension(100, 30));
		
		panel.add(new JLabel("Node"));
		panel.add(spinNode);
		panel.add(btnGenerate);
		panel.add(btnKruskal);
		
		btnGenerate.addActionListener(this);
		btnKruskal.addActionListener(this);
		
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGenerate){
			int nodes = (int) spinNode.getValue();
			if(nodes > 100){
				JOptionPane.showMessageDialog(null, "kebanyakan");
				return;
			}
			main_panel.generateNode(nodes);
		}
		else if(e.getSource() == btnKruskal){
			main_panel.doMST();
		}
	}
	
}
