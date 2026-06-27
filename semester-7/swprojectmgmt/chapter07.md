# ## **Chapter 7: MANAGING CONTRACTS AND PEOPLE**

---

### **PART A – MANAGING CONTRACTS**

---

### **1. Introduction**

Projects often acquire software from external suppliers. The software could be:

- **Tailored system** – built specially for the customer
- **Off‑the‑shelf** – bought ‘as is’
- **Customised off‑the‑shelf (COTS)** – core system is modified to fit customer needs

A contract legally binds both parties. The project manager must ensure the contract reflects the true requirements and expectations.

---

### **2. Types of Contract**

| **Contract Type** | **Meaning** | **Advantages for Customer** | **Disadvantages** |
| --- | --- | --- | --- |
| **Fixed Price** | A single agreed price for the whole job. | Known expenditure; supplier motivated to be cost‑effective. | Supplier builds in contingency → price may be higher; difficult to change requirements; threat to quality. |
| **Time and Materials** | Customer pays for actual effort at agreed rates. | Easy to change requirements; lack of price pressure can improve quality. | Customer absorbs all risk of poorly defined/ changing requirements; no supplier incentive to be cost‑effective. |
| **Fixed Price per Delivered Unit** | Price is set per measurable unit (e.g., per function point, per screen). | Transparent pricing; comparability; supplier still has cost‑effectiveness incentive. | Difficulty in measuring software size; handling changed vs. new requirements can be messy. |

> Note: Often a **licence to use** software is bought, not the software itself.
> 

---

### **3. Stages in Contract Placement**

The tendering process moves through a sequence:

**Figure: Contract Placement Flow**
![Contract Placement Flow](images/figure10-contract-placement-flow.svg)

text

```
Requirements Analysis → Invitation to Tender (ITT) → Evaluation of Proposals → Contract Award
```

- **Requirements document** must clearly specify:
    - Functions, inputs/outputs, standards, compatibility, quality needs (e.g., response times)
    - Mandatory vs. desirable features
    - Deadlines
- **Tendering approaches**:
    - **Open tendering** – any supplier can bid; all evaluated equally
    - **Restricted tendering** – only invited suppliers can bid; shortlist reduces as stages progress
    - **Negotiated procedure** – negotiate with one supplier (e.g., for extension of existing software)
- **Evaluation plan** is prepared beforehand to assess proposals objectively: reading proposals, interviews, demonstrations, site visits, practical tests. Focus is on **value for money (VFM)** – not just lowest price.
- **Memoranda of Agreement (MoA)** may be used: customer first requests technical proposals → agree on technical solution in MoA → then request priced tenders based on that MoA. This separates technical and commercial evaluation.

---

### **4. Typical Terms of a Contract (Contract Checklist)**

| **Term** | **What it covers** |
| --- | --- |
| **Definitions** | Precise meaning of words like ‘supplier’, ‘user’, ‘application’. |
| **Form of agreement** | Is it a sale, lease, or licence? Can licence be transferred? |
| **Goods and services** | Detailed specification of what is to be supplied. |
| **Timetable of activities** | Delivery milestones and dates. |
| **Payment arrangements** | Payments tied to completion of specific tasks/milestones. |
| **Ownership of software** | Can client sell to others? Does supplier retain copyright? Escrow – source code deposited with third party in case supplier fails. |
| **Environment** | Where equipment is installed, site preparation, electricity, etc. |
| **Customer commitments** | Access, information, staff time that the customer must provide. |
| **Standards to be met** | Quality standards, documentation standards, etc. |
| **Acceptance criteria** | How the customer will test and formally accept the deliverables. |

---

### **5. Contract Management**

Ongoing management of the contract ensures both sides meet obligations. Key aspects:

- **Progress reporting** – regular status reports from supplier
- **Decision points** – linked to payments or phase approvals
- **Variations (changes)** – how changes to requirements are handled (formal change control)
- **Quality reviews** – joint review meetings
- **Acceptance** – final sign‑off procedure, often after successful acceptance testing

---

### **PART B – MANAGING PEOPLE AND ORGANIZING TEAMS**

---

### **1. Introduction**

People are an organisation’s most important asset. A manager’s activities around people include:

- Problem solving, motivating, planning, estimating, controlling, organising.

---

### **2. Understanding Behaviour – Organisational Behaviour Background**

**A. Human Needs Hierarchy (Maslow)**
![Maslow Hierarchy Pyramid](images/figure13-maslow-hierarchy-pyramid.png)

text

```
      Self-
   Realization
  Esteem Needs
 Social Needs
Safety Needs
Physiological Needs
```

- People are motivated by unmet needs. Lower‑level needs (pay, safety) must be satisfied before higher‑level ones (esteem, growth) become motivating.

**B. Personality Types** – Three orientations that affect motivation:

- **Task‑oriented** – motivated by the work itself; loves the challenge.
- **Self‑oriented** – works to achieve personal goals (money, status, recognition).
- **Interaction‑oriented** – motivated by being around colleagues; social workplace is key.

A balanced team needs a mix of all three. An all‑task team may lack collaboration; an all‑self team may have power struggles; an all‑interaction team may chat more than work.

---

### **3. Selecting the Right Person for the Job**

Selection is based on:

- **CV/Resume** – experience, education, skills
- **Interview** – personal interaction, attitude, communication
- **References** – past performance
- Sometimes **psychological/aptitude tests** (usefulness debated)

**Key Staff Selection Factors** (simplified from the table):

| **Factor** | **Importance** |
| --- | --- |
| **Application domain experience** | Critical – developers must understand the business area. |
| **Communication ability** | Very important – must interact with team, managers, customers. |
| **Adaptability / Attitude** | Indicates ability to learn and positive approach. |
| **Programming language/ Platform experience** | Relevant mainly for short‑duration projects where there’s no time to learn. |
| **Educational background** | Shows fundamentals and learning ability; becomes less important with experience. |
| **Personality** | Must be compatible with team; no single type is “best”. |

---

### **4. Instruction in the Best Methods**

This refers to ensuring that staff are trained in and follow **the most effective work methods**. In practice it means:

- Defining standard development processes (e.g., coding standards, review procedures)
- Providing training and mentoring so team members know *how* to do their tasks correctly
- Using frameworks like the **People Capability Maturity Model (PCMM)** to systematically improve workforce skills.

**PCMM (5 levels)** – a roadmap for improving people management:

1. **Initial** – ad‑hoc people practices
2. **Repeatable** – basic policies for skill development
3. **Defined** – standardised people management across the organisation
4. **Managed** – quantitative goals for people competencies
5. **Optimising** – continuous improvement of individual competence and motivation

---

### **5. Motivation**

A manager must actively motivate the team. Key motivators are linked to:

- **Basic needs** (salary, job security)
- **Personal needs** (respect, recognition, growth)
- **Social needs** (belonging, teamwork)

**Practical ways to motivate**:

- Set clear, achievable targets
- Involve people in decision‑making
- Recognize and reward good work
- Provide opportunities to learn and advance

---

### **6. Working in Groups → Becoming a Team**

Most software work is group‑based. Group effectiveness depends on:

**A. Group Composition**

- Avoid groups where all members share the same personality type.
- An effective group balances task‑oriented, self‑oriented, and interaction‑oriented people.

**B. Group Cohesiveness**

- A cohesive group values the group above individuals.
- Benefits: shared quality standards, reduced fear of asking questions, learning from each other, egoless programming (constructive peer reviews).

**C. Group Communications**

- Good communication is essential for sharing design decisions and status.
- Factors that affect communication:
    - **Status differences** – higher‑status members may dominate; must encourage open exchange.
    - **Gender mix** – mixed‑sex groups tend to communicate better.
    - **Channels** – avoid channelling all communication through a central person; encourage direct communication.

**D. Team Formation – Becoming a Team**

Teams evolve through stages (Tuckman’s model – you can mention for context):

- Forming → Storming → Norming → Performing.
- The goal is to reach **Performing**, where the team works smoothly with high trust and productivity.

---

### **7. Decision Making**

In a project environment, decisions are needed constantly – technical choices, priority calls, risk responses.

**Decision‑making approaches**:

- **Autocratic** – manager decides alone; fast but may miss input.
- **Consultative** – manager gathers input, then decides; balances speed and participation.
- **Consensus** – the group discusses until everyone agrees; high buy‑in but time‑consuming.
- **Delegated** – decision is pushed to the expert or sub‑team; good for technical matters.

**Factors influencing choice**: urgency, importance, team expertise, and impact on motivation. Involving the team in decisions that affect them improves commitment.

---

### **8. Leadership**

Leadership is based on **respect, not just title**. On a software project, two leadership roles often emerge:

| **Role** | **Responsibility** |
| --- | --- |
| **Technical leader** | Guides architecture, design, coding standards; earns respect through competence. |
| **Managerial leader** | Handles planning, resources, communication with stakeholders. |

A healthy organisation supports a **career path for technical competence**, so good engineers don’t have to become managers to advance.

Good leaders:

- Communicate a clear vision
- Empower team members
- Remove obstacles
- Act with integrity

---

### **9. Organizational Structures**

How project teams and authority are arranged.

**A. Team Structures** (from lecture notes)

- **Small informal teams** (< 8 members) – democratic, everyone contributes; suitable for small projects.
- **Chief programmer team** – a highly skilled chief programmer designs and codes the critical parts; supported by specialists (librarian, tester). Works well for technically complex projects.
- **Break large projects** into multiple small teams, each responsible for a subsystem.

**B. Broader Organizational Structures** (briefly added for completeness)

- **Functional** – staff grouped by speciality (development, testing, design). Project manager borrows members.
- **Project‑based** – dedicated team assigned full‑time to the project; project manager has full authority.
- **Matrix** – staff report to both a functional manager and a project manager. Balances resource utilisation and project focus, but can cause dual‑command conflicts.

---

