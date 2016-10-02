package com.java.samplejavacodes;

import java.util.Scanner;

public class PrimeNumbers {
	
	public static void main(String[] args)
	{
		System.out.println("Enter Number : ");
		Scanner scn = new Scanner(System.in);
		
		int no = scn.nextInt();
		int i=2;
		while(i<no)
		{
			if(no % i == 0)
			{
				System.out.println(no + " is Not a Prime");
				break;
			}
			else
			{
				i++;
				continue;
			}
				
			
		}
		if(i == no)
			System.out.println(no+" is Prime number");
		
		scn.close();
			
	}

}
