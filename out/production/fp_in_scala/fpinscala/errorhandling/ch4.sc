import fpinscala.errorhandling._

object ch4 {

  val z = Some(2)
  val x  = None

  z.map(x => x + 2)
  x.map(x => x)

  z.getOrElse(999)
  x.getOrElse(999)

  z.flatMap(x => Some(x + 10))
  x.flatMap(x => None)


}