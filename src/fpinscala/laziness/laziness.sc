import fpinscala.laziness._

import scala.collection.immutable.Stream.cons

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

}