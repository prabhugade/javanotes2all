package com.javanotes2all.java.Objects;


interface Animal { 
	void makeNoise(); 
}
class Horse implements Animal 
{
	Long weight = 1200L;
	public void makeNoise() 
	{ 
		System.out.println("whinny"); 
	}
}
public class FinalizeOverride extends Horse 
{
	@Override
    protected void finalize() throws Throwable {

            System.out.println(this.getClass().getName()+ ":I'm dying ");
            super.finalize();
    }
	public void makeNoise() { System.out.println("vinny"); }
	public static void main(String[] args) {
		FinalizeOverride i1 = new FinalizeOverride();
		FinalizeOverride i2 = new FinalizeOverride();
		FinalizeOverride i3 = new FinalizeOverride();
		i3 = i1; i1 = i2; i2 = null; i3 = i1;
		System.gc();
	} 
}


