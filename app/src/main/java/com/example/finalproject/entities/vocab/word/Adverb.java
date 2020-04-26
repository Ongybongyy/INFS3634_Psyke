
package com.example.finalproject.entities.vocab.word;

import java.io.Serializable;
import java.util.List;

public class Adverb extends PartOfSpeech implements Serializable
{


    private final static long serialVersionUID = 1547647236105617884L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Adverb() {
    }

    /**
     * 
     * @param syn
     */
    public Adverb(List<String> syn, List<String> ant, List<String> rel, List<String> sim) {
        super(syn, ant, rel, sim);

    }

}
