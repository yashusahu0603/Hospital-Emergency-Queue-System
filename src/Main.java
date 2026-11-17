import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hospital hospital = new Hospital();

        EmergencyQueue emergencyQueue = new EmergencyQueue(100);

        int patientId = 1;
        int arrivalTime = 1;

        int choice;

        System.out.println("======================================");
        System.out.println("     HOSPITAL EMERGENCY QUEUE SYSTEM");
        System.out.println("======================================");

        do {

            System.out.println("\n========== HOSPITAL MENU ==========");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. View Emergency Queue");
            System.out.println("4. Treat Next Patient");
            System.out.println("5. Search Patient");
            System.out.println("6. Delete Patient");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n===== ADD NEW PATIENT =====");

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Patient Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    System.out.println("\nPriority Levels:");
                    System.out.println("1. Critical");
                    System.out.println("2. Serious");
                    System.out.println("3. Moderate");
                    System.out.println("4. Normal");

                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();

                    if (age <= 0 || priority < 1 || priority > 4) {
                        System.out.println("Invalid Age or Priority!");
                        break;
                    }

                    Patient patient = new Patient(
                            patientId,
                            name,
                            age,
                            disease,
                            priority,
                            arrivalTime
                    );

                    hospital.addPatientRecord(patient);

                    emergencyQueue.addPatient(patient);

                    System.out.println("Patient ID: " + patientId);

                    patientId++;
                    arrivalTime++;

                    break;

                case 2:

                    hospital.displayAllPatients();

                    break;

                case 3:

                    emergencyQueue.displayQueue();

                    break;

                case 4:

                    Patient treated = emergencyQueue.treatNextPatient();

                    if (treated != null) {

                        System.out.println("\n===== PATIENT UNDER TREATMENT =====");

                        treated.displayPatient();
                    }

                    break;

                case 5:

                    System.out.print("Enter Patient ID to Search: ");

                    int searchId = sc.nextInt();

                    hospital.searchPatient(searchId);

                    break;

                case 6:

                    System.out.print("Enter Patient ID to Delete: ");

                    int deleteId = sc.nextInt();

                    hospital.deletePatient(deleteId);

                    emergencyQueue.deletePatient(deleteId);

                    break;

                case 7:

                    System.out.println("\nThank you for using Hospital Emergency Queue System!");

                    break;
            }

        } while (choice != 7);


    }
}