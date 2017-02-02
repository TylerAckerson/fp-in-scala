package fpinscala.laziness

import Stream._

object funLaziness {

  trait Stream[+A] {

//    def toList: List[A] = ???


  }

  val a = Stream(List(1,2,3,4,5))
  a

}