package it.gianvitoblog.blog.dto;

public class PostDTO {
    private String title;
    private String body;
    private String authorFirstname;
    private String authorLastname;
    private Integer bodyLenght;
    private String authorEmail;

    public PostDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }

    public String getAuthorLastname() {
        return authorLastname;
    }

    public void setAuthorLastname(String authorLastname) {
        this.authorLastname = authorLastname;
    }

    public Integer getBodyLenght() {
        return bodyLenght;
    }

    public void setBodyLenght(Integer bodyLenght) {
        this.bodyLenght = bodyLenght;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
}
