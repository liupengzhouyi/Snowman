package teacher_chu.javaBean;

public class GuestBook {

    /*public GuestBook() {
        init();
    }

    public GuestBook(String name, String phone, String email, String title, String content) {
        init();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public GuestBook(String id, String name, String phone, String email, String title, String content) {
        init();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public GuestBook(String id, String name, String phone, String email, String title, String content, String time) {
        init();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public void init() {
        this.id = new String();
        this.name = new String();
        this.phone = new String();
        this.title = new String();
        this.email = new String();
        this.content = new String();
        this.time = new String();
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getPhone() {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }*/

    private Integer id = 0;
    private String name = null;
    /*private String phone =null;
    private String email = null;
    private String title = null;
    private String content = null;
    private String time = null;*/
}
