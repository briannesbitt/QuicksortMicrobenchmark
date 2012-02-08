import sys
import time
import random

def swap(arr, i, j):
   temp = arr[i]
   arr[i] = arr[j]
   arr[j] = temp

def quicksort(arr, left, right):
  pivot = arr[(left + right) >> 1]
  i = left
  j = right

  while i <= j:
    while (arr[i] < pivot):
      i += 1

    while arr[j] > pivot:
      j -= 1

    if i <= j:
      swap(arr, i, j)
      i += 1
      j -= 1

  if left < j:
    quicksort(arr, left, j)

  if i < right:
    quicksort(arr, i, right)


def doSort(arrlen):
  arr = [0]*arrlen

  for i in range(0, len(arr)):
    arr[i] = random.randrange(arrlen)
    if i % 2 == 0:
      arr[i] = -1 * arr[i]

  start = time.clock()
  quicksort (arr, 0, len(arr) - 1)
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

for i in range(1, 4):
  t = doSort(alen)

  if t < min:
    min = t

print("python quicksort: ", round(min*1000), " ms")