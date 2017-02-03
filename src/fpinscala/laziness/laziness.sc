import fpinscala.laziness._

object laziness {

  val s = Stream(1, 2, 3, 4)

  s.toList
  s.toList take 2

  s take 1 match { case Cons(h, t) => h() }


}