# IO-Building-Info


Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.



## Getting Started





### Wymagania

Aplikacja REST'owa napisana w Javie - wymaga pobranego JDK (wersja 1.7 - 1.8).



### Uruchomienie i obsługa



Posiadając pobranego Maven'a na swojej maszynie, poprzez wiersz poleceń: 


```
mvn spring-boot:run
```



Po skutecznym uruchomieniu w przeglądarke łączymy się z localhost. 


```
http://localhost:8080/nazwa-operacji
```



Każdą operacje dotyczącą jednego obiektu należy zakończyć **ID oczekiwanego obiektu**. Operacje zwracające listę pokoi o polach przekraczających pewien próg wymagają dodatkowo podania **progu, który należy przekroczyć**.

Dostępne operacje:

* **building** - Wyświetla informacje o wszystkich elementach,
* **GUI/** - Otwiera GUI które pozwala na wprowadzanie nowych budynków do systemu
* **GUI/new/** - Dodaje nowy budynek zgodnie z danymi w formacie JSON
* **getRoomArea** - Wyświetla powierzchnię pokoju,
* **getLevelArea** - Wyświetla powierzchnię poziomu,
* **getBuildingArea** - Wyświetla powierzchnię budynku,
* **getRoomCube** - Wyświetla kubaturę pokoju,
* **getLevelCube** - Wyświetla kubaturę poziomu,
* **getBuildingCube** - Wyświetla kubaturę budynku,
* **getRoomPowerPerSquare** - Oblicza i wyświetla średnią moc oświetlenia na metr kwadratowy w pokoju,
* **getLevelPowerPerSquare** - Oblicza i wyświetla średnią moc oświetlenia na metr kwadratowy na poziomie,
* **getBuildingPowerPerSquare** - Oblicza i wyświetla średnią moc oświetlenia na metr kwadratowy w budynku,
* **getRoomHeatingPerCube** - Oblicza i wyświetla średnie zużycie energii na ogrzewanie na metr sześcienny w pokoju,
* **getLevelHeatingPerCube** - Oblicza i wyświetla średnie zużycie energii na ogrzewanie na metr sześcienny na poziomie,
* **getBuildingHeatingPerCube** - Oblicza i wyświetla średnie zużycie energii na ogrzewanie na metr sześcienny w budynku,
* **getRoomRent** - Oblicza i wyświetla cenę wynajmu pomieszczenia,
* **getLevelRent** - Oblicza i wyświetla cenę wynajmu całego poziomu,
* **getBuildingRent** - Oblicza i wyświetla cenę wynajmu całego budynku,
* **buildingRentOverThreshold** - zwraca listę pokoi w budynku, których czynsz jest wyższy od podanego progu,
* **buildingPowerOverThreshold** - zwraca listę pokoi w budynku, których zużycie energii na metr kwadratowy jest wyższe od podanego progu,
* **buildingHeatingOverThreshold** - zwraca listę pokoi w budynku, których zużycie energii cieplnej na metr sześcienny jest wyższe od podanego progu.

Przyklady:

Wyświetlenie kubatury budynku o wybranym ID:
```http://localhost:8080/buildingCube?id=0```

Wyświetlenie Danych całego budynku o wybranym ID:
```http://localhost:8080/building?id=12```

### Kompilacja

Z wiersza poleceń:

```mvn compile```

### Stworzenie paczki do dystrybucji

Z wiersza poleceń:

```mvn package```

### Instalacja paczki w repozytorium lokalnym

Z wiersza poleceń:

```mvn install```

### Generowanie dokumentacji

Z wiersza poleceń:

```mvn javadoc:javadoc```

### Uruchamianie testów jednostkowych

Z wiersza poleceń:

```mvn test```

### Uruchamianie testów wydajnościowych

Z wiersza poleceń:

```mvn jmeter:jmeter```

### Uruchamianie wszystkich dostępnych testów

Z wiersza poleceń:

```mvn clean verify```

## Struktura Danych

* Lokacja [Location](https://github.com/Nebizar/IO-Building-Info/blob/master/src/main/java/pl/put/poznan/building_info/structures/Location.java) to budynek, poziom, lub pomieszczenie
* Budynek [Building](https://github.com/Nebizar/IO-Building-Info/blob/master/src/main/java/pl/put/poznan/building_info/structures/Building.java) może składać się z poziomów a te z pomieszczeń
* Każda lokalizacja jest charakteryzowana przez:
	* id – unikalny identyfikator
	* name – opcjonalna nazwa lokalizacji
* Pomieszczenie [Room](https://github.com/Nebizar/IO-Building-Info/blob/master/src/main/java/pl/put/poznan/building_info/structures/Room.java) dodatkowo jest charakteryzowane przez:
	* area - powierzchnia w m^2
	* cube - kubatura pomieszczenia w m^3
	* heating - poziom zużycia energii ogrzewania (float)
	* lightPower – łączna moc oświetlenia
	* rent - cena wynajmu
* Struktura budynku w JSON np {"levels":[{"rooms":[{"area":16.771454,"cube":86.15964,"heating":193.71202,"lightPower":172.36221,"rent":524.1692,"ID":35,"name":"Room"},{"area":35.63685,"cube":44.08831,"heating":74.20811,"lightPower":297.57465,"ID":36,"name":"Room"}],"ID":30,"name":"Level"}],"name":"Building"}


## Zbudowane przy użyciu

* [Maven](https://maven.apache.org/) - Dependency Management



## Rejestr produktu

Obsługa i zarządzanie zadaniami w zespole - Trello

* [Trello](https://trello.com/b/81rhAaNb/io-building-info-sprint-1) - SPRINT #1

* [Trello](https://trello.com/b/FNcwC89E/io-building-info-sprint-2) - SPRINT #2

* [Trello](https://trello.com/b/1St28toN/io-building-info-sprint3) - SPRINT #3

## Autorzy



* **Krzysztof Pasiewicz** - [Nebizar](https://github.com/Nebizar)
* **Angelika Szyszka** - [Angelika444](https://github.com/Angelika444)
* **Kamil Jędrzejczak** - [aieozn](https://github.com/aieozn)
* **Mikołaj Frankowski** - [RolandMcDoland](https://github.com/RolandMcDoland)



## Szczegóły



* Projekt wykonany w ramach przedmiotu Inżynieria Oprogramowania na Politechnice Poznańskiej,
* Prowadzący: dr. inż. Mirosław Ochodek
