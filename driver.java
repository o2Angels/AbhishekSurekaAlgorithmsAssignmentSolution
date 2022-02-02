package com.greatlearning.GradededAssign;
import java.util.*;

public class driver {
	
	public static void main(String[] args) {
		MergeSortAlgorithm mergeSort = new MergeSortAlgorithm();
		System.out.println("enter the no of companies");
		int n; 
		double currentstock;
		int countTrue =0, countFalse =0;
		
		
		Scanner KBD = new Scanner(System.in);
		 n = KBD.nextInt();
		
		double [] companiesStockPrice = new double[n];
		for(int i=0; i<n; i++) {
			
			System.out.println("Enter the current stock price of the company "+(i+1));
				
			currentstock = KBD.nextFloat();
			companiesStockPrice[i] = currentstock;
			//System.out.println(current stock);
			System.out.println("Wheather company's stock price rose today compare to yesterday?");
			//----
			
            boolean user = KBD.nextBoolean();
          
	
            if (user == true){
            	// System.out.println("It is true");
            	countTrue =countTrue +1;
            }
            else{

            	//System.out.println("It is false");
            	countFalse = countFalse +1;
            }
			//----
            
		}
		
		
		//--------Main Syntax over
	
				
        
        System.out.println("----------------------");
        
        System.out.println("1. Display the companies stock prices in ascending order");
        System.out.println("2. Display the companies stock prices in descending order");
        System.out.println("3. Display the total no of companies for which stock prices rose today");
        System.out.println("4. Display the total no of companies for which stock prices declined today");
        System.out.println("5. Search a specific stock price");
        System.out.println("6. press 0 to exit");
    
        System.out.println("----------------------");
        
        ///////////switch implementation begins
        
        System.out.println("Enter the operation that you want to perform");
        
        int choice;
        boolean quit = false;
        do {
        
        choice = KBD.nextInt();
        switch(choice) {
		
        case 1: {
				// sorted array in ascending order
        		System.out.println("Stock prices in ascending order are :");
				mergeSort.sort(companiesStockPrice,0,n-1);
				for(int i=0; i<n; i++) {
								
					System.out.println(companiesStockPrice[i]);
					}
					Menu.displayMenu();
					System.out.println("Enter the operation that you want to perform");
					break;
				}
		
		case 2: {
				// ---reverse array 
				System.out.println("Stock prices in descending order are :");
				for(int i=n-1; i>=0; i--) {
				
					System.out.println(companiesStockPrice[i]);
					
					}
					Menu.displayMenu();
					System.out.println("Enter the operation that you want to perform");
					break;
				}
				
		case 3: System.out.println("Total no of companies for which stock prices rose today "+ countTrue); 
				Menu.displayMenu();
				System.out.println("Enter the operation that you want to perform");
				break;
				
		case 4: System.out.println("Total no of companies for which stock prices declined today "+ countFalse); 
				Menu.displayMenu();
				System.out.println("Enter the operation that you want to perform");
				break;
		
		case 5: {
				System.out.println("enter the key value"); 
				
				float key = KBD.nextFloat();
				for(int i=0; i<n; i++) {
					if (key == companiesStockPrice[i]) { 
						System.out.println("Stock of value " + key +" is present");
						break;
					}	
											
						System.out.println("Value not found");
						

				}
				
        		}
				
				Menu.displayMenu();
				System.out.println("Enter the operation that you want to perform");
				break;
		
		case 0 : System.out.println("Exited successfully");
				break;
		default: System.out.println("Enter the Correct Choice");
		}
        
        }while(!quit);
        
        ///////////switch implementation ends
	}

}
