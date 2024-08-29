def doLiczb(l: List[Option[Int]]): List[Int] = {
    l.foldLeft(List.empty[Int])((acc, curr) => curr match {
        case None => acc
        case Some(curr) => curr :: acc
    }).reverse
}

@main
def zadanie_domowe_9: Unit ={
    val lista = List(Some(5),Some(2),Some(5),Some(4), None)
    println(doLiczb(lista))
}

def suma(l: List[Option[Int]]): Int = {
    println(l.flatten)
        0
}

@main
def zadanie_domowe_10: Unit = {
    val lista = List(Some(5),Some(2),Some(5),Some(4), None)
    println(suma(lista))
}