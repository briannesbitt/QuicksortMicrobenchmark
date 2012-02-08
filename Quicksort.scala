import java.lang.Math

object Quicksort
{
  def quicksort(xs: Array[Int])
  {
    def swap(i: Int, j: Int)
    {
      val t = xs(i);
      xs(i) = xs(j);
      xs(j) = t
    }

    def sort1(left: Int, right: Int)
    {
      val pivot = xs((left + right) >> 1)
      var i = left;
      var j = right
      while (i <= j)
      {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        if (i <= j)
        {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (left < j)
      {
        sort1(left, j)
      }
      if (right > i)
      {
        sort1(i, right)
      }
    }
    sort1(0, xs.length - 1)
  }

  def doSort(len: Int):Long = 
  {
    var i: Int = 0
    val a: Array[Int] = new Array[Int](len)

    for (e <- a)
    {
      a(i) = (Math.random() * len).asInstanceOf[Int];
      if (i % 2 == 0)
      {
        a(i) = -a(i)
      }
      i = i + 1
    }

    val start = System.currentTimeMillis()
    quicksort(a)
    val diff = System.currentTimeMillis() - start

    for (i <- 1 to a.length - 1)
    {
      if (a(i-1) > a(i))
      {
        System.err.println("did not sort")
        System.exit(1)
      }
    }

    return diff
  }

  def main(args: Array[String])
  {
    if (args.length != 1)
    {
      System.err.println("usage: scala Quicksort.scala ARRAYLENGTH")
      System.exit(1)
    }

    val len = Integer.parseInt(args(0))

    var min = Long.MaxValue
    var time : Long = 0

    for (i <- 0 to 5)
    {
      time = doSort(len)
      if (time < min)
      {
        min = time
      }
    }

    println("Scala: " + min + " ms (" + len + ")")
  }
}