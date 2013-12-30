package com.javanotes2all.java.date;

import java.util.Calendar;

public class LostFriday 
{
	public int getLastFriday(int month, int year)
	{
	Calendar cal = Calendar.getInstance();
	cal.set(year, month, 1, 0, 0, 0); // set to first day of the month
	cal.set(Calendar.MILLISECOND, 0);

	int firstDay = cal.get(Calendar.DAY_OF_WEEK);
	int daysOfMonth = cal.getMaximum(Calendar.DAY_OF_MONTH);

	switch (firstDay)
	{
	    case Calendar.SUNDAY :
	        return 25;
	    case Calendar.MONDAY :
	    	if (daysOfMonth == 31) return 31;
	        return 24;
	    case Calendar.TUESDAY :
	    	if (daysOfMonth >= 30) return 30;
	        return 23;
	    case Calendar.WEDNESDAY :
	    	if (daysOfMonth >= 29) return 29;
	        return 22;
	    case Calendar.THURSDAY :
	    	 return 28;
	    case Calendar.FRIDAY :
	        return 27;
	    case Calendar.SATURDAY :
	        return 26;
	}
	throw new RuntimeException("what day of the month?");
	}
	public static void main(String[] args) 
	{
		
		/*ArrayList<Object> list=new ArrayList<Object>();
		HashMap<Object,Object> map=new HashMap<Object,Object>();
		map.put("abc", "xyz");
		list.add(map);
		String a=map.get("abc").toString();
		HashMap map1=(HashMap) list.get(0);
		System.out.print(list.get(0)+""+map1);*/
		
		/*//for finding the special charectors
		Pattern p = Pattern.compile("[?<>',?[]}{=-)(*&^%$#`~{}]");
		Matcher m = p.matcher("I am ^a string");
		boolean b = m.find();

		if (b)
		   System.out.println("There is a special character in my string");
		
		 //Create a file object with the file name
        //in the argument:
        
	// The pattern matches control characters
		if ((Pattern.matches(".*[!£$%^&*@?<>+/)({}].*", "prabhu")) == true)
		  System.out.println("There is a special character in my string");
		
		if(Pattern.matches("[\\p{Punct}]", "pr^abhu")==true)
				System.out.println("There is a special character in my string");
		
		Pattern p = Pattern.compile("[\\p{Alpha}]*[\\p{Punct}][\\p{Alpha}]*");
        Matcher m = p.matcher("a[bc");
        boolean b = m.matches();

        if (b == true)
           System.out.println("There is a sp. character in my string");
        else
            System.out.println("There is no sp. char.");*/
		
		/* try 
		 {
			 String argument = "Nå(rska täcken";
			 String encoded = URLEncoder.encode(argument, "utf-8");
			 System.out.println(encoded+"  encoded"+URLDecoder.decode(encoded)); 
			 
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/dms_ca_role","root","silica");
			 Statement	st = con.createStatement();
			 ResultSet rs=st.executeQuery("select companyid from  company where companyname='silica(minds)' AND Custmerid='0.6022607818206651'");
			 if(rs.next())
			 {
				 System.out.println(rs.getString("companyid")); 
			 }else
				 System.out.println("failed");  
		 }catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
        String s=" hai this is prabhu ";
		 System.out.println("trim String"+s.trim());*/
		
		//for merge the two sets
		/* Set arrlist = new TreeSet();
		 Set arrlist1 = new TreeSet();
	        int i = 0;
	        String str = "Rose India";

	        //Add the specified element to the end of this list.
	        arrlist.add(i+"");
	        arrlist.add(str);
	        System.out.println("arrlist = " + arrlist);

	        //Add the specified element to the end of this list.
	        arrlist1.add("Rose1");
	        arrlist1.add("India1");
	        arrlist1.add(str);
	        arrlist1.add(i+"");
	        System.out.println("arrlist1 = " + arrlist1);

	        //Insert all of the elements in the specified collection into the ArrayList  
	        arrlist.addAll(arrlist1);
	        System.out.println("arrlist = " + arrlist);*/
		
	}
	
}
