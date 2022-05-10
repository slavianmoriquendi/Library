package domain;

import domain.exceptions.UnavaiableResourceOrUser;
import utils.DateUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Wypożyczenie {

    private User user;
    private LibraryResource libraryResource;
    //"YYYY-MM-DD" - DATE FORMAT
    private LocalDate dataWypożyczenia;
    private LocalDate przewidywanaDataOddania;
    private LocalDate faktycznaDataOddania;

    public void setWypożyczenieParameters(User user, LibraryResource libraryResource){
        setUser(user);
        setLibraryResource(libraryResource);
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj datę wypożyczenia: YYYY-MM-DD");
        setDataWypożyczenia(LocalDate.parse(scaner.next()));
        ustalPrzewidywanąDatęOddania();
        setFaktycznaDataOddania(null);
    }
    public void ustalPrzewidywanąDatęOddania(){
        if (libraryResource.getResourceType().equals(ResourceType.BOOK)) {
            setPrzewidywanaDataOddania(dataWypożyczenia.plusDays(30));
        } else if (libraryResource.getResourceType().equals(ResourceType.DVD)) {
            setPrzewidywanaDataOddania(dataWypożyczenia.plusDays(2));
        }else if (libraryResource.getResourceType().equals(ResourceType.JOURNAL)){
            setPrzewidywanaDataOddania(dataWypożyczenia.plusDays(3));
        }
    }



    public Wypożyczenie(User user, LibraryResource libraryResource, LocalDate dataWypożyczenia, LocalDate faktycznaDataOddania) {
        this.user = user;
        this.libraryResource = libraryResource;
        this.dataWypożyczenia = dataWypożyczenia;
        this.faktycznaDataOddania = faktycznaDataOddania;
    }

    public Wypożyczenie() {}

    public User getUser() {return user;}
    public LibraryResource getLibraryResource() {return libraryResource;}
    public LocalDate getDataWypożyczenia() {return dataWypożyczenia;}
    public LocalDate getPrzewidywanaDataOddania() {return przewidywanaDataOddania;}
    public LocalDate getFaktycznaDataOddania() {return faktycznaDataOddania;}

    public void setUser(User user) {this.user = user;}
    public void setLibraryResource(LibraryResource libraryResource) {this.libraryResource = libraryResource;}
    public void setDataWypożyczenia(LocalDate dataWypożyczenia) {this.dataWypożyczenia = dataWypożyczenia;}
    public void setPrzewidywanaDataOddania(LocalDate przewidywanaDataOddania) {this.przewidywanaDataOddania = przewidywanaDataOddania;}
    public void setFaktycznaDataOddania(LocalDate faktycznaDataOddania) {this.faktycznaDataOddania = faktycznaDataOddania;}

    @Override
    public String toString() {
        return "Wypożyczenie{" +
                "user=" + user +
                ", libraryResource=" + libraryResource +
                ", dataWypożyczenia=" + dataWypożyczenia +
                ", przewidywanaDataOddania=" + przewidywanaDataOddania +
                ", faktycznaDataOddania=" + faktycznaDataOddania +
                '}';
    }
}
