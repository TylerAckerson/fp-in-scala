object MyModule {

  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  private def printAbs(n: Int) = {
    val msg = "The absolute value of %d is %d."
    msg.format(n, abs(n))
  }

  def main(args: Array[String]): Unit =
    println(printAbs(-42))

}

object TestFib {

  def fib(n: Int): Int = {

    @annotation.tailrec
    def go(n: Int, prev: Int, cur: Int): Int =
      if (n < 1) prev
      else go(n - 1, cur, cur + prev)

    go(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    println("Expected: 0, 1, 1, 2, 3, 5, 8")
    println("Actual:   %d, %d, %d, %d, %d, %d, %d".format(fib(0), fib(1), fib(2), fib(3), fib(4), fib(5), fib(6)))
  }
}

object TestSorted {

  def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {

    @annotation.tailrec
    def loop(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if (gt(as(n),as(n + 1))) loop(n + 1)
      else false
    }

    loop(0)
  }

}

object Curry {
  // Note that `=>` associates to the right, so we could
  // write the return type as `A => B => C`
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    a => (b => f(a, b))

  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C =
    a => f(g(a))

  def andThen[A,B,C](f: A => B, g: B => C): A => C =
    a => g(f(a))

  }
