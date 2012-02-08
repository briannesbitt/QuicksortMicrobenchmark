require "benchmark"

def doSort(len)
   arr = Array.new(len)

   for i in 0 ... arr.size
     arr[i] = Random.rand(len)
     if i % 2 == 0
       arr[i] = -1 * arr[i]
     end
   end

   ms = Benchmark.realtime do
     arr.sort!
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