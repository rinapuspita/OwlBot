package com.jiayou.owlbot.model;

import java.util.ArrayList;

public class OwlBotResponse {
    private  String type;
    private String definition;
    private String example;
    private String image_url;

    public OwlBotResponse(String type, String definition, String example, String image_url) {
        this.type = type;
        this.definition = definition;
        this.example = example;
        this.image_url = image_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
