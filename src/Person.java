public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, 50);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Object o) {
        Person other = (Person) o;

        return other.firstName.equals(firstName) && other.lastName.equals(lastName) && other.age == age;

    }

    public int compareTo(Person p) {

        if (!this.lastName.equalsIgnoreCase(p.lastName)) {
            return this.lastName.compareTo(p.lastName);
        }
        else if (!this.firstName.equalsIgnoreCase(p.firstName)) {
            return this.firstName.compareTo(p.firstName);
        }
        else {
            return this.age - p.age;
        }
    }

}
