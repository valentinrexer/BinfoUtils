package structures;

import java.util.Objects;

public class FastaEntry {
    private String id;
    private String sequence;

    public FastaEntry(String id, String sequence) {
        this.id = id;
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FastaEntry that = (FastaEntry) o;
        return Objects.equals(id, that.id) && Objects.equals(sequence, that.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sequence);
    }
}
