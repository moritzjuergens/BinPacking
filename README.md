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

## Benutzeroberfläche
### Start Screen
- Heißt den Benutzer willkommen
- Stellt dem Benutzer ein Eingabefeld zur Verfügung, um die MaxSize der Behälter festzulegen
- Der Benutzer kann nun wählen, ob er zur Ausführung den herkömmlichen "normalen" Code oder den funktionalen Code benutzen möchte
    
### Bin Sorting
- Lässt den Benutzer mit Eingabe von Zahlen und dem Drücken des "Insert element"-Buttons oder dem Drücken der Enter-Taste Elemente einfügen
- Nun gibt die Ausgabe an
    - wie viele Elemente bereits eingefügt wurden
    - welche Behälter aufgemacht wurden
    - wie viele Elemente sich in den Behältern befinden
    - welche Elemente sich in den Behältern befinden
- Wenn ein Behälter die maxSize erreicht hat, wird diese Zeile rot unterlegt

## Unsere Umsetzung
    
### Action.java
- Hier wird ein Enum zur späteren Verwendung im Code erstellt
- Es wird dafür verwendet im UI entweder die Ausführung mit dem "herkömmlichen" oder funktionalen Code durchzuführen

### Bin.java
- Hier wird das Verhalten und die Eigenschaften des Behälters (Bin) beschrieben und festgelegt
- Ein Behälter besitzt die Eigenschaft einer MaxSize, die die maximale Größe des Behälters angiebt
    - Diese MaxSize wird in ihren Getter- und Setter-Methoden überprüft, dass auch nur valide Werte eingetragen werden können
- Außerdem besitzt die Klasse noch Methoden, um Elemente in den Behälter hinzufügen zu können, den freien Platz im Behälter zu berechnen und zu schauen, ob ein Element in den Behälter hineinpasst

### InsertingUI.java
- Hier wird das User-Interface erstellt, in dem der Nutzer die Elemente dem Behälter hinzufügen kann
- Da wir die online-Variante gewählt haben, können immer weiter Elemente den Behältern hinzugefügt werden
- Die erstellen Behäter werden mit ihren enthaltenen Elementen gespeichert und angezeigt

### Main.java
- Erstellt das StartingUI als Einstieg in das Programm

### StartingUI.java
- Erstellt den Willkommens-Screen am Anfang des Programms
- Nimmt die maximale Größe eines Behälters als Benutzereingabe entgegen
- Der Benutzer kann dann entscheiden, ob die Ausführung "herkömmlich" oder funktional geschehen soll

### Worker.java
- Beinhaltet ein Interface, dass den Worker-Klassen vorgibt, welche Methoden implementiert werden müssen
- Die Worker beihnhalten den eigentlichen Algorithmus des BinPacking-Problems

### WorkerFunctional.java
- Definiert den Worker bzw. den BinPacking-Algorithmus in der funktionalen Variante

- insertElement()
    - die Behälter werden in einem Stream weitergegeben
    - es wird nach den Behältern gefiltert, die noch Platz für das übergebene Element haben
    - es wird der erste Behälter von den gefilterten Behältern genommen
    - wenn es keine Behälter gibt, in die das Element passt, wird ein neuer Behälter erstellt
    - zum Schluss wird das Element dem ersten Behälter, in den das Element hineinpasst, oder dem neuen Behälter hinzugefügt
    
- getDisplayData()
    - die Behälter werden in einem Stream weitergegeben
    - mit einer forEach-Schleife werden die Behälter durchgegangen und für das UI in einem zweidimensionalen Array zur Darstellung aufbereitet
    - die erste Dimension des Arrays enthält die Nummer des Behälter
    - die zweite Dimension des Arrays entählt die eingefügten Elemente
    
- getElements()
    - es wird ein StringJoiner erstellt, der die Elemente als String mit einem Komma getrennt nacheinander darstellt
    - dies wird dadurch erreicht, dass alle Elemente des Behälters in einem Stream weitergegeben werden und mit einre forEach-Schleife darüber iteriert wird
    
### WorkerNormal.java
- Definiert den Worker bzw. den BinPacking-Algorithmus in der "herkömmlichen" Variante

- insertElement()
    - es wird geprüft, ob das Element valide ist (größer 0 und kleiner-gleich maxSize des Behälters)
    - eine boolean Variable wird erstellt, um den Erfolg des Einfügens zu kennzeichnen
    - es wird mit einer forEach-Schleife über die Behälter iteriert
        - die Bedingung einer Verzweigung versucht, das Element in den Behälter hinzuzufügen
        - falls es erfolgreich ist, wird die Schleife abgebrochen
    - wenn es keinen Erfolg beim Hinzufügen gab, wird ein neuer Behälter erstellt und das Element hinzugefügt
    
- getDisplayData()
    - mit einer for-Schleife werden die Behälter durchgegangen und für das UI in einem zweidimensionalen Array zur Darstellung aufbereitet
    - die erste Dimension des Arrays enthält die Nummer des Behälter
    - die zweite Dimension des Arrays entählt die eingefügten Elemente
    
- getElements()
    - es wird ein StringJoiner erstellt, der die Elemente als String mit einem Komma getrennt nacheinander darstellt
    - im Folgenden wird mit einer forEach-Schleife jedes Element eines Behälters durchgegangen und dem StringJoiner übergeben
    

