package com.stu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);

        boolean flag = true;
        // Toán văn anh
        double [] arrayNumber = new double[3];
        while (flag)
        {
            System.out.println("**************Quản lí điểm sinh viên*****************");
            System.out.println("1.Nhập danh sách điểm sinh viên");
            System.out.println("2.In danh sách điểm của sinh viên");
            System.out.println("3.Tính điểm trung bình");
            System.out.println("4.Tìm điểm cao nhất và thap nhất");
            System.out.println("5.Đếm số lượng sinh viên đạt và trược");
            System.out.println("6.Xắp xếp điểm tăng dần");
            System.out.println("7.Thống kê sinh viên giỏi và xuất sắc");
            System.out.println("8.Thoát");

            int choose;
            while (true) {

                try {
                    System.out.println("Vui lòng nhập lựa chọn của bạn");
                    choose = Integer.parseInt(scanner.nextLine());

                    if(choose>=1 && choose<=8)
                    {
                        break;
                    }
                    else System.out.println("Vui lòng nhập số từ 1 đến 8");

                } catch (NumberFormatException e)
                {
                    System.out.println("Lỗi: Nhập dữ liệu không hợp lệ");
                }

            }
            switch (choose)
            {
                case 1:
                    inputArrayNumber(arrayNumber,scanner);
                    break;
                case 2:
                    outputArrayNumber(arrayNumber);
                    break;
                case 3:
                    diemTrungBinh(arrayNumber);
                    break;
                case 4:
                    maxMinNumber(arrayNumber);
                    break;
                case 5:
                    countPassFail(arrayNumber);
                    break;
                case 6:
                    sortArrayNumber(arrayNumber);
                    break;
                case 7:
                    thongKeHocLuc(arrayNumber);
                    break;
                default:
                    flag = false;
                    break;
            }

        }
    }
    public static void inputArrayNumber (double[] arrayNumber, Scanner scanner)
    {

        System.out.println("Vui lòng nhập điểm toán của bạn: ");
        arrayNumber[0] = Double.parseDouble(scanner.nextLine());

        System.out.println("Vui lòng nhập điểm văn của bạn: ");
        arrayNumber[1] = Double.parseDouble(scanner.nextLine());

        System.out.println("Vui lòng nhập điểm tiếng anh của bạn: ");
        arrayNumber[2] = Double.parseDouble(scanner.nextLine());

    }
    public static void outputArrayNumber (double []arrayNumber)
    {
        System.out.println("Danh sách điểm toán văn anh sẻ hiện theo thứ tự");
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print(arrayNumber[i]+ "\t");
        }
        System.out.println();
    }
    public static void diemTrungBinh (double []arrayNumber)
    {
        double sum =0;
        for (int i = 0; i < arrayNumber.length; i++) {
            sum+=arrayNumber[i];
        }
        System.out.printf("Điểm trung bình là:%.2f"+sum/3);
        System.out.println();
    }
    public static void maxMinNumber(double[] arrayNumber)
    {
        double max = arrayNumber[0];
        double min = arrayNumber[0];

        for (int i = 1; i < arrayNumber.length; i++) {
            if (arrayNumber[i] > max) {
                max = arrayNumber[i];
            }

            if (arrayNumber[i] < min) {
                min = arrayNumber[i];
            }
        }

        System.out.println("Điểm cao nhất là: " + max);
        System.out.println("Điểm thấp nhất là: " + min);
    }
    public static void countPassFail(double[] arrayNumber)
    {
        int pass = 0;
        int fail = 0;

        for (int i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i] >= 5) {
                pass++;
            } else {
                fail++;
            }
        }

        System.out.println("Số môn đạt: " + pass);
        System.out.println("Số môn trượt: " + fail);
    }
    public static void sortArrayNumber(double[] arrayNumber)
    {
        for (int i = 0; i < arrayNumber.length - 1; i++) {
            for (int j = i + 1; j < arrayNumber.length; j++) {
                if (arrayNumber[i] > arrayNumber[j]) {
                    double temp = arrayNumber[i];
                    arrayNumber[i] = arrayNumber[j];
                    arrayNumber[j] = temp;
                }
            }
        }

        System.out.println("Danh sách điểm sau khi sắp xếp:");

        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print("\t" + arrayNumber[i]);
        }

        System.out.println();
    }
    public static void thongKeHocLuc(double[] arrayNumber)
    {
        int gioi = 0;
        int xuatSac = 0;

        for (int i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i] >= 8 && arrayNumber[i] < 9) {
                gioi++;
            }

            if (arrayNumber[i] >= 9) {
                xuatSac++;
            }
        }

        System.out.println("Số môn loại giỏi: " + gioi);
        System.out.println("Số môn loại xuất sắc: " + xuatSac);
    }


}