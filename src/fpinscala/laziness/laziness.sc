import fpinscala.laziness._

object laziness {

  val s = Stream(1, 2, 3, 4)
  val odds = Stream(1, 3, 5, 7)
  val evens = Stream(2, 4, 6, 8)

  s.toList

  (s take 2).toList
  (s drop 2).toList

  (s takeWhile(_ < 4)).toList

  s.forAll(_ < 4)
  odds.forAll(_ % 2 != 0)
  evens.forAll(_ % 2 == 0)

  (odds takeWhileFold(_ < 6)).toList

  odds.headOption
  Empty.headOption

  odds.map(_+1).toList == evens.toList
  s.map(_+10).map(_.toString()).toList

  odds.filter(_ % 2 != 0).toList
  evens.filter(_ < 5).toList

  (odds append evens).toList

  s.flatMap(x => if (x % 2 == 0) Stream(x) else Empty).toList
  odds.flatMap(x => if (x % 3 == 0) Stream(x) else Empty).toList

  val ones: Stream[Int] = Stream.cons(1, ones)

  ones.take(5).toList
  ones.exists(_ == 1)
  ones.map(_ + 1).exists(_ % 2 == 0)
  ones.takeWhile(_ == 1)
  ones.forAll(_ != 1)

  val twos: Stream[Int] = Stream().constant(2)
  twos.take(3).toList

  val hundyPlus: Stream[Int] = Stream().from(100)
  hundyPlus.take(3).toList

  val fibs: Stream[Int] = Stream().fibs()
  fibs.take(7).toList // 0, 1, 1, 2, 3, 5, 8,

  Stream().fibsUnfold.take(7).toList
  Stream().onesUnfold.take(3).toList
  Stream().constantUnfold(2).take(4).toList
  Stream().fromUnfold(5).take(3).toList

}