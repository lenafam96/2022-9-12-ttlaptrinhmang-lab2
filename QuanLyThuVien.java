import java.util.Scanner;

class QuanLyTaiLieu {
    private String maTaiLieu, tenNhaXuatBan;
    private int soBanPhatHanh;

    public void input(Scanner scan) {
        System.out.print("Nhap ma tai lieuu: ");
        maTaiLieu = scan.nextLine();
        System.out.print("Nhap ten nha xuat bann: ");
        tenNhaXuatBan = scan.nextLine();
        System.out.print("Nhap so ban phat hanhh: ");
        soBanPhatHanh = scan.nextInt();
    }

    public void ouputTitle() {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                "Ma tai lieu", "Nha xuat ban", "So ban phat hanh",
                "Tac Gia Sach", "So Trang Sach", "So Phat Hanh",
                "Thang Phat Hanh", "Ngay Phat Hanh");
        System.out.println();
    }

    public void output() {
        System.out.printf("%-20s %-20s %-20d", maTaiLieu, tenNhaXuatBan,
                soBanPhatHanh);
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }
}

class QLSach extends QuanLyTaiLieu {
    private String tenTacGia;
    private int soTrang;

    @Override
    public void input(Scanner scan) {
        super.input(scan);
        System.out.print("Nhap ten tac gia: ");
        tenTacGia = scan.nextLine();
        System.out.print("Nhap so trang: ");
        soTrang = scan.nextInt();
    }

    public void output() {
        super.output();
        System.out.printf(" %-20s %-20d %-20s %-20s %-20s", tenTacGia,
                soTrang, " ", " ", " ");
    }
}

class QLTapChi extends QuanLyTaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;

    @Override
    public void input(Scanner scan) {
        super.input(scan);
        System.out.print("Nhap so phat hanh: ");
        soPhatHanh = scan.nextInt();
        System.out.print("Nhap thang phat hanh: ");
        thangPhatHanh = scan.nextInt();
    }

    public void output() {
        super.output();
        System.out.printf(" %-20s %-20s %-20s %-20d %-20s", " ", " ",
                soPhatHanh, thangPhatHanh, " ");
    }
}

class QLBao extends QuanLyTaiLieu {
    private String ngayPhatHanh;

    @Override
    public void input(Scanner scan) {
        super.input(scan);
        System.out.print("Nhap ngay phat hanh: ");
        ngayPhatHanh = scan.nextLine();
    }

    public void output() {
        super.output();
        System.out.printf(" %-20s %-20s %-20s %-20s %-20s", " ", " ", " ",
                " ", ngayPhatHanh);
    }
}

public class QuanLyThuVien {
    int n;
    QuanLyTaiLieu taiLieu[] = new QuanLyTaiLieu[1000];

    public void input(Scanner scan) {
        System.out.print("Nhap so tai lieu: ");
        int tmp = Integer.parseInt(scan.nextLine());
        n += tmp;

        for (int i = n - tmp; i < n; i++) {
            System.out.print("Nhap loai tai lieu: (sach, tapchi, bao) ");
            String loai = scan.nextLine();
            if (loai.equals("sach"))
                taiLieu[i] = new QLSach();
            else if (loai.equals("tapchi"))
                taiLieu[i] = new QLTapChi();
            else if (loai.equals("bao"))
                taiLieu[i] = new QLBao();
            else {
                --i;
                continue;
            }
            taiLieu[i].input(scan);
        }
    }

    public void output() {
        if (taiLieu != null) {
            taiLieu[0].ouputTitle();
            for (int i = 0; i < n; i++) {
                taiLieu[i].output();
                System.out.println();
            }
        } else
            System.out.println("Danh sach rong!");
    }

    public void FindByGenre(Scanner scan) {
        if (taiLieu != null) {
            String genre;
            do {
                System.out.printf("Nhap the loai tai lieu muon tim: (sach, tapchi, bao)");
                genre = scan.nextLine();
            } while (!genre.equals("sach") && !genre.equals("tapchi") && !genre.equals("bao"));
            taiLieu[0].ouputTitle();
            for (int i = 0; i < n; i++) {
                if (genre.equals("sach") && taiLieu[i] instanceof QLSach) {
                    taiLieu[i].output();
                    System.out.println();
                }
                if (genre.equals("tapchi") && taiLieu[i] instanceof QLTapChi) {
                    taiLieu[i].output();
                    System.out.println();
                }
                if (genre.equals("bao") && taiLieu[i] instanceof QLBao) {
                    taiLieu[i].output();
                    System.out.println();
                }
            }
        } else
            System.out.println("Danh sach rong!");

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        QuanLyThuVien ql = new QuanLyThuVien();
        int luachon;
        for (;;) {
            System.out.println(
                    "\n\n===Quan ly thu vien:===\n1.Them tai lieu moi\n2.Hien thi thong tin tai lieu\n3.Tim kiem tai lieu theo loai\n4.Thoat khoi chuong trinh");
            do {
                System.out.print("\nNhap lua chon: ");
                luachon = scan.nextInt();
            } while (luachon < 1 || luachon > 5);
            switch (luachon) {
                case 1:
                    ql.input(scan);
                    break;
                case 2:
                    ql.output();
                    break;
                case 3:
                    ql.FindByGenre(scan);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}