package JavaBean.Tools.Password;

public class DIYCode {

    public DIYCode() {

    }

    public String unicode(String source){
        StringBuffer sb = new StringBuffer();
        char [] source_char = source.toCharArray();
        String unicode = null;
        for (int i=0;i<source_char.length;i++) {
            unicode = Integer.toHexString(source_char[i]);
            if (unicode.length() <= 2) {
                unicode = "00" + unicode;
            }
            sb.append("\\u" + unicode);
        }
        //System.out.println(sb);
        return sb.toString();
    }

    public String decodeUnicode(String unicode) {
        StringBuffer sb = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {
            //System.out.println(hex[i]);
            int data = Integer.parseInt(hex[i], 16);
            sb.append((char) data);
        }
        return sb.toString();
    }

    public String unicodeForMe(String unicode) {

        String[] hex = unicode.split("\\\\u");

        String code = "";
        String password = "";

        for (int i = 1; i < hex.length; i++) {
            String string = hex[i];
            //System.out.println(string);
            code = this.StringToNumber(hex[i]);
            //System.out.println(code);
            password = password + "u" + code;
            code = "";
        }

        return password;
    }

    public String reUnicodeForMe(String unicodeForMe) {
        String[] hex = unicodeForMe.split("u");
        String unicode = "";

        for (int i=1;i<hex.length;i++) {
            //System.out.println(hex[i]);
            char[] arrays = hex[i].toCharArray();
            String temp = "";
            int[] num = new int[] {-1,-1,-1,-1,-1,-1,-1,-1};
            boolean key = false;
            int cc = 0;
            int number = 0;
            for (int j=0;j<arrays.length;j++) {
                //System.out.print(arrays[j]);
                if (arrays[j] == 'c') {
                    key = true;
                    num[cc] = j;
                    cc = cc + 1;
                } else if (arrays[j] == 'e'){
                    num[cc] = j;
                    cc = cc + 1;
                    number = number + 1;
                }
            }
            int numberI = 0;
            int numberII = 0;
            int numberIII = 0;
            int numberIV = 0;
            if (key) {
                int t = 0;
                if (number == 0) {

                } else if (number == 1){
                    String stringI = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringI);
                    numberI = Integer.parseInt(stringI);
                    /*System.out.println((char)numberI);*/
                } else if (number == 2) {
                    String stringI = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringI);
                    t = t + 2;
                    String stringII = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringII);
                    numberI = Integer.parseInt(stringI);
                    numberII = Integer.parseInt(stringII);
                    /*System.out.println((char)numberI);
                    System.out.println((char)numberII);*/
                } else if(number == 3) {
                    String stringI = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringI);
                    t = t + 2;
                    String stringII = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringII);
                    t = t + 2;
                    String stringIII = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringIII);
                    numberI = Integer.parseInt(stringI);
                    numberII = Integer.parseInt(stringII);
                    numberIII = Integer.parseInt(stringIII);
                    /*System.out.println((char)numberI);
                    System.out.println((char)numberII);
                    System.out.println((char)numberIII);*/
                } else if (number == 4) {
                    String stringI = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringI);
                    t = t + 2;
                    String stringII = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringII);
                    t = t + 2;
                    String stringIII = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringIII);
                    t = t + 2;
                    String stringIV = hex[i].substring(num[t]+1, num[t + 1]);
                    //System.out.println(stringIV);
                    numberI = Integer.parseInt(stringI);
                    numberII = Integer.parseInt(stringII);
                    numberIII = Integer.parseInt(stringIII);
                    numberIV = Integer.parseInt(stringIV);
                    /*System.out.println((char)numberI);
                    System.out.println((char)numberII);
                    System.out.println((char)numberIII);
                    System.out.println((char)numberIV);*/
                }
            }
            temp = getPassword(hex[i], numberI, numberII, numberIII, numberIV);
            unicode = unicode + "\\u" + temp;
        }
        return unicode;
    }

    public String getPassword(String password, int numberI, int numberII, int numberIII, int numberIV) {

        char[] arrays = password.toCharArray();

        int longth = arrays.length;

        String pass = "";

        int[] numbers = new int[]{numberI, numberII, numberIII, numberIV};

        int j = 0;

        for (int i=0;i<longth;i++) {
            if (arrays[i] == 'c') {
                char ch = (char)numbers[j];
                j++;
                pass = pass + ch;
                while(arrays[i] != 'e') {
                    i++;
                }
            } else {
                pass = pass + arrays[i];
            }
        }

        return pass;
    }

    // 0123456789
    public String StringToNumber(String string) {
        String number = "";
        char[] arrays = string.toCharArray();

        for (int i=0;i < arrays.length;i++) {
            if (arrays[i] <= '9' && arrays[i] >= '0') {
                number = number + arrays[i];
            } else {
                int num = (int) arrays[i];
                //System.out.println(num);
                number = number + "c" + num + "e";
            }
        }

        return number;
    }

    private String stringText = null;

    private String Code = null;

    public String getStringText() {
        return stringText;
    }

    public void setStringText(String stringText) {
        this.stringText = stringText;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public static void main(String[] args) {
        DIYCode diyCode = new DIYCode();
        String string = diyCode.unicode("核心价值观111aaa@#");
        String passI = diyCode.unicodeForMe(string);
        System.out.println(passI + "-");
        String reCode = diyCode.reUnicodeForMe(passI);
        System.out.println(reCode + "+");
        String text = diyCode.decodeUnicode(reCode);
        System.out.println(text);
    }
}
