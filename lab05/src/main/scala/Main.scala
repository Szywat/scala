import scala.annotation.tailrec

def oczyść[A](l: List[A]): List[A] = {
    @tailrec
    def helper(l: List[A], acc: List[A]): List[A] = l match {
      case Nil => acc.reverse
      case h :: t => if h == acc(0) then helper(t, acc) else helper(t, h :: acc)
    }
    helper(l, List(l(0)))
}

@main
def zadanie_01: Unit = {
  val lista = List(1, 1, 2, 4, 4, 4, 1, 3)
  println(oczyść(lista))
}

def skompresuj[A](l: List[A]): List[(A, Int)] =
  @tailrec
  def helper(l: List[A], acc: List[(A, Int)], ciag: (A, Int)): List[(A, Int)] = l match {
    case Nil => acc :+ ciag
    case h :: t => if h == ciag._1 then helper(t, acc, (h, ciag._2 + 1)) else helper(t, acc :+ ciag, (h,1))
  }

  l match {
  case Nil => Nil
  case h :: t => helper(t, Nil, (h, 1))
}

@main
def zadanie_02: Unit = {
  val lista = List('a', 'a', 'b', 'c', 'c', 'c', 'a', 'a', 'b', 'd')
  println(skompresuj(lista)) // ==> List(('a', 2), ('b', 1), ('c', 3), ('a', 2), ('b', 1), ('d', 1))
}


def isOrdered[A](leq: (A, A) => Boolean)(l: List[A]): Boolean = l match {
  case Nil => true
  case _ :: Nil => true
  case x :: y :: t => if leq(x,y) then isOrdered(leq)(y :: t) else false
}

@main
def zadanie_03: Unit = {
  val lt = (m: Int, n: Int) => m < n
  val lte = (m: Int, n: Int) => m <= n
  val lista = List(1, 2, 2, 5)
  println(isOrdered(lt)(lista)) // ==> false
  println(isOrdered(lte)(lista)) // ==> true
}

def applyForAll[A, B](f: A => B)(l: List[A]): List[B] = {
    @tailrec
    def helper(l: List[A], acc: List[B]): List[B] = l match {
      case Nil => acc
      case h :: t => helper(t, acc :+ f(h))
    }
    helper(l, Nil)
}

@main
def zadanie_04: Unit = {
  val lista = List(1, 3, 5)
  val f = (n: Int) => n + 3
  println(applyForAll(f)(lista)) // ==> List(4, 6, 8)
}