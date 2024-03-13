package registerPage;

import commons.DataHelper;

public class a {
    public static void main(String[] args) {
        DataHelper dataHelper = new DataHelper();
        String firstName, lastName, Address, City, State, Zipcode, Phone, SSN, Username, Password;
        firstName =  dataHelper.getFirstName();
        lastName = dataHelper.getLastName();
        System.out.println("a" + firstName);
        System.out.println("b" + lastName);

        System.out.println("firstName = " + dataHelper.getFirstName());
        System.out.println("lastName = " + dataHelper.getLastName());
        System.out.println("Address = " + dataHelper.getAddress());
        System.out.println("City = " + dataHelper.getCity());
        System.out.println("State = " + dataHelper.getState());
        System.out.println("Zipcode = " + dataHelper.getZipcode());
        System.out.println("Phone = " + dataHelper.getPhoneNumber());
        System.out.println("SSN = " + dataHelper.getSSN()+ firstName + "." + lastName);
        System.out.println("Username = " + dataHelper.getUserName());
        System.out.println("Password = " + dataHelper.getPassword());
    }
}
