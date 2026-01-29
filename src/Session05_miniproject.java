import java.util.Scanner;
import java.util.regex.Pattern;

public class Session05_miniproject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] msv = new String[100];
        int n = 5;
        msv[0] = "B1234567";
        msv[1] = "B2345678";
        msv[2] = "B3456789";
        msv[3] = "B1234321";
        msv[4] = "B2345432";

        Pattern pattern = Pattern.compile("^B\\d{7}$");
        int choice;

        do {
            System.out.println("=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Thoát");
            System.out.print("Mời nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (n == 0) {
                        System.out.println("Danh sách rỗng");
                    } else {
                        for (int i = 0; i < n; i++) {
                            System.out.printf("STT %d: %s\n", i + 1, msv[i]);
                        }
                    }
                    break;

                case 2:
                    if (n == 100) {
                        System.out.println("Danh sách đã đầy");
                        break;
                    }
                    String newMSV;
                    while (true) {
                        System.out.print("Nhập MSSV mới: ");
                        newMSV = sc.nextLine();
                        if (pattern.matcher(newMSV).matches()) {
                            break;
                        }
                        System.out.println("MSSV không hợp lệ");
                    }
                    msv[n] = newMSV;
                    n++;
                    System.out.println("Thêm thành công");
                    break;

                case 3:
                    System.out.print("Nhập vị trí cần sửa: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index < 1 || index > n) {
                        System.out.println("Vị trí không hợp lệ");
                        break;
                    }
                    String updateMSV;
                    while (true) {
                        System.out.print("Nhập MSSV mới: ");
                        updateMSV = sc.nextLine();
                        if (pattern.matcher(updateMSV).matches()) {
                            break;
                        }
                        System.out.println("MSSV không hợp lệ");
                    }
                    msv[index - 1] = updateMSV;
                    System.out.println("Cập nhật thành công");
                    break;

                case 4:
                    System.out.print("Nhập MSSV cần xóa: ");
                    String deleteMSV = sc.nextLine();
                    int pos = -1;
                    for (int i = 0; i < n; i++) {
                        if (msv[i].equalsIgnoreCase(deleteMSV)) {
                            pos = i;
                            break;
                        }
                    }
                    if (pos == -1) {
                        System.out.println("Không tìm thấy MSSV");
                    } else {
                        for (int i = pos; i < n - 1; i++) {
                            msv[i] = msv[i + 1];
                        }
                        n--;
                        System.out.println("Xóa thành công");
                    }
                    break;

                case 5:
                    System.out.print("Nhập chuỗi cần tìm: ");
                    String key = sc.nextLine().toLowerCase();
                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        if (msv[i].toLowerCase().contains(key)) {
                            System.out.printf("STT %d: %s\n", i + 1, msv[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không có kết quả phù hợp");
                    }
                    break;

                case 6:
                    System.out.println("Hẹn gặp lại!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 6);
    }
}
