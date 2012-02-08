assert = require 'assert'

sort = (len) ->
  a = []
  for i in [0...len]
    a.push Math.floor Math.random() * len
    if i % 2 == 0
      a[i] = -a[i]

  start = Date.now()
  b = a.sort (a,b) -> a - b
  diff = Date.now() - start

  #test
  assert.ok b[i-1] <= b[i] for i in [1...b.length]

  diff

len = process.argv[2]

if not len?
  console.log "usage: coffee sortapi.coffee ARRAYLENGTH"
  process.exit 1

min = Number.MAX_VALUE

for i in [1..5]
  time = sort len
  min = time if time < min

console.log "node.js/v8 api: " + min + " ms (" + len + ")"