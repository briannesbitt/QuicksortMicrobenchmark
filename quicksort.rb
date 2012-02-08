require "benchmark"

def swap(arr, i, j)
   temp = arr[i]
   arr[i] = arr[j]
   arr[j] = temp
end

def quicksort(arr, left, right)
  pivot = arr[(left + right) >> 1]
  i = left
  j = right

  while i <= j
    while arr[i] < pivot
      i += 1
    end
    while arr[j] > pivot
      j -= 1
    end

    if i <= j
      swap arr, i, j
      i += 1
      j -= 1
    end
  end

  if left < j
    quicksort arr, left, j
  end

  if i < right
    quicksort arr, i, right
  end
end

def doSort(len)
   arr = Array.new(len)

   for i in 0 ... arr.size
     arr[i] = Random.rand(len)
     if i % 2 == 0
       arr[i] = -1 * arr[i]
     end
   end

   ms = Benchmark.realtime do
     quicksort arr, 0, arr.size - 1
   end
   
   for i in 1...arr.size
     if arr[i-1] > arr[i]
       abort("not sorted !!")
     end
   end

   ms * 1000
end

abort("Usage: ruby quicksort.rb ARRAYLENGTH") unless ARGV.length == 1

len = ARGV[0].to_i
min = 9999999999

for i in 1..5
  t = doSort(len)

  if t < min
    min = t
  end
end

puts "ruby quicksort: " + min.to_s + " ms"