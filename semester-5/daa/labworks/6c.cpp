#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>
using namespace std;

struct Node {
    char ch;
    int freq;
    Node *left, *right;
    Node(char c, int f) : ch(c), freq(f), left(nullptr), right(nullptr) {}
};

struct Compare {
    bool operator()(Node* l, Node* r) {
        return l->freq > r->freq;
    }
};

void generateCodes(Node* root, string code, unordered_map<char, string> &codes) {
    if (!root) return;
    if (!root->left && !root->right) {
        codes[root->ch] = code;
    }
    generateCodes(root->left, code + "0", codes);
    generateCodes(root->right, code + "1", codes);
}

int main() {
    int n;
    cout << "Enter number of characters: ";
    cin >> n;

    vector<char> chars(n);
    vector<int> freq(n);
    cout << "Enter characters and their frequencies:\n";
    for (int i = 0; i < n; i++) {
        cin >> chars[i] >> freq[i];
    }

    priority_queue<Node*, vector<Node*>, Compare> pq;
    for (int i = 0; i < n; i++) {
        pq.push(new Node(chars[i], freq[i]));
    }

    while (pq.size() > 1) {
        Node* left = pq.top(); pq.pop();
        Node* right = pq.top(); pq.pop();

        Node* parent = new Node('\0', left->freq + right->freq);
        parent->left = left;
        parent->right = right;
        pq.push(parent);
    }

    Node* root = pq.top();

    unordered_map<char, string> codes;
    generateCodes(root, "", codes);

    cout << "\nHuffman Codes:\n";
    for (auto &p : codes) {
        cout << p.first << ": " << p.second << endl;
    }

    int totalBits = 0;
    for (int i = 0; i < n; i++) {
        totalBits += freq[i] * codes[chars[i]].length();
    }
    cout << "Total bits required to compress the file: " << totalBits << endl;

    cout << "\nLab No.: 6(c)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}
