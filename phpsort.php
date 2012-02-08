<?

function qsort($len)
{
   // Sample data
   $a = array();

   for ($i = 0 ; $i < $len ; $i++)
   {
      $a[$i] = floor(rand(0, $len));

      if ($i % 2 == 0)
      {
         $a[$i] = -1 * $a[$i];
      }
   }

   $start = microtime(true);
   sort($a, SORT_NUMERIC);
   $diff = microtime(true) - $start;

   for ($i = 1 ; $i < count($a) ; $i++)
   {
      if ($a[$i-1] > $a[$i])
      {
         die("failed to sort!!");
      }
   }

   return $diff;
}

if (count($argv) != 2)
{
   die("usage: php -q phpsort.php ARRAY_LENGTH");
}

$len = $argv[1];


$min = PHP_INT_MAX;

for ($i = 0 ; $i < 5 ; $i++)
{
   $time = qsort($len);

   if ($time < $min)
   {
      $min = $time;
   }
}

echo "PHP sort api: " . round($min*1000) . " ms (" . $len . ")\n" ;

?>