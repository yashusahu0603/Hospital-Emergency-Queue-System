public class Hospital {


    class Node {

        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    Node head;


    void addPatientRecord(Patient patient) {

        Node newNode = new Node(patient);

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Patient Record Saved Successfully!");
    }


    void displayAllPatients() {

        if (head == null) {
            System.out.println("No Patient Records Found!");
            return;
        }

        Node temp = head;

        System.out.println("\n===== ALL PATIENT RECORDS =====");

        while (temp != null) {

            temp.patient.displayPatient();

            temp = temp.next;
        }
    }


    void searchPatient(int id) {

        Node temp = head;

        while (temp != null) {

            if (temp.patient.id == id) {

                System.out.println("Patient Found!");
                temp.patient.displayPatient();
                return;
            }

            temp = temp.next;
        }

        System.out.println("Patient Not Found!");
    }
    // Delete patient from Linked List
    void deletePatient(int id) {

        if (head == null) {
            System.out.println("No Patient Records Found!");
            return;
        }

        if (head.patient.id == id) {

            head = head.next;

            System.out.println("Patient Record Deleted Successfully!");
            return;
        }

        Node temp = head;

        while (temp.next != null) {

            if (temp.next.patient.id == id) {

                temp.next = temp.next.next;

                System.out.println("Patient Record Deleted Successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Patient Not Found!");
    }
}