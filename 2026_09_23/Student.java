class Student {

    private String name;
    private int age;
    private double gpa;

    public void setName(String n) {
        name = n;
    }
    public void setAge(int a) {
        age = a;
    }
    public void setGpa(double g) {
        gpa = g;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getGpa() {
        return gpa;
    }

    public void eat() {
        System.out.println(name + " who is " + age + ", and has a gpa of " + gpa + " is eating");
    }
}