package enum1anno;

public class Enum01 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
    }
}

class Season{
    private String name;
    private String desc;
    public static final Season SPRING = new Season("春天","温暖");
    public static final Season WINTER = new Season("冬天","温暖");
    public static final Season SUMMER = new Season("夏天","温暖");
    public static final Season AUTUMN = new Season("秋天","温暖");
    // 将构造器改为私有，防止直接new
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    // 取消set方法，不允许改

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}