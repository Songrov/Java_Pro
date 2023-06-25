package lesson1.HW1;
public class Person {
    private String fullName;
    private int age;

    public void walk()
    {
        System.out.println("Person " + fullName + " идет");
    }

    public void talk()
    {
        System.out.println("Person " + fullName + " говорит");
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public static void main(String[] args) {
        Person johnSmith = new Person();
        johnSmith.setFullName("John Smith");
        johnSmith.setAge(25);

        Person maryBrown = new Person("Mary Brown", 27);

        johnSmith.talk();
        maryBrown.walk();

        // maryBrown.age
    }

}