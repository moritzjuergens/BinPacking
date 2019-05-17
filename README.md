# BinPacking

Gruppe: 

 - Georg Giesbrecht
 - Moritz Jürgens
 - Nicolas Fürhaupter
 - Maurice Schramm
 - Tobias Essigke
 
Algorithmus

- Algorithmus bekommt drei Informationen
   - Anzahl der Objekte --> int numberOfObjects
   - Größe der Objekte --> int sizeOfObject
   - Größe des Bins (muss größer/gleich der Größe des größten Objekts sein) --> int sizeOfBin
- Initialisierung von Array der Objekte --> int[] objectArray
- Sortierung der Objekte im Array --> absteigend
   - wir nehmen und den einfachsten Sortieralgorithmus
- Anfang Algorithmus
    - int binCounter = 0 zählt Anzahl der bins
    - wir gehen array durch von 0 bis numberOfObjects
    - wenn zahl an stelle i == 0 dann abbruch
    - größte zahl wird in int zischenvariable currentBin gespeichert
    - zahl, die aus dem array geholt wurde, wird im array mit 0 überspeichert oder aus der Arraylist gestrichen
	
// Test
