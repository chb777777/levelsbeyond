package notes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;

public class Api {

    public static NoteService noteService = new NoteService();
    private static ObjectMapper om = new ObjectMapper();

    public static void main(String[] args)
    {
        port(8080);

        Gson gson = new Gson();
        //POST - add a new note
        post("/notes", (req, res) ->
        {
            res.type("application/json");
            Note note = gson.fromJson(req.body(), Note.class);
            Note result = noteService.addNote(note.getBody());
            res.status(201); // 201 Created
            return om.writeValueAsString(result);
        });
        // GET - get all notes with or without search string
        get("/notes", (req, res) ->
        {
            String needle = req.queryParams("query");
            res.type("application/json");
            if(needle!=null)
            {
                List result = noteService.getAllNotes(needle);
                if(result.isEmpty())
                {
                    return om.writeValueAsString("no note contain query string");
                }
                return om.writeValueAsString(result);
            }
            List result = noteService.getAllNotes();
            if (result.isEmpty())
            {
                return om.writeValueAsString("note not found");
            }
            else
            {
                return om.writeValueAsString(noteService.getAllNotes());
            }
        });
        // GET - get note by id
        get("/notes/:id", (req, res) ->
        {
            res.type("application/json");
            Note result =  noteService.getNote(req.params(":id"));
            if(result!=null)
            {
                return om.writeValueAsString(result);
            }
            else
            {
                res.status(404); // 404 Not found
                return om.writeValueAsString("Note not found");
            }
        });
        // DELETE - delete note
        delete("/notes/:id", (req, res) -> {
            String id = req.params(":id");
            Note note = noteService.getNote(id);
            if (note != null)
            {
                noteService.deleteNote(id);
                return om.writeValueAsString("Note with id " + id + " is deleted!");
            }
            else
            {
                res.status(404);
                return om.writeValueAsString("Note not found");
            }
        });

        // PUT - Update note
        put("/user/:id", (req, res) -> {
            String id = req.params(":id");
            Note user = noteService.getNote(id);
            if (user != null) {
                String body = req.queryParams("body");
                noteService.updateNote(id, body);
                return om.writeValueAsString("Note with id " + id + " is updated!");
            } else {
                res.status(404);
                return om.writeValueAsString("Note not found");
            }
        });
    }
}