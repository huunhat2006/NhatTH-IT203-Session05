import java.util.Scanner;
import java.lang.String;
public class Session05_miniproject {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String[] msv = {"B1234567","B2345678","B3456789","B1234321","B2345432"};

        while (choice != 6) {
            System.out.println("=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1.Hiển thị");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Thoát");
            System.out.print("Mời nhập lựa chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (msv.length != 0) {
                        for (int i = 0; i < msv.length; i++) {
                            System.out.printf("STT %d: %s\n", i + 1, msv[i]);
                        }
                    } else {
                        System.out.println("Không có sinh viên");
                    }
                    break;

                case 2:
                    if (msv.length < 100) {
                        System.out.println("Mời nhập vị trí cần thêm: ");
                        int location = sc.nextInt();
                        if (location > 0 && location <= msv.length) {
                            for (int i = msv.length; i > location;i--) {
                                msv[i] = msv[i - 1];
                            }

                            boolean isTrue = false;
                            while (isTrue) {
                                System.out.println("Mời nhập MSV: ");
                                String newMSV = sc.nextLine();
                                char firstChar = newMSV.charAt(0);
                            }
                        }



                    }
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    System.out.println("Hẹn gặp lại!!!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời nhập lại");
                    break;
            }
        }
    }

}
