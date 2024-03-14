package Exam_JavaCore.Run;

import Exam_JavaCore.QlNhanVien.Employee;
import Exam_JavaCore.QlPhongBan.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    public static final Scanner scanner = new Scanner(System.in);
    private static EmployeeManagement instance;
    private static ArrayList<Employee> employees;
    private EmployeeManagement() {
        employees = new ArrayList<Employee>();
    }

    public static EmployeeManagement getInstance() {
        if (instance == null) {
            instance = new EmployeeManagement();
        }

        return instance;
    }
    public ArrayList<Employee> getListEmployee(){
        return employees;
    }
    public void QlEmployee(){
        do {
            try {
                System.out.println("**********************DEPARTMENT-MENU************************\n" +
                        "1.\tThêm mới nhân viên \n" +
                        "2.\t Hiển thị thông tin tất cả nhân viên \n" +
                        "3.\tXem chi tiết thông tin nhân viên \n" +
                        "4.\tThay đổi thông tin nhân viên \n" +
                        "5.\tXóa nhân viên \n" +
                        "6.\tHiển thị danh sách nhân viên theo phòng ban \n" +
                        "7.\tSắp xếp danh sách nhân viên \n" +
                        "8.\tQuay lại \n");

                System.out.println("Mời bạn chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Số nhân viên muốn nhập");
                        int n = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < n; i++) {
                            Employee employee = new Employee();
                            employee.inputData(scanner, i + 1);
                            employees.add(employee);
                        }
                        break;
                    case 2:
                        System.out.println("Hiển thị thông tin tất cả nhân viên");
                        for (Employee employee : employees) {
                            employee.displayData();
                        }
                        break;
                    case 3:
                        System.out.println("Sửa tên phòng ban");
//                        try {
//                            System.out.println("Nhập vào tên phòng ban muốn thay đổi");
//                            String name =scanner.nextLine();
////                            Department department = getDepartmentByName(departments, name);
//                            if (department != null) {
//                                department.displayData();
//                                try {
//                                    System.out.println("bạn có muốn sửa lại thông tin k? (c/k)");
//                                    String choice1 = scanner.nextLine();
//                                    if (choice1.equalsIgnoreCase("c")) {
//                                        department.editData();
//                                        System.out.println("đã cập nhật thành công");
//                                        break;
//                                    } else {
//                                        System.err.println("huỷ cập nhật thông tin");
//                                    }
//                                }catch (Exception e){
//                                    System.err.println("Định dạng không đúng, mời nhập lại");
//                                }
//                            } else {
//                                System.err.println("Không tồn tại tên phòng ban có tên: " + name);
//                            }
//                        }catch (Exception e){
//                            System.err.println("Định dạng không đúng, mời nhập lại");
//                        }
                        break;
                    case 4:
                        System.out.println("Xóa phòng ban");
//                        try {
//                            System.out.println("Nhập vào tên phòng ban muốn thay đổi");
//                            String name =scanner.nextLine();
//                            Department department = getDepartmentByName(departments, name);
//                            if (department != null) {
//                                department.displayData();
//                                try {
//                                    System.out.println("bạn có muốn sửa lại thông tin k? (c/k)");
//                                    String choice1 = scanner.nextLine();
//                                    if (choice1.equalsIgnoreCase("c")) {
//                                        departments.remove(department);
//                                        System.out.println("đã xoá xong");
//                                        break;
//                                    } else {
//                                        System.err.println("huỷ xoá");
//                                    }
//                                }catch (Exception e){
//                                    System.err.println("Định dạng không đúng, mời nhập lại");
//                                }
//                            } else {
//                                System.err.println("Không tồn tại tên phòng ban có tên: " + name);
//                            }
//                        }catch (Exception e){
//                            System.err.println("Định dạng không đúng, mời nhập lại");
//                        }
                        break;
                    case 5:
//                        System.out.println("Tìm kiếm phòng ban");
//                        try {
//                            System.out.println("Nhập vào tên phòng ban muốn tìm kiếm");
//                            String name =scanner.nextLine();
//                            Department department = getDepartmentByName(departments, name);
//                            if (department != null) {
//                                department.displayData();
//                                getDepartmentByName(departments,name);
//                            } else {
//                                System.err.println("Không tồn tại tên phòng ban có tên: " + name);
//                            }
//                        }catch (Exception e){
//                            System.err.println("Định dạng không đúng, mời nhập lại");
//                        }
//                        break;
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

//    public static Department getDepartmentByName(List<Department> departments, String name) {
//        for (Department department1 : departments) {
//            if (department1.getDepartmentName().toLowerCase().contains(name)) {
//                return department1;
//            }
//        }
//        return null;
//    }

}

