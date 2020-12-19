package Arrays;

public class Example1 
{
	String[] arr =new String[5];
	public void addinarray()
	{
	for(int i=0;i<=3;i++)
	{
		arr[i]="sagar";
	}
	System.out.println(arr[2]);
	}
	

	public static void main(String[] args)
	{
      Example1 ex=new Example1();
      ex.addinarray();
	}

}
