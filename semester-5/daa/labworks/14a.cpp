#include <iostream>
#include <vector>
using namespace std;

int main() {
    int V, E;
    cout << "Enter number of vertices: ";
    cin >> V;
    cout << "Enter number of edges: ";
    cin >> E;

    vector<pair<int,int>> edges;
    cout << "Enter edges (u v):" << endl;
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        edges.push_back({u, v});
    }

    vector<bool> visited(V+1, false);
    vector<int> vertexCover;

    for (auto edge : edges) {
        int u = edge.first;
        int v = edge.second;
        if (!visited[u] && !visited[v]) {
            visited[u] = true;
            visited[v] = true;
            vertexCover.push_back(u);
            vertexCover.push_back(v);
        }
    }

    cout << "Approximate Minimum Vertex Cover: ";
    for (int v : vertexCover) cout << v << " ";
    cout << endl;

    cout << "\nLab No.: 14(a)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}