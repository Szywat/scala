error id: file://<WORKSPACE>/lab03/src/main/scala/Main.scala:[1125..1125) in Input.VirtualFile("file://<WORKSPACE>/lab03/src/main/scala/Main.scala", "import scala.annotation.tailrec
import scala.math.sqrt

// Zadanie 01

def reverse(str: String): String = {
  @tailrec
  def helper(str: String, acc: String): String = {
    if (str.isEmpty()) {
      acc
    } else {
      helper(str.tail, str.head + acc) // akumulator będzie `jakiś` i NA POCZĄTEK dodajemy pierwszą literę reszty słowa
    }
  }
  helper(str, "")
}

@main
def zadanie_01(str: String): Unit = {
  println(reverse(str))
}

// Zadanie 02

def pierwsza(n: Int): Boolean = {
  @tailrec
  def helper(n: Int, acc: Int): Boolean = {
    if (n >= 2) {

    if (n % acc == 0 && n != acc) {
      false
    } else if (acc == sqrt(n).ceil.toInt) {
      true
    } else {
      helper(n, acc + 1)
    }
  } else {
    false
  }
  }
  helper(n, 2)
}

@main
def zadanie_02(n: Int): Unit = {
  println(n)
  println(pierwsza(n))
}

// Zadanie 03

def ciąg(n: Int): Int = {
  @tailrec
    def helper(n: Int, a: Int, b: Int): Int = {
      if n == 0 then a
      else if n == 1 then b
      else helper(n-1, b, a+b)
    }
    helper(n, 2, 1)
}

@main
def zadanie_03(n: Int): Unit = {
  println(ciąg(n))
}

// Zadanie 04

def")
file://<WORKSPACE>/lab03/src/main/scala/Main.scala
file://<WORKSPACE>/lab03/src/main/scala/Main.scala:69: error: expected identifier; obtained eof
def
   ^
#### Short summary: 

expected identifier; obtained eof