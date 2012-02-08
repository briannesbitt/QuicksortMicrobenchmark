using System;
using System.Diagnostics;

public class Quicksort
{
   public static double Sort(int len)
   {
      var arr = new int[len];
      var random = new Random();
      for (int i = 0; i < arr.Length; i++)
      {
         arr[i] = (int)(random.Next(len));
         if (i % 2 == 0)
         {
            arr[i] = -arr[i];
         }
      }

      var start = DateTime.Now;
      Array.Sort(arr);
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
      
      for (int i = 0 ; i < 5 ; i++)
      {
         time = Math.Min(time, Sort(len));
      }

      Console.WriteLine("C# Array.Sort() api: " + time + " ms (" + len + ")");
   }
}