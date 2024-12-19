#include <iostream>
#include <string>

class Job {
private:
    std::string company;
    std::string position;
    double salary;
    std::string location;

public:
    Job(const std::string& comp, const std::string& pos, double sal, const std::string& loc)
        : company(comp), position(pos), salary(sal), location(loc) {}

    void display() const {
        std::cout << "Job Information:" << std::endl;
        std::cout << "Company: " << company << std::endl;
        std::cout << "Position: " << position << std::endl;
        std::cout << "Salary: " << salary << " lakhs per month" << std::endl;
        std::cout << "Location: " << location << std::endl;
    }
};

class Person {
private:
    std::string name;
    std::string birthDate;
    int height;
    double weight;
    std::string location;
    Job* job;

public:
    Person(const std::string& n, const std::string& bd, int h, double w, const std::string& loc)
        : name(n), birthDate(bd), height(h), weight(w), location(loc), job(nullptr) {}

    ~Person() {
        delete job;
    }

    void setJob(const std::string& comp, const std::string& pos, double sal, const std::string& loc) {
        job = new Job(comp, pos, sal, loc);
    }

    void display() const {
        std::cout << "Person Information:" << std::endl;
        std::cout << "Name: " << name << std::endl;
        std::cout << "Birth Date: " << birthDate << std::endl;
        std::cout << "Height: " << height << " inches" << std::endl;
        std::cout << "Weight: " << weight << " kg" << std::endl;
        std::cout << "Location: " << location << std::endl;
        
        if (job) {
            std::cout << std::endl;
            job->display();
        }
    }
};

int main() {
    Person ram("Ram", "15th December 1990", 6, 75, "Nepal");
    ram.setJob("ABC company", "AI Researcher", 1.5, "Kathmandu");
    
    ram.display();

    return 0;
}