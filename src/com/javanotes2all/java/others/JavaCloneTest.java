package com.javanotes2all.java.others;

class JavaCloneTest {
	public static void main(String args[]) throws CloneNotSupportedException
	{
		Test t=new Test(10,20);
		System.out.println(t.getClass());
		t.display();
		Test t1=t.clone();
		t1.display();
		t.setValue(50, 100);
		t.display();
		t1.display();
	}
}
class Test implements Cloneable
{
	int a,b;
	Test(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	public void display()
	{
		System.out.println(a+"  "+b);
	}
	@Override
    protected Test clone() throws CloneNotSupportedException {
        return (Test) super.clone();
    }
	public void setValue(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
}
