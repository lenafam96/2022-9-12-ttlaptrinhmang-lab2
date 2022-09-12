import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    private String maHH;
    private String tenHH;
    private float soLuong;
    private float gia1SP;

    public Product() {
        this.maHH = "";
        this.tenHH = "";
        this.soLuong = 0;
        this.gia1SP = 0;
    }

    public Product(String maHH, String tenHH, float soLuong, float gia1SP) {
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.soLuong = soLuong;
        this.gia1SP = gia1SP;
    }

    public String getMaHH() {
        return maHH;
    }

    public void setMaHH(String maHH) {
        this.maHH = maHH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia1SP() {
        return gia1SP;
    }

    public void setGia1SP(float gia1sp) {
        gia1SP = gia1sp;
    }

    public void input(Scanner sc) {
        System.out.print("Nhap ma hang hoa: ");
        this.maHH = sc.nextLine();
        System.out.print("Nhap ten hang hoa: ");
        this.tenHH = sc.nextLine();
        System.out.print("Nhap so luong hang hoa: ");
        this.soLuong = Float.parseFloat(sc.nextLine());
        System.out.print("Nhap gia 1 san pham: ");
        this.gia1SP = Float.parseFloat(sc.nextLine());
    }

    public void display() {
        System.out.printf("%-10s|%-20s|%-10.0f|%-10.2f\n", this.getMaHH().toUpperCase(), this.getTenHH().toUpperCase(),
                this.getSoLuong(), this.getGia1SP());
    }
}

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> a = new ArrayList<Product>();
        do {
            System.out.println("\nNhap thong tin san pham thu " + (a.size() + 1));
            Product product = new Product();
            product.input(sc);
            a.add(product);
            System.out.print("Tiep tuc nhap (y/n)?");
        } while (!sc.nextLine().equals("n"));
        System.out.println("\n\n\n=>San pham co gia ban cao nhat:");
        System.out.printf("%-10s|%-20s|%-10s|%-10s\n", "Ma HH", "Ten hang hoa", "So luong", "Don gia");
        System.out.println("-".repeat(53));
        float max = a.get(0).getGia1SP();
        for (Product product : a) {
            if (max < product.getGia1SP())
                max = product.getGia1SP();
        }
        for (Product product : a) {
            if (product.getGia1SP() == max)
                product.display();
        }
        System.out.println("-".repeat(53));
        System.out.println("\n\n\n    ===Danh sach san pham giam dan theo gia===");
        System.out.printf("%-10s|%-20s|%-10s|%-10s\n", "Ma HH", "Ten hang hoa", "So luong", "Don gia");
        System.out.println("-".repeat(53));
        Collections.sort(a, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getGia1SP() < p2.getGia1SP() ? 1 : (p1.getGia1SP() == p2.getGia1SP()) ? 0 : -1;
            }
        });
        for (Product product : a) {
            product.display();
        }
        System.out.println("-".repeat(53));
        System.out.println("\n\n\n\t===Danh sach san pham ten \"sua\"===");
        System.out.printf("%-10s|%-20s|%-10s|%-10s\n", "Ma HH", "Ten hang hoa", "So luong", "Don gia");
        System.out.println("-".repeat(53));
        for (Product product : a) {
            if (product.getTenHH().contains("sua"))
                product.display();
        }
        System.out.println("-".repeat(53));
        sc.close();
    }
}