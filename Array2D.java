import java.util.Scanner;

public class Array2D
{
   public static void main(String args[])
   {
       int row, col, m, n;
       int arr[][] = new int[100][100];
       Scanner sobj = new Scanner(System.in);
	   
       System.out.print("Enter row for the array : ");
       row = sobj.nextInt();
       System.out.print("Enter column for the array : ");
       col = sobj.nextInt();
	   
       
       System.out.println("Enter " +(row*col)+ " Array Elements : ");
       for(m=0; m<row; m++)
       {
           for(n=0; n<col; n++)
           {
               arr[m][n] = sobj.nextInt();
           }
       }
	   
       System.out.print("The Array is :\n");
       for(m=0; m<row; m++)
       {
           for(n=0; n<col; n++)
           {
               System.out.print(arr[m][n]+ "  ");
           }
           System.out.println();
       }
   }
}
