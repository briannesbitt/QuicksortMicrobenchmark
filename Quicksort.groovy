def swap(arr, i, j) {
   temp = arr[i]
   arr[i] = arr[j]
   arr[j] = temp
}

def quicksort(arr, left, right) {
   pivot = arr[(left+right) >> 1 ]
   i=left
   j=right
   while (i<=j) {
      while (arr[i] < pivot) i++
      while (arr[j] > pivot) j--
      if (i <= j) {
         swap(arr, i, j)
         i++
         j--
      }
   }
   if (left < j) quicksort(arr, left, j)
   if (right > i) quicksort(arr, i, right)
}

def doSort(len) {

   // Sample data
   arr = new int[len]
   arr.eachWithIndex { x, i ->
      arr[i] = Math.random() * len
      if (i % 2 == 0) arr[i] = -arr[i]
   }

   start = System.currentTimeMillis()
   quicksort(arr, 0, arr.length-1)
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

System.out.println("groovy quicksort: " + min + " ms (" + len + ")");