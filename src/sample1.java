import java.util.ArrayList;
import java.util.Iterator;

public class sample1 
{
	public static void main(String[] args) 
	{
		
		long start = System.currentTimeMillis();
		ArrayList<String> list=new ArrayList<String>();
		  int size = 100000;
	        for (int i = 0; i < size; i++)
	               list.add(""+i);
		long end = System.currentTimeMillis();
		System.out.println("Execution time was for adding "+(end-start)+" ms.");
		
		start = System.currentTimeMillis();
		Iterator<String> it=list.iterator();
		while(it.hasNext())
		{
			it.next();
			//System.out.println(it.next());
		}
		end = System.currentTimeMillis();
		System.out.println("Execution time was with iterator "+(end-start)+" ms.");
		
		start = System.currentTimeMillis();
		Object[] data=list.toArray();
		for(int i=0;i<data.length;i++)
			//System.out.println(data[i]);
		end = System.currentTimeMillis();
		System.out.println("Execution time was with array "+(end-start)+" ms.");
		
		String s="140.555$11.0$31932.0$799.0$21.0$11.0";
		String itdata[]=s.split("\\$");
		
		double oldqty=(Double.parseDouble(itdata[0])-Double.parseDouble(itdata[1])-Double.parseDouble(itdata[4]));
		double olducost=(Double.parseDouble(itdata[2])-Double.parseDouble(itdata[3]))/(Double.parseDouble(itdata[0])-Double.parseDouble(itdata[1]));
		double oldamt=(olducost*oldqty);
		
		//System.out.println(Double.parseDouble(itdata[2])-Double.parseDouble(itdata[3]));
		//System.out.println(Double.parseDouble(itdata[0])-Double.parseDouble(itdata[1]));
		//System.out.println(31133.0/129.555);
		//System.out.println(31932.0/140.555);
		System.out.println(oldqty);
		System.out.println(olducost);
		System.out.println(oldamt);
		System.out.println(oldamt+779);
		
		
		
		//for question
		String mystring = "handbagging"; 
		ArrayList<String> a = new ArrayList<String>();
		a.add("ing");
		a.add("bag");
		a.add("and");
		String result=mystring;
		for(int i=0;i<a.size();i++)
		{
			result=result.replace(a.get(i), "+"+a.get(i)+"+").replace("++", "+");
		}
		if(result.endsWith("+"))
			result=result.substring(0,result.length()-1);
		
		System.out.println(result);
		
	}

}
