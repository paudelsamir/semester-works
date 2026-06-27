# ## **Chapter 9: SOFTWARE CONFIGURATION MANAGEMENT (SCM)**

---

### **1. INTRODUCTION TO SCM**

**What is Software Configuration Management?**

SCM is the discipline of **identifying, organizing, and controlling** changes to software products throughout the project lifecycle. It ensures that everyone works with the correct versions of all project artifacts and that changes are managed systematically.

**Think of SCM as the "librarian" of the project** — it knows where everything is, who changed what, when, and why.

**Key Goal**: Maintain the **integrity** and **traceability** of the software product as it evolves.

**What is a Configuration?**

The complete set of software products (code, documents, test data, manuals, etc.) at a specific point in time, along with their relationships.

---

### **2. NEED FOR SCM**

Why is SCM essential in a software project?

| **Problem SCM Solves** | **Explanation** |
| --- | --- |
| **Multiple developers changing the same code** | Without control, changes overwrite each other, causing lost work and bugs. |
| **Inability to revert to a stable version** | If a change breaks the system, you must be able to go back to the last working state. |
| **Confusion over which version is "current"** | Stakeholders need to know exactly which build is being tested, delivered, or deployed. |
| **Uncontrolled changes (scope creep)** | Changes made without authorization or impact analysis can derail the project. |
| **Parallel development (branching)** | Different versions (e.g., maintenance release vs. new feature development) must be managed simultaneously. |
| **Audit and accountability** | You need to know who made what change and why, for reviews and compliance. |

**Without SCM, a project can quickly descend into chaos** — duplicate effort, lost code, broken builds, and angry customers.

---

### **3. BASIC CONFIGURATION CONCEPTS**

**A. Configuration Item (CI)**

A CI is any work product that is placed under configuration control. Examples:

- Source code files
- Requirements specifications
- Design documents
- Test plans and test cases
- User manuals
- Build scripts and configuration files

**B. Baseline**

A baseline is a **formally reviewed and agreed-upon set of CIs** that serves as a fixed reference point for further development. Once baselined, changes can only be made through a formal change control process.

**Figure: Baselines through the lifecycle**
![Baselines Lifecycle](images/figure11-baselines-lifecycle.png)

text

```
Requirements ── Baseline 1 ── Design ── Baseline 2 ── Coding ── Baseline 3 ── Testing ── Baseline 4 (Release)
```

- **Baseline 1**: Requirements specification approved.
- **Baseline 2**: Design documents approved.
- **Baseline 3**: Code frozen for testing.
- **Baseline 4**: Final tested product released.

**C. Version vs. Revision vs. Release**

- **Version**: A specific instance of a CI at a given point in time (e.g., v1.0, v1.1).
- **Revision**: A minor change to a version (e.g., bug fix).
- **Release**: A version distributed to customers.

**D. Repository (or Library)**

A central database that stores all CIs and their change history. Developers "check out" items, modify them, and "check in" the updated versions. Tools: Git, SVN, etc.

**E. Branching and Merging**

- **Branch**: A separate line of development (e.g., a feature branch, a bug-fix branch).
- **Merge**: Combining changes from one branch back into another (e.g., merging a completed feature into the main line).

---

### **4. MANAGEMENT RESPONSIBILITIES IN SCM**

SCM involves four main activities that form a continuous cycle:

![SCM Configuration Management Cycle](images/figure19-scm-cycle.png)

**1. Configuration Identification**

- Define what CIs are under SCM.
- Establish naming conventions and version numbering schemes.
- Define baselines.
- Identify the structure of the product (e.g., using a Product Breakdown Structure).

**2. Configuration Control (Change Control)**

- Evaluate, approve, and track all changes to baselined CIs.
- Use a **Change Control Board (CCB)** to review change requests.
- A formal change request goes through:
    - Submission → Impact analysis → CCB decision (approve/reject/defer) → Implementation → Verification → Update records.

**3. Configuration Status Accounting**

- Record and report the current status of each CI (e.g., "checked out", "in review", "approved", "baselined").
- Provide traceability: who changed what, when, and why.
- Generate reports for management on the state of the configuration.

**4. Configuration Auditing**

- Verify that the actual configuration matches the documented configuration.
- Two types:
    - **Physical audit**: Does the actual product (code, docs) match the baseline specification?
    - **Functional audit**: Does the product meet the functional requirements defined in the baseline?
- Ensures that SCM processes are being followed correctly.