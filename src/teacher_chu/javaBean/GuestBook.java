package teacher_chu.javaBean;

public class GuestBook {

    public GuestBook(String name, String phone, String email, String title, String content) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public void inti() {
        this.name = new String();
        this.phone = new String();
        this.title = new String();
        this.email = new String();
        this.content = new String();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    private String name = null;
    private String phone =null;
    private String email = null;
    private String title = null;
    private String content = null;
}
