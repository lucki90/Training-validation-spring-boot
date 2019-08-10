package pl.lucky.model;

import pl.lucky.common.Lang;
import pl.lucky.constraint.NotBadWord;

import javax.validation.constraints.NotNull;

public class Message {

    @NotNull
    private String title;
    @NotBadWord(lang = {Lang.PL, Lang.ENG})
    private String content;
    public Message(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
