public class CARule {
	
	
	private static CARule carule;
	private static int[] ruleset;
	private int[] cell;
	
	private CARule()
	 {
		cell=new int[64];
		
		ruleset= new int[]{0,1,0,1,1,0,1,0};
		
		
	
		 
		//for first(0th) generation
		for(int i=0;i<cell.length;i++)
		{
			cell[i]=0;
		}
		cell[cell.length/2]=1;
		
		
		//for adding the first generation
		CAGeneration ca_gen=new CAGeneration();
		ca_gen.everyGeneration(cell);
		CAGenerationSet.getCags().add(ca_gen);
		 
	 }
	
	
	public void CARuleSet(String comboSelected)
	{
		
		 if(comboSelected.equals("ruleset90"))
        {
            ruleset= new int[]{0,1,0,1,1,0,1,0};
        }
        else if(comboSelected.equals("ruleset122"))
        {
        	
            ruleset= new int[]{0,1,1,1,1,0,0,1};
            
        }
        	 
        else if(comboSelected.equals("ruleset165"))
        {
        	
            ruleset= new int[]{1,0,1,0,0,1,0,1};
        }
        else if(comboSelected.equals("ruleset188"))
        {
        	
            ruleset= new int[]{1,0,1,1,1,1,0,0};
        }
		 
        else if(comboSelected.equals("ruleset196"))
        {
        	
            ruleset= new int[]{1,1,0,0,0,1,0,0};
        }
		 
        else if(comboSelected.equals("ruleset201"))
        {
        
            ruleset= new int[]{1,1,0,0,1,0,0,1};
        }
	
        else if(comboSelected.equals("ruleset206"))
        {
        	
            ruleset= new int[]{1,1,0,0,1,1,1,0};
        }
		 
        else if(comboSelected.equals("ruleset225"))
        {
        
            ruleset= new int[]{1,1,1,0,0,0,0,1};
        }
	 
        else if(comboSelected.equals("ruleset231"))
        {
        	
            ruleset= new int[]{1,1,1,0,0,1,1,1};
        }
        else if(comboSelected.equals("ruleset255"))
        {
        
            ruleset= new int[]{1,1,1,1,1,1,1,1};
        }
		 
        
	}
	
	public static CARule getInstance()
	{
		if(carule==null)
		{
			carule=new CARule();
			
		}
		return carule;
	}
	 public int[] populateNextGeneration()
	 {
		 
	
		 
		 int[] nextgen=new int[cell.length];
		 for(int i=1;i<cell.length-1;i++)
		 {
			 int left=cell[i-1];
			 int mid=cell[i];
			 int right=cell[i+1];
			 nextgen[i]=rules(left,mid,right);
			 
		 }
		 cell=nextgen;
		 
		return cell;
		 
		
	 }
	 
	 public int rules(int x,int y,int z)
	 {
		 String s= "" + x + y + z;
		 int index=Integer.parseInt(s,2);
		 return ruleset[index];
		 
	 }
	 
	 public static void setRight()
	 {
		 
		 carule=null;
	 }
	
	
	

}


