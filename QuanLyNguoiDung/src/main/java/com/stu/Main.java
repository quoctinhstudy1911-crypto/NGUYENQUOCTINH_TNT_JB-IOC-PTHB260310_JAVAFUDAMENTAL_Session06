package com.stu;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fullName = "";
        String email = "";
        String phone = "";
        String password = "";

        boolean flag = true;

        while (flag) {
            System.out.println("**************** QUẢN LÝ NGƯỜI DÙNG ****************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");

            int choose;

            while (true) {
                try {
                    System.out.print("Lựa chọn của bạn: ");
                    choose = Integer.parseInt(scanner.nextLine());

                    if (choose >= 1 && choose <= 6) {
                        break;
                    } else {
                        System.out.println("Vui lòng nhập từ 1 đến 6");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Dữ liệu không hợp lệ");
                }
            }

            switch (choose) {
                case 1:
                    System.out.print("Nhập họ tên: ");
                    fullName = scanner.nextLine();

                    System.out.print("Nhập email: ");
                    email = scanner.nextLine();

                    System.out.print("Nhập số điện thoại: ");
                    phone = scanner.nextLine();

                    System.out.print("Nhập mật khẩu: ");
                    password = scanner.nextLine();
                    break;

                case 2:
                    fullName = chuanHoaHoTen(fullName);
                    System.out.println("Họ tên sau khi chuẩn hóa: " + fullName);
                    break;

                case 3:
                    if (kiemTraEmail(email)) {
                        System.out.println("Email hợp lệ");
                    } else {
                        System.out.println("Email không hợp lệ");
                    }
                    break;

                case 4:
                    if (kiemTraPhone(phone)) {
                        System.out.println("Số điện thoại hợp lệ");
                    } else {
                        System.out.println("Số điện thoại không hợp lệ");
                    }
                    break;

                case 5:
                    if (kiemTraPassword(password)) {
                        System.out.println("Mật khẩu hợp lệ");
                    } else {
                        System.out.println("Mật khẩu không hợp lệ");
                    }
                    break;

                default:
                    flag = false;
                    System.out.println("Thoát chương trình");
                    break;
            }
        }
    }

    public static String chuanHoaHoTen(String fullName) {

        fullName = fullName.trim().toLowerCase();

        String[] arr = fullName.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];

            result.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));

            if (i != arr.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static boolean kiemTraEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }

    public static boolean kiemTraPhone(String phone) {
        String regex = "^(03|05|07|08|09)[0-9]{8}$";
        return Pattern.matches(regex, phone);
    }

    public static boolean kiemTraPassword(String password) {
        String regex =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.matches(regex, password);
    }
}