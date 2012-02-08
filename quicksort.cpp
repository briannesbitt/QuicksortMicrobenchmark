#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <time.h>

using namespace std;

LARGE_INTEGER timerFreq;
LARGE_INTEGER counterAtStart;

void start_time()
{
   QueryPerformanceFrequency(&timerFreq);
   QueryPerformanceCounter(&counterAtStart);
}

unsigned int get_time()
{
   if (timerFreq.QuadPart == 0)
   {
     return -1;
   }
   else
   {
      LARGE_INTEGER c;
      QueryPerformanceCounter(&c);
      return static_cast<unsigned int>( (c.QuadPart - counterAtStart.QuadPart) * 1000 / timerFreq.QuadPart );
  }
}

void swap(int* arr, int i, int j)
{
   int temp = arr[i];
   arr[i] = arr[j];
   arr[j] = temp;
}

void quick_sort(int* arr, int left, int right)
{
   int middle = (left + right) / 2;
   int pivot = arr[middle];
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
      quick_sort(arr, left, j);   
   }
   if (i < right)
   {
      quick_sort(arr, i, right);   
   }
}

unsigned int sort(int len)
{
   int* arr = (int*)malloc(sizeof(int) * (len+1));
   arr[len] = NULL;

   for (int i = 0; i < len; i++)
   {
      arr[i] = (rand() % len);

      if (i % 2 == 0)
      {
         arr[i] = -arr[i];
      }
   }

   unsigned int start = get_time();
   quick_sort(arr, 0, len - 1);
   unsigned int diff = get_time() - start;

   for (int i = 1 ; i < len ; i++)
   {
      if (arr[i-1] > arr[i])
      {
         printf("not sorted!!");
         exit(1);
      }
   }

   free(arr);

   return diff;
}

int main(int argc, char **argv)
{
   timeBeginPeriod(1);
   start_time();

   srand((unsigned int)time(NULL));

   unsigned int min = 999999;
   unsigned int time;

   if (argc != 2)
   {
      printf("Usage: quicksort.exe ARRAYLENGTH");
      exit(1);
   }

   int len = atoi(argv[1]);

   for (int i = 0 ; i < 5 ; i++)
   {
      time = sort(len);
      if (time < min)
      {
         min = time;
      }
   }

   printf("c quicksort: %i (%i)", min, len);

   timeEndPeriod(1);

   return 0;
}
