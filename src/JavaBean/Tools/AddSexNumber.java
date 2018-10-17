package JavaBean.Tools;

public class AddSexNumber {

    private String IDNumber = null;

    public AddSexNumber(String IDNumber, String sex) {
        this.IDNumber = IDNumber;
        this.AddSex(sex);
    }

    public void AddSex(String sex) {
        String sexNumber = "";
        if(sex == "男") {
            sexNumber = "0";
        } else {
            sexNumber = "1";
        }
        this.IDNumber = this.IDNumber + sexNumber;
    }

    public String getIDNumber() {
        return this.IDNumber;
    }
}
