package Exam_JavaCore.QlNhanVien;

import Exam_JavaCore.IEmployee;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee implements IEmployee {


    private int employeeId;    //(mã nhân viên , tự tăng)
    private String employeeName;    //(tên nhân viên, không được để trống).
    private String email;     //(địa chỉ gmail, đúng định dạng, không trùng lặp)
    private String phoneNumber;    //(số điện thoại, đúng định dạng số Việt nam, không trùng lặp)
    private String address;     //(địa chỉ thường trú )
    private boolean gender;    //(giới tính ,nhận 1 trong 2 giá trị MALE, FEMALE)
    private Date birthday; //  ngày sinh, đinh dạng dd/MM/yyyy , không để trống)
    private float basicSalary;    //(lương cơ bản, đơn vị $)
    private float allowanceSalary;    //(phụ cấp, đơn vị $)
    private float rate;   //(hệ số lương , phải >=1)
    private int departmentId;   //(mã phòng ban làm việc , không được null)

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String email, String phoneNumber, String address, boolean gender, Date birthday, float basicSalary, float allowanceSalary, float rate, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
        this.basicSalary = basicSalary;
        this.allowanceSalary = allowanceSalary;
        this.rate = rate;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public float getAllowanceSalary() {
        return allowanceSalary;
    }

    public void setAllowanceSalary(float allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public static final Scanner scanner = new Scanner(System.in);
    public static final ArrayList<Employee> employees = new ArrayList<>();


    @Override
    public void inputData(Scanner scanner, int index) {
        System.out.println("Nhân viên thứ: " + index);
        inputId();
        inputNameEpl();
        inputAddress();
        inputGmail();
        inputAddress();
        inpuBirthday();
        inputGender();
        inputbasicSalary();
        inputallowanceSalary();
        inputdepartmentId();
    }

    public void inputId() {
        boolean check = false;
        do {
            try {
                System.out.println("Nhập vào mã nhân viên");
                int newId = Integer.parseInt(scanner.nextLine());
                if (newId > 0) {
                    check = true;
                    departmentId = newId;
                } else {
                    System.err.println("Mã thể nhân viên bị trùng hoặc không hợp lệ, yêu cầu nhập lại");
                }
            } catch (NumberFormatException exception) {
                System.err.println("Định dạng không hợp lệ, vui lòng nhập lại");
            }
        } while (!check);
    }

    public void inputNameEpl() {
        boolean check = false;
        do {
            try {
                System.out.println("Nhập vào tên nhân viên");
                String newName = scanner.nextLine();
                boolean result = Pattern.matches("(.{1,})", newName);
                if (result) {
                    check = true;
                    employeeName = newName;
                } else {
                    System.err.println("Không bỏ trống tên nhân viên, vui lòng nhập lại.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Định dạng không hợp lệ, vui lòng nhập lại");
            }
        } while (!check);
    }

    public void inputGmail() {
        boolean check = false;
        do {
            try {
                System.out.println("Nhập vào địa chỉ gmail, đúng định dạng");
                String newgmail = scanner.nextLine();
                boolean result = Pattern.matches("(.{1,})", newgmail);
                if (result) {
                    check = true;
                    email = newgmail;
                } else {
                    System.err.println("Không bỏ trống gmail, vui lòng nhập lại.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Định dạng không hợp lệ, vui lòng nhập lại");
            }
        }while (!check) ;
    }
    public void inputPhone(){
        boolean check = false;
        do {
            try {
                System.out.println("Nhập vào số điện thoại");
                String newPhone = scanner.nextLine();
                boolean result = Pattern.matches("(.{1,})", newPhone);
                if (result) {
                    check = true;
                    phoneNumber = newPhone;
                } else {
                    System.err.println("Không bỏ trống số điện thoại, vui lòng nhập lại.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Định dạng không hợp lệ, vui lòng nhập lại");
            }
        }while (!check) ;
    }
    public void inputAddress(){
        boolean check = false;
        do {
            try {
                System.out.println("Nhập vào địa chỉ");
                String newAddress = scanner.nextLine();
                boolean result = Pattern.matches("(.{1,})", newAddress);
                if (result) {
                    check = true;
                    address = newAddress;
                } else {
                    System.err.println("Không bỏ trống địa chỉ, vui lòng nhập lại.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Định dạng không hợp lệ, vui lòng nhập lại");
            }
        }while (!check) ;
    }
    public void inputGender(){
        do{
            try {
                System.out.println("Nhập vào giới tính true hoặc false");
                boolean newGender = Boolean.parseBoolean(scanner.nextLine());
                gender = newGender;
            }catch (Exception e) {
                System.err.println("định dạng không đúng mời nhập lại");
            }
        }while (true);

    }
    public void inputbasicSalary(){
        do {
            try {
                System.out.println("Nhập vào lương cơ bản");
                float lcb = Float.parseFloat(scanner.nextLine());
                basicSalary = lcb;

            }catch (Exception e) {
                System.err.println("định dạng không đúng mời nhập lại");
            }
        }while (true);
    }
    public void inputallowanceSalary(){
        do {
            try {
                System.out.println("Nhập phụ cấp");
                float lcb = Float.parseFloat(scanner.nextLine());
                allowanceSalary = lcb;

            }catch (Exception e) {
                System.err.println("định dạng không đúng mời nhập lại");
            }
        }while (true);
    }
    public void inputrate(){
        do {
            try {
                System.out.println("Nhập hệ số lương >= 1");
                float lcb = Float.parseFloat(scanner.nextLine());
                rate = lcb;

            }catch (Exception e) {
                System.err.println("định dạng không đúng mời nhập lại");
            }
        }while (true);
    }

    public void inputdepartmentId(){
        do {
            try {
                System.out.println("Nhập hệ số lương >= 1");
                int lcb = Integer.parseInt(scanner.nextLine());
                departmentId = lcb;
            }catch (Exception e) {
                System.err.println("định dạng không đúng mời nhập lại");
            }
        }while (true);
    }





    public void inpuBirthday(){
        boolean check = false;
        do {
            try {
                System.out.println("Nhập vào ngày,tháng, năm sinh");
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
                boolean result = Pattern.matches("(.{1,})", (CharSequence) date);
                if (result) {
                    check = true;
                    birthday = date;
                } else {
                    System.err.println("Không bỏ trống địa chỉ, vui lòng nhập lại.");
                }

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }while (!check);
    }


    public void editDataEpy () {
    }

    @Override
    public void displayData () {
        System.out.printf("Mã nhân viên: %d, Tên nhân viên: %s ", employeeId,employeeName);
        System.out.printf("Email: %s, phone: %d ", email,phoneNumber);
        System.out.printf("address: %s, gender: %d ", address,(gender? "MALE" :"FEMALE"));

    }
    }
