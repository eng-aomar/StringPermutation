/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permtation;

import java.util.Scanner;

/**
 *
 * @author Alaa
 */
public class StringPermutation {
    public static void main(String args[]) 
	{ 
            while (true) {
		System.out.print("Enter your string : "); 
                Scanner scanner = new Scanner(System.in);
                String inputString = scanner.nextLine();

	        char [] arr =inputString.toCharArray();
	
		permtation perm = new permtation(arr); 
		while (perm.HasNext()) 
		{ 
			perm.GetNext(); 
		} 
                System.out.print("Would you like to continue?(y/n) "); 
                String answer= scanner.nextLine();
                if (answer.equalsIgnoreCase("N")) {
				System.out.print("Thank you !!");
				break;
            }
                
            }
	} 
}

