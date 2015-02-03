package com.javanotes2all.java.xml;

public class Employee {

	private String name;

	private int age;
	
	private int id;

	private String type;
	
	private String v;
	
	private String n;
	
	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public Employee(){
		
	}
	
	public Employee(String name, int id, int age,String type,String v,String n) {
		this.name = name;
		this.age = age;
		this.id  = id;
		this.type = type;
		this.v  = v;
		this.n = n;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Employee Details - ");
		sb.append("Name:" + getName());
		sb.append(", ");
		sb.append("Type:" + getType());
		sb.append(", ");
		sb.append("Id:" + getId());
		sb.append(", ");
		sb.append("Age:" + getAge());
		sb.append(".");
		sb.append("v:" + getV());
		sb.append(".");
		sb.append("n:" + getN());
		sb.append(".");
		
		return sb.toString();
	}
}