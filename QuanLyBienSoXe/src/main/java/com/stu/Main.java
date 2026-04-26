package com.stu;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] bienSoXe = new String[100];
        int count = 0;

        boolean flag = true;

        while (flag) {
            System.out.println("************** QUẢN LÝ BIỂN SỐ XE **************");
            System.out.println("1. Nhập danh sách biển số xe");
            System.out.println("2. In danh sách biển số xe");
            System.out.println("3. Tìm kiếm chính xác biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");

            int choose;

            while (true) {
                try {
                    System.out.print("Nhập lựa chọn: ");
                    choose = Integer.parseInt(scanner.nextLine());

                    if (choose >= 1 && choose <= 6) {
                        break;
                    } else {
                        System.out.println("Vui lòng nhập từ 1 đến 6");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu không hợp lệ");
                }
            }

            switch (choose) {
                case 1:
                    System.out.print("Nhập số lượng biển số xe: ");
                    int n = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < n; i++) {
                        while (true) {
                            System.out.print("Nhập biển số xe thứ " + (i + 1) + ": ");
                            String plate = scanner.nextLine();

                            if (kiemTraBienSoXe(plate)) {
                                bienSoXe[count] = plate;
                                count++;
                                break;
                            } else {
                                System.out.println("Biển số xe không đúng định dạng");
                            }
                        }
                    }
                    break;

                case 2:
                    inDanhSachBienSoXe(bienSoXe, count);
                    break;

                case 3:
                    timKiemChinhXac(bienSoXe, count, scanner);
                    break;

                case 4:
                    timTheoMaTinh(bienSoXe, count, scanner);
                    break;

                case 5:
                    sapXepBienSoXe(bienSoXe, count);
                    break;

                default:
                    flag = false;
                    System.out.println("Thoát chương trình");
                    break;
            }
        }
    }

    public static boolean kiemTraBienSoXe(String plate) {
        String regex = "^[0-9]{2}[A-Z][0-9]-[0-9]{3}\\.[0-9]{2}$";
        return Pattern.matches(regex, plate);
    }

    public static void inDanhSachBienSoXe(String[] bienSoXe, int count) {

        if (count == 0) {
            System.out.println("Danh sách trống");
            return;
        }

        StringBuilder builder = new StringBuilder();

        builder.append("Danh sách biển số xe:\n");

        for (int i = 0; i < count; i++) {
            builder.append(bienSoXe[i]).append("\n");
        }

        System.out.println(builder);
    }

    public static void timKiemChinhXac(String[] bienSoXe, int count, Scanner scanner) {

        System.out.print("Nhập biển số cần tìm: ");
        String search = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (bienSoXe[i].equalsIgnoreCase(search)) {
                System.out.println("Tìm thấy: " + bienSoXe[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy biển số xe");
        }
    }

    public static void timTheoMaTinh(String[] bienSoXe, int count, Scanner scanner) {

        System.out.print("Nhập mã tỉnh: ");
        String maTinh = scanner.nextLine();

        String tenTinh = getProvinceName(maTinh);

        if (tenTinh.equals("Không xác định")) {
            System.out.println("Mã tỉnh không tồn tại");
            return;
        }

        boolean found = false;

        System.out.println("Tỉnh: " + tenTinh);
        System.out.println("Danh sách biển số:");

        for (int i = 0; i < count; i++) {
            if (bienSoXe[i].startsWith(maTinh)) {
                System.out.println(bienSoXe[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có biển số thuộc tỉnh này");
        }
    }

    public static void sapXepBienSoXe(String[] bienSoXe, int count) {

        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {

                int maTinh1 = Integer.parseInt(bienSoXe[i].substring(0, 2));
                int maTinh2 = Integer.parseInt(bienSoXe[j].substring(0, 2));

                if (maTinh1 > maTinh2) {
                    String temp = bienSoXe[i];
                    bienSoXe[i] = bienSoXe[j];
                    bienSoXe[j] = temp;
                }
            }
        }

        System.out.println("Danh sách biển số sau khi sắp xếp:");

        for (int i = 0; i < count; i++) {
            System.out.println(bienSoXe[i]);
        }
    }
    public static String getProvinceName(String maTinh) {
        switch (maTinh) {
            case "11": return "Cao Bằng";
            case "12": return "Lạng Sơn";
            case "14": return "Quảng Ninh";
            case "15":
            case "16": return "Hải Phòng";
            case "17": return "Thái Bình";
            case "18": return "Nam Định";
            case "19": return "Phú Thọ";
            case "20": return "Thái Nguyên";
            case "21": return "Yên Bái";
            case "22": return "Tuyên Quang";
            case "23": return "Hà Giang";
            case "24": return "Lào Cai";
            case "25": return "Lai Châu";
            case "26": return "Sơn La";
            case "27": return "Điện Biên";
            case "28": return "Hòa Bình";

            case "29":
            case "30":
            case "31":
            case "32":
            case "33":
            case "40": return "Hà Nội";

            case "34": return "Hải Dương";
            case "35": return "Ninh Bình";
            case "36": return "Thanh Hóa";
            case "37": return "Nghệ An";
            case "38": return "Hà Tĩnh";

            case "43": return "Đà Nẵng";

            case "47": return "Đắk Lắk";
            case "48": return "Đắk Nông";
            case "49": return "Lâm Đồng";

            case "50":
            case "51":
            case "52":
            case "53":
            case "54":
            case "55":
            case "56":
            case "57":
            case "58":
            case "59": return "TP.HCM";

            case "60": return "Đồng Nai";
            case "61": return "Bình Dương";
            case "62": return "Long An";
            case "63": return "Tiền Giang";
            case "64": return "Vĩnh Long";
            case "65": return "Cần Thơ";
            case "66": return "Đồng Tháp";
            case "67": return "An Giang";
            case "68": return "Kiên Giang";
            case "69": return "Cà Mau";

            case "70": return "Tây Ninh";
            case "71": return "Bến Tre";
            case "72": return "Bà Rịa - Vũng Tàu";
            case "73": return "Quảng Bình";
            case "74": return "Quảng Trị";
            case "75": return "Thừa Thiên Huế";
            case "76": return "Quảng Ngãi";
            case "77": return "Bình Định";
            case "78": return "Phú Yên";
            case "79": return "Khánh Hòa";

            case "81": return "Gia Lai";
            case "82": return "Kon Tum";
            case "83": return "Sóc Trăng";
            case "84": return "Trà Vinh";
            case "85": return "Ninh Thuận";
            case "86": return "Bình Thuận";
            case "88": return "Vĩnh Phúc";
            case "89": return "Hưng Yên";

            case "90": return "Hà Nam";
            case "92": return "Quảng Nam";
            case "93": return "Bình Phước";
            case "94": return "Bạc Liêu";
            case "95": return "Hậu Giang";
            case "97": return "Bắc Kạn";
            case "98": return "Bắc Giang";
            case "99": return "Bắc Ninh";

            default:
                return "Không xác định";
        }
    }
}