import scala.annotation.tailrec


def coJestCztery(n: List[Int], x: Int): Int = {
    @tailrec
    def helper(n: List[Int], x: Int, acc: Int): Int = {
        if n == Nil then acc
        else if n.head == x then helper(n.tail, x, acc + 1)
        else helper(n.tail, x, acc)
    }
    helper(n, x, 0)
}

@main
def dod_zadanie_01: Unit = {
    println(coJestCztery(List(1,4,7,2,3,4,8,9,1,4,5,5,6,4), 4))
}


def duplikaty(n: List[Int]): List[Int] = {
    @tailrec
    def helper(n: List[Int], acc: List[Int], prev: Int): List[Int] = {
        if n == Nil then acc.reverse
        else if n.head == prev then helper(n.tail, n.head :: acc, n.head)
        else helper(n.tail, acc, n.head)
    }
    helper(n.tail, Nil, n.head)
}

@main
def dod_zadanie_02: Unit = {
    println(duplikaty(List(5, 1, 2, 2, 3, 1, 1,1, 5,5)))
}