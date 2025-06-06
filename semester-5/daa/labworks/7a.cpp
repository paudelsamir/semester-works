
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge {
    int u, v, weight;
};

bool compare(Edge a, Edge b) {
    return a.weight < b.weight;
}

int findParent(int u, vector<int>& parent) {
    if (parent[u] == u)
        return u;
    return parent[u] = findParent(parent[u], parent);
}

void unionSet(int u, int v, vector<int>& parent) {
    int pu = findParent(u, parent);
    int pv = findParent(v, parent);
    parent[pu] = pv;
}

int main() {
    int V, E;
    cout << "Enter number of vertices and edges: ";
    cin >> V >> E;

    vector<Edge> edges(E);
    for (int i = 0; i < E; i++) {
        cout << "Enter edge (u v weight): ";
        cin >> edges[i].u >> edges[i].v >> edges[i].weight;
    }

    sort(edges.begin(), edges.end(), compare);
    vector<int> parent(V);
    for (int i = 0; i < V; i++)
        parent[i] = i;

    vector<Edge> mst;
    int totalWeight = 0;

    for (Edge e : edges) {
        if (findParent(e.u, parent) != findParent(e.v, parent)) {
            mst.push_back(e);
            totalWeight += e.weight;
            unionSet(e.u, e.v, parent);
        }
    }

    cout << "\nMinimum Spanning Tree edges:\n";
    for (Edge e : mst)
        cout << e.u << " - " << e.v << " : " << e.weight << endl;

    cout << "Total Weight of MST: " << totalWeight << endl;

    cout << "\nLab No.: 7(a)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}

