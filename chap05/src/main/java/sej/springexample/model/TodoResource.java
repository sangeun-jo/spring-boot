package sej.springexample.model;

import org.springframework.hateoas.ResourceSupport;

public class TodoResource extends ResourceSupport { //ResourceSupport 리소스 반환할 때 링크정보 포함할 수 있게 해줌
    private String title;

    public TodoResource() {
    }

    public TodoResource(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
