
package com.example.finalproject.entities.vocab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.finalproject.entities.vocab.word.Adjective;
import com.example.finalproject.entities.vocab.word.Adverb;
import com.example.finalproject.entities.vocab.word.Noun;
import com.example.finalproject.entities.vocab.word.PartOfSpeech;
import com.example.finalproject.entities.vocab.word.Verb;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VocabResponse implements Serializable
{

    @SerializedName("adjective")
    @Expose
    private Adjective adjective;
    @SerializedName("adverb")
    @Expose
    private Adverb adverb;
    @SerializedName("noun")
    @Expose
    private Noun noun;
    @SerializedName("verb")
    @Expose
    private Verb verb;

    private PartOfSpeech word;
    private final static long serialVersionUID = -993697291068904962L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VocabResponse() {
    }



    /**
     * 
     * @param adjective
     * @param verb
     * @param noun
     * @param adverb
     */
    public VocabResponse(Adjective adjective, Adverb adverb, Noun noun, Verb verb) {
        super();
        this.adjective = adjective;
        this.adverb = adverb;
        this.noun = noun;
        this.verb = verb;

    }

    public PartOfSpeech getWord() {
        return this.word != null ? word : combinedEntries();
    }

    private PartOfSpeech combinedEntries(){
        this.word = new PartOfSpeech(mergeSyn(), mergeAnt(), mergeRel(), mergeSim());
        return this.word;
    }

    private List<String> mergeSyn() {
        List<String> synList = new ArrayList<>();

        if(adjective != null && adjective.getSyn() != null) synList.addAll(this.adjective.getSyn());
        if(adverb != null && adverb.getSyn() != null) synList.addAll(this.adverb.getSyn());
        if(noun != null && noun.getSyn() != null) synList.addAll(this.noun.getSyn());
        if(verb != null && verb.getSyn() != null) synList.addAll(this.verb.getSyn());

        return synList;
    }

    private List<String> mergeRel() {
        List<String> relList = new ArrayList<>();

        if(adjective != null && adjective.getRel() != null) relList.addAll(this.adjective.getRel());
        if(adverb != null && adverb.getRel() != null) relList.addAll(this.adverb.getRel());
        if(noun != null && noun.getRel() != null) relList.addAll(this.noun.getRel());
        if(verb != null && verb.getRel() != null) relList.addAll(this.verb.getRel());

        return relList;
    }

    private List<String> mergeSim() {
        List<String> simList = new ArrayList<>();

        if(adjective != null && adjective.getSim() != null) simList.addAll(this.adjective.getSim());
        if(adverb != null && adverb.getSim() != null) simList.addAll(this.adverb.getSim());
        if(noun != null && noun.getSim() != null) simList.addAll(this.noun.getSim());
        if(verb != null && verb.getSim() != null) simList.addAll(this.verb.getSim());

        return simList;
    }
    private List<String> mergeAnt() {
        List<String> antList = new ArrayList<>();

        if(adjective != null && adjective.getAnt() != null) antList.addAll(this.adjective.getAnt());
        if(adverb != null && adverb.getAnt() != null) antList.addAll(this.adverb.getAnt());
        if(noun != null && noun.getAnt() != null) antList.addAll(this.noun.getAnt());
        if(verb != null && verb.getAnt() != null) antList.addAll(this.verb.getAnt());

        return antList;
    }

    public Adjective getAdjective() {
        return adjective;
    }
    public Adverb getAdverb() {
        return adverb;
    }
    public Noun getNoun() {
        return noun;
    }
    public Verb getVerb() {
        return verb;
    }


}
