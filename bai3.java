import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    private String bookName;
    private String bookAuthor;
    private String producer;
    private int yearPublishing;
    private float price;

    public Book() {
        this.bookName = "";
        this.bookAuthor = "";
        this.producer = "";
        this.yearPublishing = 0;
        this.price = 0;
    }

    public Book(String bookName, String bookAuthor, String producer, int yearPublishing, float price) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.producer = producer;
        this.yearPublishing = yearPublishing;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearPublishing() {
        return yearPublishing;
    }

    public void setYearPublishing(int yearPublishing) {
        this.yearPublishing = yearPublishing;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void input(Scanner sc) {
        System.out.print("Nhap ten sach: ");
        this.setBookName(sc.nextLine());
        System.out.print("Nhap ten tac gia: ");
        this.setBookAuthor(sc.nextLine());
        System.out.print("Nhap ten nha xuat ban: ");
        this.setProducer(sc.nextLine());
        System.out.print("Nhap nam xuat ban: ");
        this.setYearPublishing(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap gia tien: ");
        this.setPrice(Float.parseFloat(sc.nextLine()));
    }

    public void display() {
        System.out.printf("%-20s|%-15s|%-15s|%-10d|%-10.2f|", this.getBookName().toUpperCase(),
                this.getBookAuthor().toUpperCase(), this.getProducer().toUpperCase(), this.getYearPublishing(),
                this.getPrice());
    }
}

class UnetiBook extends Book {
    private String language;
    private int semester;

    public UnetiBook() {
        super();
        this.language = "";
        this.semester = 0;
    }

    public UnetiBook(String bookName, String bookAuthor, String producer, int yearPublishing, float price,
            String language, int semester) {
        super(bookName, bookAuthor, producer, yearPublishing, price);
        this.language = language;
        this.semester = semester;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Nhap ngon ngu: ");
        this.setLanguage(sc.nextLine());
        System.out.print("Nhap hoc ky: ");
        this.setSemester(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%-15s|%-10d\n", this.getLanguage().toUpperCase(), this.getSemester());
    }

    public static void Title() {
        System.out.printf("%-20s|%-15s|%-15s|%-10s|%-10s|%-15s|%-10s|\n", "Ten sach", "Ten tac gia", "Nha xuat ban",
                "Nam XB", "Gia", "Ngon ngu", "Hoc ky");
    }
}

class Test {
    ArrayList<UnetiBook> list = new ArrayList<UnetiBook>();

    public Test(Scanner sc) {
        int option = 0;
        while (true) {
            PrintMenu();
            System.out.printf("Nhap lua chon: ");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: {
                    do {
                        System.out.println("\nNhap thong tin san pham thu " + (list.size() + 1));
                        UnetiBook book = new UnetiBook();
                        book.input(sc);
                        list.add(book);
                        System.out.print("Tiep tuc nhap (y/n)?");
                    } while (!sc.nextLine().equals("n"));
                    break;
                }
                case 2: {
                    System.out.println("\n\n\n\t\t\t\t===Danh sach Uneti Book===");
                    PrintBar();
                    UnetiBook.Title();
                    PrintBar();
                    for (UnetiBook unetiBook : list) {
                        unetiBook.display();
                    }
                    PrintBar();
                    break;
                }
                case 3: {
                    Collections.sort(list, new Comparator<UnetiBook>() {
                        @Override
                        public int compare(UnetiBook p1, UnetiBook p2) {
                            return p1.getYearPublishing() < p2.getYearPublishing() ? 1
                                    : (p1.getYearPublishing() == p2.getYearPublishing()) ? 0 : -1;
                        }
                    });
                    System.out.println("\n\n\n\t\t\t===Danh sach Uneti Book theo nam xuat ban===");
                    PrintBar();
                    UnetiBook.Title();
                    PrintBar();
                    for (UnetiBook unetiBook : list) {
                        unetiBook.display();
                    }
                    PrintBar();
                    break;
                }
                case 4: {
                    System.out.print("Nhap ten sach can tim: ");
                    String tenSach = sc.nextLine();
                    System.out.println("\n\n\n\t\t\t\t===Danh sach ten \"" + tenSach.toUpperCase() + "\"===");
                    PrintBar();
                    UnetiBook.Title();
                    PrintBar();
                    for (UnetiBook unetiBook : list) {
                        if (unetiBook.getBookName().toLowerCase().contains(tenSach.toLowerCase()))
                            unetiBook.display();
                    }
                    PrintBar();
                    break;
                }
                case 5: {
                    System.out.print("Nhap ten tac gia: ");
                    String tenTacGia = sc.nextLine();
                    System.out.println("\n\n\n\t\t\t\t===Danh sach cua tac gia \"" + tenTacGia.toUpperCase() + "\"===");
                    PrintBar();
                    UnetiBook.Title();
                    PrintBar();
                    for (UnetiBook unetiBook : list) {
                        if (unetiBook.getBookAuthor().toLowerCase().contains(tenTacGia.toLowerCase()))
                            unetiBook.display();
                    }
                    PrintBar();
                    break;
                }
                case 6: {
                    return;
                }
            }
        }
    }

    void PrintBar() {
        System.out.println("-".repeat(101));
    }

    void PrintMenu() {
        System.out.println("\n\n\n\t===Menu===\n"
                + "1.Nhap thong tin sach\n"
                + "2.Hien thi thong tin vua nhap\n"
                + "3.Danh sach giam dan theo nam xuat ban\n"
                + "4.Tim kiem theo ten sach\n"
                + "5.Tim kiem theo ten tac gia\n"
                + "6.Thoat\n");
    }
}

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Test test = new Test(sc);
        sc.close();
    }
}
