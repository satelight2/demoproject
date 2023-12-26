package ra.enity;

import ra.run.StudentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement{
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private String classId;
    private List<Float> listMarkJavascript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new ArrayList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String gpa;
    private boolean studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, String classId, List<Float> listMarkJavascript, List<Float> listMarkJavaCore, List<Float> listMarkJavaWeb, float avgMark, String gpa, boolean studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.classId = classId;
        this.listMarkJavascript = listMarkJavascript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public List<Float> getListMarkJavascript() {
        return listMarkJavascript;
    }

    public void setListMarkJavascript(List<Float> listMarkJavascript) {
        this.listMarkJavascript = listMarkJavascript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        //nhap id student
        inputIdStudent(sc);
        //nhap ten student
        inputNameStudent(sc);
        //nhap tuoi student
        inputAgeStudent(sc);
        //nhap gioi tinh student
        inputSexStudent(sc);
        //nhap id class
        inputClassIdStudent(sc);
        //nhap diem student
        inputMarkStudent(sc);
        //nhap trang thai student
        inputStudentStatus(sc);

    }
    public void inputIdStudent(Scanner sc){
        System.out.println("Nhap id sinh vien: ");
      do{
          this.studentId = sc.nextLine();
          if(this.studentId.length() == 6 && this.studentId.charAt(0) == 'S'){
              break;}
        else{
            System.out.println("Id sinh vien khong duoc de trong");
        }
      }while (true);
    }

    public void inputNameStudent(Scanner sc){
        System.out.println("Nhap ten sinh vien: ");
        do{
            this.studentName = sc.nextLine();
            if(this.studentName.length() >= 10 && this.studentName.length() <= 30){
                break;
            }
            else{
                System.out.println("Ten sinh vien khong duoc de trong");
            }
        }while (true);
    }

    public void inputAgeStudent(Scanner sc){
        System.out.println("Nhap tuoi sinh vien: ( 18 - 40))");
        do{
            this.age = Integer.parseInt(sc.nextLine());
            if(this.age >= 18 && this.age <= 40){
                break;
            }
            else{
                System.out.println("Tuoi sinh vien ngoai khoang tuoi cho phep");
            }
        }while (true);
    }

    public void inputSexStudent(Scanner sc){
        System.out.println("Nhap gioi tinh sinh vien: (true - nam, false - nu)");
        this.sex = Boolean.parseBoolean(sc.nextLine());
    };

    public void inputClassIdStudent(Scanner sc){
        System.out.println("Chon lop hoc cho sinh vien : ");
        do{
            for (int i = 0; i < StudentManagement.listStudentClass.size(); i++) {
                System.out.println((i+1) + ". " + StudentManagement.listStudentClass.get(i).getClassName());
            }
            int choice = Integer.parseInt(sc.nextLine());
            if(choice > 0 && choice <= StudentManagement.listStudentClass.size()){
                this.classId= StudentManagement.listStudentClass.get(choice - 1).getClassId();
                break;
            }
            else{
                System.out.println("Lua chon khong hop le");
            }
        }while (true);

    }

    public void inputMark(Scanner sc,String subjectName){
        System.out.printf("Nhap vao diem %s:",subjectName);
        switch (subjectName){
            case "Javascript":
                this.listMarkJavascript.add(Float.parseFloat(sc.nextLine()));
                break;
            case "Java Core":
                this.listMarkJavaCore.add(Float.parseFloat(sc.nextLine()));
                break;
            case "Java Web":
                this.listMarkJavaWeb.add(Float.parseFloat(sc.nextLine()));
                break;
        }
    };

    public void inputMarkStudent(Scanner sc){
        System.out.println("Nhap vao diem sinh vien: ");
        inputMark(sc,"Javascript");
        inputMark(sc,"Java Core");
        inputMark(sc,"Java Web");
    }

    public void inputStudentStatus(Scanner sc){
        System.out.println("Nhap vao trang thai sinh vien: (true - dang hoc, false - nghi hoc)");
        this.studentStatus = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("%-12s | %-20s | %-3s | %-4s | %-8s | %-15s | %-15s | %-15s | %-7s | %-5s | %-13s%n",
                "Student ID", "Student Name", "Age", "Sex", "Class ID", "Marks (JS)", "Marks (Java Core)", "Marks (Java Web)",
                "Avg Mark", "GPA", "Status");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");

        System.out.printf("%-12s | %-20s | %-3d | %-4s | %-8s | %-15s | %-15s | %-15s | %-7.2f | %-5s | %-13s%n",
                this.studentId, this.studentName, this.age, (this.sex ? "Male" : "Female"), this.classId, this.listMarkJavascript, this.listMarkJavaCore, this.listMarkJavaWeb,
                this.avgMark, this.gpa, (this.studentStatus ? "Active" : "Inactive"));
    }
    public void calAvgMark() {
        this.avgMark = (this.listMarkJavascript.get(this.listMarkJavascript.size() - 1)
                + this.listMarkJavaCore.get(this.listMarkJavaCore.size() - 1)
                + this.listMarkJavaWeb.get(this.listMarkJavaWeb.size() - 1)) / 3;
    }

    public void getGPAByAvgMark() {
        if (this.avgMark < 5) {
            this.gpa = "Yếu";
        } else if (this.avgMark < 7) {
            this.gpa = "Trung bình";
        } else if (this.avgMark < 9) {
            this.gpa = "Khá";
        } else {
            this.gpa = "Giỏi";
        }
    }
}
