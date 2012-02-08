public class ArrayApi
{
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
      java.util.Arrays.sort(arr);
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
      int len = 10;

      if (args.length != 1)
      {
         System.err.println("usage: java ArrayApi ARRAYLENGTH");
         System.exit(1);
      }

      len = Integer.parseInt(args[0]);

      long time = Long.MAX_VALUE;
      
      for (int i = 0 ; i < 5 ; i++)
      {
         time = Math.min(time, sort(len));
      }

      System.out.println("java " + ArrayApi.class.getName() + ": " + time + " ms (" + len + ")");
   }
}