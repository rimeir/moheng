package moheng.auth.dto;

public class LoginMember {
    private Long id;

    private LoginMember() {
    }

    public LoginMember(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
