package memoEx.entity;

import java.time.LocalDateTime;

public class PostEntity {
    private String title;
    private String content;

    private LocalDateTime lastUpdatedDateTime;

    private PostEntity(String title, String content){
        this.title = title;
        this.content = content;
        this.lastUpdatedDateTime = LocalDateTime.now();
    }

    static PostEntity newInstance(String title, String content){
        return new PostEntity(title, content);
    }

    void update(String content){
        this.content = content;
        this.lastUpdatedDateTime = LocalDateTime.now();
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    String getLastUpdatedDateTime() {
        return lastUpdatedDateTime.toString();
    }
}
