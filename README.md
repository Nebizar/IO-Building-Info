# IO-Building-Info


Dla administrator�w budynk�w, kt�rzy pragn� optymalizowa� koszty zarz�dzania budynkami  nasza aplikacja Building Info umo�liwi pozyskanie informacji o parametrach budynku na poziomie pomieszcze�, kondygnacji oraz ca�ych budynk�w. Aplikacja b�dzie dost�pna poprzez GUI a tak�e jako zdalne API dzi�ki czemu mo�na j� zintegrowa� z istniej�cymi narz�dziami.



## Getting Started





### Wymagania

Aplikacja REST'owa napisana w Javie - wymaga pobranego JDK (wersja 1.7 - 1.8).



### Uruchomienie i obs�uga



Posiadaj�c pobranego Maven'a na swojej maszynie, poprzez wiersz polece�: 


```
mvn spring-boot:run
```



Po skutecznym uruchomieniu w przegl�darke ��czymy si� z localhost. 


```
http://localhost:8080/nazwa-operacji
```



Ka�d� operacje dotycz�c� jednego obiektu nale�y zako�czy� **ID oczekiwanego obiektu**.

Dost�pne operacje:

* **building** - Wy�wietla informacje o wszystkich elementach,
* **building/new/** - Dodaje nowy budynek zgodnie z danymi w formacie JSON
* **getRoomArea** - Wy�wietla powierzchni� pokoju,
* **getLevelArea** - Wy�wietla powierzchni� poziomu,
* **getBuildingArea** - Wy�wietla powierzchni� budynku,
* **getRoomCube** - Wy�wietla kubatur� pokoju,
* **getLevelCube** - Wy�wietla kubatur� poziomu,
* **getBuildingCube** - Wy�wietla kubatur� budynku,
* **getRoomPowerPerSquare** - Oblicza i wy�wietla �redni� moc o�wietlenia na metr kwadratowy w pokoju,
* **getLevelPowerPerSquare** - Oblicza i wy�wietla �redni� moc o�wietlenia na metr kwadratowy na poziomie,
* **getBuildingPowerPerSquare** - Oblicza i wy�wietla �redni� moc o�wietlenia na metr kwadratowy w budynku,
* **getRoomHeatingPerCube** - Oblicza i wy�wietla �rednie zu�ycie energii na ogrzewanie na metr sze�cienny w pokoju,
* **getLevelHeatingPerCube** - Oblicza i wy�wietla �rednie zu�ycie energii na ogrzewanie na metr sze�cienny na poziomie,
* **getBuildingHeatingPerCube** - Oblicza i wy�wietla �rednie zu�ycie energii na ogrzewanie na metr sze�cienny w budynku,

Przyklady:

Wy�wietlenie kubatury budynku o wybranym ID:
```http://localhost:8080/buildingCube?id=0```

Wy�wietlenie Danych ca�ego budynku o wybranym ID:
```http://localhost:8080/building?id=12```

### Kompilacja

Z wiersza polece�:

```mvn compile```

### Stworzenie paczki do dystrybucji

Z wiersza polece�:

```mvn package```

### Instalacja paczki w repozytorium lokalnym

Z wiersza polece�:

```mvn install```

### Generowanie dokumentacji

Z wiersza polece�:

```mvn javadoc:javadoc```

### Uruchamianie test�w jednostkowych

Z wiersza polece�:

```mvn test```


## Struktura Danych

* Lokacja [Location](https://github.com/Nebizar/IO-Building-Info/blob/master/src/main/java/pl/put/poznan/building_info/structures/Location.java) to budynek, poziom, lub pomieszczenie
* Budynek [Building](https://github.com/Nebizar/IO-Building-Info/blob/master/src/main/java/pl/put/poznan/building_info/structures/Building.java) mo�e sk�ada� si� z poziom�w a te z pomieszcze�
* Ka�da lokalizacja jest charakteryzowana przez:
	* id � unikalny identyfikator
	* name � opcjonalna nazwa lokalizacji
* Pomieszczenie [Room](https://github.com/Nebizar/IO-Building-Info/blob/master/src/main/java/pl/put/poznan/building_info/structures/Room.java) dodatkowo jest charakteryzowane przez:
	* area - powierzchnia w m^2
	* cube - kubatura pomieszczenia w m^3
	* heating - poziom zu�ycia energii ogrzewania (float)
	* light � ��czna moc o�wietlenia
* Struktura budynku w JSON np {"levels":[{"rooms":[{"area":16.771454,"cube":86.15964,"heating":193.71202,"lightPower":172.36221,"ID":35,"name":"Room"},{"area":35.63685,"cube":44.08831,"heating":74.20811,"lightPower":297.57465,"ID":36,"name":"Room"}],"ID":30,"name":"Level"}],"name":"Building"}


## Zbudowane przy u�yciu

* [Maven](https://maven.apache.org/) - Dependency Management



## Rejestr produktu

Obs�uga i zarz�dzanie zadaniami w zespole - Trello

* [Trello](https://trello.com/b/81rhAaNb/io-building-info-sprint-1) - SPRINT #1

* [Trello](https://trello.com/b/FNcwC89E/io-building-info-sprint-2) - SPRINT #2

## Autorzy



* **Krzysztof Pasiewicz** - [Nebizar](https://github.com/Nebizar)
* **Angelika Szyszka** - [Angelika444](https://github.com/Angelika444)
* **Kamil J�drzejczak** - [aieozn](https://github.com/aieozn)
* **Miko�aj Frankowski** - [RolandMcDoland](https://github.com/RolandMcDoland)



## Szczeg�y



* Projekt wykonany w ramach przedmiotu In�ynieria Oprogramowania na Politechnice Pozna�skiej,
* Prowadz�cy: dr. in�. Miros�aw Ochodek
