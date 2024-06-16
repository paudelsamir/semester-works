#include <iostream>
#define MAX 5
using namespace  std;

class CircularQueue {
    int arr[MAX], front, rear;

public:
    CircularQueue() : front(-1), rear(-1) {}

    void enqueue(int element) {
        if ((rear + 1) % MAX == front)
            std::cout << "Queue Overflow" << std::endl;
        else {
            if (front == -1) front = 0;
            rear = (rear + 1) % MAX;
            arr[rear] = element;
            std::cout << element << " enqueued" << std::endl;
        }
    }

    void dequeue() {
        if (front == -1)
            std::cout << "Queue Underflow" << std::endl;
        else {
            std::cout << "Dequeued: " << arr[front] << std::endl;
            if (front == rear)
                front = rear = -1;
            else
                front = (front + 1) % MAX;
        }
    }

    void display() {
        if (front == -1)
            std::cout << "Queue is empty" << std::endl;
        else {
            std::cout << "Queue elements: ";
            int i = front;
            do {
                std::cout << arr[i] << " ";
                i = (i + 1) % MAX;
            } while (i != (rear + 1) % MAX);
            std::cout << std::endl;
        }
    }
};

int main() {
    CircularQueue q;
    int choice, value;

    while (true) {
        std::cout << "\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit\nEnter your choice: ";
        std::cin >> choice;

        switch (choice) {
            case 1:
                std::cout << "Enter value: ";
                std::cin >> value;
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
                std::cout << "Invalid choice" << std::endl;
        }
    }
}
