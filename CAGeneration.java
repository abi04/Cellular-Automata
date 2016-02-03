import java.util.ArrayList;


public class CAGeneration {
	
	private ArrayList<CACell> ca_gen;
	
	public CAGeneration()
	{
		ca_gen=new ArrayList<>();
		
	}

	public ArrayList<CACell> getCag() {
		return ca_gen;
	}

	public void setCag(ArrayList<CACell> ca_gen) {
		this.ca_gen = ca_gen;
	}
	
		
	public void everyGeneration(int[] x)
	{
		//for every generation
		for(int i=0;i<x.length;i++)
		{
			CACell a= new CACell();
			a.setCellval(x[i]);
			ca_gen.add(a);
		}
		
		//printing every generation
		System.out.print("\n");
		
		for(int i=0;i<ca_gen.size();i++)
		{
			System.out.print(ca_gen.get(i).getCellval());
		}
		
	}
	
	

}

