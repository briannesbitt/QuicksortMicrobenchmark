def doSort(len) {

   // Sample data
   arr = new int[len]
   arr.eachWithIndex { x, i ->
      arr[i] = Math.random() * len
      if (i % 2 == 0) arr[i] = -arr[i]
   }

   start = System.currentTimeMillis()
   Arrays.sort(arr)
   ms = System.currentTimeMillis() - start

   for (i in 1..len-1) {
      assert arr[i-1] <= arr[i]
   }

   return ms
}

if (args.length != 1) {
   println "usage: groovy Quicksort.groovy ARRAYLENGTH"
   System.exit(0)
}


len = args[0].toInteger()

long min = 999999999
      
for (i in 1..3) {
   time = doSort(len)

   if (time < min) min = time
}

System.out.println("groovy sort api: " + min + " ms (" + len + ")");