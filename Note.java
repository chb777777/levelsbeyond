package notes;

public class Note {

    private Long id;
    private String body;

    public Note(){
    }

    public Note(long id, String body) {
        this.id = id;
        this.body = body;
    }

    public String getBody()
    {
        return this.body;
    }

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setBody(String newBody)
    {
        this.body = newBody;
    }
}
