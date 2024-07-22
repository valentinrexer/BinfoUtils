package structures;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FASTA {
    private List<FastaEntry> entries;

    public long size() {
        return entries.size();
    }

    public List<FastaEntry> getEntries() {
        return entries;
    }
}
