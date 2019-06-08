import java.util.*;
import java.io.*;

public class SudokuMatrix
{
	static int[][]a= new int[9][9];
	static String sudokuMatrix= new String();
	
	
	public static void generate()
	{
	   int k=1,n=1;
	   for(int i=0;i<9;i++)
	   {
	      k=n;
	      for(int j=0;j<9;j++)
	      {
	          if(k<=9)
	          {
	              a[i][j]=k;
	              k++;
	          }
	          else
	          {
	           k=1;
	           a[i][j]=k;
	           k++;
	          }
	      }
	      n=k+3;
	      if(k==10)
	      n=4;
	      if(n>9)
	      n=(n%9)+1;
	   }
	   
	}
	
	
	public static void random_gen(int check){
		int k1,k2,max=2,min=0;
		Random r= new Random();
		   for(int i=0;i<3;i++)
		   {
		//There are three groups.So we are using for loop three times.
		      k1=r.nextInt(max-min+1)+min;
		//This while is just to ensure k1 is not equal to k2.
		      do{
		         k2=r.nextInt(max-min+1)+min;
		      }while(k1==k2);
		      max+=3;min+=3;
		//check is global variable.
		//We are calling random_gen two time from the main func.
		//Once it will be called for columns and once for rows.
		      if(check==1)
		//calling a function to interchange the selected rows.
		      permutation_row(k1,k2);
		      else if(check==0)
		      permutation_col(k1,k2);
		      }
		   }
	
	public static void permutation_row(int k1,int k2){
		int temp;//k1 and k2 are two rows that we are selecting to interchange.
		   for(int j=0;j<9;j++)
		   {
		      temp=a[k1][j]; 	
		      a[k1][j]=a[k2][j];
		      a[k2][j]=temp;
		   }
		}
	
	 public static void permutation_col(int k1,int k2){
		 int temp;
		    for(int j=0;j<9;j++)
		    {
		       temp=a[j][k1];
		       a[j][k1]=a[j][k2];
		       a[j][k2]=temp;
		    }
		 }
	 public static void row_change(int k1,int k2)
	 {
	    int temp;
	    for(int n=1;n<=3;n++)
	    {
	       for(int i=0;i<9;i++)
	       {
	          temp=a[k1][i];
	          a[k1][i]=a[k2][i];
	          a[k2][i]=temp;
	       }
	       k1++;
	       k2++;
	    }
	 }
	 public static void col_change(int k1,int k2)
	 {
	    int temp;
	    for(int n=1;n<=3;n++)
	    {
	       for(int i=0;i<9;i++)
	       {
	          temp=a[i][k1];
	          a[i][k1]=a[i][k2];
	          a[i][k2]=temp;
	       }
	       k1++;
	       k2++;
	    }
	    System.out.println("");
	 /*   for(int i=0;i<9;i++)
		   {
		      for(int j=0;j<9;j++)
		      {
		         System.out.print(a[i][j]+" "+ "|" +" ");
		      }
		      System.out.println("");
		   } */
		   
		   
	 }
	 

	 public static String sudokuGenerator()
	 {	
		   

		 int counter=1;
	 int k1,k2;
	 
		 generate();
		 random_gen(1);	
		 random_gen(0);
		 
		 
		 
		 Random rand=new Random();
		   int n[]={0,3,6};
		   for(int i=0;i<2;i++)
		   {
		      k1=n[rand.nextInt(n.length)];
		      do{
		         k2=n[rand.nextInt(n.length)];
		      }while(k1==k2);
		      if(counter==1)
		      row_change(k1,k2);
		      else col_change(k1,k2);  
		      counter++;
		    }
		   
		   int max=8;
		    int min=0;

		    //Striking out
		    int R[]={0,1,2,3,4,5,6,7,8};
		    int i1,j1, random;
		    for (i1=0;i1<9;i1++)
		    { for (j1=0;j1<6;j1++)
		    	{random=R[rand.nextInt(R.length)];
		    	a[i1][random]=0;
		    
		    }
		    }
		    
		    for(int i=0;i<9;i++)
		     {
		        for(int j=0;j<9;j++)
		        {
		           sudokuMatrix=sudokuMatrix+Integer.toString(a[i][j])+"/";
		        }
		        
		     }			
		    
		    return sudokuMatrix;
		  
		    
		    /*for(k1=0;k1<9;k1++)
		    {
		       for(k2=0;k2<9;k2++)
		       strike_out(k1,k2);
		     }
		     System.out.println(); */
		    /* for(int i=0;i<9;i++)
		     {
		        for(int j=0;j<9;j++)
		        {
		           System.out.print(a[i][j]+"\t");
		        }
		        System.out.println("");
		     }			*/							
		  
		   
		   
	 }



}
