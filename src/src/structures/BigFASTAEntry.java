package structures;

public class BigFASTAEntry {
    private String name;
    private LongPair position;

    public BigFASTAEntry(String name, LongPair position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LongPair getPosition() {
        return position;
    }

    public void setPosition(LongPair position) {
        this.position = position;
    }
}
