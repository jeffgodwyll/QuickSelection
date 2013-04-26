
	//Program to compute the ith statistic of an array!
	// It returns the ith smallest element of the array.
	// It selects a pivot uniformly at random and partition the array 
	// around the pivot with all elements less than the pivot on the left of
	// the pivot and all elements greater than the pivot to the right of the
	// pivot!
	// Then it checks if the index is equal to the pivot and returns the pivot if
	// it is!
	// If the pivot is greater than (>) index, it recurses on the left partition.
	// if the pivot is less than (<) index it recurses on the right partition 
	// rselect returns the ith statistic of the array! i.e the ith smallest 
	// element of the array!


import java.util.Scanner;
public class midsemMain {
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

	  
	  
	 System.out.println (" Enter Size of Array : ");
	 int sizeOfArray = input.nextInt(); // size of input array} 
	

	 int arraySize = sizeOfArray;

	 int[] array = new int[arraySize] ; //  array or list declaration which will hold the numbers to be sorted


	 // test for empty array
	 if ( arraySize > 0)
	   System.out.println (" Enter " + arraySize + " array elements :");
	 

	  

	  for ( int i = 0; i < arraySize; i++)
	    array[i] = input.nextInt(); 


	  System.out.println();

	  System.out.println (" Array before Sorting ");


	  for ( int i = 0; i < arraySize; i++)
	    System.out.println (array[i] + "   ");


	  System.out.println();

	  int l = 0; // start array index
	  int r = arraySize - 1; // end of array index
	  int index;
	  System.out.println (" Enter index of element : ");
	  index = input.nextInt();
	 

	   int ithStat =  rSelection( array, l, r, index - 1 );

	   System.out.println ("\n\n\n");

	   if ( ithStat != -11111)
	     System.out.println (index + "_th Statistic = : " + ithStat);

	  System.out.println ("\n\n");

	  for ( int i = 0; i < arraySize; i++)
	   System.out.println (array[i] + "   ");
	  System.out.println();
	   
	}
	


	// function rSelection definition!

	static int rSelection( int array[], int l, int r, int index)
	{

	  // select pivot element randomly!!
	 
	  int pivotPt;

	  // Perform data validation:
	  if ( l > r )
	    {
	    System.out.println ("Invalid array index! Left index > Right index");
	    return -11111;
	    }

	  else if ( ( index > r ) || ( index < l ))
	    {
	    System.out.println ((index + 1) + "_th Statistic is outside array domain");
	    return -11111;
	    } 

	  if ( l < r )
		  //pivot value is approximately the middle value
		  pivotPt = (l+r)/2;
	  else
	    pivotPt = l;

	  int pst = partitions( array, l, r, pivotPt );

	  // Return solution if found   

	  if ( pst == index )
	    return array[pst];


	   // recursively do rSelection on left array

	  if ( pst >  index  )
	      return  rSelection( array, l, pst-1, index);
	   

	      // recursively do rSelection on the right array

	  if (  pst <  index )
	      return  rSelection( array, pst + 1, r, index );
	 
	return 0;  
	}



	static int partitions( int array[], int l, int r, int pvt)
	{

	  // swap pivot with first element!
	 int tmp ;
	 int pivot = array[pvt];
	  array[pvt] = array[l];

	  // int pivot = array[l];
	  int i = l + 1;
	  while ( ( array[i] < pivot ) && ( i <  r + 1 ))
	    i++;
	  int jstart = i;
	 

	  // start partitions algorithm

	  for ( int j = jstart; j < r+1; j++)
	    {
	      if ( array[j] < pivot )
		{
		  tmp = array[i];
		  array[i] = array[j];
		  array[j] = tmp;
		  i++;
		}
	    }

	      // swap pivot
	      array[l] = array[i-1];
	      array[i-1] = pivot;
	      return i-1;

	}


}
