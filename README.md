# IO-Building-Info


Dla administratorów budynków, którzy pragn¹ optymalizowaæ koszty zarz¹dzania budynkami  nasza aplikacja Building Info umo¿liwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeñ, kondygnacji oraz ca³ych budynków. Aplikacja bêdzie dostêpna poprzez GUI a tak¿e jako zdalne API dziêki czemu mo¿na j¹ zintegrowaæ z istniej¹cymi narzêdziami.



## Getting Started





### Wymagania

Aplikacja REST'owa napisana w Javie - wymaga pobranego JDK (wersja 1.7 - 1.8).



### Uruchomienie i obs³uga



Posiadaj¹c pobranego Maven'a na swojej maszynie, poprzez wiersz poleceñ: 


```
mvn spring-boot:run
```



Po skutecznym uruchomieniu w przegl¹darke ³¹czymy siê z localhost. 


```
http://localhost:8080/nazwa-operacji
```



Ka¿d¹ operacje dotycz¹c¹ jednego obiektu nale¿y zakoñczyæ **ID oczekiwanego obiektu**.

Dostêpne operacje:

* **building** - Wyœwietla informacje o wszystkich elementach,
* **building/new/** - Dodaje nowy budynek zgodnie z danymi w formacie JSON
* **getRoomArea** - Wyœwietla powierzchniê pokoju,
* **getLevelArea** - Wyœwietla powierzchniê poziomu,
* **getBuildingArea** - Wyœwietla powierzchniê budynku,
* **getRoomCube** - Wyœwietla kubaturê pokoju,
* **getLevelCube** - Wyœwietla kubaturê poziomu,
* **getBuildingCube** - Wyœwietla kubaturê budynku,
* **getRoomPowerPerSquare** - Oblicza i wyœwietla œredni¹ moc oœwietlenia na metr kwadratowy w pokoju,
* **getLevelPowerPerSquare** - Oblicza i wyœwietla œredni¹ moc oœwietlenia na metr kwadratowy na poziomie,
* **getBuildingPowerPerSquare** - Oblicza i wyœwietla œredni¹ moc oœwietlenia na metr kwadratowy w budynku,
* **getRoomHeatingPerCube** - Oblicza i wyœwietla œrednie zu¿ycie energii na ogrzewanie na metr szeœcienny w pokoju,
* **getLevelHeatingPerCube** - Oblicza i wyœwietla œrednie zu¿ycie energii na ogrzewanie na metr szeœcienny na poziomie,
* **getBuildingHeatingPerCube** - Oblicza i wyœwietla œrednie zu¿ycie energii na ogrzewanie na metr szeœcienny w budynku,

Przyklady:

Wyœwietlenie kubatury budynku o wybranym ID:
```http://localhost:8080/buildingCube?id=0```

Wyœwietlenie Danych ca³ego budynku o wybranym ID:
```http://localhost:8080/building?id=12```

### Kompilacja

Z wiersza poleceñ:

```mvn compile```

### Stworzenie paczki do dystrybucji

Z wiersza poleceñ:

```mvn package```

### Instalacja paczki w repozytorium lokalnym

Z wiersza poleceñ:

```mvn install```

### Generowanie dokumentacji

Z wiersza poleceñ:

```mvn javadoc:javadoc```

### Uruchamianie testów jednostkowych

Z wiersza poleceñ:

```mvn test```


## Struktura Danych

* Lokacja [Location](https://github.com/Nebizar/IO-Building-Info/blob/master/src/main/java/pl/put/poznan/building_info/structures/Location.java) to budynek, poziom, lub pomieszczenie
* Budynek [Building](https://github.com/Nebizar/IO-Building-Info/blob/master/src/main/java/pl/put/poznan/building_info/structures/Building.java) mo¿e sk³adaæ siê z poziomów a te z pomieszczeñ
* Ka¿da lokalizacja jest charakteryzowana przez:
	* id – unikalny identyfikator
	* name – opcjonalna nazwa lokalizacji
* Pomieszczenie [Room](https://github.com/Nebizar/IO-Building-Info/blob/master/src/main/java/pl/put/poznan/building_info/structures/Room.java) dodatkowo jest charakteryzowane przez:
	* area - powierzchnia w m^2
	* cube - kubatura pomieszczenia w m^3
	* heating - poziom zu¿ycia energii ogrzewania (float)
	* light – ³¹czna moc oœwietlenia
* Struktura budynku w JSON np {"levels":[{"rooms":[{"area":16.771454,"cube":86.15964,"heating":193.71202,"lightPower":172.36221,"ID":35,"name":"Room"},{"area":35.63685,"cube":44.08831,"heating":74.20811,"lightPower":297.57465,"ID":36,"name":"Room"}],"ID":30,"name":"Level"}],"name":"Building"}


## Zbudowane przy u¿yciu

* [Maven](https://maven.apache.org/) - Dependency Management



## Rejestr produktu

Obs³uga i zarz¹dzanie zadaniami w zespole - Trello

* [Trello](https://trello.com/b/81rhAaNb/io-building-info-sprint-1) - SPRINT #1

* [Trello](https://trello.com/b/FNcwC89E/io-building-info-sprint-2) - SPRINT #2

## Autorzy



* **Krzysztof Pasiewicz** - [Nebizar](https://github.com/Nebizar)
* **Angelika Szyszka** - [Angelika444](https://github.com/Angelika444)
* **Kamil Jêdrzejczak** - [aieozn](https://github.com/aieozn)
* **Miko³aj Frankowski** - [RolandMcDoland](https://github.com/RolandMcDoland)



## Szczegó³y



* Projekt wykonany w ramach przedmiotu In¿ynieria Oprogramowania na Politechnice Poznañskiej,
* Prowadz¹cy: dr. in¿. Miros³aw Ochodek
