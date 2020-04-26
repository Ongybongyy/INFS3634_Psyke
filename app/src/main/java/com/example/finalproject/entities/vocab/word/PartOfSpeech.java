
package com.example.finalproject.entities.vocab.word;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartOfSpeech implements Serializable
{

    @SerializedName("syn")
    @Expose
    private List<String> syn = null;
    @SerializedName("ant")
    @Expose
    private List<String> ant = null;
    @SerializedName("rel")
    @Expose
    private List<String> rel = null;
    @SerializedName("sim")
    @Expose
    private List<String> sim = null;
    private final static long serialVersionUID = 4229148917701640713L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PartOfSpeech() {
    }

    protected void setSyn(List<String> syn) {
        this.syn = syn;
    }

    protected void setAnt(List<String> ant) {
        this.ant = ant;
    }

    protected void setRel(List<String> rel) {
        this.rel = rel;
    }

    protected void setSim(List<String> sim) {
        this.sim = sim;
    }

    /**
     *
     * @param ant
     * @param sim
     * @param rel
     * @param syn
     */
    public PartOfSpeech(List<String> syn, List<String> ant, List<String> rel, List<String> sim) {
        super();
        this.syn = syn;
        this.ant = ant;
        this.rel = rel;
        this.sim = sim;
    }

    public List<String> getSyn() {
        return syn;
    }

    public List<String> getAnt() {
        return ant;
    }

    public List<String> getRel() {
        return rel;
    }

    public List<String> getSim() {
        return sim;
    }


}
