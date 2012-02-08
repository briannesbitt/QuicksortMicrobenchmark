using System;

public class Quicksort
{
   public static void Swap(int[] arr, int i, int j)
   {
      var temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public static void Qsort(int[] arr, int left, int right)
   {
      var pivot = arr[(left + right) >> 1];
      var i = left;
      var j = right;
      while (i <= j)
      {
         while (arr[i] < pivot)
            i++;
         while (arr[j] > pivot)
            j--;
         if (i <= j)
         {
            Swap(arr, i++, j--);
         }
      }
      if (left < j)
      {
         Qsort(arr, left, j);
      }
      if (i < right)
      {
         Qsort(arr, i, right);
      }
   }

   public static double Sort(int len)
   {
      var arr = new int[len];
      var random = new Random();
      for (var i = 0; i < arr.Length; i++)
      {
         arr[i] = (int)(random.Next(len));
         if (i % 2 == 0)
         {
            arr[i] = -arr[i];
         }
      }

      var start = DateTime.Now;
      Qsort(arr, 0, arr.Length - 1);
      var diff = DateTime.Now - start;

      for (var i = 1 ; i < arr.Length ; i++)
      {
		  if (arr[i-1] > arr[i])
		  {
	         Console.WriteLine("not sorted!!");
	         Environment.Exit(1);
		  }
      }

      return diff.TotalMilliseconds;
   }

   public static void Main(string[] args)
   {
      if (args.Length != 1)
      {
         Console.WriteLine("usage: Quicksort ARRAYLENGTH");
         Environment.Exit(1);
      }

      var len = int.Parse(args[0]);

      var time = double.MaxValue;
      
      for (var i = 0 ; i < 5 ; i++)
      {
         time = Math.Min(time, Sort(len));
      }

      Console.WriteLine("C# quicksort: " + time + " ms (" + len + ")");
   }
}