
package com.example.finalproject.entities.vocab.word;

import java.io.Serializable;
import java.util.List;

public class Adjective extends PartOfSpeech implements Serializable
{

    private final static long serialVersionUID = 4229148917701640713L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Adjective() {
    }

    /**
     * 
     * @param ant
     * @param sim
     * @param rel
     * @param syn
     */
    public Adjective(List<String> syn, List<String> ant, List<String> rel, List<String> sim) {
        super(syn, ant, rel, sim);

    }


}
