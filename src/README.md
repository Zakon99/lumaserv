# User API

REST-API mit Spring Boot, Swagger & H2 Datenbank zur Verwaltung von Benutzern.

## Notiz
Auch wenn Swagger keine Anforderung war, habe ich es mit aufgenommen, da es nur ein paar Zeilen Code sind
und mir, dass das Testen und verifizieren der API vereinfacht. Somit muss mir nicht selber CURL befehle schreiben und immer zu Copy & Pasten.
Schien für mich Zeitfressender wie eben Swagger aufzusetzen.

Für den Docker h2 Container habe ich mich ebenfalls bewusst entscheiden, da ich fit mit Docker bin. Ich habe einfach mal die annahme getroffen,
dass ihr Docker isntalliert habt. Wenn nicht fällt mir leider die Anforderung "das Projekt lokal startbar ist". Ich hoffe das ist ok.

Ich habe die Commits versucht so kleinteilig wie möglich zu halten, dass ihr auch mein Tempo, bzw. meine Schritte nacvollziehen könnt.

Zentrales Exception Handling und einfach Authentifizierung mittels Spring Security habe ich leider Zeitlich nicht mehr geschafft.

Da ich eigentlich aus dem JakartaEE umfeld komme habe ich mich relativ Strikt an die SpringStarterDokumentation gehalten.
Das gleiche gilt für die JUnit Tests. Wie im gespräch bereits erwähnt hatte ich nie viel Berührung mit JUnit Tests.
Die Tests sind dementsprechend auch stark an Dokumentation gehalten und so rudimentär wie möglich.


## Voraussetzungen
- Java 21
- Maven 3.9+
- Docker / Docker Compose

## Starten
Bevor die APi gestartet wird, muss die Datenbank aufgesetzt werden. 

Per CMD in das ```src/main/resources/docker``` verzeichnis wechseln. Dann folgenden Command ausführen:

```bash
docker compose up -d
```
Nach erstelllung des Docker Containers dann die Spring Boot Application Starten:

```bash
mvn spring-boot:run      # startet auf http://localhost:8080
```

## Endpoints
Endpunkte sid im Swagger Dokumentiert und können darüber getestet werden.
http://localhost:8080/swagger-ui.html

## Aufbau (Model-View-Controller)

```
UserController            HTTP Endpoints
UserService               Geschäftslogik
UserRepository            Datenzugriff (Spring Data JPA)
User                      Model: JPA-Entity
UserNotFoundException     User wurde in der DB nicht gefunden Exception
EmailExistsException      Email Adresse ist bereits verwendet Exception
CreateUserRequest         Record für ein CreateuserRequest
UserResponse              Record für ein UserResponse
```
