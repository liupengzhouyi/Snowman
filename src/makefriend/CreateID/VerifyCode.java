package makefriend.CreateID;

/**
 * 类名： Verify Code
 * 函数： 构造函数
 *       计算校验码：
 *       添加校验码：
 * 使用方法：
 * 1。 实例话
 * 2。 getID();
 */
public class VerifyCode {

    public VerifyCode(String ID) {
        this.setID(ID);
        this.init(ID);
    }

    public void init(String id) {
        //System.out.println(id);
        //校验序列
        int[] numbers = new int[]{1,3,5,4,2,5,2,4,3,7,9,8,6,5};
        //ID长度
        int lonnth = id.length();
        char[] array = id.toCharArray();
        //临时工
        int addNumber = 0;
        //校验数
        int verifyNumber = 0;
        for (int i=0;i<lonnth;i++) {
            String temp = array[i] + "";
            //System.out.println(temp);
            int number = Integer.valueOf(temp);
            //System.out.println(number);
            addNumber = number * numbers[i];
            verifyNumber = verifyNumber + addNumber;
            addNumber = 0;
        }
        //获取检验码
        verifyNumber = verifyNumber % 9;
        //检验吗格式转换
        String verifyCode = String.valueOf(verifyNumber);
        this.AddIDAndVerifyCode(this.getID(),verifyCode);
    }

    public void AddIDAndVerifyCode(String ID, String verify) {
        this.setID(ID + verify);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    //user id
    private String ID;


    public static void main(String[] args) {
        VerifyCode verifyCode = new VerifyCode("2018101712098");

    }
}
