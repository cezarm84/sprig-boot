Öppna webbläsaren:
Gå till
http://localhost:8080 i din webbläsare

Användning:
Skapa en ny kanal
Gå till
 http://localhost:8080
Använd "Skapa kanal" för att lägga till en ny
Visa alla kanaler
Gå till http://localhost:8080/channels.
Här kan du se en lista över alla  kanaler.
_________________________________________________________________
Visa en specifik kanal
Gå till http://localhost:8080/channels/{id}.
Ersätt {id} med den faktiska ID:et för kanalen du vill visa.
___________________________________________
Uppdatera en kanals titel
OBS!!!!( jag har fortfarande problem med detta)
Använd en PATCH-brequest till http://localhost:8080/channels/{id}.
Ersätt {id} med den faktiska ID:et för kanalen.
Skicka med en JSON-payload som innehåller "newTitle": "Nytt Kanalnamn".
_____________________________________________________________
Skicka ett meddelande i en kanal
Använd en PUT-begäran till http://localhost:8080/channels/channel/{id}/messages.
Ersätt {id} med den faktiska ID:et för kanalen.

___________________________________
Visa alla meddelanden i kanal
Gå till http://localhost:8080/channels/{id}/messages.
Ersätt {id} med den faktiska ID:et för kanalen.
_______________________
Uppdatera ett meddelandes innehåll
Använd en PATCH-begäran till
http://localhost:8080/channels/messages/{id}.
Ersätt {id} med den faktiska ID:et för meddelandet.

__________________________________________
Ta bort ett meddelande
Använd en DELETE-begäran till http://localhost:8080/channels/messages/{id}.
Ersätt {id} med den faktiska ID:et för meddelandet.