package domain;

import java.util.List;
import java.util.Scanner;

public class LibraryLog {

    public void oddaj(List<Wypożyczenie> libraryLog) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Give title of library resource : ");
        String oddawanyLibraryResource = scanner.nextLine();
        System.out.println(libraryLog.get(0).getLibraryResource().getAuthor());
//        if (libraryLog.contains(oddawanyLibraryResource)){
//            return true;
//            int idWypożyczenia = libraryLog.indexOf(oddawanyLibraryResource);
//            libraryLog.get(idWypożyczenia).getLibraryResource().setResourceStatus(ResourceStatus.AVAILABLE);
//            System.out.println("Give return date:         YYYY-MM-DD");
//            libraryLog.get(idWypożyczenia).setFaktycznaDataOddania(LocalDate.parse(scanner2.nextLine()));
//            int daysAfterTerm = libraryLog.get(idWypożyczenia).getPrzewidywanaDataOddania()
//                    .compareTo(libraryLog.get(idWypożyczenia).getFaktycznaDataOddania());
//            System.out.println(daysAfterTerm);
//
//        }else {
//            System.out.println("Illegal Operation");
//        }
    }

    public void wypożycz(Wypożyczenie noweWypożyczenie,
                         List<User> userList,
                         List<LibraryResource> libraryResourceList,
                         List<Wypożyczenie> libraryLog){
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        int userId = 0;
        int libraryResourceId = 0;
        System.out.println("Give full name of user:         NAME SURNAME");
        String wypożyczającyUser = scanner2.nextLine();
        System.out.println("Give title of library resource : ");
        String wypożyczanyLibraryResource = scanner3.nextLine();

        if (userList.contains(wypożyczającyUser) && libraryResourceList.contains(wypożyczanyLibraryResource)) {
            userId = userList.indexOf(wypożyczającyUser);
            libraryResourceId = libraryResourceList.indexOf(wypożyczanyLibraryResource);

        } else if (userList.get(userId).getUserStatus() != UserStatus.BLOCKED) {
            noweWypożyczenie.setWypożyczenieParameters(userList.get(userId),libraryResourceList.get(libraryResourceId));
            System.out.println(noweWypożyczenie.toString());
            libraryLog.add(noweWypożyczenie);
            libraryResourceList.get(libraryResourceId).setResourceStatus(ResourceStatus.NOTAVAILABLE);
            (userList.get(userId).getLibraryUserCard()).add(noweWypożyczenie);

        }else {
            System.out.println("Illegal operation");
        }
    }
    private List<Wypożyczenie> libraryLog;

    public LibraryLog(List<Wypożyczenie> libraryLog) {
        this.libraryLog = libraryLog;
    }

    public List<Wypożyczenie> getLibraryLog() {
        return libraryLog;
    }

    public void setLibraryLog(List<Wypożyczenie> libraryLog) {
        this.libraryLog = libraryLog;
    }
}
