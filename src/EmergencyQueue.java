public class EmergencyQueue {

    Patient[] heap;
    int size;
    int capacity;

    public EmergencyQueue(int capacity) {

        this.capacity = capacity;
        heap = new Patient[capacity];
        size = 0;
    }


    boolean hasHigherPriority(Patient p1, Patient p2) {

        if (p1.priority != p2.priority) {
            return p1.priority < p2.priority;
        }

        return p1.arrivalTime < p2.arrivalTime;
    }

    // Add patient into Min Heap
    void addPatient(Patient patient) {

        if (size == capacity) {
            System.out.println("Emergency Queue is Full!");
            return;
        }

        heap[size] = patient;

        int current = size;
        size++;

        while (current > 0) {

            int parent = (current - 1) / 2;

            if (hasHigherPriority(heap[current], heap[parent])) {

                Patient temp = heap[current];
                heap[current] = heap[parent];
                heap[parent] = temp;

                current = parent;

            } else {
                break;
            }
        }

        System.out.println("Patient Added to Emergency Queue!");
    }

    // Remove patient with highest priority
    Patient treatNextPatient() {

        if (size == 0) {
            System.out.println("No Patients in Emergency Queue!");
            return null;
        }

        Patient treatedPatient = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        int current = 0;

        while (true) {

            int left = 2 * current + 1;
            int right = 2 * current + 2;
            int smallest = current;

            if (left < size &&
                    hasHigherPriority(heap[left], heap[smallest])) {

                smallest = left;
            }

            if (right < size &&
                    hasHigherPriority(heap[right], heap[smallest])) {

                smallest = right;
            }

            if (smallest != current) {

                Patient temp = heap[current];
                heap[current] = heap[smallest];
                heap[smallest] = temp;

                current = smallest;

            } else {
                break;
            }
        }

        return treatedPatient;
    }

    // Display emergency queue
    void displayQueue() {

        if (size == 0) {
            System.out.println("Emergency Queue is Empty!");
            return;
        }

        System.out.println("\n===== EMERGENCY QUEUE =====");

        for (int i = 0; i < size; i++) {

            heap[i].displayPatient();
        }
    }
    // Delete patient from Emergency Queue
    void deletePatient(int id) {

        int index = -1;

        // Find patient using ID
        for (int i = 0; i < size; i++) {

            if (heap[i].id == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return;
        }

        // Replace deleted patient with last patient
        heap[index] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        // Restore Min Heap property
        if (index < size) {

            if (index > 0 &&
                    hasHigherPriority(heap[index], heap[(index - 1) / 2])) {

                while (index > 0) {

                    int parent = (index - 1) / 2;

                    if (hasHigherPriority(heap[index], heap[parent])) {

                        Patient temp = heap[index];
                        heap[index] = heap[parent];
                        heap[parent] = temp;

                        index = parent;

                    } else {
                        break;
                    }
                }

            } else {

                while (true) {

                    int left = 2 * index + 1;
                    int right = 2 * index + 2;
                    int smallest = index;

                    if (left < size &&
                            hasHigherPriority(heap[left], heap[smallest])) {
                        smallest = left;
                    }

                    if (right < size &&
                            hasHigherPriority(heap[right], heap[smallest])) {
                        smallest = right;
                    }

                    if (smallest != index) {

                        Patient temp = heap[index];
                        heap[index] = heap[smallest];
                        heap[smallest] = temp;

                        index = smallest;

                    } else {
                        break;
                    }
                }
            }
        }
    }
}