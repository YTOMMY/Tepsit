# Bassoni Tepsit

### webService_Bassoni
questo è un progetto eclipse maven che implementa un web service. <br>
dopo aver eseguito il comando mvn jetty:run si avvierà il servizio. <br>
servizi disponibili: <br>
pagina home con collegamento all'autore
/api/test/{nome} (GET): restituisce {nome} in maiuscolo <br>
/api/books (GET): restituisce elenco libiri <br>
/api/books/{id} (GET): restituisce il libro con id = {id} <br>
/api/books/{id}/authors: restituisce gli autori del libro con id = {id} <br>
/api/books (POST: Book): Inserisce un il libro <br>
/api/books/{id} (PUT: Book): Modifica il libro con id = {id} <br>
/api/books/{id} (DELETE): Elimina il libro con id = {id}

### webService_Bassoni_client
lato client di webService_Bassoni <br>
avviare it.edu.marconipontedera.
