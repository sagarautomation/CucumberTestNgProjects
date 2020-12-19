package Arrays;

public class Get5pair 
{
	public static void m1()
	{
	int[]no={1,6,8,2,4,2,3,2,0,5};
	int paircount=0;
	for(int i=0;i<=no.length-1;i++)
	{
		for(int j=i+1;j<=no.length-1;j++)
		{
			if(no[i]+no[j]==5)
			{
				paircount++;
				System.out.println(no[i]+" "+no[j]);
			}
			else
			{
				
			}
		}

	}
	System.out.println("Paircount is"+paircount);
	}
	public static void main(String[] args) 
	{
		Get5pair.m1();	
	}

}
