package ra.run;

import ra.enity.Student;
import ra.enity.StudentClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static List<StudentClass> listStudentClass = new ArrayList<>();
    public static List<Student> listStudent = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("***************QUẢN LÝ HỌC VIỆN***************");
            System.out.println("1. Quản lý lớp");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    displayMenuClass(sc);
                    break;
                case 2:
                    displayMenuStudent(sc);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }

        }while(true);
    }

    public static void displayMenuClass(Scanner sc){
        boolean check = true;
        do{
            System.out.println("*************QUẢN LÝ LỚP****************");
            System.out.println("1. Thêm mới lớp học");
            System.out.println("2. Cập nhật thông tin lớp học");
            System.out.println("3. Hiển thị thông tin lớp học");
            System.out.println("4. Thống kê các lớp hoc đang hoạt động");
            System.out.println("5. Tìm kiếm lớp học theo tên lớp học");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    addNewClass(sc);
                    break;
                case 2:
                    updateClass(sc);
                    break;
                case 3:
                    displayClass(sc);
                    break;
                case 4:
                    displayActiveClass(sc);
                    break;
                case 5:
                    searchClassByName(sc);
                    break;
                case 6:
                    check = false;
                    break;
            }

        }while(check);
    };

    public static void addNewClass(Scanner sc){
        System.out.println("Nhap vao so lop hoc muon them");
        int numberOfClass = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfClass; i++) {
            StudentClass studentClass = new StudentClass();
            studentClass.inputData(sc);
            listStudentClass.add(studentClass);
            System.out.println("them thanh cong");

        }
    };
    public static void updateClass(Scanner sc){
        System.out.println("Nhap vao id class muon sua");
        String idClass = sc.nextLine();
        int index = findClassById(idClass);
        if(index > -1){
            listStudentClass.get(index).inputClassName(sc);
            listStudentClass.get(index).inputDescription(sc);
            listStudentClass.get(index).inputClassStatus(sc);
            System.out.println("Sua thanh cong");
        }else {
            System.err.println("Khong tim thay id class");
        }

    };

    public static int findClassById(String idClass){
        for (int i = 0; i < listStudentClass.size(); i++) {
            if(listStudentClass.get(i).getClassId().equals(idClass)){
                return i;
            }
        }
        return -1;

    };

    public static void displayClass(Scanner sc){
     for (StudentClass studentClass : listStudentClass){
         studentClass.displayData();
     }
    };

    public static void displayActiveClass(Scanner sc){
        int count = 0;
        for(StudentClass studentClass : listStudentClass){
            if(studentClass.getClassStatus() == 1){
                count++;

            }
        }
        System.out.println("So lop hoc dang hoat dong la: " + count);
    };

    public static void searchClassByName(Scanner sc){
        System.out.println("Nhap vao ten lop hoc muon tim kiem");
        String nameClass = sc.nextLine();
        for (StudentClass studentClass : listStudentClass){
            if(studentClass.getClassName().equals(nameClass)){
                studentClass.displayData();
            }
        }
        System.out.println("Khong tim thay ten lop hoc");
    };

    public static void displayMenuStudent(Scanner sc){
        boolean check = true;
        do{
            System.out.println("***************QUẢN LÝ SINH VIÊN****************");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Cập nhật thông tin sinh viên");
            System.out.println("3. Hiển thị thông tin sinh viên");
            System.out.println("4. Tính điểm trung bình");
            System.out.println("5. Xếp loại sinh viên");
            System.out.println("6. Sắp xếp sinh viên theo điểm trung bình tăng dần");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê số sinh viên đạt loại giỏi, khá, trung bình, yếu");
            System.out.println("9. Thống kê sinh viên pass qua môn học");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    check = false;
                    break;
                default:
                    System.out.println("Nhap sai lua chon");
                    break;
            }
        }while(check);
    };

    public static void addNewStudent(Scanner sc){
        System.out.println("Nhap vao so sinh vien muon them");
        int numberOfStudent = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfStudent; i++) {
            Student student = new Student();
            student.inputData(sc);
            listStudent.add(student);
            System.out.println("them thanh cong");
        }
    };
    public static void updateStudent(Scanner sc){
        System.out.println("Nhap vao id student muon sua");
        String idStudent = sc.nextLine();
        int index = findStudentById(idStudent);
        if(index > -1){
            listStudent.get(index).inputNameStudent(sc);
            listStudent.get(index).inputAgeStudent(sc);
            listStudent.get(index).inputSexStudent(sc);
            listStudent.get(index).inputClassIdStudent(sc);
            listStudent.get(index).inputMarkStudent(sc);
            listStudent.get(index).inputStudentStatus(sc);
            System.out.println("Sua thanh cong");
        }else {
            System.err.println("Khong tim thay id student");
        }

    };

    public static int findStudentById(String idStudent){
        for (int i = 0; i < listStudent.size(); i++) {
            if(listStudent.get(i).getStudentId().equals(idStudent)){
                return i;
            }
        }
        return -1;
    };

    public static void displayStudent(Scanner sc){
        for (Student student : listStudent){
            student.displayData();
        }
    };

    public static void calAvg(Scanner sc){
        listStudent.forEach(student -> {
            student.calAvgMark();
        });
        displayStudent(sc);
    };


}
