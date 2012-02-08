<?

function swap(&$arr, $i, $j)
{
   $temp = $arr[$i];
   $arr[$i] = $arr[$j];
   $arr[$j] = $temp;
}

function quicksort(&$arr, $left, $right)
{
   $pivot = $arr[($left + $right) >> 1];
   $i = $left;
   $j = $right;

   while ($i <= $j)
   {
      while ($arr[$i] < $pivot)
      {
        $i++;
      }

      while ($arr[$j] > $pivot)
      {
         $j--;
      }

      if ($i <= $j)
      {
         swap($arr, $i++, $j--);
      }
   }
  
   if ($left < $j)
   {
      quicksort($arr, $left, $j);
   }

   if ($i < $right)
   {
      quicksort($arr, $i, $right);
   }
}

function qsort($len)
{
   // Sample data
   $arr = array();

   for ($i = 0 ; $i < $len ; $i++)
   {
      $arr[$i] = floor(rand(0, $len));

      if ($i % 2 == 0)
      {
         $arr[$i] = -1 * $arr[$i];
      }
   }

   $start = microtime(true);
   quicksort($arr, 0, count($arr) - 1);
   $diff = microtime(true) - $start;

   for ($i = 1 ; $i < count($arr) ; $i++)
   {
      if ($arr[$i-1] > $arr[$i])
      {
         die("failed to sort!!");
      }
   }

   return $diff;
}

if (count($argv) != 2)
{
   die("usage: php -q quicksort.php ARRAY_LENGTH");
}

$len = $argv[1];

$min = PHP_INT_MAX;

for ($i = 0 ; $i < 3 ; $i++)
{
   $time = qsort($len);

   if ($time < $min)
   {
      $min = $time;
   }
}

echo "PHP quicksort: " . round($min*1000) . " ms (" . $len . ")\n" ;

?>