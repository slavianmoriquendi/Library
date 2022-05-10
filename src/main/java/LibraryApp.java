import domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jws.Oneway;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        List<LibraryResource> libraryResourceList = new ArrayList<>();
        List<Wypożyczenie> libraryLog = new ArrayList<>();
        LibraryLog libraryLog1 = new LibraryLog(libraryLog);

        while (true){
            int action;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Add new user press: 1 \nAdd new resource press: 2 \nWypożycz press: 3 \nOddaj press: 4");
            action = scanner.nextInt();


            if (action == 1){
                User newUser = new User();
                newUser.addUserParameters(newUser);
                userList.add(newUser);
                System.out.println(userList.get(0).toString());

            } else if (action == 2) {
                LibraryResource newLibraryResource = new LibraryResource();
                newLibraryResource.addNewResourceParameters(newLibraryResource);
                libraryResourceList.add(newLibraryResource);

            } else if (action == 3) {
                Wypożyczenie noweWypożyczenie = new Wypożyczenie();
                libraryLog1.wypożycz(noweWypożyczenie,userList,libraryResourceList,libraryLog1.getLibraryLog());


            } else if (action == 4) {
                libraryLog1.oddaj(libraryLog);


            }


        }








//        User user1 = new User();
//        LibraryResource ksiazka1 = new LibraryResource(
//                "Gra o tron",
//                "G.R.R. Martin",
//                ResourceType.BOOK,
//                ResourceStatus.AVAILABLE);
//        ksiazka1.settingLibraryNumber();
//
//        Wypożyczenie wypożyczenie1 = new Wypożyczenie(user1,ksiazka1, LocalDate.of(2022,01,01),null);
//        wypożyczenie1.ustalPrzewidywanąDatęOddania();
//        System.out.println(wypożyczenie1.getPrzewidywanaDataOddania());
//        List<Wypożyczenie> listaWypożyczeń = new ArrayList<>();
//        listaWypożyczeń.add(wypożyczenie1);
//
//
        //Dodawanie elementów do biblioteki
//        List<LibraryResources> katalog= new ArrayList<>();
//        katalog.add(new LibraryResources().addNewResourceValues());
//        katalog.add(new LibraryResources().addNewResourceValues());
//        System.out.println(katalog.get(1).getLibraryNumber());
//        System.out.println(katalog.get(0).getLibraryNumber());
    }
}