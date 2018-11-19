package teacher_chu.work013;

public class goods {
    public goods(String id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    String name = null;
    String id = null;
    int money = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
