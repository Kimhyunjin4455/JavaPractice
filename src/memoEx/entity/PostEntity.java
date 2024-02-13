package memoEx.entity;

import java.time.LocalDateTime;

public class PostEntity {

    private int id;
    private String title;
    private String content;

    private LocalDateTime lastUpdatedDateTime;

    private PostEntity(int id, String title, String content, LocalDateTime localDateTime){
        this.title = title;
        this.content = content;
        this.lastUpdatedDateTime = localDateTime;
    }

    static PostEntity newInstance(int id, String title, String content, LocalDateTime localDateTime){
        return new PostEntity(id, title, content, localDateTime);
    }

    void update(String content){
        this.content = content;
        this.lastUpdatedDateTime = LocalDateTime.now();
    }

    int getId(){
        return id;
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
