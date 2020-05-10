package com.jiayou.owlbot.model;

import java.util.ArrayList;

public class Word {
    String word;
    String pronunciation;
    ArrayList<OwlBotResponse> definitions;

    public Word(String word, String pronunciation, ArrayList<OwlBotResponse> definitions) {
        this.word = word;
        this.pronunciation = pronunciation;
        this.definitions = definitions;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public ArrayList<OwlBotResponse> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(ArrayList<OwlBotResponse> definitions) {
        this.definitions = definitions;
    }
}
