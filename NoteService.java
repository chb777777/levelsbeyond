package notes;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NoteService
{
    private static Map<Long, Note> notes = new HashMap<>();
    private static final AtomicInteger count = new AtomicInteger(0);


    public Note addNote(String newNote)
    {
        long currentId = count.incrementAndGet();
        Note note = new Note(currentId, newNote);
        notes.put(currentId, note);
        return note;
    }
    public List<Note> getAllNotes()
    {
        return new ArrayList<>(notes.values());
    }

    public List<Note> getAllNotes(String needle)
    {
        List<Note> allNotes = getAllNotes();
        List<Note> result =  new ArrayList<Note>();

        for (int i = 1; i < allNotes.size(); i++)
        {
            if(allNotes.get(i).getBody().indexOf(needle)!=-1)
            {
                result.add(allNotes.get(i));
            }
        }
        return result;
    }

    public Note getNote(String id)
    {
        return notes.get(Long.parseLong(id));
    }

    public void deleteNote(String id)
    {
        notes.remove(Long.parseLong(id));
    }

    public Note updateNote(String id, String body)
    {
        long cid = Long.parseLong(id);
        notes.get(cid).setBody(body);
        return notes.get(cid);
    }
}