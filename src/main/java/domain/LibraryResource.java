package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class LibraryResource {
    private String libraryNumber;
    private String title;
    private String author;
    private ResourceType resourceType;
    private ResourceStatus resourceStatus;



    public void settingLibraryNumber() {
        String fromType = "";
        String fromTitle = title.substring(0,3);

        switch (resourceType){
            case BOOK:
                fromType += "B";
                break;
            case JOURNAL:
                fromType += "J";
                break;
            case DVD:
                fromType += "D";
                break;
            default:
                fromType += "UNKNOWN-TYPE";
        }
        String fromAuthor = author.substring(author.length()-2);
        String[] libraryNumberName = new String[3];
        libraryNumberName[0] = fromTitle;
        libraryNumberName[1] = fromType;
        libraryNumberName[2] = fromAuthor;

        String libraryNumber = StringUtils.join(libraryNumberName, '-');
        setLibraryNumber(libraryNumber);
    }

    public void addNewResourceParameters(LibraryResource newLibraryElement) {

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("What type of element You want to add? (BOOK/JOURNAL/DVD)");
        newLibraryElement.setResourceType(ResourceType.valueOf(scanner1.next().toUpperCase()));
        System.out.println("Add title: ");
        newLibraryElement.setTitle(scanner2.nextLine());
        System.out.println("Add author: (NAME SURNAME)");
        newLibraryElement.setAuthor(scanner3.nextLine());
        newLibraryElement.setResourceStatus(ResourceStatus.AVAILABLE);
        newLibraryElement.settingLibraryNumber();
        System.out.println("You added following library Resource: ");
        System.out.println(newLibraryElement.toString());


    }




    public LibraryResource(
                           String title,
                           String author,
                           ResourceType resourceType,
                           ResourceStatus resourceStatus) {
        this.title = title;
        this.author = author;
        this.resourceType = resourceType;
        this.resourceStatus = resourceStatus;
    }
    public LibraryResource() {}

    public String getLibraryNumber() {return libraryNumber;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public ResourceType getResourceType() {return resourceType;}
    public ResourceStatus getResourceStatus() {return resourceStatus;}

    public void setLibraryNumber(String libraryNumber) {this.libraryNumber = libraryNumber;}
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setResourceType(ResourceType resourceType) {this.resourceType = resourceType;}
    public void setResourceStatus(ResourceStatus resourceStatus) {this.resourceStatus = resourceStatus;}

    @Override
    public String toString() {
        return "LibraryResource{" +
                "libraryNumber='" + libraryNumber + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", resourceType=" + resourceType +
                ", resourceStatus=" + resourceStatus +
                '}';
    }
}
