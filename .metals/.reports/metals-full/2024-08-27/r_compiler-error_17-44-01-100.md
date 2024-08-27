file://<WORKSPACE>/zadania_domowe/src/main/scala/Main.scala
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 984
uri: file://<WORKSPACE>/zadania_domowe/src/main/scala/Main.scala
text:
```scala
import scala.annotation.tailrec

def duplikaty[A](l: List[A]): Int = {
  @tailrec
  def helper(l: List[A], acc: Int): Int = l match {
    case Nil => acc
    case _ :: Nil => acc
    case h :: n :: t => if h == n then helper(n :: t, acc + 1) else helper(n :: t, acc)
  }
  helper(l, 0)
}

@main
def zadanie_domowe_1: Unit = {
  val lista = List(1, 1, 3, 4, 4, 1)
  println(duplikaty(lista))
}


def coDrugi(f: Int => Int)(l: List[Int]): List[Int] = {
  @tailrec
  def helper(l: List[Int], acc: List[Int], ind: Int): List[Int] = l match {
    case Nil => acc
    case h :: t => if ind % 2 == 0 then helper(t, acc :+ f(h), ind + 1) else helper(t, acc :+ h, ind + 1)
  }
  helper(l, Nil, 0)
}

@main
def zadanie_domowe_2: Unit = {
  val lista = List(1, 1, 3, 4, 4, 1)
  val f = (n: Int) => n * 10
  println(coDrugi(f)(lista))
}
// nie działa dla [A, B]

def skompresuj[A](l: List[A]): List[(A, Int)] = {
    @tailrec
    def helper(l: Lista[A], acc: List[(A, Int)], counter: Int): Lista[@@]
}

@main
def zadanie_domowe_3: Unit = {
  println()
}


def podzielnePrzez2(l: List[Int]): (Int, Int) = {
  @tailrec
  def helper(l: List[Int], tak: Int, nie: Int): (Int, Int) = l match {
    case Nil => (tak, nie)
    case h :: t => if h % 2 == 0 then helper(t, tak + 1, nie) else helper(t, tak, nie + 1)
  }
  helper(l, 0, 0)
}

@main
def zadanie_domowe_4: Unit = {
  val lista = List(1, 1, 3, 4, 4, 1)
  println(podzielnePrzez2(lista))
}


```



#### Error stacktrace:

```
dotty.tools.dotc.core.SymDenotations$NoDenotation$.owner(SymDenotations.scala:2607)
	scala.meta.internal.pc.SignatureHelpProvider$.isValid(SignatureHelpProvider.scala:83)
	scala.meta.internal.pc.SignatureHelpProvider$.notCurrentApply(SignatureHelpProvider.scala:94)
	scala.meta.internal.pc.SignatureHelpProvider$.$anonfun$1(SignatureHelpProvider.scala:48)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile(LinearSeq.scala:280)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile$(LinearSeq.scala:278)
	scala.collection.immutable.List.dropWhile(List.scala:79)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:48)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:435)
```
#### Short summary: 

java.lang.AssertionError: NoDenotation.owner