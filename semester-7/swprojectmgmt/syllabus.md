# Software Project Management — Revision Notes

## Unit 1: Introduction to Software Project Management

<details><summary>Definition</summary>

The study of planning, organizing, directing, and controlling software projects to achieve objectives within time, cost, and quality constraints.
</details>

<details><summary>Software Engineering Problem</summary>

Four core difficulties make software unique:
- **Invisibility** — progress/structure cant be seen
- **Complexity** — infinite logical paths per unit cost
- **Conformity** — must fit changing human rules/laws
- **Flexibility** — easy to change → scope creep
</details>

<details><summary>Software Product Attributes</summary>

**Core qualities (PRooFS):**
- **P**erformance — speed & responsiveness
- **R**eliability — consistent operation
- **F**unctionality — meets required features
- **S**ecurity — protects data & access
- **R** — (Usability — ease of use)

**Architectural qualities (SMR):**
- **S**calability — handles growth
- **M**aintainability — easy to modify
- **R**eusability — components reusable

**Operational qualities (AIF):**
- **A**vailability — uptime & accessibility
- **I**nteroperability — works with other systems
- **F**lexibility — adapts to change
</details>

<details><summary>Definition of SP</summary>

Non-routine, specific objectives, fixed time, for a client, multiple specialisms, phased, constrained resources, large/complex

**Software Project:** Whole lifecycle from early investigation → implementation → maintenance (code + docs + training)
</details>

<details><summary>SP vs Physical Projects</summary>

| Aspect | Physical (bridge) | Software (HMS) |
|---|---|---|
| Invisibility | Progress visible (pillars rising) | Cannot see completion |
| Complexity | Fixed physical laws | Infinite logical paths |
| Conformity | Stable building codes | Changing rules/laws |
| Flexibility | Expensive to change | Easy → frequent changes |
</details>

<details><summary>Activities Covered by SPM — Feasibility + Planning + Execution</summary>

**Feasibility — TOESLiP:**
- **T**echnical — hardware/software available?
- **O**perational — will users accept?
- **E**conomical — benefits > costs?
- **S**chedule — in time?
- **L**egal — data protection, licenses?

**Planning:** Outline for whole project; detailed only for next stage (rolling wave)

**Execution:**
- **Design** → UI, architecture, database
- **Implementation** → coding, integration
- **Maintenance:** Corrective (bugs), Adaptive (new platforms), Perfective (new features)
</details>

<details><summary>Categorising SPs</summary>

**By user type:** Compulsory (mandatory use) vs Voluntary (optional use)

**By system type:** Info System (org interface) vs Embedded (machine interface) vs Real-time vs Web/Mobile

**By aim:** Objectives-Driven (goal, alternative solutions allowed) vs Product-Driven (exact specified product)

**By sourcing:** In-house (built by own team) vs Outsourced (external vendor)
</details>

<details><summary>Project Management Cycle — POSD-CMCP</summary>

- **P**lan — decide what to do
- **O**rganise — make arrangements
- **S**taff — select right people
- **D**irect — lead & instruct
- **C**oordinate — integrate efforts
- **M**onitor — check progress
- **C**ontrol — correct deviations
- **P**resent — report to stakeholders
</details>

<details><summary>SPM Framework — 3 Sections</summary>

**1. Tools & Techniques:**
- PERT/CPM, Gantt charts, EVA, Risk analysis, WBS

**2. Knowledge Areas:**
- Project Analysis, Activity Planning & Scheduling, Resource Allocation, Monitoring & Control

**3. Support Factors:**
- Risk Management, Contracts & People, QA & Testing, SCM
</details>

<details><summary>SPM Framework — 10 Steps</summary>

1. Identify project scope & objectives
2. Identify stakeholders
3. Identify project deliverables
4. Plan project activities (WBS)
5. Estimate effort & duration (CPM/PERT)
6. Allocate resources
7. Execute & monitor progress
8. Manage risks
9. Control changes
10. Close project & review
</details>

<details><summary>Project Control Cycle</summary>

START → Publish Initial Plan → Monitor/Gather Info → Compare Progress vs Target

**Satisfactory?**
- **No** → Corrective Action → Publish Revised Plan → back to Monitor
- **Yes** → **Project Complete?**
  - **No** → back to Monitor
  - **Yes** → Review & End

**Memory:** Measure → Compare → Decide → Act → Repeat
</details>

<details><summary>Types of Project Plan</summary>

**Specialized function plans (Ch4-8):**
- Quality Plan — standards, reviews, tests
- Validation Plan — testing & acceptance
- Configuration Mgmt Plan — version control, change control
- Maintenance Plan — post-delivery effort/cost
- Staff Development Plan — team skill improvement

**By management level:**
- **Strategic** (top mgmt, long-term)
- **Tactical** (middle mgmt, mid-term)
- **Operational** (lower mgmt, short-term/daily)
</details>

---

## Unit 2: Project Analysis

<details><summary>Definition</summary>

The process of evaluating whether a software project is feasible, beneficial, and worth undertaking.
</details>

<details><summary>Introduction</summary>

"Is this project worth doing?" → Strategic + Technical + Economic assessments
</details>

<details><summary>Strategic Assessment</summary>

- Supports business strategy?
- Competitive advantage?
- Right time?
- What if we don't do it?
</details>

<details><summary>Technical Assessment — HSSIO</summary>

- **H**ardware — servers, network, devices
- **S**oftware — dev tools, databases, licenses
- **S**kills — team expertise
- **I**nfrastructure — existing IT environment
- **O**perational fit — can org use & maintain?
</details>

<details><summary>Economic Analysis — Symbols</summary>

**P**=Present, **F**=Future, **A**=Annual (equal recurring), **G**=Gradient (constant increase), **i**=interest rate, **n**=periods

**Core concept:** Money today > money tomorrow (can earn interest)
</details>

<details><summary>PW Analysis</summary>

**Formulas:**
- Single: `P = F(1+i)^(-n)`
- Annuity: `P = A × [(1+i)^n - 1] / [i(1+i)^n]`

**Rule:** NPW > 0 → Accept. Choose highest positive NPW.
</details>

<details><summary>FW Analysis</summary>

**Formulas:**
- Single: `F = P(1+i)^n`
- Annuity: `F = A × [(1+i)^n - 1] / i`

**Rule:** FW benefits > FW costs → Accept
</details>

<details><summary>AW Analysis</summary>

**Formulas:**
- P → A: `A = P × [i(1+i)^n] / [(1+i)^n - 1]`
- F → A: `A = F × i / [(1+i)^n - 1]`

**Rule:** Net AW > 0 → Accept. **Best for unequal lives.**
</details>

<details><summary>IRR Method</summary>

**Formula:** `IRR = i₁ + [NPW₁/(NPW₁ - NPW₂)] × (i₂ - i₁)`

Where: i₁=lower rate(+NPW), i₂=higher rate(-NPW)

**Rule:** IRR > MARR → Accept
</details>

<details><summary>BCR Analysis</summary>

**Formula:** `BCR = PW(Benefits) / PW(Costs)` or `Eq Annual Benefits / Eq Annual Costs`

**Rule:** BCR > 1 → Accept. BCR = 1 → Break even.
</details>

<details><summary>Uniform Gradient Cash Flow</summary>

For costs increasing by constant **G** each year. Split into **Base annuity + Gradient part**.

**Formulas:**
- G → P: `P = G × [(1+i)^n - i×n - 1] / [i²(1+i)^n]`
- G → A: `A = G × [1/i - n/((1+i)^n - 1)]`
</details>

<details><summary>Mutually Exclusive Alternatives</summary>

| Method | Best For | Watch Out |
|---|---|---|
| **NPW** | Same lifetimes | Use LCM or AW if lives differ |
| **AW** | Different lives | Cleanest — no LCM needed |
| **Incremental IRR** | When IRRs differ | Never rank by IRR alone |
| **BCR** | Ratio | Tiny project can have huge BCR |

**Incremental IRR steps:**
1. Order by initial cost (low → high)
2. Compute IRR of cheaper; if > MARR, its the baseline
3. Incremental cash flows = Costlier − Cheaper
4. If Incremental IRR > MARR → choose costlier
</details>

---

## Unit 3: Activity Planning and Scheduling

<details><summary>Definition</summary>

The process of breaking a project into activities and arranging them in a logical sequence with timelines.
</details>

<details><summary>Objectives — FRDMC</summary>

- **F**easibility — possible within time/resources?
- **R**esource allocation — what/when needed?
- **D**etailed costing — how much/when spent?
- **M**otivation — clear targets motivate team
- **C**o-ordination — team availability timing
</details>

<details><summary>WBS — Work Breakdown Structure</summary>

Hierarchical decomposition into work packages (assignable to one person/team). IBM's 5 levels.

**Why essential:** Identifies all activities, helps estimate effort, assign responsibility, foundation for schedule
</details>

<details><summary>Gantt Chart</summary>

Activities ↓, time →, bars show start/end

**Pros:** Easy, shows start/end/duration
**Cons:** No dependencies, no critical path
</details>

<details><summary>Network Models — CPM, PERT, PDM</summary>

| Model | Key Characteristic |
|---|---|
| **CPM** | Deterministic — known single durations |
| **PERT** | Probabilistic — 3 estimates (O, M, P) |
| **PDM** | Activity-on-Node, 4 dependency types + lags |
</details>

<details><summary>CPM — ES, EF, LS, LF, Float</summary>

**Forward pass:** EF = ES + D, ES(successor) = max(EF predecessors)
**Backward pass:** LS = LF - D, LF(predecessor) = min(LS successors)
**Float** = LS - ES
**Critical Path** = activities with Float = 0

**Steps:** List activities → Draw network → Forward pass → Backward pass → Compute float → Find critical path
</details>

<details><summary>PERT — O, M, P, TE, σ², Z</summary>

- **TE** = (O + 4M + P)/6
- **σ²** = [(P - O)/6]²
- **Z** = (T - TE_project) / σ_project
- Z=0 → 50%, Z=1 → 84%, Z=-1 → 16%

**Use:** R&D, high uncertainty projects
</details>

<details><summary>PDM — FS, SS, FF, SF</summary>

- **FS** = Finish-to-Start (standard CPM)
- **SS** = Start-to-Start (with lag)
- **FF** = Finish-to-Finish (with lag)
- **SF** = Start-to-Finish (rare)
- **+Lag** = delay, **-Lag** = lead/overlap
</details>

<details><summary>Identifying Critical Activities</summary>

Activities where Float = 0. Any delay delays whole project. Focus management attention here.
</details>

<details><summary>Shortening Project Duration</summary>

**Crashing:** Add resources to critical activities → cost ↑, time ↓
**Fast-tracking:** Overlap sequential tasks → risk ↑, time ↓

**Process:** Identify critical path → find crashable/overlappable activities → pick best option → update network
</details>

---

## Unit 4: Risk Management

<details><summary>Definition</summary>

The process of identifying, analyzing, and controlling risks that may affect a software project.
</details>

<details><summary>Nature of Risk</summary>

- **Risk** (predictable prob/impact) vs **Uncertainty** (cannot guess)
- **Negative** (threats) vs **Positive** (opportunities)
- **Known** (identified) vs **Unknown** (emerge)
- **Business** (org benefit) vs **Project** (delivery)
- **Common SW risks:** Personnel, tech, requirements, estimation, organisational
</details>

<details><summary>Risk Identification — BISADC</summary>

- **B**rainstorming, **I**nterviews, **S**WOT
- **A**ssumption Analysis, **D**iagramming (fishbone), **C**hecklists

**Risk Register:** Description, probability, impact, owner, planned response
</details>

<details><summary>Risk Analysis</summary>

**Qualitative:** P × I Matrix → Critical / High / Medium / Low

| | Low Impact | Medium | High |
|---|---|---|---|
| **High Prob** | Medium | **High** | **Critical** |
| **Medium** | Low | Medium | High |
| **Low** | Very Low | Low | Medium |

**Quantitative:** `EMV = Probability × Impact Cost`
</details>

<details><summary>Schedule Risk (Z-values)</summary>

Uses PERT on critical path:
1. TE & σ² per critical activity
2. Project TE = sum, Project var = sum of σ²
3. `Z = (T - TE) / σ` → normal table

Turns schedule uncertainty into numeric risk probability
</details>

---

## Unit 5: Resource Allocation

<details><summary>Definition</summary>

The process of assigning available resources efficiently to project activities.
</details>

<details><summary>Resources — PEMF</summary>

- **P**eople, **E**quipment, **M**aterials, **F**acilities

**Per activity:** Work amount, skill level, complexity, task category, timing
</details>

<details><summary>Allocation — 3 Schedules</summary>

**Activity Schedule** (start/finish), **Resource Schedule** (who when), **Cost Schedule** (expenditure)

**Burman's Priority:**
1. Shortest critical → Other critical → Shortest non-critical → Least float non-critical → Remaining

**Note:** Allocation can change critical path (resource-constrained critical path)
</details>

<details><summary>Smoothing vs Balancing</summary>

| | Smoothing | Balancing |
|---|---|---|
| Uses float | Only within | May exceed |
| End date | Unchanged | May extend |
| Goal | Flatten peaks | Stay within limit |
| When | Resources flexible | Resources fixed |
</details>

<details><summary>Cost Categories</summary>

- **Staff costs** — salaries, benefits, pension
- **Overheads** — office, insurance, travel
- **Usage charges** — contractors, leased equipment
</details>

---

## Unit 6: Monitoring and Control

<details><summary>Definition</summary>

The process of tracking project performance and taking corrective actions to keep the project on schedule and within budget.
</details>

<details><summary>Introduction</summary>

**Cycle:** Measure → Compare → Decide → Act → Repeat

**Checkpoints:** Regular (monthly) and Event-driven (on deliverable completion)
</details>

<details><summary>Data Collection — WPPT</summary>

- **W**eekly timesheets — hours per activity
- **P**rogress meetings — what done/what next
- **P**artial completion — count completed sub-products
- **T**raffic Light (RAG) — Green/Amber/Red status

**RAG steps:** Identify key elements → break into sub-elements → assess G/A/R → overall assessment

**Monitor priority:** Critical path, zero-float, high-risk, scarce resource activities
</details>

<details><summary>Visualizing Progress</summary>

- **Gantt (Updated):** Original bars + actual progress + "today" marker
- **Slip Chart:** Bars bend right = slipping. More bend = more variance
- **Ball Chart:** Circle = original/revised date + colour status
</details>

<details><summary>Cost Monitoring</summary>

- Record actual expenditure vs planned cumulative cost curve (baseline)
- **Components:** Staff costs, Overheads, Usage charges
- **Cost monitoring alone is not enough** → need EVA
</details>

<details><summary>EVA — 3 Core Metrics</summary>

| Metric | Meaning |
|---|---|
| **PV** | Budgeted cost of work **planned** by now |
| **EV** | Budgeted cost of work **actually completed** (% × BAC) |
| **AC** | Money **actually spent** |
</details>

<details><summary>EVA — Variances, Indices, Forecasts</summary>

- **SV** = EV - PV (+ ahead, - behind)
- **CV** = EV - AC (+ under, - over)
- **SPI** = EV/PV (>1 ahead, <1 behind)
- **CPI** = EV/AC (>1 under, <1 over)
- **EAC** = BAC/CPI (forecast final cost)
- **ETC** = EAC - AC (money still needed)
- **TCPI** = (BAC - EV)/(BAC - AC) (efficiency needed)
</details>

<details><summary>Project Control</summary>

**Shortening Critical Path:** Crashing (cost↑ time↓), Fast-tracking (risk↑ time↓)
**Reconsider precedence:** Relax FS constraints

**Change Control — SRIC:**
1. **S**ubmit → 2. **R**eview impact → 3. **I**mplement if approved → 4. **C**ommunicate

**Key:** No change without formal approval & impact analysis
</details>

---

## Unit 7: Managing Contracts and People

<details><summary>Definition</summary>

The process of managing contractual agreements and leading project team members effectively.
</details>

### Part A — Contracts

<details><summary>Introduction</summary>

A contract legally binds both parties. PM must ensure contract reflects true requirements.
</details>

<details><summary>Contract Types — by Deliverables</summary>

- **Tailored system** — built specially for customer
- **Off-the-shelf** — bought as-is
- **COTS** (Customized Off-The-Shelf) — core system modified to fit needs
</details>

<details><summary>Contract Types — by Payment (FTF)</summary>

| Type | Customer Risk | Change Ease |
|---|---|---|
| **F**ixed Price | Low (supplier bears) | Hard |
| **T**ime & Materials | High (customer bears) | Easy |
| **F**ixed Price per Unit | Medium (balanced) | Medium |
</details>

<details><summary>Contract Placement — R-I-E-A</summary>

**Requirements → ITT → Evaluation → Award**

**Tendering:** Open (anyone), Restricted (invited), Negotiated (one supplier)

**Evaluation:** Value for money (VFM), not just lowest price

**MoA:** Technical proposal agreed first → then priced tender
</details>

<details><summary>Contract Terms — CONTRACT</summary>

- **C** — Customer commitments
- **O** — Ownership & escrow
- **N** — Non-disclosure / Notice
- **T** — Terminologies / Definitions
- **R** — Responsibility / Resource
- **A** — Acceptance criteria
- **C** — Contract form of agreement
- **T** — Termination / Testing
</details>

<details><summary>Contract Management</summary>

Progress reporting, Decision points, Variations (change control), Quality reviews, Acceptance sign-off
</details>

### Part B — People

<details><summary>Understanding Behaviour (OB Background)</summary>

Organisational behaviour studies how individuals & groups act in organisations. Helps managers predict, understand, and influence behaviour.
</details>

<details><summary>Personality — TSI</summary>

- **T**ask-oriented — motivated by work
- **S**elf-oriented — motivated by personal goals
- **I**nteraction-oriented — motivated by social environment
- *Need mix of all three in a team*
</details>

<details><summary>Selecting the Right Person — Key Factors</summary>

**Sources:** CV/Resume, Interview, References, Psychological/aptitude tests

**Factors — D-C-A-P-E-P:**
- **D**omain experience — critical
- **C**ommunication ability — very important
- **A**daptability / Attitude — indicates learning ability
- **P**latform/Programming experience — relevant for short projects
- **E**ducational background — shows fundamentals
- **P**ersonality — compatible with team
</details>

<details><summary>Instruction in Best Methods (PCMM)</summary>

Standard development processes (coding standards, reviews) + training.

**PCMM — 5 levels:**
1. **I**nitial — ad-hoc
2. **R**epeatable — basic policies
3. **D**efined — standardised
4. **M**anaged — quantitative goals
5. **O**ptimising — continuous improvement
</details>

<details><summary>Motivation — Maslow + Herzberg</summary>

**Maslow's Hierarchy:**
Physiological → Safety → Social → Esteem → Self-actualisation
*A satisfied need no longer motivates*

**Herzberg's Two-Factor:**
- **Hygiene factors** (policy, supervision, salary) — absence causes dissatisfaction, presence doesn't motivate
- **Motivators** (achievement, recognition, responsibility) — create satisfaction & drive performance

**Practical ways:** Clear targets, involve in decisions, recognise/reward, learning opportunities
</details>

<details><summary>Team Formation — Tuckman</summary>

**F**orming → **S**torming → **N**orming → **P**erforming → Adjourning

**Group factors:**
- **Composition** — balance TSI mix
- **Group cohesiveness** — shared values, egoless programming, learning from each other
- **Communication** — status differences, gender mix, channels
</details>

<details><summary>Decision Making</summary>

**Autocratic** (decides alone) → **Democratic** (majority vote) → **Consensus** (all agree) → **Delegated** (expert decides)
</details>

<details><summary>Leadership</summary>

**Roles:**
- **Technical leader** — architecture, design, standards
- **Managerial leader** — planning, resources, communication

**Styles:**
- **Autocratic** — manager decides alone
- **Democratic** — participative
- **Directive** — tells what to do
- **Permissive** — gives freedom to team

Good leaders: clear vision, empower, remove obstacles, integrity
</details>

<details><summary>Organisational Structures — FPM</summary>

- **F**unctional (by speciality, PM borrows)
- **P**roject-based (dedicated team, PM full authority)
- **M**atrix (dual reporting — functional + project)

**Team structures:** Small informal (<8), Chief programmer (lead + specialists), Multiple small teams
</details>

---

## Unit 8: SQA and Testing

<details><summary>Definition</summary>

The process of ensuring that software meets specified quality standards through planned quality activities and testing.
</details>

<details><summary>Testing Principles — TPPES</summary>

**Traceability to requirements** | Every test → specific requirement
**Plan tests early** | Start planning before execution
**Pareto principle** | 80% errors in 20% of components
**Exhaustive testing impossible** | Prioritise by risk
**Start small → integrate** | Unit → integration → system
**Pesticide paradox** | Repeating same tests finds no new bugs; review/update tests
**Absence‑of‑errors fallacy** | Bug‑free ≠ useful; must meet user needs
</details>

<details><summary>Test Plan</summary>

Includes: Introduction, Assumptions, Test cases, Features tested/not tested, Strategy, Deliverables, Resources, Risks, Schedule
</details>

<details><summary>Testing Methods — BWG</summary>

- **B**lack-box — no internal knowledge (input/output)
- **W**hite-box — full code knowledge (paths, conditions)
- **G**rey-box — partial knowledge
</details>

<details><summary>Levels — UISA</summary>

1. **U**nit — individual functions (by developer)
2. **I**ntegration — combined modules (bottom-up/top-down)
3. **S**ystem — complete system (specialised team)
4. **A**cceptance — **Alpha** (internal) + **Beta** (external users)

**Non-functional:** Performance, Security, Usability, Portability
</details>

<details><summary>V&V</summary>

- **Verification:** "Building product right?" — correct implementation
- **Validation:** "Building right product?" — meets customer needs
</details>

<details><summary>CMM — IRDMO</summary>

1. **I**nitial — ad-hoc, depends on individuals
2. **R**epeatable — basic tracking, realistic planning
3. **D**efined — standard org-wide processes
4. **M**anaged — metrics, predictable
5. **O**ptimising — continuous improvement
</details>

<details><summary>SQA Activities — PBRT-FCMAR</summary>

**P**lan → **B**uild → **R**eview → **T**est → **F**ollow → **C**hange → **M**easure → **A**udit → **R**eport

*Follows full SDLC flow: Planning → Construction → V&V → Maintenance → Closure*
</details>

<details><summary>QA Organisation Structure</summary>

QA Manager has direct line into each department for quality, independent of departmental hierarchy
</details>

<details><summary>SQA Plan — MS-SPRT</summary>

- **M**anagement — SQA in org structure
- **D**ocumentation — work products
- **S**tandards, practices, conventions
- **P**roblem reporting & corrective action
- **R**eviews and audits
- **T**est — reference test plan
</details>

---

## Unit 9: SCM

<details><summary>Definition</summary>

SCM identifies, organises & controls changes to software artifacts. "Librarian of the project" — knows where everything is, who changed what, when & why. Key goal: integrity + traceability.
</details>

<details><summary>Need for SCM</summary>

- Multiple devs changing same code
- Can't revert to stable version
- Which version is current?
- Uncontrolled changes (scope creep)
- Parallel development (branching)
- Audit & accountability
</details>

<details><summary>Core Concepts — C-B-R-V-M</summary>

- **C**I (Config Item) — any work product under control (code, docs, test plans, build scripts)
- **B**aseline — fixed reference; changes need formal CCB approval
- **R**epository — central DB (check-out → modify → check-in)
- **V**ersion (v1.0) vs **R**evision (bug fix) vs **R**elease (distributed)
- **B**ranching (separate line) + **M**erging (combine)

**Baseline Lifecycle:**
Requirements → B1 → Design → B2 → Coding → B3 → Testing → B4 (Release)
</details>

<details><summary>SCM Activities — ICSA</summary>

1. **I**dentification — define CIs, naming, baselines, product breakdown structure
2. **C**ontrol — CCB evaluates/approves changes (Submit → Impact analysis → CCB → Implement → Verify → Update records)
3. **S**tatus Accounting — record/report CI status ("checked out", "in review", "baselined")
4. **A**uditing — Physical (matches spec?) + Functional (meets requirements?)
</details>

<details><summary>Git/GitHub Basics</summary>

**Local:** `git init` → `git add` → `git commit -m ""`
**Sync:** `git push`, `git pull`, `git clone`
**Branching:** `git branch <name>`, `git checkout <name>`, `git merge <name>`
**Collaboration:** Fork → Clone → Branch → Commit → Push → Pull Request → Merge
**Undo:** `git reset`, `git revert`, `git stash`
**Info:** `git status`, `git log`, `git diff`
</details>

---

## Formula Sheet

```
Economic Analysis:
  P = F(1+i)^(-n)                    F = P(1+i)^n
  P = A[(1+i)^n - 1]/[i(1+i)^n]     F = A[(1+i)^n - 1]/i
  A = P[i(1+i)^n]/[(1+i)^n - 1]
  IRR = i₁ + [NPW₁/(NPW₁-NPW₂)](i₂-i₁)
  BCR = PW(Benefits)/PW(Costs)
  P_grad = G[(1+i)^n - i×n - 1]/[i²(1+i)^n]
  A_grad = G[1/i - n/((1+i)^n - 1)]

PERT:
  TE = (O+4M+P)/6    σ² = [(P-O)/6]²    Z = (T-TE)/σ

EVA:
  SV=EV-PV  CV=EV-AC  SPI=EV/PV  CPI=EV/AC
  EAC = BAC/CPI  ETC = EAC-AC  TCPI = (BAC-EV)/(BAC-AC)

Risk:
  EMV = Probability × Impact Cost
```
