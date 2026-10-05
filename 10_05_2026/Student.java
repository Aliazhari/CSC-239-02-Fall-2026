public class Student extends Person {

    String id;

    public Student(String name, int age, String ssn, String city, String id) {
      
        super(name, age, ssn, city);
          this.id = id;

    }

    @Override
    public void work() {
      
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", getName()=" + getName() + ", getAge()=" + getAge() + ", getSsn()=" + getSsn()
                + ", getCity()=" + getCity() + "]";
    }

    
    
}
