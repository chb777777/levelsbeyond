# Notes REST API
requires java 7 or newer

requires SPARK `https://spark.apache.org/downloads.html`

run Api.java

# end Points

```
post("/notes") -- to add a note
get("/notes") -- get all notes
get("/notes/{id}" -- get note by id
get("notes?query=xxx") -- get all notes with query string
delete("notes/{id}") -- delete note by id
put("notes/{id}?body=xxx") -- update note by id
```
