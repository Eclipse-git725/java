package generic;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1", new User(1, 18, "张三"));
        dao.save("2", new User(2, 20, "李四"));
        dao.save("3", new User(3, 22, "王五"));

        System.out.println("获取id为2的对象：" + dao.get("2"));
        dao.update("3", new User(3, 25, "赵六"));
        System.out.println("获取id为3的对象：" + dao.get("3"));
        System.out.println("获取所有对象：" + dao.list());
        dao.delete("1");
        System.out.println("删除id为1的对象：" + dao.list());
    }
}
class DAO<T>{
    Map<String,T> map = new HashMap<>();
    public void save(String id, T entity){
        map.put(id, entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        if(map.containsKey(id)) {
            map.put(id, entity);
        }
    }
    public List<T> list(){
        List<T> list = new ArrayList<>();
        Iterator<Map.Entry<String, T>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, T> obj =  iterator.next();
            list.add(obj.getValue());
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }
}
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name + " age: " + age;
    }
}