#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Job {
    int id, deadline, profit;
};

bool compare(Job a, Job b) {
    return a.profit > b.profit;
}

int main() {
    int n;
    cout << "Enter number of jobs: ";
    cin >> n;
    vector<Job> jobs(n);

    for (int i = 0; i < n; i++) {
        cout << "Enter job ID, deadline and profit for job " << i + 1 << ": ";
        cin >> jobs[i].id >> jobs[i].deadline >> jobs[i].profit;
    }

    sort(jobs.begin(), jobs.end(), compare);

    int maxDeadline = 0;
    for (auto job : jobs)
        if (job.deadline > maxDeadline)
            maxDeadline = job.deadline;

    vector<int> slot(maxDeadline + 1, -1);
    int totalProfit = 0;

    for (auto job : jobs) {
        for (int t = job.deadline; t > 0; t--) {
            if (slot[t] == -1) {
                slot[t] = job.id;
                totalProfit += job.profit;
                break;
            }
        }
    }

    cout << "Selected Jobs: ";
    for (int i = 1; i <= maxDeadline; i++) {
        if (slot[i] != -1)
            cout << "J" << slot[i] << " ";
    }
    cout << "\nTotal Profit: " << totalProfit << endl;

    cout << "\nLab No.: 6(b)" << endl;
    cout << "Name: Samir Paudel" << endl;
    cout << "Roll No./Section: 114-079/D" << endl;

    return 0;
}
