
package com.example.finalproject.entities.vocab.word;

import java.io.Serializable;
import java.util.List;

public class Noun extends PartOfSpeech implements Serializable
{

    private final static long serialVersionUID = 7051965827621944844L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Noun() {
    }

    /**
     * 
     * @param syn
     */
    public Noun(List<String> syn, List<String> ant, List<String> rel, List<String> sim) {
        super(syn, ant, rel, sim);

    }

}
