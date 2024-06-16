#include <iostream>
#define MAX 5
using namespace std;

class CircularQueue {
    int arr[MAX], front, rear;

public:
    CircularQueue() : front(-1), rear(-1) {}

    void enqueue(int element) {
        if ((rear + 1) % MAX == front)
            cout << "Queue Overflow" << endl;
        else {
            if (front == -1) front = 0;
            rear = (rear + 1) % MAX;
            arr[rear] = element;
            cout << element << " enqueued" << endl;
        }
    }

    void dequeue() {
        if (front == -1)
            cout << "Queue Underflow" << endl;
        else {
            cout << "Dequeued: " << arr[front] << endl;
            if (front == rear)
                front = rear = -1;
            else
                front = (front + 1) % MAX;
        }
    }

    void display() {
        if (front == -1)
            cout << "Queue is empty" << endl;
        else {
            cout << "Queue elements: ";
            int i = front;
            do {
                cout << arr[i] << " ";
                i = (i + 1) % MAX;
            } while (i != (rear + 1) % MAX);
            cout << endl;
        }
    }
};

int main() {
    CircularQueue q;
    int choice, value;

    while (true) {
        cout << "\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit\nEnter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter value: ";
                cin >> value;
                q.enqueue(value);
                break;
            case 2:
                q.dequeue();
                break;
            case 3:
                q.display();
                break;
            case 4:
                return 0;
            default:
                cout << "Invalid choice" << endl;
        }
    }
}
