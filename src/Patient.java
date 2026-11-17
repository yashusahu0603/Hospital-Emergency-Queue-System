public class Patient {

    int id;
    String name;
    int age;
    String disease;
    int priority;
    int arrivalTime;

    public Patient(int id, String name, int age, String disease, int priority, int arrivalTime) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    void displayPatient() {

        System.out.println("----------------------------");
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("Priority: " + priority);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("----------------------------");
    }
}