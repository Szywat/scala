import scala.annotation.tailrec

def duplikaty[A](l: List[A]): Int = {
  @tailrec
  def helper(l: List[A], acc: Int): Int = l match {
    case Nil => acc
    case _ :: Nil => acc
    case h :: n :: t => if h == n then helper(n :: t, acc + 1) else helper(n :: t, acc)
  }
  helper(l, 0)
}

@main
def zadanie_domowe_1: Unit = {
  val lista = List(1, 1, 3, 4, 4, 1)
  println(duplikaty(lista))
}


def coDrugi[A](f: A => A)(l: List[A]): List[A] = {
  @tailrec
  def helper(l: List[A], acc: List[A], ind: Int): List[A] = l match {
    case Nil => acc
    case h :: t => if ind % 2 == 0 then helper(t, acc :+ f(h), ind + 1) else helper(t, acc :+ h, ind + 1)
  }
  helper(l, Nil, 0)
}

@main
def zadanie_domowe_2: Unit = {
  val lista = List(1, 1, 3, 4, 4, 1)
  val f = (n: Int) => n * 10
  println(coDrugi(f)(lista))
}
// nie działa dla [A, B]

def skompresuj[A](l: List[A]): List[(A, Int)] = {
    @tailrec
    def helper(l: List[A], acc: List[(A, Int)], ciag: (A, Int)): List[(A, Int)] = l match {
      case Nil => acc :+ ciag
      case h :: t => if h == ciag._1 then helper(t, acc, (h, ciag._2 + 1)) else helper(t, acc :+ ciag, (h, 1))
    }

    l match {
      case Nil => Nil
      case h :: t => helper(t, Nil, (h, 1))
    }
}

@main
def zadanie_domowe_3: Unit = {
  println()
}


def podzielnePrzez2(l: List[Int]): (Int, Int) = {
  @tailrec
  def helper(l: List[Int], tak: Int, nie: Int): (Int, Int) = l match {
    case Nil => (tak, nie)
    case h :: t => if h % 2 == 0 then helper(t, tak + 1, nie) else helper(t, tak, nie + 1)
  }
  helper(l, 0, 0)
}

@main
def zadanie_domowe_4: Unit = {
  val lista = List(1, 1, 3, 4, 4, 1)
  println(podzielnePrzez2(lista))
}

