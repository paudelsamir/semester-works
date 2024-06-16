#include <iostream>
#define MAX 100
using namespace std;

class Stack {
private:
    int arr[MAX];
    int top = -1;

public:
    void push(int x) {
        if (top >= MAX - 1) cout << "Overflow\n";
        else arr[++top] = x;
    }

    int pop() {
        if (top < 0) {
            cout << "Underflow\n";
            return -1;
        }
        return arr[top--];
    }

    int peek() {
        if (top < 0) {
            cout << "Empty\n";
            return -1;
        }
        return arr[top];
    }

    bool isEmpty() {
        return top < 0;
    }

    void display() {
        if (top < 0) cout << "Empty\n";
        else {
            cout << "Elements: ";
            for (int i = 0; i <= top; i++)
                cout << arr[i] << " ";
            cout << "\n";
        }
    }
};

int main() {
    Stack s;
    int choice, value;
    while (true) {
        cout << "\n1.Push 2.Pop 3.Peek 4.Display 5.Exit\nChoice: ";
        cin >> choice;
        switch (choice) {
            case 1:
                cout << "Value: ";
                cin >> value;
                s.push(value);
                break;
            case 2:
                cout << "Popped: " << s.pop() << "\n";
                break;
            case 3:
                cout << "Top: " << s.peek() << "\n";
                break;
            case 4:
                s.display();
                break;
            case 5:
                return 0;
            default:
                cout << "Invalid\n";
        }
    }
}