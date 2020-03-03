/*
    This class contains Employee data
 */

public class Employee implements Comparable<Employee> {

    private int employeeId;
    private String firstName;
    private String lastName;

    public int getEmployeeID() {
        return employeeId;
    }

    public void setEmployeeID(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
        Initializes the employeeID and sets the other fields to nu
     */
    public Employee(int employeeId) {
        this.employeeId = employeeId;
        setFirstName(null);
        setLastName(null);
    }

    /*
        Initializes the employeeID and sets the other fields to nu
    */
    public Employee(int employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*
        Implements comparable interface
     */
    @Override
    public int compareTo(Employee emp) {
        return Integer.compare(this.employeeId,emp.employeeId );
    }

    /*
        String representation of Employee object
     */
    @Override
    public String toString() {
        return (employeeId + " " + firstName + " " + lastName);
    }
}