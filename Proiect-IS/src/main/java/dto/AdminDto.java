package dto;

public class AdminDto {

    private String id;
    private String email;


    public String getIdAdmin() {
        return id;
    }

    public void setIdAdmin(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "idAdmin='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
