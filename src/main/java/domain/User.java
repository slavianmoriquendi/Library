package domain;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private int userLibraryNumber;
    private UserStatus userStatus;
    private String userFullName;
    private List<Wypożyczenie> libraryUserCard; //Zawiera wypożyczone aktualnie książki

    public void addUserParameters(User user){
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Give new user number:");
        user.setUserLibraryNumber(scanner1.nextInt());
        user.setUserStatus(UserStatus.NEW);
        System.out.println("Give User's Name and Surname: ");
        user.setUserFullName(scanner2.nextLine());
        user.setLibraryUserCard(new ArrayList<>());
        System.out.println("You added following user" + user.toString());

    }





    public User() {}

    public int getUserLibraryNumber() {return userLibraryNumber;}
    public UserStatus getUserStatus() {return userStatus;}
    public String getUserFullName() {return userFullName;}
    public List<Wypożyczenie> getLibraryUserCard() {return libraryUserCard;}

    public void setUserLibraryNumber(int userLibraryNumber) {this.userLibraryNumber = userLibraryNumber;}
    public void setUserFullName(String userFullName) {this.userFullName = userFullName;}
    public void setUserStatus(UserStatus userStatus) {this.userStatus = userStatus;}
    public void setLibraryUserCard(List<Wypożyczenie> libraryUserCard) {this.libraryUserCard = libraryUserCard;}

    @Override
    public String toString() {
        return "User{" +
                "userLibraryNumber=" + userLibraryNumber +
                ", userStatus=" + userStatus +
                ", userFullName='" + userFullName + '\'' +
                ", libraryUserCard=" + libraryUserCard +
                '}';
    }
}
