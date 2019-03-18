
public class TestHWThree {

    // create a Person object
    public static Person createObject(String firstName, String lastName, int age){
        return new Person(new String(firstName), new String(lastName), age);
    }

    // display contents of the instance variables
    public static String getString(Person p) {
        return "Name = " + p.getFirstName() + " " + p.getLastName()
                + " age: " + p.getAge();
    }

    // display contents of a PersonArrayList
    public static void display(PersonArrayList pal) {
        for (int i = 0; i < pal.size(); i++) {
            System.out.println(i + ": " + getString(pal.get(i)));
        }
    }

    // display contents of a Person array
    public static void display(Person[] perArr) {
        for (int i = 0; i < perArr.length; i++) {
            System.out.println(i + ": " + getString(perArr[i]));
        }
    }

    public static void main(String[] args) {

        Person[] perArr = {createObject("Pilar", "Smith", 45), createObject("Max", "Jay", 11),
                createObject("Abigail", "Zee", 15), createObject("Abigail", "Zee", 14),
                createObject("Jim", "Zee", 15), createObject("Jackson", "Mason", 44),
                createObject("Juan", "Jay", 5), createObject("Carlos", "Mason", 54),
                createObject("Kyle", "Mason", 62), createObject("Xaviar", "Austin", 23),
                createObject("Xaviar", "Austin", 51), createObject("Juan", "Jay", 5),
                createObject("Juan", "Jay", 17),createObject("Ava", "Kim", 33)};

        PersonArrayList pal = new PersonArrayList(6);
        for (Person p : perArr) { // add Person objects to the PersonArrayList
            pal.add(p);
        }
        System.out.println("\nNumber of objects in perArr: " + pal.size());
        display(pal);

        System.out.println("\nDisplay contents in sorted order:" );
        display(pal.sort());


        System.out.println("\nPerson objects greater than Abraham Green 32:");
        display(pal.greaterThan(createObject("Abraham", "Green", 32)));

        System.out.println("\nPerson objects greater than Juan Jay 5:");
        display(pal.greaterThan(createObject("Juan", "Jay", 5)));


        System.out.println("\nAdd Graha mMonday 54  position 3");
        pal.add(3, new Person("Graham", "Monday", 54));
        System.out.println("Number of objects in perArr: " + pal.size());
        display(pal);

        System.out.println("Testing for IndexOutOfBounds for add methods");
        Person p = new Person("Karen", "Enn", 29);
        try {
            pal.add(-1, p);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bounds");
        }
        try {
            pal.add(pal.size() + 1, p);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bounds");
        }

        System.out.println("\nAdd Karen Enn 29  position 0");
        pal.add(0, p);
        System.out.println("Number of objects in perArr: " + pal.size());
        display(pal);

        System.out.println("\nAdd Karen Enn 29  position " + pal.size());
        pal.add(pal.size(), p);
        System.out.println("Number of objects in perArr: " + pal.size());
        display(pal);

        System.out.println("\nAdd Karen Enn 29  position 8");
        pal.add(8, p);
        System.out.println("Number of objects in perArr: " + pal.size());
        display(pal);

        System.out.println("\nTesting for IndexOutOfBounds for remove methods");
        try {
            pal.remove(-3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bounds");
        }
        try {
            pal.remove(pal.size());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bounds");
        }

        System.out.print("\nRemove last object from PersonArrayList: ");
        System.out.println(getString(pal.remove(pal.size() - 1)));
        System.out.println("Number of objects in perArr: " + pal.size());
        display(pal);

        System.out.print("\nRemove first object from PersonArrayList: ");
        System.out.println(getString(pal.remove(0)));
        System.out.println("Number of objects in perArr: " + pal.size());
        display(pal);

        System.out.print("\nRemove 5th object from PersonArrayList: ");
        System.out.println(getString(pal.remove(5)));
        System.out.println("Number of objects in perArr: " + pal.size());
        display(pal);

        System.out.println("\nJuan Jay 18 removed from PersonArrayList: " +
                pal.remove(createObject("Juan", "Jay", 18)));
        System.out.println("Number of objects in perArr: " + pal.size());
        display(pal);

        System.out.println("\nJuan Jay 5 removed from PersonArrayList: " + pal.remove(createObject("Juan", "Jay", 5)));
        System.out.println("Number of objects in perArr: " + pal.size());
        display(pal);

        System.out.println("\nFinal PersonArrayList in Sorted Order");
        display(pal.sort());



    }
}
