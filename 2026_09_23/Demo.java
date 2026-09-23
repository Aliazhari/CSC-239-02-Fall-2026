public class Demo {
    
    public static void main(String[] args) {
        
        Student s1 = new Student();
        s1.setName("Bob");
        s1.setAge(19);
        s1.setGpa(3.9);

        Student s2 = new Student();
         s2.setName("Alin");
        s2.setAge(20);
        s2.setGpa(4.0);

        Student[] students = new Student[2];
        students[0] = s1;
        students[1] = s2;

        // for (int i = 0; i < 2; i++) {
        //     System.out.println("Student # " + (i + 1) + "is: " + students[i].getName() + " " + students[i].getAge() + " " + students[i].getGpa());
        // }
        // System.out.println(s1.getName());
        // s1.eat();
        // s2.eat();

        System.out.println(s1.toString());
    }
}
