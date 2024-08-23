package main;

import structures.FASTA;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) {
        Path p = Paths.get("/home/valentin-rexer/uni/own/Cyprinodon_variegatus.C_variegatus-1.0.dna.toplevel.fa");
        FASTA f = new FASTA();
        f.store(p);

        f.size();
    }
}
