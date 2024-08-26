import scala.annotation.tailrec
def sumuj(l: List[Option[Double]]): Option[Double] = {
    @tailrec
    def helper(l: List[Option[Double]], acc: Double): Option[Double] = 
      l match {
        case Nil => Some(acc)
        case Some(h) :: t => helper(t, acc + h) // Some => cokolwiek
        case None :: t => helper(t, acc)
    }
    helper(l, 0.0)
}


@main
def zadanie_01: Unit = {
  val lista = List(Some(4.0), Some(-3.0), None, Some(1.0), Some(0.0))
  println(sumuj(lista))
}


def maksimum(l1: List[Double], l2: List[Double]): List[Double] = {
    @tailrec
    def helper(l1: List[Double], l2: List[Double], acc: List[Double]): List[Double] = 
      (l1, l2) match {
        case (Nil, Nil) => acc
        case (l1, Nil) => acc.concat(l1)
        case (Nil, l2) => acc.concat(l2)
        case (h1 :: t1, h2 :: t2) => if h1 > h2 then helper(t1, t2, acc :+ h1) else helper(t1, t2, acc :+ h2)
    }
    helper(l1, l2, Nil)
}

@main
def zadanie_02: Unit = {
  val lista1 = List(2.0, -1.6, 3.2, 5.4, -8.4)
  val lista2 = List(3.3, -3.1, 3.2, -4.1, -0.4, 5.5)

  println(maksimum(lista1, lista2))
}

def usun[A](l: List[A], el: A): List[A] = {
    @tailrec
    def helper(l: List[A], el: A, acc: List[A]): List[A] = l match {
        case Nil => acc
        case h :: t => if h != el then helper(t, el, acc :+ h) else helper(t, el, acc)
      }
    helper(l, el, Nil)
}


@main
def zadanie_03: Unit = {
  val lista = List(2, 1, 4, 1, 3, 3, 1, 2)

  println(usun(lista, 1)) // ==> List(2, 4, 3, 3, 2)
}

def divide[A](l: List[A]): (List[A], List[A]) = {
    @tailrec
    def helper(l: List[A], parz: List[A], niep: List[A], ind: Int): (List[A], List[A]) = l match {
      case Nil => (parz, niep)
      case h :: t => if ind % 2 == 0 then helper(t, parz :+ h, niep, ind + 1) else helper(t, parz, niep :+ h, ind + 1)
    }
    helper(l, Nil, Nil, 0)
}

@main
def zadanie_04: Unit = {
  val lista = List(1, 3, 5, 6, 7)

  println(divide(lista)) // ==>  ( List(1, 5, 7), List(3, 6) ).
}

type Pred[A] = A => Boolean

def and[A](p: Pred[A], q: Pred[A]): Pred[A] = {
    a => p(a) && q(a)
}

def or[A](p: Pred[A], q: Pred[A]): Pred[A] = {
    a => p(a) || q(a)
}

def not[A](p: Pred[A]): Pred[A] = {
    a => !p(a)
}

def imp[A](p: Pred[A], q: Pred[A]): Pred[A] = {
    a => p(a) || !q(a)
}

