/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/FindRepetitionWithoutExtraSpace.php.html
Problem

Find repetition in multiple sorted arrays without using extra space. There are k sorted arrays. 
We have to find whether some numbers are repeating in any one of those arrays. Here k is constant and 
we are allowed extra space in the order of k as they are constant. The constraint is not to use extra space in order of the length of the arrays.
Solution

We will implement a solution which has complexity of O(n) and using O(k) extra space. At first we scan through
 individual arrays to find for repetitions. As the arrays are sorted, if there are repetitions, the numbers will be side by side.
  So we always keep on checking two adjacent elements and report the repetition.
Now the complex case is to find out repetition across the arrays. As the arrays are sorted we try to do a merge of 
the arrays like a merge sort. But only exception is we don't store the resultant array. We just keep checking the front of each arrays.
 If any repetition is found in the front of the k arrays we report them and move the corresponding arrays' pointer to the next element.
  If no repetition is found in the front row we move the pointer of the minimum number just like a merge sort. When each arrays last element
   is reached we conclude the search. In this way as we always are bothered about the front of each array, our extra space does not grow in 
   the order of total elements. It is dependent on the number of front elements only, i.e, order of k.

 */

package org.vivek.algos.arrayexamples;

public class FindRepetitionWithoutExtraSpace
{

 /**
  * @param args
  */
 public static void main(String[] args)
 {
  int[][]arr={{8,12,13,16,17,22,24,29},
    {4,8,14,16,18,23},
    {33,36,37,44,95,126},
    {5,7,15,18}};
  findRepetition(arr);
 }

 public static void findRepetition(int[][] arr)
 {
  int index[]=new int[arr.length];
  int frontNumber[]=new int[arr.length];
  int length[]=new int[arr.length];
  for(int i=0;i<arr.length;++i)
  {
   length[i]=arr[i].length;
  }
  boolean modified=true;
  while(modified)
  {
   modified=false;
   for(int i=0;i<arr.length;++i)
   {
    if(index[i]<length[i])
    {
     modified=true;
     frontNumber[i]=arr[i][index[i]];
    }
    else
    {
     frontNumber[i]=Integer.MAX_VALUE;
    }
   }
   int min=frontNumber[0];
   int minIndex=0;
   for(int i=1;i<arr.length;++i)
   {
    if(frontNumber[i]==min)
    {
     if(frontNumber[i]!=Integer.MAX_VALUE)
      System.out.println(frontNumber[i]);
     index[i]++;
    }
    else if(frontNumber[i]<min)
    {
     min=frontNumber[i];
     minIndex=i;
    }
   }
   index[minIndex]++;
  }
 }
}
    
