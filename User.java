public class User {

  //Initializes instance variables
  private String firstName;
  private String lastName;

  //Constructor, creates instances of class
  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  //Getters to retrieve info from User class
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
