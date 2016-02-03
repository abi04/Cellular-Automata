import java.util.ArrayList;




public class CAGenerationSet {
	
	private static CAGenerationSet cag_set;
	private static ArrayList<CAGeneration> ca_gensa;
	
	
	private CAGenerationSet()
	{
		ca_gensa=new ArrayList<>();
		
		
	}
	
	
	
	public void CAGenerationSet1(String comboSelected)
	{
		
		
		
		
		CARule ca_rule=CARule.getInstance();
		
		// overriding the ruleset
		ca_rule.CARuleSet(comboSelected);
		int[] b=ca_rule.populateNextGeneration();
		
		
		
		CAGeneration cag=new CAGeneration();
		
		cag.everyGeneration(b);
		ca_gensa.add(cag);
		
		
	}
	
	public static CAGenerationSet getInstance()
	{
		if(cag_set==null)
		{
			cag_set=new CAGenerationSet();
		}
		return cag_set;
	}
	


	public static ArrayList<CAGeneration> getCags() {
	
		return ca_gensa;
	}
	
	public static void SetRight()
	{
		cag_set=null;
		
		
	}

	
	

}

	
	

