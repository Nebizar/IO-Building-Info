# IO-Building-Info
IO project - Building Info App

Do kompilowania polecam pobrać mavena, wejść w główny folder projektu i odpaić przez "mvn spring-boot:run"

Jeżeli wszystko się uda to po wpisaniu w przeglądarce "http://localhost:8080/building" powinno wam się pokazać dużo tekstu

Do wysyłania zapytań JSON polecam POSTMAN-a (taka mała apka)
 - https://www.youtube.com/watch?v=FyZBTbv7UM0


 INNE KOMUNIKATY

DOSTĘPNE PRZEZ PRZEGLĄDARKĘ (GET)
 http://localhost:8080/building                     Wyświetla informacje o wszystkich elementach 
 http://localhost:8080/building?id=12               Wyświetla info o elemencie 12 (różne informacje w zależności od typu)


JSON
http://localhost:8080/building/new/                 Dodaje nowy budynek zgodnie z danymi w formacie JSON
  + Struktura budynku w JSON
  np {"levels":[{"rooms":[{"area":16.771454,"cube":86.15964,"heating":193.71202,"lightPower":172.36221,"ID":35,"name":"Room"},{"area":35.63685,"cube":44.08831,"heating":74.20811,"lightPower":297.57465,"ID":36,"name":"Room"}],"ID":30,"name":"Level"}],"name":"Building"}

Uwagi Mikołaja:

Do JSON można przesyłać tylko klasy stworzone przez użytkownika więc dodałem nową klasę Value, w której są trzy pola:
 - type- czego w tym wypadku dotyczy klasa (np. kubatura budynku, powierzchnia poziomu itp.)
 - id- id elementu, którego dotyczy wartość
 - value- wartość, którą przekazujemy
Polecam postarać się w miarę możliwości korzystać z tej klasy, żeby niepotrzebnie nie dodawać niewiadomo ilu.

Polecam też używać tego co zrobiłem jako template'a, jako że wszystkie te zadania są dosyć podobne powinno dzięki temu pójść dużo szybciej.

KOMUNIKAT DODANY:

 http://localhost:8080/buildingCube?id=0		Wyświetla kubaturę budynku o id podnaym jako parametr (jeżeli id nie będzie należało do budynku wyświetli się error)
 http://localhost:8080/levelCube?id=1			Wyświetla kubaturę poziomu o id podnaym jako parametr (jeżeli id nie będzie należało do budynku wyświetli się error)
 http://localhost:8080/roomCube?id=5			Wyświetla kubaturę pokoju o id podnaym jako parametr (jeżeli id nie będzie należało do budynku wyświetli się error)