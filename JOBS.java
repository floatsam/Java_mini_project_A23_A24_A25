import java.util.*;
//class profession{};
//class skills extends profession;
//dummy classes to get started on, given above, will create them later....
class JobMngmtSystem{
  public static void main(String[] args){
    //Arraylist
  }
}
public class Factors
{
	protected String factorialize(int p)
	{
		String b = "1 ";
		for(int i = 2;2*i <= p; i++)
		{
			if(p%i == 0)
			{
				b = b + i + " ";

			}
		}
			b = b + p;
			return b;
	}
	public static void main(String[] args)
	{
		Factors pr = new Factors();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int x = 0;
		x=sc.nextInt();
		System.out.println(pr.factorialize(x));
	}
}
