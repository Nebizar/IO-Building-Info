# IO-Building-Info
IO project - Building Info App

Do kompilowania polecam pobrać mavena, wejść w główny folder projektu i odpaić przez "mvn spring-boot:run"

Jeżeli wszystko się uda to po wpisaniu w przeglądarce "http://localhost:8080/abc" powinno się wam wyświetlić "abc"

Do wysyłania zapytań JSON polecam POSTMAN-a (taka mała apka)
 - na http://localhost:8080/ wysyłacie zapytanie POST z JSON-ową treścią ... 


 INNE KOMUNIKATY

DOSTĘPNE PRZEZ PRZEGLĄDARKĘ (GET)
 http://localhost:8080/building                     Wyświetla informacje o wszystkich elementach 
 http://localhost:8080/building?id=12               Wyświetla info o elemencie 12 (różne informacje w zależności od typu)


JSON
http://localhost:8080/building/new/                 Dodaje nowy budynek zgodnie z danymi w formacie JSON
  + Struktura budynku w JSON
  np {"levels":[{"rooms":[{"area":16.771454,"cube":86.15964,"heating":193.71202,"lightPower":172.36221,"ID":35,"name":"Room"},{"area":35.63685,"cube":44.08831,"heating":74.20811,"lightPower":297.57465,"ID":36,"name":"Room"}],"ID":30,"name":"Level"}],"name":"Building"}