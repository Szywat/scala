error id: file://<WORKSPACE>/zadania_domowe/src/main/scala/Main.scala:[858..858) in Input.VirtualFile("file://<WORKSPACE>/zadania_domowe/src/main/scala/Main.scala", "import scala.annotation.tailrec

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


def coDrugi(f: Int => Int)(l: List[Int]): List[Int] = {
  @tailrec
  def helper(l: List[Int], acc: List[Int], ind: Int): List[Int] = l match {
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


def   ")
file://<WORKSPACE>/zadania_domowe/src/main/scala/Main.scala
file://<WORKSPACE>/zadania_domowe/src/main/scala/Main.scala:38: error: expected identifier; obtained eof
def   
      ^
#### Short summary: 

expected identifier; obtained eof