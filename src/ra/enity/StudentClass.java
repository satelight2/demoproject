package ra.enity;

import java.util.Scanner;

public class StudentClass implements IStudentManagement{
    private String classId;
    private String className;
    private String description;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String description, int classStatus) {
        this.classId = classId;
        this.className = className;
        this.description = description;
        this.classStatus = classStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        //nhap id class
        inputIdClass(sc);
        //nhap ten class
        inputClassName(sc);

        //nhap mo ta class
        inputDescription(sc);

        //nhap trang thai class
        inputClassStatus(sc);

    }
    public  void inputIdClass(Scanner sc){
        System.out.println("Nhap id class: ");

        do{
            this.classId = sc.nextLine();
            if(this.classId.length()==5 && this.classId.startsWith("J")){
                break;
            }else{
                System.err.println("Id class phai bat dau bang J va co 5 ki tu");
            }
        }while(true);
    }

    public void inputClassName(Scanner sc){
        System.out.println("Nhap ten class: ");

        do{
            this.className = sc.nextLine();
            if(this.className.length()>=10){
                break;
            }else{
                System.err.println("Ten class phai co it nhat 10 ki tu");
            }
        }while(true);
    }

    public void inputDescription(Scanner sc){
        System.out.println("Nhap mo ta class: ");

        do{
            this.description = sc.nextLine();

            if(this.description.length()>=20){
                break;
            }else{
                System.err.println("Mo ta class phai co it nhat 20 ki tu");
            }
        }while(true);
    }

    public void inputClassStatus(Scanner sc){
        System.out.println("Nhap trang thai class: ");

       do{
           this.classStatus = Integer.parseInt(sc.nextLine());
           if(0 <= this.classStatus && this.classStatus<=3){
               break;
              }else{
               System.err.println("Trang thai class phai la 0 den 3");

           }
       }while (true);
    }
    @Override
    public void displayData() {
        String classStatus = "";
        switch (this.classStatus){
            case 0:
                classStatus = "Inactive";
                break;
            case 1:
                classStatus = "Active";
                break;
            case 2:
                classStatus = "New";
                break;
            case 3:
                classStatus = "Graduated";
                break;
        }
        System.out.printf("%-10s | %-20s | %-30s | %-10s%n", "Class ID", "Class Name", "Description", "Class Status");
        System.out.println("---------------------------------------------------------------");

        System.out.printf("%-10s | %-20s | %-30s | %-10s%n", this.classId, this.className, this.description, classStatus);
    }
}
