package sej.springexample.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserVO implements Serializable {
    private String id;
    @NotNull(message = "userName 필드가 null 입니다.")
    private String userName;
    private String email;

    public UserVO() {
    }

    public UserVO(String id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
