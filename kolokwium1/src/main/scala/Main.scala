import scala.annotation.tailrec

def myHead(l: List[Int]): Int = l match {
  case Nil => -1
  case h :: t => h
}

def myTail(l: List[Int]): List[Int] = l match {
  case Nil => Nil
  case h :: t => t
}

def myReverse(l: List[(Int,Int)]): List[(Int, Int)] = {
  @tailrec 
  def helper(l: List[(Int,Int)], acc: List[(Int,Int)]): List[(Int,Int)] = l match {
    case Nil => acc
    case h :: t => helper(t, h :: acc)
  }
  helper(l, Nil)
}

def wystąpienia(arg: List[Int]): List[(Int,Int)] = {
  @tailrec
    def helper(arg: List[Int], acc: List[(Int, Int)], uniq: List[Int], tuple: (Int, Int), copy: List[Int]): List[(Int, Int)] = arg match {
      case Nil => if uniq.isEmpty then tuple :: acc else helper(copy, tuple :: acc, myTail(uniq), (myHead(uniq), 0), copy)
      case h :: t => if h == tuple._1 then helper(t, acc, uniq, (tuple._1, tuple._2+1), copy) else helper(t, acc, uniq, (tuple._1, tuple._2), copy)
    }
    myReverse(helper(arg, Nil, myTail(arg.toSet.toList), (myHead(arg), 0), arg))

}

@main
def zadanie_01: Unit = {
  val lista = List(1,2,3,3,2,1)
  println(wystąpienia(lista)) // ==> true
}
