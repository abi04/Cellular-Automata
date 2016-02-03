
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;



public abstract class JUIApp1 implements ActionListener {
    protected static JFrame frame ;
    protected JPanel main_Panel = null;
    protected JComboBox combo=null;
    protected JTextField txt=null;
    protected JButton button0 = null;
    protected JButton button1 = null;
    

	public  JUIApp1() {
		initGUI();
		
	}
	
	
	
	private void initGUI() {
		frame = new JFrame();
		frame.setTitle("jui");
		frame.setSize(800, 800);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		frame.add(get_MainPanel(),BorderLayout.NORTH);
		frame.setVisible(true);
	}

	public JPanel get_MainPanel() {
		main_Panel = new JPanel();
		main_Panel.setLayout(new FlowLayout());
		button0 = new JButton("Start");
		button0.addActionListener(this);
		main_Panel.add(button0);
		
		button1 = new JButton("Stop");
		button1.addActionListener(this);
		main_Panel.add(button1);
		
		txt=new JTextField("Generation");
		main_Panel.add(txt);
		
		combo=new JComboBox();
		combo.addItem("ruleset90");
		combo.addItem("ruleset122");
		combo.addItem("ruleset201");	
		combo.addItem("ruleset231");
		combo.addItem("ruleset188");
		combo.addItem("ruleset196");
		combo.addItem("ruleset206");
		combo.addItem("ruleset225");
		combo.addItem("ruleset231");
		combo.addItem("ruleset255");
		combo.addItem("ruleset165");
		
		
		main_Panel.add(combo);
		
		
		
		
		return main_Panel;
	}
	

    public abstract void run();
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		
	}	
	public static void main(String[] args) {
	
	}
}
