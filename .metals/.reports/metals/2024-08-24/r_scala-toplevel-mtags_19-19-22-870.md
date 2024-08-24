error id: file://<WORKSPACE>/lab03/src/main/scala/Main.scala:[352..352) in Input.VirtualFile("file://<WORKSPACE>/lab03/src/main/scala/Main.scala", "import scala.annotation.tailrec
import scala.compiletime.ops.string

def reverse(str: String): String = {
  @tailrec
    def helper(str: String, acc: String): String = {
      if str.isEmpty() then acc
      else helper(str.tail, str.head + acc)
    }
    helper(str, "")
}

@main
def zadanie_01(str: String): Unit = {
    println(reverse(str))
}

def ")
file://<WORKSPACE>/lab03/src/main/scala/Main.scala
file://<WORKSPACE>/lab03/src/main/scala/Main.scala:18: error: expected identifier; obtained eof
def 
    ^
#### Short summary: 

expected identifier; obtained eof