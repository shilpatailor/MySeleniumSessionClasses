package SeleniumMethods;

public class FindDuplicateChar {

	public static void main(String[] args) {
		// Write a java program to find out the duplicate characters in given string

		//String s = "pppdaf";
		String s = "pwwkew";

		for(int i=0; i<s.length(); i++)
		{
			int flag =0;
			for(int j=0; j<s.length(); j++)
			{
				if(s.charAt(i) == s.charAt(j) && i!=j)
				{
					flag = 1;
					break;
				}
			}

			if(flag==0)
			System.out.print(s.charAt(i));
		}

	}

}
