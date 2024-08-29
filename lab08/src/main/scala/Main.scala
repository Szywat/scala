
def mastermind(secret: List[Int], guess: List[Int]): (Int, Int) = {
    val czarne = secret.zipWithIndex.intersect(guess.zipWithIndex).length
    val biale = secret.intersect(guess).length - czarne
    (czarne, biale)
    // zipWithIndex, intersect, length
}

@main
def zadanie_01: Unit = {
    val secret = List(1, 3, 2, 2, 4, 5)
    val guess  = List(2, 1, 2, 4, 7, 2)
    println(mastermind(secret, guess))
}

def ranking(l: List[(String, String, Double, Double)]): List[(Int, String, Double)] = {
    val zawodnik = l.map((imie, nazwisko, ocena1, ocena2) => (imie + " " +nazwisko, ocena1, ocena2))
    val srednia = zawodnik.groupBy(_._1).toList.map((x) => x._2).map((elem) => elem.foldLeft((elem.head._1, 0.0, 0.0))
    ((acc, curr) => (acc._1, acc._2 + (curr._2/elem.length),acc._3 + (curr._3/elem.length))))
    val sredniaSuma = srednia.map((imienazwisko, ocena1, ocena2) => (imienazwisko, ocena1+ocena2, ocena1))
    val sorted = sredniaSuma.sortBy(_._2).reverse
    val oceny = sorted.foldLeft(List.empty[(Int, String, Double, Double)])((acc, el) => {
        acc match
        case Nil => (1, el._1, el._2, el._3) :: acc
        case head :: tail if head._4 == el._3 && el._2 < head._3 => (head._1 + 1, el._1, el._2, el._3) :: acc
        case head :: tail if head._4 == el._3 => (head._1, el._1, el._2, el._3) :: acc
        case head :: tail => (head._1 + 1, el._1, el._2, el._3) :: acc
    }).reverse
    val koniec = oceny.map((a,b,c,d) => (a,b,c))
    koniec

}

@main
def zadanie_02(): Unit = {
    val oceny = List(("imie", "nazwisko", 10.9, 5.6), ("imie", "nazwisko", 4.6, 3.2), ("a", "b", 15.4, 2.0), ("c", "d", 15.4, 2.0))
    println(ranking(oceny))
}

def threeNumbers(n: Int): List[(Int, Int, Int)] = {
    for {
        a <- 1 until n
        b <- a+1 until n
        c <- b+1 until n
        if a*a + b*b == c*c
    } yield (a,b,c)
}.toList

@main
def zadanie_03: Unit = { 
    println(threeNumbers(9))
}