package Interview;

public class GainCreditStickGame
{
	public static int count=0;
	public static int stickgame(int input1,int[] input2)//6
	{
		int index=2;
		int stick_picked_by_Matt=input2[index];
		int no_of_sticks_unpicked=input2.length-1;//5
		int[] length_of_each_unpicked_stick=new int[no_of_sticks_unpicked+1];
		System.out.println(length_of_each_unpicked_stick.length-1);
		for(int i=0;i<=input2.length-1;i++)  //[1,2,3,2,1,3]
		{
		 if(i==index)
		 {
			 continue;
		 }
		 else
		 {
			 try{
			 length_of_each_unpicked_stick[i] =input2[i];
			 System.out.println(length_of_each_unpicked_stick[i]);
			 }
			 catch(Exception e)
			 
			 {
				 
			 }
		 }
		 
		 
		}
		
		//find atleast one pair of stick which when put together will match size of the stick

		for(int i=0;i<length_of_each_unpicked_stick.length-1;i++)
		{
			for(int j=i+1;j<length_of_each_unpicked_stick.length-1-1;j++)
			{
			  int result=length_of_each_unpicked_stick[i]+length_of_each_unpicked_stick[j];
			  if(result==stick_picked_by_Matt)
			  {
				 ++count; 
			  }
			  else
			  {
				  
			  }
			}
		}
		
		
		

		return count;
		
	}

	public static void main(String[] args) 
	{
//		Matt and Raymond went for roaming to jungle suddenly they come accross
//		large pile of sticks of different sizes.Looking at large pile Matt was struck 
//		with an idea and decide to challenge friend with new kind of game.
//		......................
//		A/Q too rule,, Matt will pick up stick of some length then Raymond has to find
//		atleast one pair of stick which when put together will match size of the stick
//		Matt has picked If he can then Raymond wins otherwise Matt wins.
		int no_of_sticks= 5;
		int[] length_of_each_stick=new int[]{1,2,3,9,10};
        int winning_chances=stickgame(no_of_sticks,length_of_each_stick);
        System.out.println("winning chances is"+winning_chances);
        
		
		
		
	
		
		
	}

}

