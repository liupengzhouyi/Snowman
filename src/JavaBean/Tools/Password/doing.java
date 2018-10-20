package JavaBean.Tools.Password;

public class doing {
    public static void main(String[] args) {
        String user = "liupeng.0@outlook.com";
        String code = "核心价值观";

        System.out.println("用户：" + user);

        System.out.println("明文：" + code);

        String password = new password(user).getPrivatePassword();
        System.out.println("私钥：" + password);

        DIYCode diyCode = new DIYCode();

        String unicode = diyCode.unicode(code);
        System.out.println("转化为unicode：" + unicode);

        String myUnicode = diyCode.unicodeForMe(unicode);
        System.out.println("我的unicode：" + myUnicode);

        String yourUnicode = new CreateValues(password, myUnicode).getCoreValues();
        System.out.println("与密钥结合：" + yourUnicode);

        String valuees = new Encryption(yourUnicode).getText();
        System.out.println("你的密文：" + valuees);

        System.out.println("我的unicode：" + myUnicode);
        myUnicode = new GetYourUnicode(valuees).getMyUnicode();
        System.out.println("我的unicode：" + myUnicode);

        String unicodeII = new DIYCode().reUnicodeForMe(myUnicode);
        System.out.println("转化为unicode："+ unicodeII);

        String string = new DIYCode().decodeUnicode(unicodeII);
        System.out.println("明文：" + string);
    }
}
