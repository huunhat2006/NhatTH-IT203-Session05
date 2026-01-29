import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = getInt("Nhập lựa chọn: ");
            scanner.nextLine();
            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    static void showMenu() {
        System.out.println("\n========= MENU =========");
        System.out.println("1. Two Sum");
        System.out.println("2. Move Zeroes");
        System.out.println("3. Valid Palindrome");
        System.out.println("4. Reverse Words");
        System.out.println("5. Happy Number");
        System.out.println("0. Thoát");
        System.out.println("========================");
    }

    static int getInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Nhập số hợp lệ: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static int[] inputArray() {
        int n = getInt("Nhập số phần tử: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = getInt("arr[" + i + "] = ");
        }
        return arr;
    }

    static void twoSum() {
        int[] arr = inputArray();
        int target = getInt("Nhập target: ");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.printf("Tìm thấy: [%d, %d]\n", i, j);
                    return;
                }
            }
        }
        System.out.println("Không tìm thấy cặp nào");
    }

    static void moveZeroes() {
        int[] arr = inputArray();
        int index = 0;
        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }
        while (index < arr.length) {
            arr[index++] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void validPalindrome() {
        System.out.print("Nhập chuỗi: ");
        String input = scanner.nextLine();
        if (isPalindrome(input)) {
            System.out.println("Chuỗi là Palindrome");
        } else {
            System.out.println("Chuỗi không phải Palindrome");
        }
    }

    static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int l = 0, r = cleaned.length() - 1;
        while (l < r) {
            if (cleaned.charAt(l++) != cleaned.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    static void reverseWords() {
        System.out.print("Nhập chuỗi: ");
        String s = scanner.nextLine();
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }
        System.out.println(result.toString().trim());
    }

    static void happyNumber() {
        int n = getInt("Nhập số n: ");
        if (isHappy(n)) {
            System.out.println("Là số hạnh phúc");
        } else {
            System.out.println("Không phải số hạnh phúc");
        }
    }

    static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) return false;
            set.add(n);
            n = sumOfSquares(n);
        }
        return true;
    }

    static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}
