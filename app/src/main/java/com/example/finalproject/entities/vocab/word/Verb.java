
package com.example.finalproject.entities.vocab.word;

import java.io.Serializable;
import java.util.List;

public class Verb extends PartOfSpeech implements Serializable
{

    private final static long serialVersionUID = 4138753342594446L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Verb() {
    }

    /**
     * 
     * @param syn
     */
    public Verb(List<String> syn, List<String> ant, List<String> rel, List<String> sim) {
        super(syn, ant, rel, sim);

    }


}
