import scala.annotation.tailrec
def myReverse[A](l: List[A]): List[A] = {
    @tailrec
    def helper(l: List[A], acc: List[A]): List[A] = l match {
        case Nil => acc
        case h :: t => helper(t, h :: acc)
    }
    helper(l, Nil)
}

def myHead[A](l: List[A]): A = l match {
    case h :: t => h
    // nie uwzględniam Nil, ponieważ nie mamy nic co byśmy wstawili do funkcji generycznej
    // a że program się wywali i tak przy użyciu .head na pustej liście, więc tutaj też wywali błąd jak będzie Nil
}

def myTail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case h :: t => t
}

def myTake[A](l: List[A], n: Int): List[A] = {
    @tailrec
    def helper(l: List[A], n: Int, acc: List[A]): List[A] = l match {
        case Nil => acc
        case h :: t => if n == 0 then acc else helper(t, n-1, h :: acc)
    }
    helper(l, n, Nil)
}

def myDrop[A](l: List[A], n: Int): List[A] = {
    @tailrec
    def helper(l: List[A], n: Int, acc: List[A]): List[A] = l match {
        case Nil => acc
        case h :: t => if n == 0 then acc.concat(h :: t) else helper(t, n-1, acc) 
    }
    helper(l, n, Nil)
}
@main
def zadanie_dodatkowe_1: Unit = {
    val lista = List(1,2,3,4,5,6)
    println(myReverse(myTake(lista, 3)))
    println(myDrop(lista, 3))
}

def rankingLiczb(l: List[Int]): List[(Int, Int)] = {
    l.sortWith((x,y) => x > y).zipWithIndex.map(x => (x._2 +1, x._1))

}

@main
def zadanie_dodatkowe_2: Unit = {
    val lista = List(10,3,7,24,8,1)
    println(rankingLiczb(lista))
}

def myConcat[A, B](l: List[A], m: List[B]): List[Any] = {
    myReverse(l)
    @tailrec
    def helper(l: List[A], m: List[B], acc: List[Any]): List[Any] = (l, m) match {
    case (Nil, Nil) => myReverse(acc)
    case (h :: t, Nil) => myReverse(h :: t)
    case (Nil, hm :: tm) => helper(Nil, tm, hm :: acc)
    case (h :: t, hm :: tm) => helper(t, hm :: tm, h :: acc)
}
    helper(l, m, Nil)
}

@main
def zadanie_dodatkowe_3: Unit = {
    println(myConcat(List(1,2,3), List(4,5,6)))
    println(myConcat(List(1,2,3), List("lmao","abc","cde")))
}