package lesson6.helpers;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
        		"id='" + id + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
