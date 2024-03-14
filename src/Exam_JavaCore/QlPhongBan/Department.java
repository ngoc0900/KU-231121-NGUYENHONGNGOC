package Exam_JavaCore.QlPhongBan;

import Exam_JavaCore.IEmployee;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Department implements IEmployee {
    private int departmentId;
    private String departmentName;

    public Department() {
    }

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public static final ArrayList<Department> departments = new ArrayList<>();
    public static final Scanner scanner = new Scanner(System.in);

    @Override
    public void inputData(Scanner scanner, int index) {
        System.out.println("Phòng ban thứ: "+ index);
        inputDptID();
        inputDepartmentName();

    }
    public void inputDptID(){

        boolean check = false;
        do {
            try {
                System.out.println("Nhập vào mã phòng ban");
                int newId = Integer.parseInt(scanner.nextLine());
                if (newId > 0 ) {
                    check = true;
                    departmentId = newId;
                } else {
                    System.err.println("Mã thể loại bị trùng, yêu cầu nhập lại");
                }
            } catch (NumberFormatException exception) {
                System.err.println("Định dạng không hợp lệ, vui lòng nhập lại");
            }
        } while (!check);
    }

    public void inputDepartmentName(){
        boolean check = false;
        do {
            try {
                System.out.println("Nhập vào tên phòng ban");
                String newName = scanner.nextLine();
                boolean result = Pattern.matches("(.{1,})", newName);
                if (result ) {
                    check = true;
                    departmentName = newName;
                } else {
                    System.err.println("Không bỏ trống tên phòng ban, vui lòng nhập lại.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Định dạng không hợp lệ, vui lòng nhập lại");
            }
        } while (!check);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã phòng ban: %d, Tên phòng ban: %s \n", departmentId, departmentName);
    }
     public void editData(){
        inputDepartmentName();
     }
}


