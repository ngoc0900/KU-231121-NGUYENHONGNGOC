package Exam_JavaCore.Run;

import Exam_JavaCore.QlPhongBan.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentManagement {
    public static final Scanner scanner = new Scanner(System.in);
    private static DepartmentManagement instance;
    private static ArrayList<Department> departments;
    private DepartmentManagement() {
        departments = new ArrayList<Department>();
    }

    public static DepartmentManagement getInstance() {
        if (instance == null) {
            instance = new DepartmentManagement();
        }

        return instance;
    }
    public ArrayList<Department> getListDepartment(){
        return departments;
    }
    public void QLDepartment(){
        do {
            try {
                System.out.println("**********************DEPARTMENT-MENU************************\n" +
                        "1.\tThêm mới phòng ban \n" +
                        "2.\tHiển thị thông tin tất cả phòng ban \n" +
                        "3.\tSửa tên phòng ban \n" +
                        "4.\tXóa phòng ban \n" +
                        "5.\tTìm kiếm phòng ban \n" +
                        "6.\tQuay lại \n");
                System.out.println("Mời bạn chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Số phòng ban muốn nhập");
                        int n = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < n; i++) {
                            Department department = new Department();
                            department.inputData(scanner, i + 1);
                            departments.add(department);
                        }
                        break;
                    case 2:
                        System.out.println("Hiển thị thông tin tất cả phòng ban");
                        for (Department department : departments) {
                            department.displayData();
                        }
                        break;
                    case 3:
                        System.out.println("Sửa tên phòng ban");
                        try {
                            System.out.println("Nhập vào tên phòng ban muốn thay đổi");
                            String name =scanner.nextLine();
                            Department department = getDepartmentByName(departments, name);
                            if (department != null) {
                                department.displayData();
                                try {
                                    System.out.println("bạn có muốn sửa lại thông tin k? (c/k)");
                                    String choice1 = scanner.nextLine();
                                    if (choice1.equalsIgnoreCase("c")) {
                                        department.editData();
                                        System.out.println("đã cập nhật thành công");
                                        break;
                                    } else {
                                        System.err.println("huỷ cập nhật thông tin");
                                    }
                                }catch (Exception e){
                                    System.err.println("Định dạng không đúng, mời nhập lại");
                                }
                            } else {
                                System.err.println("Không tồn tại tên phòng ban có tên: " + name);
                            }
                        }catch (Exception e){
                                System.err.println("Định dạng không đúng, mời nhập lại");
                        }
                        break;
                    case 4:
                        System.out.println("Xóa phòng ban");
                        try {
                            System.out.println("Nhập vào tên phòng ban muốn thay đổi");
                            String name =scanner.nextLine();
                            Department department = getDepartmentByName(departments, name);
                            if (department != null) {
                                department.displayData();
                                try {
                                    System.out.println("bạn có muốn sửa lại thông tin k? (c/k)");
                                    String choice1 = scanner.nextLine();
                                    if (choice1.equalsIgnoreCase("c")) {
                                        departments.remove(department);
                                        System.out.println("đã xoá xong");
                                        break;
                                    } else {
                                        System.err.println("huỷ xoá");
                                    }
                                }catch (Exception e){
                                    System.err.println("Định dạng không đúng, mời nhập lại");
                                }
                            } else {
                                System.err.println("Không tồn tại tên phòng ban có tên: " + name);
                            }
                        }catch (Exception e){
                            System.err.println("Định dạng không đúng, mời nhập lại");
                        }
                        break;
                    case 5:
                        System.out.println("Tìm kiếm phòng ban");
                        try {
                            System.out.println("Nhập vào tên phòng ban muốn tìm kiếm");
                            String name =scanner.nextLine();
                            Department department = getDepartmentByName(departments, name);
                            if (department != null) {
                                department.displayData();
                                getDepartmentByName(departments,name);
                            } else {
                                System.err.println("Không tồn tại tên phòng ban có tên: " + name);
                            }
                        }catch (Exception e){
                            System.err.println("Định dạng không đúng, mời nhập lại");
                        }
                        break;
                    case 6:
                        BasicManagement.QlMain();
                    default:
                        System.err.println("Mời chọn lại từ 1-6!");
                }
            }catch (Exception e){
                System.err.println("Định dạng không hợp lệ, mời nhập lại.");
            }
        }while (true);
    }

    public static Department getDepartmentByName(List<Department> departments, String name) {
        for (Department department1 : departments) {
            if (department1.getDepartmentName().toLowerCase().contains(name)) {
                return department1;
            }
        }
        return null;
    }

}
