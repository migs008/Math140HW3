/*
Author: Miguel Aquino
Date: 3/19/2019
Purpose: Compares the names and ages of persons.
*/

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

    @Override
    public boolean equals(Object o) {
        Person other = (Person) o;

        return other.firstName.equals(firstName) && other.lastName.equals(lastName) && other.age == age;

    }

    @Override
    public int compareTo(Person p) {

        int x;

        if (!this.lastName.equalsIgnoreCase(p.lastName)) {
            x = this.lastName.compareTo(p.lastName);
        }
        else if (!this.firstName.equalsIgnoreCase(p.firstName)) {
            x = this.firstName.compareTo(p.firstName);
        }
        else {
            x = this.age - p.age;
        }
        return x;
    }

}
