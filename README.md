# Notes REST API
requires java 7 or newer

requires apache SPARK framework `https://spark.apache.org/downloads.html`

install via brew
`brew install apache-spark`

run Api.java

# API end Points

```
post("/notes") -- to add a note
get("/notes") -- get all notes
get("/notes/{id}" -- get note by id
get("notes?query=xxx") -- get all notes with query string
delete("notes/{id}") -- delete note by id
put("notes/{id}?body=xxx") -- update note by id
```
