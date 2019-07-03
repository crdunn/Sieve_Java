package com.collabera.jump;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeClass {

	public static void main(String[] args) {
		
		//Setting up a scanner to capture the user's input
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("See all prime numbers that are less than the number of your choice:");
		
		while (true) {
			try {
				n = scan.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.println("Please enter a number");
				scan.next();
			}
		}
		scan.close();
		if (n < 2) {
			System.out.println("Number of Primes: 0");
		}
		else if (n < 3 ) {
			System.out.println("Number of Primes: 1");
		} else {
			
			//Capturing the process's start time
			long startTime = System.currentTimeMillis();
			
			//creating a boolean array to hold whether the number at that index is prime
			boolean arr[] = new boolean[n];
			
			//initializing the boolean array with the first three numbers and their prime conditions
			arr[0] = false;
			arr[1] = false;
			arr[2] = true;
			
			boolean flip = true;
			for (int i = 3; i < n; i++) {
				if (flip) {
					arr[i] = true;
				} else {
					arr[i] = false;
				}
				flip = !flip;
			}
			
			for (int j = 3; j < n; j++) {
				if (arr[j]) {
					int k = 3*j;
					while (k < n) {
						arr[k] = false;
						k += 2*j;
						
					}
				}
			}
			long endTime = System.currentTimeMillis();
			
			int c = 0;
			String allPrimes = "";
			for (int l = 0; l < n; l++) {
				if (arr[l]) {
					allPrimes += l + ", ";
					c++;
				}
			}
			System.out.println(allPrimes + "End.");
			long exTime = endTime - startTime;
			System.out.println("Number of Primes: " + c);
			System.out.println("execution time (miliseconds): " + exTime + " (Inaccurate for small numbers)");
		}
	}

}
