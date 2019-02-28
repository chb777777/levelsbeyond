# Notes REST API
requires java 7 or newer
requires Java Maven Framework `https://maven.apache.org/what-is-maven.html`
requires apache SPARK framework `https://spark.apache.org/downloads.html`

install via brew
`brew cask install java`
`brew install apache-spark`
`brew install maven`

In project main folder
install all project dependencies `maven install`
run Api.java `java Api.java`

# API end Points

```
post("/notes") -- to add a note
get("/notes") -- get all notes
get("/notes/{id}" -- get note by id
get("notes?query=xxx") -- get all notes with query string
delete("notes/{id}") -- delete note by id
put("notes/{id}?body=xxx") -- update note by id
```
