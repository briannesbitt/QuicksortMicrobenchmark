public class Quicksort
{
   public static void swap(int[] arr, int i, int j)
   {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public static void quicksort(int[] arr, int left, int right)
   {
      int pivot = arr[(left + right) >> 1];
      int i = left;
      int j = right;
      while (i <= j)
      {
         while (arr[i] < pivot)
            i++;
         while (arr[j] > pivot)
            j--;
         if (i <= j)
         {
            swap(arr, i++, j--);
         }
      }
      if (left < j)
      {
         quicksort(arr, left, j);
      }
      if (i < right)
      {
         quicksort(arr, i, right);
      }
   }

   public static long sort(int len)
   {
      int[] arr = new int[len];
      for (int i = 0; i < arr.length; i++)
      {
         arr[i] = (int)(Math.random() * len);
         if (i % 2 == 0)
         {
            arr[i] = -arr[i];
         }
      }

      long start = System.currentTimeMillis();
      quicksort(arr, 0, arr.length - 1);
      long diff = System.currentTimeMillis() - start;

      for (int i = 1 ; i < arr.length ; i++)
      {
         if (arr[i-1] > arr[i])
         {
            throw new AssertionError("not sorted!!");
         }
      }

      return diff;
   }

   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java Quicksort ARRAYLENGTH");
         System.exit(1);
      }

      int len = Integer.parseInt(args[0]);

      long time = Long.MAX_VALUE;
      
      for (int i = 0 ; i < 5 ; i++)
      {
         time = Math.min(time, sort(len));
      }

      System.out.println("java " + Quicksort.class.getName() + ": " + time + " ms (" + len + ")");
   }
}