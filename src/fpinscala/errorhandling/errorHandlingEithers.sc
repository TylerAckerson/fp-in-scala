import fpinscala.errorhandling._

object errorHandlingEithers {

  val a = Right(10)
  val b = Left("nope")

  a.map(_ * 2)
  b.map(x => x)

  a.flatMap(x => Right(x + 2))
  b.flatMap(x => x)

  a.orElse(Right(500))
  b.orElse(Right(500))

  a.map2(Right(50))(_+_)
  b.map2(Left(10))((e, b) => e)


//  Either.traverse(List(1,2,3))(x => Right(x))
//  Either.sequence(List(1,2,3))(x => x % 2 == 0)
}