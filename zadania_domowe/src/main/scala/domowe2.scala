def dluzszyNiz5(l: List[String]): List[String] = {
    l.filter((x)=> x.length <= 5)
}

@main
def zadanie_domowe_7: Unit ={
    val lista = List("lmao", "pies", "nietoperz", "kot", "ptak", "żyrafa", "zebra")
    println(dluzszyNiz5(lista))
}

def wartoscPlus1_1(l: List[Int]): List[Int] = {
    l.map((x) => x+1)
}

def wartoscPlus1_2(f: Int => Int)(l: List[Int]): List[Int] = {
    l.map((x) => f(x))
}

@main
def zadanie_domowe_8: Unit = {
    val lista = List(1,2,3,4,5)
    val f = (n: Int) => n + 1
    println(wartoscPlus1_1(lista))
    println(wartoscPlus1_2(f)(lista))
}

def razyFilterPodzial(l: List[Double]): (List[Double], List[Double]) = {
    l.map((x) => x*10).filter((x) => x % 4 != 0).partition(x => x > 50)
}

@main
def zadanie_domowe_5: Unit = {
    val lista = List(2.5, 7.1, 6.7, 7.2, 0.4, 2.6, 5.7, 4.0, 5.9, 7.5)
    println(razyFilterPodzial(lista))

}

def jednaTrzeciaIndeks(l: List[Int]): List[(Int, Int)] = {
    l.drop((l.length / 3)).zipWithIndex.map((n, ind) => (n, ind + (l.length / 3)))
    
}

@main
def zadanie_domowe_6: Unit = {
    val lista = List(1,2,3,4,5,6,7)
    println(jednaTrzeciaIndeks(lista))
}