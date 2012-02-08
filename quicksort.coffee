assert = require 'assert'

Array.prototype.swap = (i, j) -> 
  temp = @[i]
  @[i] = this[j]
  @[j] = temp

quicksort = (arr, l = 0, r = arr.length - 1) ->
  pivot = arr[Math.floor((l+r) / 2)]
  i = l
  j = r

  while i <= j
    i++ while arr[i] < pivot
    j-- while arr[j] > pivot
    arr.swap i++, j-- if i <= j
      
  quicksort arr, l, j if l < j
  quicksort arr, i, r if r > i

sort = (len) ->
  a = []
  for i in [0...len]
    a.push Math.floor Math.random() * len
    if i % 2 == 0
      a[i] = -a[i]

  start = Date.now()
  quicksort a
  diff = Date.now() - start

  #test
  assert.ok a[i-1] <= a[i] for i in [1...a.length]

  diff

len = process.argv[2]

if not len?
  console.log "usage: coffee quicksort.coffee ARRAYLENGTH"
  process.exit 1

min = Number.MAX_VALUE

for i in [1..5]
  time = sort len
  min = time if time < min

console.log "node.js/v8 quicksort: " + min + " ms (" + len + ")"