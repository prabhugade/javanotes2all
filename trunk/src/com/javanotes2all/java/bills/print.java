package com.javanotes2all.java.bills;
import java.util.ArrayList;

public class print 
{
	public static ArrayList<String> ordered_names = new ArrayList<String>();
	public static ArrayList<String> ordered_quantity = new ArrayList<String>();
	public static ArrayList<String> tot_amout = new ArrayList<String>();
	
	public static void main(String[] args) 
	{
		String printtype="bill";
		ordered_names.add("veg xxxASDFASDFADSFASDFA asdcxdfserd");
		ordered_names.add("maaza coca -cola(2ltrpet)");
		ordered_names.add("Fanta/sprite/limaca/thumsup(2ltrpet)");
		
		ordered_quantity.add("104.44");
		ordered_quantity.add("1114.144");
		ordered_quantity.add("10334.442");
		
		tot_amout.add("12345.12");
		tot_amout.add("655656");
		tot_amout.add("48785412");
		for(int i=0; i<ordered_names.size();i++)
		{
			//System.out.println(Print.ordered_names.get(i)+"  "+Print.ordered_names.get(i).length());
			if(ordered_names.get(i).length()<=16)
			{
				if(printtype.equalsIgnoreCase("bill"))
				{
					System.out.println(ordered_names.get(i)+repeat(' ', 16-ordered_names.get(i).length()+4)+ordered_quantity.get(i)+repeat(' ',8-ordered_quantity.get(i).length()+2)+tot_amout.get(i)+"\n");
				}else
				{
					System.out.println(ordered_names.get(i)+repeat(' ', 16-ordered_names.get(i).length()+4)+ordered_quantity.get(i)+"\n");
				}
			}else
			{
				String[] str;
				if(ordered_names.get(i).contains(" "))
				{
					str = ordered_names.get(i).split(" ");
				}else if(ordered_names.get(i).contains("-"))
				{
					str = ordered_names.get(i).split("-");
				}else
				{
					str = ordered_names.get(i).split("(?<=\\G.{14})");
				}
				for(int j=0;j<str.length;j++)
				{
					System.out.println(str.length);
					if(str.length==j+1)
					{
						System.out.println("if"+j);
						if(printtype.equalsIgnoreCase("bill"))
						{
							System.out.println(str[j]+repeat(' ', 16-str[j].length()+4)+ordered_quantity.get(i)+repeat(' ',8-ordered_quantity.get(i).length()+2)+tot_amout.get(i)+"\n");
						}else
						{	
							System.out.println(str[j]+repeat(' ', 16-str[j].length()+4)+ordered_quantity.get(i)+"\n");
						}
					}else
					{
						System.out.println(j);
						String s="";
						if(str[j].length()<16)
						{
							if(j+1<=str.length&&(str[j]+" "+str[j+1]).length()<16)
							{
								System.out.println("ifif"+j);
								s=str[j]+" "+str[j+1];
								if(str.length==j+1)
								{
									if(printtype.equalsIgnoreCase("bill"))
									{
										System.out.println(s+repeat(' ', 16-(str[j]+" "+str[j+1]).length()+4)+ordered_quantity.get(i)+repeat(' ',8-ordered_quantity.get(i).length()+2)+tot_amout.get(i)+"\n");
									}else
									{	
										System.out.println(s+repeat(' ', 16-(str[j]+" "+str[j+1]).length()+4)+ordered_quantity.get(i)+"\n");
									}
								}else
								{
									System.out.println(s+j);
									j++;
									System.out.println(s+"\n");
								}
								
							}else
							{
								System.out.println(str[j]+"\n");
							}
						}
					}
				}
			}
		}
		
	}
	public static String repeat(char c,int i)
	{
		String tst = "";
		for(int j = 0; j < i; j++)
		{
			tst = tst+c;
		}
		return tst;
	}
}
