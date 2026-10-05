public  class Person {
    
    private String name;
    private int age;
    private String ssn;
    private String city;

    public Person() {

    }

    public Person(String name, int age, String ssn, String city) {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void work() {
        System.out.println("This person works hard");
    }

    @Override
    public String toString() {
        return super.toString() + "; Person [name=" + name + ", age=" + age + ", ssn=" + ssn + ", city=" + city + "]";
    }

    

    

}
