

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class UI  {
		
	
	
	
	public static void main(String args[])
	{
		System.out.println(Thread.currentThread().toString());
		Run run=new Run();
		
		
	}
	
}

	class  Run extends CAApp1 {
	
	private int r;
	private String comboselected;
	private boolean b;
	
	
	
	
	public Run()
	{
		
		frame.setTitle("Cellular Automated");
		
	}	
	
	
	public void actionPerformed(ActionEvent arg0) 
	{
	
	 if(arg0.getSource()==button0)
		{
		 
		 	
			System.out.println("Start button  pressed");
			
			
			//Validating the inputs 
			try { 
		        Integer.parseInt(txt.getText()); 
		    } catch(NumberFormatException e) { 
		        JOptionPane.showMessageDialog(null, "Please enter numbers only");
		    }
			
			if(txt.getText().isEmpty() || Integer.parseInt(txt.getText())==0)
			{
				JOptionPane.showMessageDialog(null, "Enter valid Number of generations");
				return;
			}
			
			//Taking the inputs 
			int r1=Integer.parseInt(txt.getText());
			String comboselected1=combo.getSelectedItem().toString();
			this.r=r1;
			this.comboselected=comboselected1;
			
			System.out.println(Thread.currentThread().toString());
			b=true;	
			CAGenerationSet.SetRight();
			CARule.setRight();
			
			
			for(int i=0;i<r;i++)
			{
			CAGenerationSet cag_set=CAGenerationSet.getInstance();
			cag_set.CAGenerationSet1(comboselected);
			}
			
			//new MainPanel class object 
			frame.getContentPane().add(new MainPanel(r));
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		    
	        
			
		}
		else if (arg0.getSource()==button1){
			
			b=false;
			System.out.println("Pause button  pressed");
			
			
			MainPanel.setBoolean(b);
			
				
			
		}
		else
		{
			
		}
	
	
		
	}
	  

}

//this class extends JPanel	
class MainPanel extends JPanel {
	
	private int timePeriod;
	private int x;
	private static int counter;
	private static boolean run;
	private int a,b;
	

	
    MainPanel(int a) {
    	
    	
    	run=true;
    	this.a=a;
    	b=1;
    	
    	
    	
    }
    
    //set the boolean value
    public static void setBoolean(boolean booln)
    {
    	run=booln;
    	System.out.println(" value is:"+run);
    }
    
    public boolean getBoolean()
    {
    	return run;
    }
    
    
    
    // AWT thread automatically calls paintComponent method 
    
    public void paintComponent(Graphics graphic1) {
    	
    	//this method will clear prior images drawn
    	super.paintComponent(graphic1);
    	draw(graphic1);
    	
    }
    
    
    	
    	
    public void draw(Graphics graphic1)
    	{
    		
    		Graphics2D graphic2=(Graphics2D) graphic1;	
    		
    		for(int l=0;l<b;l++)
    		{
    			
	    		CAGeneration ca_gen=CAGenerationSet.getCags().get(l);
	    		System.out.println(run);
	    		
	        	x=counter;
	        	counter=counter+6;
    		
	            for(int i=0;i<ca_gen.getCag().size();i++)
		        {
	            	
		        	if(ca_gen.getCag().get(i).getCellval()==0)
		        	{
		        		
		        		graphic2.setColor(Color.ORANGE);
		        		
		        		graphic2.fillRect(6*i,x,6,6);
		        		
		        		
		        		
		        	}
		        	else
		        	{
		        		
		        		graphic2.setColor(Color.BLUE);
		        		graphic2.fillRect(6*i,x,6,6);
		
		        	}
		         
		        }
	            
         
	            
    		}
    	  
    	counter=0;
    	
    	
    	 if(b<CAGenerationSet.getCags().size() && run==true)
         {
    		 System.out.println("hi");
    		 try {
            	 
        			Thread.sleep(500);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
    		 repaint(); //repaints the canvas with every generation 
    		 b++;
         }
    	 
    		
    	 
    	
    }
    
      
}

