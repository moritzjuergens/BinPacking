# BinPacking

## Gruppe: 

 - Georg Giesbrecht
 - Moritz Jürgens
 - Nicolas Fürhaupter
 - Maurice Schramm
 - Tobias Essigke
 
## Problemstellung
Bei dem Bin Packing-Problem handelt es sich um ein Problem, welches sich überwiegend in der Transport und Logistik Branche wieder findet. 
Es geht bei diesem Problem grundsätzlich darum, Elemente verschiedener Größen möglichst sinnvoll in Behälter zu verpacken. 
Ziel hierbei ist es, möglichst wenig Behälter zu benutzen, sowie die benutzten Behälter möglichst effizient zu bepacken. 
Das Problem welches sich hierbei jedoch ergibt, ist dass es bei n Elementen auch n Möglichkeiten gibt, dies zu verpacken. 
Bei unserer Recherche zu diesem Thema haben wir herausgefunden, dass es zur Lösung dieses Problems verschiedenste Möglichkeiten und Ansätze gibt.
Zunächst einmal gibt es die Möglichkeit ein solches Programm „online“ oder auch „offline“ zu gestalten. 
Der einzige Unterschied hier ist, dass bei der online Variante die Elemente einzeln geliefert werden und direkt in die Behälter verteilt werden. 
Bei der offline Variante hingegen, sind die Anzahl und die Größe der Elemente bereit bekannt und werden ebenfalls Best möglichst in die Behälter verteilt.
Es gibt drei Möglichkeiten die Elemente in die Behälter zu verteilen:
- Next-Fit
    - Hier wird jedes Element in denselben Behälter gepackt wie sein Vorgänger 
    - vorausgesetzt es gibt noch genug Platz 
    - ansonsten wir ein neuer Behälter geöffnet
- First-Fit
    - Hier wird mehrfach über die Behälter iteriert und das Element wird in den ersten Behälter gepackt, in den es passt
    - Findet sich kein passender Behälter, so wird ein neuer Behälter geöffnet
- Best-Fit
    - Hier wird das Element in den Behälter gepackt, in den es gerade noch so rein passt
    - Beispiel: Es existieren zwei Behälter. In dem ersten Behälter, ist noch Platz für ein Element der Größe 2. In dem zweiten Behälter ist noch Platz für ein Element der Größe 1. So wird ein Element der Größe 1 nicht in den ersten sondern in den zweiten Behälter gepackt, da es dort besser hineinpasst.

## Überlegung
Nach ausgiebiger Überlegung, haben wir uns entschieden die „Online“  Variante zu verwenden, da uns diese mehr interessiert hat und unserer Meinung nach näher an der Realität ist (z.B.: Beladung eines Postwagens mit Paketen unterschiedlicher Größe). 
Außerdem haben wir uns, um ein möglichst gutes Ergebnis zu erzielen, auf eine der drei oben genannten Möglichkeiten festgelegt. 
Unsere Entscheidung ist auf die First-Fit-Variante gefallen.

## Unsere Umsetzung
