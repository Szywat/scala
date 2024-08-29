file://<WORKSPACE>/zadania_domowe/src/main/scala/domowe2.scala
### dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition skompresuj is defined in
  <WORKSPACE>/lab05/src/main/scala/Main.scala
and also in
  <WORKSPACE>/zadania_domowe/src/main/scala/domowe1.scala
One of these files should be removed from the classpath.

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 145
uri: file://<WORKSPACE>/zadania_domowe/src/main/scala/domowe2.scala
text:
```scala
def dluzszyNiz5(l: List[String]): List[String] = {
    l.filter((x)=> x.length <= 5)
}

@main
def zadanie_domowe_7: Unit ={
    val lista = List(@@"lmao", "pies", "nietoperz", "kot", "ptak", "żyrafa", "zebra")
    println(dluzszyNiz5(lista))
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
```



#### Error stacktrace:

```

```
#### Short summary: 

dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition skompresuj is defined in
  <WORKSPACE>/lab05/src/main/scala/Main.scala
and also in
  <WORKSPACE>/zadania_domowe/src/main/scala/domowe1.scala
One of these files should be removed from the classpath.