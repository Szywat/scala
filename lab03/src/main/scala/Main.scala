import scala.annotation.tailrec
import scala.compiletime.ops.string

def reverse(str: String): String = {
  @tailrec
    def helper(str: String, acc: String): String = {
      if str.isEmpty() then acc
      else helper(str.tail, str.head + acc)
    }
    helper(str, "")
}

@main
def zadanie_01(str: String): Unit = {
    println(reverse(str))
}

def pierwsza(n: Int): Boolean = {
  @tailrec
  def helper(n: Int, acc: Int): Boolean = {
    if n == 2 then true
    else if n < 2 || n % acc == 0 then false
    else if acc >= ((n/2) +1) then true 
    else helper(n, acc + 1)
  }
  helper(n, 2)
}

@main
def zadanie_02(n: Int): Unit = {
  println(pierwsza(n))
}

def ciąg(n: Int): Int = {
    @tailrec
    def helper(n: Int, acc: Int, prev: Int): Int = {
      if n == 0 then prev
      else helper(n-1, acc + prev, acc)
    }
    helper(n, 1, 2)
}

@main
def zadanie_03(n: Int): Unit = {
  println(ciąg(n))
}



def tasuj(l1: List[Int], l2: List[Int]): List[Int] = {
    @tailrec
      def helper01(l1: List[Int], l2: List[Int], acc: List[Int]): List[Int] = {
        if l1 == Nil && l2 == Nil then helper02(acc, Nil)
        else if l1 == Nil then helper02(acc.concat(l2), Nil)
        else if l2 == Nil then helper02(acc.concat(l1), Nil)
        else if l1.head > l2.head then helper01(l1, l2.tail, acc :+ l2.head)
        else if l2.head > l1.head then helper01(l1.tail, l2, acc :+ l1.head)
        else helper01(l1.tail, l2.tail, acc :+ l1.head)
        
      }
      def helper02(acc: List[Int], prev: List[Int]): List[Int] = {
        if acc == Nil then prev.reverse
        else if prev == Nil then helper02(acc.tail, acc.head :: prev)
        else if acc.head != prev.head then helper02(acc.tail, acc.head :: prev)
        else helper02(acc.tail, prev)
      }
      helper01(l1, l2, Nil)
}

@main
def zadanie_04: Unit = {
  val lista1 = List(2, 4, 3, 5)
  val lista2 = List(1, 2, 2, 3, 1, 5)
  println(tasuj(lista1, lista2))
}