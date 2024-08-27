
def sumOpts(l: List[Option[Double]]): Option[Double] = {
    if l.forall(_.isEmpty) then None
    else Some(l.flatten.sum)
}

@main
def zadanie_01: Unit = {
  val lista = List(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))
  println(sumOpts(lista))
}

def position[A](l: List[A], el: A): Option[Int] = {
    if l.contains(el) then Some(l.indexOf(el))
    else None
}

@main
def zadanie_02: Unit = {
  val lista = List(2, 1, 1, 5)
  println(position(lista, 3))
}

def indices[A](l: List[A], el: A): Set[Int] = {
    l.zipWithIndex.filter(_._1 == el).map(_._2).toSet
}

@main
def zadanie_03: Unit = {
  val lista = List(1, 2, 1, 1, 5)
  println(indices(lista, 1))
}

def swap[A](l: List[A]): List[A] = {
    val podzielone = l.grouped(2).toList
    podzielone.map(x => x.reverse).flatten
}

@main
def zadanie_04: Unit = {
  val lista = List(1, 2, 3, 4, 5)
  println(swap(lista))
}

@main
def zadanie_05(): Unit = {
  val strefy: List[String] = java.util.TimeZone.getAvailableIDs.toList
  val strefyEuropy: List[String] = strefy.filter(_.startsWith("Europe/")).map(_.stripPrefix("Europe/"))
  val posortowaneStrefy: List[String] = strefyEuropy.sortBy(s => (s.length, s))
  println(posortowaneStrefy)
}

def freq[A](l: List[A]): List[(A, Int)] = {
    l.groupBy(identity).map((n, lista) => (n, lista.length)).toList
}

@main
def zadanie_06(): Unit = {
  val lista = List('a','b','a','c','c','a')
  println(freq(lista))
}