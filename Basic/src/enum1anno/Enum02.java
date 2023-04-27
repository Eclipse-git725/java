package enum1anno;

public class Enum02 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
        // values方法，返回枚举类中的所有常量
        Week[] weeks = Week.values();
        for(Week week : weeks){
            System.out.println(week);
        }
    }
}

enum Season2{
    SPRING("春天","温暖"),Winter("冬天","严寒");
    private String name;
    private String desc;

    private Season2() {
    }

    private Season2(String name, String desc) {
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

enum Week{
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");

    private String name;

    private Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}