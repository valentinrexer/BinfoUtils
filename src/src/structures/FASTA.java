package structures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FASTA {
    private List<FASTAEntry> entries;
    private Logger LOG = LogManager.getLogger(FASTA.class);

    public FASTA() {
        entries = new ArrayList<>();
    }

    public FASTA(Path filePath) {
        entries = new ArrayList<>();
        store(filePath);
    }

    public FASTA(List<Path> files) {
        entries = new ArrayList<>();

        for (Path file : files) {
            store(file);
        }
    }

    public void store(Path filePath) {
        LOG.info("Storing FASTA file: " + filePath.toAbsolutePath());
        long counter = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()));
            String line;
            String name = "";
            String sequence = "";

            while ((line = br.readLine()) != null) {
                if(line.startsWith(">")){

                    if(!name.isEmpty()) {
                        entries.add(new FASTAEntry(name, sequence));
                        sequence = "";
                        counter++;
                        if(counter % 1000 == 0){
                            LOG.info("Stored {} entries from {}", counter, filePath.toAbsolutePath());
                        }
                    }

                    name = line;
                }

                else sequence = sequence.concat(line);
            }

            entries.add(new FASTAEntry(name, sequence));
            LOG.info("Stored {} entries from {}", counter, filePath.toAbsolutePath());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long size() {
        return entries.size();
    }

    public List<FASTAEntry> getEntries() {
        return entries;
    }
}
