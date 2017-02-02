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

  z.orElse(Some(20))
  x.orElse(Some(20))

  z.filter(_ % 2 == 0)
  x.filter(_ == None)

//  Option.failingFn(2)
//  Option.failingFn2(4)

  Option.map2(z, z)((a, b) => a + b)
//  Option.map2(z, z)((a, b) => a + b)

}