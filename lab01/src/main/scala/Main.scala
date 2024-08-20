def obramuj(napis: String): String = {

  val linie = napis.split('\n') // split rozdziela nam słowa jeśli podany znak istnieje
  val najdluzsza = linie.maxBy(s => s.length) /// maxBy szuka nam najdłuższego wyrazu bazując na długosci oddzielonych wyrazów
  val szerokosc = najdluzsza.length() // długość najdłuższego wyrazu zamieniamy na liczbę
  val ramka = "*" + ("*" * szerokosc) + "*" // ramka to początek, środek (szerokość to ilość gwiazdek w środku), zakończenie

  ramka + "\n" + linie.map(l => "*" + l + (" " * (szerokosc - l.length())) + "*").mkString("\n") + "\n" + ramka
  // ^ co funkcja ma zwracać
    // ramka, pominięcie do następnej linijki,
    // każdy wyraz osobno ze spacjami równej szerokości odjąć długość tych wyrazów,
    // oddzielenie każdego wyrazu przejściem do następnej linijki
    // przejście do następnej linijki, zakończenie ramką
}

@main
def mainProg(napis: String): Unit = {
  println(obramuj(napis))

}

