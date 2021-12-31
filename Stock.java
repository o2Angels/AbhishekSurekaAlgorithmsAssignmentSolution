package stock;
import java.util.Scanner;

public class Stock {
	
	static int partitionAsc (double a[], int start, int end)  {  
		double pivot = a[end]; // pivot element  
		int i = (start - 1);  
  
		for (int j = start; j <= end - 1; j++)   {  
        // If current element is smaller than the pivot  
			if (a[j] < pivot)  {  
            i++; // increment index of smaller element  
            	double t = a[i];  
            		a[i] = a[j];  
            		a[j] = t;  
				}  
		}  
		double t = a[i+1];  
			a[i+1] = a[end];  
			a[end] = t;  
			return (i + 1);  
		}  
	static int partitionDesc (double a[], int start, int end)  {  
		double pivot = a[end]; // pivot element  
		int i = (start - 1);  
		
		for (int j = start; j <= end - 1; j++) {  
        // If current element is smaller than the pivot  
			if (a[j] > pivot)  {  
            i++; // increment index of smaller element  
            double t = a[i];  
            a[i] = a[j];  
            a[j] = t;  
        }  
    }  
    double t = a[i+1];  
    a[i+1] = a[end];  
    a[end] = t;  
    return (i + 1);  
}
static void quickDesc(double a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */  
{  
    if (start < end)  {  
        int p = partitionDesc(a, start, end); //p is the partitioning index  
        quickDesc(a, start, p - 1);  
        quickDesc(a, p + 1, end);  
    }  
}    
  
/* function to implement quick sort */  
static void quickAsc(double a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */  {  
    if (start < end)   {  
        int p = partitionAsc(a, start, end); //p is the partitioning index  
        quickAsc(a, start, p - 1);  
        quickAsc(a, p + 1, end);  
    }  
}  
  
/* function to print an array */  
static void printArr(double a[], int n)  {  
    int i;  
    for (i = 0; i < n; i++)  
        System.out.print("\t"+a[i]);  
}  
static int linearSearch(double a[], int n, double val) {  
	
  // Going through array sequentially  
  for (int i = 0; i < n; i++)  {  
        if (a[i] == val)  
        return i+1;  
    }  
  return -1;  
}  
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
int n,i,j,countT=0,countF=0;
System.out.println("Enter the number of companies: ");
n=sc.nextInt();
int opChoice=0;
double[] sharePrice = new double[n];
boolean[] priceRise = new boolean[n];
for(i=0;i<n;i++)
{
System.out.println("Enter the current stock price of the company "+(i+1)+":");
sharePrice[i]=sc.nextDouble();
System.out.println("Whether company "+(i+1)+"'s stock price rose today compare to yeterday ?: ");
priceRise[i]=sc.nextBoolean();
}
while(opChoice!=6)
{
System.out.println("Enter the operation you want to perform: ");
System.out.println("1.Display the companies stock prices in ascending order:");
System.out.println("2.Display the companies stock prices in descending order:");
System.out.println("3.Display the total no of companies for which stock prices rose today:");
System.out.println("4.Display the total no of companies for which stock prices declined today:");
System.out.println("5.Search a specific stock price:");
System.out.println("6.Press 0 to exit:");
System.out.println("---------------------------");
opChoice=sc.nextInt();
switch(opChoice)
{

	case 1:System.out.println("Stock prices in ascending order:");
       quickAsc(sharePrice,0,n-1);
       printArr(sharePrice,n);
       break;
       
        
	case 2:System.out.println("Stock prices in descending order:");
       quickDesc(sharePrice,0,n-1);
       printArr(sharePrice,n);
       break;
                
	case 3:System.out.println("Total no of companies for which the stock price rose today:");
       for(i=0;i<n;i++) {
    	   
       if(priceRise[i]==true)
        countT++;
       }
       System.out.println(countT);
       break;
       
	case 4:System.out.println("Total no of companies for which the stock price rose today:");
       for(i=0;i<n;i++) {
    	   
       if(priceRise[i]==false)
        countF++;
       }
       System.out.println(countF);
       break; 
                
	case 5:System.out.println("Enter the key value: ");
       double key = sc.nextDouble();
       int result = linearSearch(sharePrice,n,key);
       if(result==-1)
       System.out.println("Value not found");
       else
       System.out.println("Stock of value "+key+" is present");
       break;
       
	case 6:System.out.println("Exited Successfully!");
       System.exit(1);
       

}
}
}
}