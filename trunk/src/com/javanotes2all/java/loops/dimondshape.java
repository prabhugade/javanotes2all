package com.javanotes2all.java.loops;

public class dimondshape 
{
	public static void main(String[] args) 
	{
		int n=10;
		for(int i=1;i<=n;i++)
		{
			if(i%2!=0)
			{
				int k=n-i;
				int l=0;
				boolean check=true;
				for(int j=0;j<(n+(n-1));j++)
				{
					if(j<k)
						System.out.print("\t");
					else
					{

						if(l<i&&check)
						{
							System.out.print((l+1)+"\t");
							check=false;
							l++;
						}else
						{
							check=true;
							System.out.print("\t");
						}

					}
				}
				System.out.println("\n\n");
			}
		}
		for(int i=n-1;i>0;i--)
		{
			if(i%2!=0)
			{
				int k=n-i;
				int l=0;
				boolean check=true;
				for(int j=0;j<(n+(n-1));j++)
				{
					if(j<k)
						System.out.print("\t");
					else
					{

						if(l<i&&check)
						{
							System.out.print((l+1)+"\t");
							check=false;
							l++;
						}else
						{
							check=true;
							System.out.print("\t");
						}

					}
				}
				System.out.println("\n\n");
			}
		}
	}

}
