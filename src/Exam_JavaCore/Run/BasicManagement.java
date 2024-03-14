package Exam_JavaCore.Run;

import java.util.Scanner;

public class BasicManagement {
    public static void main(String[] args) {
        QlMain();
    }
    public static void QlMain(){
        DepartmentManagement qlDpt = DepartmentManagement.getInstance();
        EmployeeManagement qlEpl = EmployeeManagement.getInstance();
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("========= MENU========= \n" +
                        "1.\tQuản lý phòng ban \n" +
                        "2.\tQuản lý nhân viên \n" +
                        "3.\tThoát chương trình \n");
                System.out.println("Mời bạn chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                         qlDpt.QLDepartment();
                        break;
                    case 2:
                        qlEpl.QlEmployee();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Mời chọn lại từ 1-3");
                }
            }catch (Exception e){
                System.err.println("Định dạng không hợp lệ, mời nhập lại.");
            }

        }while (true);
    }


}




