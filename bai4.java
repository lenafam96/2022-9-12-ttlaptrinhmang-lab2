import java.util.ArrayList;
import java.util.Scanner;

class Engine {
    private String engineId;
    private String engineName;
    private String manufacturer;
    private int yearMaking;
    private float price;

    public Engine() {
        this.engineId = "";
        this.engineName = "";
        this.manufacturer = "";
        this.yearMaking = 0;
        this.price = 0;
    }

    public Engine(String engineId, String engineName, String manufacturer, int yearMaking, float price) {
        this.engineId = engineId;
        this.engineName = engineName;
        this.manufacturer = manufacturer;
        this.yearMaking = yearMaking;
        this.price = price;
    }

    public String getEngineId() {
        return this.engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    public String getEngineName() {
        return this.engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearMaking() {
        return this.yearMaking;
    }

    public void setYearMaking(int yearMaking) {
        this.yearMaking = yearMaking;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void input(Scanner sc) {
        System.out.print("Nhap ma may: ");
        this.setEngineId(sc.nextLine());
        System.out.print("Nhap ten may: ");
        this.setEngineName(sc.nextLine());
        System.out.print("Nhap ten nha san xuat: ");
        this.setManufacturer(sc.nextLine());
        System.out.print("Nhap nam san xuat: ");
        this.setYearMaking(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap gia tien: ");
        this.setPrice(Float.parseFloat(sc.nextLine()));
    }

    public void display() {
        System.out.printf("%-10s|%-20s|%-20s|%-10d|%-10.2f|", this.getEngineId().toUpperCase(),
                this.getEngineName().toUpperCase(), this.getManufacturer().toUpperCase(), this.getYearMaking(),
                this.getPrice());
    }
}

class Mobile extends Engine {
    private String country;

    public Mobile() {
        super();
        this.country = "";
    }

    public Mobile(String engineId, String engineName, String manufacturer, int yearMaking,
            float price, String country) {
        super(engineId, engineName, manufacturer, yearMaking, price);
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void input(Scanner sc) {
        System.out.print("\nNhap ma dien thoai: ");
        this.setEngineId(sc.nextLine());
        System.out.print("Nhap ten dien thoai: ");
        this.setEngineName(sc.nextLine());
        System.out.print("Nhap ten nha san xuat: ");
        this.setManufacturer(sc.nextLine());
        System.out.print("Nhap nam san xuat: ");
        this.setYearMaking(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap gia tien: ");
        this.setPrice(Float.parseFloat(sc.nextLine()));
        System.out.print("Nhap nuoc san xuat: ");
        this.setCountry(sc.nextLine());
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%-20s|%-10s|%-10s|\n", this.getCountry(), "", "");
    }
}

class Car extends Engine {
    private int totalSeat;
    private float speed;

    public Car() {
        super();
        this.totalSeat = 0;
        this.speed = 0;
    }

    public Car(String engineId, String engineName, String manufacturer, int yearMaking,
            float price, int totalSeat, int speed) {
        super(engineId, engineName, manufacturer, yearMaking, price);
        this.totalSeat = totalSeat;
        this.speed = speed;
    }

    public int getTotalSeat() {
        return this.totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void input(Scanner sc) {
        System.out.print("\nNhap ma xe: ");
        this.setEngineId(sc.nextLine());
        System.out.print("Nhap ten xe: ");
        this.setEngineName(sc.nextLine());
        System.out.print("Nhap ten nha san xuat: ");
        this.setManufacturer(sc.nextLine());
        System.out.print("Nhap nam san xuat: ");
        this.setYearMaking(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap gia tien: ");
        this.setPrice(Float.parseFloat(sc.nextLine()));
        System.out.print("Nhap so cho ngoi: ");
        this.setTotalSeat(Integer.parseInt(sc.nextLine()));
        System.out.print("Nhap toc do: ");
        this.setSpeed(Float.parseFloat(sc.nextLine()));
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%-20s|%-10d|%-10.2f|\n", "", this.getTotalSeat(), this.getSpeed());
    }
}

class Manager {
    static ArrayList<Engine> list = new ArrayList<Engine>();

    public static void main(Scanner sc) {
        int option = 0;
        while (true) {
            PrintMenu();
            System.out.printf("Nhap lua chon: ");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: {
                    do {
                        Engine engine = new Mobile();
                        engine.input(sc);
                        list.add(engine);
                        System.out.print("Tiep tuc nhap (y/n)?");
                    } while (!sc.nextLine().equals("n"));
                    break;
                }
                case 2: {
                    do {
                        Engine engine = new Car();
                        engine.input(sc);
                        list.add(engine);
                        System.out.print("Tiep tuc nhap (y/n)?");
                    } while (!sc.nextLine().equals("n"));
                    break;
                }
                case 3: {
                    System.out.println("\n\n\n\t\t\t\t===Danh sach thong tin dien thoai va o to===");
                    PrintBar();
                    Title();
                    PrintBar();
                    for (Engine engine : list) {
                        engine.display();
                    }
                    PrintBar();
                    break;
                }
                case 4: {
                    System.out.print("Nhap ten nha san xuat can tim: ");
                    String tenNSX = sc.nextLine();
                    System.out.println(
                            "\n\n\n\t\t\t\t===Danh sach dien thoai va o to cua \"" + tenNSX.toUpperCase() + "\"===");
                    PrintBar();
                    Title();
                    PrintBar();
                    for (Engine engine : list) {
                        if (engine.getManufacturer().toLowerCase().contains(tenNSX.toLowerCase()))
                            engine.display();
                    }
                    PrintBar();
                    break;
                }
                case 5: {
                    return;
                }
            }
        }

    }

    static void PrintBar() {
        System.out.println("-".repeat(118));
    }

    static void PrintMenu() {
        System.out.println("\n\n\n\t===Menu===\n"
                + "1.Nhap thong tin dien thoai\n"
                + "2.Nhap thong tin o to\n"
                + "3.Hien thi thong tin\n"
                + "4.Tim kiem theo ten nha san xuat\n"
                + "5.Thoat\n");
    }

    static void Title() {
        System.out.printf("%-10s|%-20s|%-20s|%-10s|%-10s|%-20s|%-10s|%-10s|\n", "Ma may", "Ten may", "Nha san xuat",
                "Nam sx", "Gia", "Nuoc san xuat", "So ghe", "Toc do");
    }
}

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager.main(sc);
        sc.close();
    }
}
