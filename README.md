# Math140HW3
Math 140 Programming Assignment 3 Deadline: Wednesday, March 20, 2019
Learning Objectives: After completing this assignment you should know how to (1) write
a class with multiple constructors (2) write a class that implements Comparable, (2)
compare objects, and (3) write methods for an ArrayList object.
Part 1: Write a class called Person that implements Comparable with the following
features
Private instance variables:
String firstName
String lastName
int age
Public constructor:
Person(String firstName, String lastName, int age) – initializes the instance variables
Person(String firstName, String lastName) – initializes firstName and lastName; the age
should be set to 50. This constructor should only have one executable statement. Use
the keyword this to implement this feature.
Public methods:
• Accessor and mutator methods for the three instance variables.
• boolean equals(Object o) – returns true if two Person objects have the same name
and age; otherwise returns false
• int compareTo(Person p) – Let p1 and p2 represent two Person objects.
If lastName of p1 > lastName of p2 then p1 > p2.
If the values stored in lastName are equal then if firstName of p1 > firstName of p2 then
p1 > p2.
If the values stored in lastName and firstName are equal then if age of p1 > age of p2
then p1 > p2.
Example for the compareTo method: Suppose we have the following objects
 Person p1 = new Person("Tom", "Smith", 18);
 Person p2 = new Person("Jane", "Monday", 45);
 Person p3 = new Person("Pilar", "Monday", 30);
 Person p4 = new Person("Jane", "Monday", 30);
Using the above rules we can conclude that p1 > p2, p3 > p2, and p2 > p4.
Math 140 Programming Assignment 3 Deadline: Wednesday, March 20, 2019
Part 2: [Note that in the examples below the variables p1, p2, p3, p4, and p5 refer to
Person objects.]
Write a class called PersonArrayList that is a modified version of the ArrayList class.
The PersonArrayList class contains the following features
Private Instance Variables
Person[] list - stores the Person objects for the PersonArrayList class
int size – contains the number of Person objects stored in the PersonArrayList object;
Note that 0 <= size < list.length.
The initial value of size is zero. The only methods that change the value of size are the
add and remove methods. The constructor does not assign a value to size.
Public Constructor
PersonArrayList(int capacity) – allocates memory for the list array.
Example: If capacity = 10 then assign an array with 10 elements to list.
Important: The constructor only allocates memory for the array of Person objects.
Private Method
void ensureCapacity(int minCapacity) method increases the capacity of this
PersonArrayList instance, if necessary, to ensure that it can hold at least the number of
elements specified by the minimum capacity argument. If minCapacity is less than or
equal to list.length then make no changes to the list array.
If minCapacity > list.length then increase the length of the list array to minCapacity.
Elements stored at positions 0 to size – 1 after changing the capacity should be
identical to the values stored in these positions before increasing the array length. (Use
techniques found in the increaseCapacity method presented in class.)
Example: Suppose list = {p1, p2, p3};
After calling ensureCapacity(5) the contents of list should be
list = {p1, p2, p3, null, null};
Note that null values are automatically added to the array when increasing the capacity
to five.
IMPORTANT: ensureCapacity is the only method that can change the length of the
list array.
Math 140 Programming Assignment 3 Deadline: Wednesday, March 20, 2019
Public Methods
1. void add(Person p) If size ≥ list.length then call the ensureCapacity method to
double the size of the list array. After guaranteeing the list array has sufficient
capacity, insert value at position size in the list array and then increase size by 1.
Example: Suppose list = {p1, p2, p3, null}, size = 3.
After calling add(p4), list = {p1, p2, p3, p4} and size = 4.
 After call add(p5), list = {p1, p2, p3, p4, p5, null, null, null} and size = 5.

2. void add(int index, Person value) If index < 0 or index > size then throw an
IndexOutOfBoundsException. If size ≥ list.length then call the ensureCapacity
method to double the size of the list array. After guaranteeing the list array has
sufficient capacity, insert value at position index in the list array and then
increase size by 1.
Example of throwing the exception:
if (index < 0 || index > size)
 throw new IndexOutOfBoundsException();
Example: Suppose list = {p1, p2, p3, null} and size = 3
After calling add(2, p4), list = {p1, p2, p4, p3} and size = 4
3. Person remove(int index) If index < 0 or index >= size then throw an
IndexOutOfBoundsException. Otherwise, remove the value stored at index by
shifting the values stored in list to the left, decrease size by 1, and return the Person
removed by the method.
Example: Suppose list = {p1, p2, p3, p4} and size = 4
After calling remove(2), list = {p1, p2, p4, null} , size = 3, return p3
4. boolean remove(Person s) If s is in the list then remove the first occurrence of
s, values to the right of removed value are shifted to the left, decrease size by 1,
and return true. Otherwise, return false.
Math 140 Programming Assignment 3 Deadline: Wednesday, March 20, 2019
5. Person get(int index) – If index < 0 or index >= size then throw an
IndexOutOfBoundsException. Otherwise, return the Person object stored at
position index.
6. int size() – return the value of size
7. PersonArrayList greaterThan(Person p) – returns a PersonArrayList object
containing Person objects that are greater than p.
8. Person[] sort() – returns an array containing the Person objects stored in the
PersonArrayList object in sorted order. [The length of the returned array = size.
Note that the number of Person objects in the list array can be greater than
size.]
Example:
Assume list = {p1, p2, p3, null, null}
where
 Person p1 = new Person("Pilar", "Ess", 45);
 Person p2 = new Person("Linda", "Jackson", 28);
 Person p3 = new Person("Pilar", "Ess", 30);
 The sort method should return the following array: {p3, p1, p2}
 
Math 140 Programming Assignment 3 Deadline: Wednesday, March 20, 2019
Coding Instructions
1. Do not use any Java classes that trivialize the problem.
2. Do not declare static instance variables for this assignment.
3. You can write additional helper methods but they should declared as private.
4. Test each of the methods.
5. Use consistent notation to format your code. Indent 4-spaces.
6. Variables and methods should start with a lower-case character. Each
abbreviation or word that appears in the middle of the identifier starts with an
uppercase character.
7. Use meaningful variables names.
8. Do not use variable names that consist of one character unless they are declared
in a for loop. Example: for (int i = 0; i < arr.length; i++)
9. Do not use a single character for an abbreviation. Example: Suppose a variable
represents the number of books. Do not call this variable nBooks. Instead, use
numBooks or numberBooks.
10.Do not use break or continue statements in while or for loops.
11.Do not change the value of a counter variable to terminate a loop:
Example:
for (int i = 0; i < arr.length; i++){
 if (arr[i] < 0)
 i = arr.length;
}
12.Loops should not perform any irrelevant iterations.
13.Each method should have at most one return statement.
14.Do not use a return statement in a void method.
15.Do not use a while loop when an if statement is appropriate for the code
segment. (In other words, do not write a while loop that is guaranteed to iterate
at most one time.)
Math 140 Programming Assignment 3 Deadline: Wednesday, March 20, 2019
16. Use “else if” when appropriate:
Example:
Instead of
if (a < 1){
 a++;
}
if (a > 10){
 a--;
}
use
if (a < 1){
 a++;
}
else if (a > 10){
 a--;
}
17.boolean variables should not be compared to true or false.
Example: Suppose flag is a boolean variable.
Do not write statements similar to
if (flag == true)
 Instead use
 if (flag)
18.Separate code segments with a most one blank line. Note that a code segment
is a method, a loop or an if block. A single statement is usually not considered
to be a code segment.
Math 140 Programming Assignment 3 Deadline: Wednesday, March 20, 2019
19.A block comment near the top of the Java file with the following information
/*
Author: Your name and an acknowledgement of any person who assisted you in
this project.
Date: The date you completed the assignment.
Purpose: A description of the class.
*/
