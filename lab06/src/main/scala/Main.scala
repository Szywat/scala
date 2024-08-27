
def subseq[A](list: List[A], begIdx: Int, endIdx: Int): List[A] = {
    list.take(endIdx).drop(begIdx)
}

@main
def zadanie_01: Unit = {
  val l = List(1, 1, 2, 4, 4, 4, 1, 3)
  println(subseq(l, 2, 5))
}


def pairPosNeg(list: List[Double]): (List[Double], List[Double]) = {
    list.filter((x) => x != 0.0).partition((x) => x > 0)
}

@main
def zadanie_02: Unit = {
  val l = List(1.0, -1.9, 2.0, -10.6, 2.1, -4.5, 0.0, 3.7)
  println(pairPosNeg(l))
}

def deStutter[A](list: List[A]): List[A] = {
    list.foldLeft(List[A]())((acc, curr) => if acc.isEmpty || acc.last != curr then acc :+ curr
    else acc)
}

@main
def zadanie_03: Unit = {
  val l = List(1, 1, 2, 4, 4, 4, 1, 3)
  println(deStutter(l))
}

def remElems[A](list: List[A], k: Int): List[A] = {
    list.zipWithIndex.filter((x) => x._2 != k).map(_._1)
}

@main
def zadanie_04: Unit = {
  val l = List(1, 1, 2, 4, 4, 4, 1, 3)
  println(remElems(l, 2))
}


// zadanie 5
def freqMax[A](list: List[A]): (Set[A], Int) = {
  val count = list.groupBy(identity)
  val countList = count.map((n, list) => (n, list.length)).toList

  val maxVal = countList.map(_._2).max
  val filtered = countList.filter(_._2 == maxVal)

  val result = (filtered.map(_._1).toSet, maxVal)
  result
}

@main
def zadanie_05(): Unit = {
  val l = List(1, 1, 2, 4, 4, 3, 4, 1, 3)
  println(freqMax(l))
}

