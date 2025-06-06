#include <iostream>
#include <queue>
#include <unordered_map>
using namespace std;

struct Node {
    char ch;
    int freq;
    Node* left;
    Node* right;

    Node(char c, int f) {
        ch = c;
        freq = f;
        left = right = nullptr;
    }

    Node(int f) {
        ch = '\0';
        freq = f;
        left = right = nullptr;
    }
};

struct Compare {
    bool operator()(Node* a, Node* b) {
        if (a->freq == b->freq) {
            return a->ch > b->ch;
        }
        return a->freq > b->freq;
    }
};

void generateCodes(Node* root, string code, unordered_map<char, string>& codes) {
    if (!root) return;

    if (root->ch != '\0') {
        codes[root->ch] = code.empty() ? "0" : code;
        return;
    }

    generateCodes(root->left, code + "0", codes);
    generateCodes(root->right, code + "1", codes);
}

void huffmanCoding(char chars[], int freq[], int n) {
    priority_queue<Node*, vector<Node*>, Compare> minHeap;

    for (int i = 0; i < n; i++) {
        minHeap.push(new Node(chars[i], freq[i]));
    }

    while (minHeap.size() > 1) {
        Node* left = minHeap.top();
        minHeap.pop();
        Node* right = minHeap.top();
        minHeap.pop();

        Node* merged = new Node(left->freq + right->freq);
        merged->left = left;
        merged->right = right;

        minHeap.push(merged);
    }

    Node* root = minHeap.top();
    unordered_map<char, string> codes;
    generateCodes(root, "", codes);

    cout << "\nHuffman Codes:" << endl;
    cout << "Character\tFrequency\tCode" << endl;

    int totalBits = 0;
    for (int i = 0; i < n; i++) {
        cout << chars[i] << "\t\t" << freq[i] << "\t\t" << codes[chars[i]] << endl;
        totalBits += freq[i] * codes[chars[i]].length();
    }

    cout << "\nTotal bits required: " << totalBits << endl;

    int originalBits = 0;
    for (int i = 0; i < n; i++) {
        originalBits += freq[i];
    }
    originalBits *= 8; // Assuming 8 bits per character

    cout << "Original bits (8-bit encoding): " << originalBits << endl;
    cout << "Compression ratio: " << (double)originalBits/totalBits << ":1" << endl;
}

int main() {
    int n;
    cout << "Enter number of characters: ";
    cin >> n;

    char* chars = new char[n];
    int* freq = new int[n];

    for (int i = 0; i < n; i++) {
        cout << "Character " << i + 1 << ": ";
        cin >> chars[i];
        cout << "Frequency of " << chars[i] << ": ";
        cin >> freq[i];
    }

    huffmanCoding(chars, freq, n);

    cout << "\nLab No. 6(c)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114079/D" << endl;

    delete[] chars;
    delete[] freq;
    return 0;
}
