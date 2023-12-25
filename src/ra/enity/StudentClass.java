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
        //fafafafafaaaagagbakjghakjhgkjahgajk

    }
    public  void inputIdClass(Scanner sc){
        System.out.println("Nhap id class: ");
        this.classId = sc.nextLine();
        do{
            if(this.classId.length()==5 && this.classId.startsWith("J")){
                break;
            }else{
                System.err.println("Id class phai bat dau bang J va co 5 ki tu");
            }
        }while(true);
    }

    public void inputClassName(Scanner sc){
        System.out.println("Nhap ten class: ");
        this.className = sc.nextLine();
        do{
            if(this.className.length()>=10){
                break;
            }else{
                System.err.println("Ten class phai co it nhat 10 ki tu");
            }
        }while(true);
    }

    public void inputDescription(Scanner sc){
        System.out.println("Nhap mo ta class: ");
        this.description = sc.nextLine();
        do{
            if(this.description.length()>=20){
                break;
            }else{
                System.err.println("Mo ta class phai co it nhat 20 ki tu");
            }
        }while(true);
    }
    @Override
    public void displayData() {

    }
}
