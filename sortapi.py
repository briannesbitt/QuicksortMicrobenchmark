import sys
import time
import random

def doSort(arrlen):
  arr = [0]*arrlen

  for i in range(0, len(arr)):
    arr[i] = random.randrange(arrlen)
    if i % 2 == 0:
      arr[i] = -1 * arr[i]

  start = time.clock()
  arr.sort()
  diff = time.clock() - start
   
  for i in range(1, len(arr)):
    if arr[i-1] > arr[i]:
      print("not sorted")
      sys.exit()

  return diff

if len(sys.argv) != 2:
  print("usage: python sortapi.py ARRAYLENGTH")
  sys.exit()

alen = int(sys.argv[1])
min = 9999999999

for i in range(1, 6):
  t = doSort(alen)

  if t < min:
    min = t

print("python api sort: ", round(min*1000), " ms")