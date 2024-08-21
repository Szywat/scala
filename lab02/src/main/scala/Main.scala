import scala.annotation.tailrec
import scala.math.sqrt

// Zadanie 01

def parzysta(n: Int): Boolean = {
  n % 2 == 0  // n mod 2
}

@main
def zadanie_01: Unit = {
  assert(parzysta(2))
  assert(!parzysta(3))
  assert(parzysta(4))
  assert(!parzysta(5))
  // assert to sprawdzenie założenia czy wynik == true or false, if false => error
}

// Zadanie 02

def nwd(a: Int, b: Int): Int = {
    if (a == b) { // jeśli są takie same to mamy nasze nwd
      a
    } else if (a > b) { // jeśli a > b to odejmujemy b od a, bo wtedy będzie równe b lub mniejsze, co ułatwi nam szukanie tego dzielnika
      nwd(a - b, b)
    } else {
      nwd(a, b - a) // jeśli b > a to odejmujemy a od b, bo wtedy będzie równe a lub mniejsze, co ułatwi nam szukanie tego dzielnika
    }
}

@main
def zadanie_02(a: Int, b: Int): Unit = {
    println(a)
    println(b)
    println(nwd(a, b))
}

// Zadanie 03

def pierwsza(n: Int): Boolean = {
    assert(n >= 2)
    if (n % 2 == 0 && n != 2) {
      false
    } else {
      !(2 until sqrt(n).ceil.toInt).exists(d => n % d == 0)
    }
    
}

@main
def zadanie_03(liczba: Int): Unit = {
    println(liczba)
    println(pierwsza(liczba))
}

// Zadanie 04
// nie mam pojęcia jak zrobić to gówno