# Engineering Economics — Practice Problems

---

## 1. Present Worth (PW) Analysis

### Problem 1.1 — Single Future Sum
**Q:** You will receive Rs 50,000 after 4 years. What is its present worth at an interest rate of 8%?

**Given:** F = 50,000, n = 4, i = 8% = 0.08
**Required:** P

**Which formula?** Single future amount → Present → `P = F(1+i)^(-n)`

**Solution:**
```
P = 50,000 × (1.08)^(-4)
  = 50,000 / (1.08)^4
  = 50,000 / 1.3605
  = Rs 36,751
```

**Interpretation:** Rs 50,000 after 4 years is equivalent to Rs 36,751 today at 8% interest.

---

### Problem 1.2 — Equal Annual Series
**Q:** A project gives Rs 12,000 every year for 5 years. Find the present worth of these returns at i = 10%.

**Given:** A = 12,000, n = 5, i = 10% = 0.10
**Required:** P

**Which formula?** Equal annual payments → Present → `P = A × [(1+i)^n - 1] / [i(1+i)^n]`

**Solution:**
```
P = 12,000 × [(1.10)^5 - 1] / [0.10 × (1.10)^5]
  = 12,000 × [1.6105 - 1] / [0.10 × 1.6105]
  = 12,000 × 0.6105 / 0.16105
  = 12,000 × 3.7908
  = Rs 45,490
```

---

### Problem 1.3 — Combination (NPW)
**Q:** A machine costs Rs 2,00,000 today. It saves Rs 60,000 per year for 4 years. At i = 12%, should you buy it?

**Given:** P_investment = 2,00,000, A_savings = 60,000, n = 4, i = 12% = 0.12
**Required:** NPW

**Which formulas?**
- Investment is already at time 0 → use as-is (no formula needed, it's already P)
- Savings are equal annual → Annuity formula: `P = A × [(1+i)^n - 1] / [i(1+i)^n]`
- NPW = PW(inflows) - PW(outflows)

**Solution:**
```
PW of savings = 60,000 × [(1.12)^4 - 1] / [0.12 × (1.12)^4]
             = 60,000 × [1.5735 - 1] / [0.12 × 1.5735]
             = 60,000 × 0.5735 / 0.1888
             = 60,000 × 3.0373
             = Rs 1,82,238

NPW = 1,82,238 - 2,00,000 = -Rs 17,762
```

**Decision:** NPW < 0 → **Reject.** The machine destroys value.

---

### Problem 1.4 — Uneven Cash Flows
**Q:** An investment of Rs 1,00,000 gives returns of Rs 30,000 in Year 1, Rs 40,000 in Year 2, and Rs 50,000 in Year 3. At i = 10%, find NPW.

**Given:** P = 1,00,000, Uneven A₁=30k, A₂=40k, A₃=50k, i = 10%
**Required:** NPW

**Which formula?** Each cash flow is a single future sum → `P = F(1+i)^(-n)` applied THREE times, one per year.

**Solution:**
```
PW of Year 1 = 30,000 / (1.10)^1 = 30,000 / 1.10   = 27,273
PW of Year 2 = 40,000 / (1.10)^2 = 40,000 / 1.21   = 33,058
PW of Year 3 = 50,000 / (1.10)^3 = 50,000 / 1.331  = 37,566

PW of inflows = 27,273 + 33,058 + 37,566 = Rs 97,897
NPW = 97,897 - 1,00,000 = -Rs 2,103
```

**Decision:** NPW < 0 → **Reject.**

---

## 2. Future Worth (FW) Analysis

### Problem 2.1 — Single Present Sum
**Q:** You invest Rs 20,000 today at 9% for 6 years. What will it be worth?

**Given:** P = 20,000, i = 9% = 0.09, n = 6
**Required:** F

**Which formula?** Single present amount → Future → `F = P(1+i)^n`

**Solution:**
```
F = 20,000 × (1.09)^6
  = 20,000 × 1.6771
  = Rs 33,542
```

---

### Problem 2.2 — Equal Annual Series to Future
**Q:** You deposit Rs 5,000 at the end of each year for 5 years. How much will you have at the end of 5 years at i = 7%?

**Given:** A = 5,000, n = 5, i = 7% = 0.07
**Required:** F

**Which formula?** Equal annual series → Future → `F = A × [(1+i)^n - 1] / i`

**Solution:**
```
F = 5,000 × [(1.07)^5 - 1] / 0.07
  = 5,000 × [1.4026 - 1] / 0.07
  = 5,000 × 0.4026 / 0.07
  = 5,000 × 5.7507
  = Rs 28,754
```

---

### Problem 2.3 — Net Future Worth
**Q:** Same machine problem as 1.3. Investment Rs 2,00,000, saves Rs 60,000/yr for 4 yrs at 12%. Evaluate using FW.

**Given:** P = 2,00,000, A = 60,000, n = 4, i = 12%
**Required:** Net FW

**Which formulas?**
- Investment P → F: `F = P(1+i)^n`
- Annual savings A → F: `F = A × [(1+i)^n - 1] / i`
- NFW = FW(inflows) - FW(outflows)

**Solution:**
```
FW of investment = 2,00,000 × (1.12)^4 = 2,00,000 × 1.5735 = Rs 3,14,700
FW of savings    = 60,000 × [(1.12)^4 - 1] / 0.12
                 = 60,000 × [1.5735 - 1] / 0.12
                 = 60,000 × 0.5735 / 0.12
                 = 60,000 × 4.7793 = Rs 2,86,758

Net FW = 2,86,758 - 3,14,700 = -Rs 27,942
```

**Decision:** NFW < 0 → **Reject** (same conclusion as PW).

---

## 3. Annual Worth (AW) Analysis

### Problem 3.1 — Single Present Sum to Annual
**Q:** A machine costs Rs 5,00,000. It lasts 5 years. What is the equivalent annual cost at i = 12%?

**Given:** P = 5,00,000, n = 5, i = 12% = 0.12
**Required:** A

**Which formula?** Present → Annual series → `A = P × [i(1+i)^n] / [(1+i)^n - 1]`

**Solution:**
```
A = 5,00,000 × [0.12 × (1.12)^5] / [(1.12)^5 - 1]
  = 5,00,000 × [0.12 × 1.7623] / [1.7623 - 1]
  = 5,00,000 × 0.2115 / 0.7623
  = 5,00,000 × 0.2774
  = Rs 1,38,700
```

The machine effectively costs Rs 1,38,700 per year for 5 years.

---

### Problem 3.2 — Net Annual Worth
**Q:** A project costs Rs 3,00,000 now and gives Rs 80,000 yearly for 6 years. At i = 10%, find the Net Annual Worth.

**Given:** P = 3,00,000, A_inflow = 80,000, n = 6, i = 10%
**Required:** Net AW

**Which formulas?**
- Investment P → A: `A = P × [i(1+i)^n] / [(1+i)^n - 1]`
- Inflow A is already annual → use as-is
- Net AW = A_inflow - A_cost

**Solution:**
```
Equivalent annual cost of investment = 3,00,000 × [0.10 × (1.10)^6] / [(1.10)^6 - 1]
(1.10)^6 = 1.7716
= 3,00,000 × [0.10 × 1.7716] / [1.7716 - 1]
= 3,00,000 × 0.17716 / 0.7716
= 3,00,000 × 0.2296
= Rs 68,880

Net AW = 80,000 - 68,880 = Rs 11,120
```

**Decision:** Net AW > 0 → **Accept.**

---

### Problem 3.3 — AW for Unequal Lives (Key Use Case)
**Q:** Machine A costs Rs 2,00,000, lasts 3 yrs, saves Rs 90,000/yr. Machine B costs Rs 3,50,000, lasts 6 yrs, saves Rs 1,00,000/yr. Which is better at i = 10%?

**Given:** Two projects with different lives (3 vs 6 years)
**Required:** Which to choose?

**Why AW?** When lives differ, you CANNOT compare NPW directly (different time horizons). AW converts to equivalent yearly cost, making a fair comparison.

**Which formulas?**
- For each: convert P cost to A using `A = P × [i(1+i)^n] / [(1+i)^n - 1]`
- Net AW = A_savings - A_cost

**Solution:**
```
Machine A (n=3):
  Equivalent annual cost = 2,00,000 × [0.10 × (1.10)^3] / [(1.10)^3 - 1]
  (1.10)^3 = 1.331
  = 2,00,000 × [0.10 × 1.331] / [1.331 - 1]
  = 2,00,000 × 0.1331 / 0.331
  = 2,00,000 × 0.4021
  = Rs 80,420
  Net AW_A = 90,000 - 80,420 = Rs 9,580

Machine B (n=6):
  Equivalent annual cost = 3,50,000 × [0.10 × (1.10)^6] / [(1.10)^6 - 1]
  (1.10)^6 = 1.7716
  = 3,50,000 × 0.17716 / 0.7716
  = 3,50,000 × 0.2296
  = Rs 80,360
  Net AW_B = 1,00,000 - 80,360 = Rs 19,640
```

**Decision:** Machine B has higher Net AW (19,640 > 9,580) → **Choose Machine B.**

---

## 4. Internal Rate of Return (IRR) Method

### Problem 4.1 — Simple Two-Cash-Flow IRR
**Q:** Invest Rs 10,000 today, get Rs 15,000 after 3 years. Find IRR. MARR = 8%.

**Given:** P = 10,000, F = 15,000, n = 3, MARR = 8%
**Required:** IRR

**Which formula?** Set NPW = 0 → `-P + F/(1+i)^n = 0` → Solve for i.

**Solution:**
```
-10,000 + 15,000 / (1+i)^3 = 0
15,000 / (1+i)^3 = 10,000
(1+i)^3 = 1.5
1 + i = (1.5)^(1/3)
1 + i = 1.1447
i = 0.1447 = 14.47%
```

**Decision:** IRR (14.47%) > MARR (8%) → **Accept.**

---

### Problem 4.2 — IRR with Equal Annual Returns (Trial & Error)
**Q:** Invest Rs 50,000 today, get Rs 15,000 per year for 5 years. Find IRR. MARR = 12%.

**Given:** P = 50,000, A = 15,000, n = 5
**Required:** IRR

**Which formula?** Set NPW = 0 → `-P + A × [(1+i)^n - 1] / [i(1+i)^n] = 0`

This needs trial & error or interpolation.

**Solution:**
```
We need: 15,000 × [(1+i)^5 - 1] / [i(1+i)^5] = 50,000
Or: (P/A factor) = 50,000/15,000 = 3.333

Try i = 15%:
P/A factor = [(1.15)^5 - 1] / [0.15 × (1.15)^5]
(1.15)^5 = 2.0114
= [2.0114 - 1] / [0.15 × 2.0114]
= 1.0114 / 0.3017
= 3.352 → NPW = 15,000 × 3.352 - 50,000 = 50,280 - 50,000 = +280

Try i = 16%:
(1.16)^5 = 2.1003
= [2.1003 - 1] / [0.16 × 2.1003]
= 1.1003 / 0.3360
= 3.274 → NPW = 15,000 × 3.274 - 50,000 = 49,110 - 50,000 = -890

Interpolation:
IRR = 15% + [280 / (280 + 890)] × 1%
    = 15% + [280 / 1170] × 1%
    = 15% + 0.239%
    = 15.24%
```

**Decision:** IRR (15.24%) > MARR (12%) → **Accept.**

---

## 5. Benefit-Cost Ratio (BCR) Analysis

### Problem 5.1 — Simple BCR
**Q:** A project costs Rs 80,000 now. Benefits are Rs 25,000 per year for 5 years. At i = 10%, find BCR.

**Given:** P_cost = 80,000, A_benefit = 25,000, n = 5, i = 10%
**Required:** BCR

**Which formula?** BCR = PW(Benefits) / PW(Costs)

- PW of benefits (annuity) → `P = A × [(1+i)^n - 1] / [i(1+i)^n]`
- PW of costs is already at time 0

**Solution:**
```
PW of benefits = 25,000 × [(1.10)^5 - 1] / [0.10 × (1.10)^5]
               = 25,000 × 3.7908
               = Rs 94,770

BCR = 94,770 / 80,000 = 1.185
```

**Decision:** BCR > 1 → **Accept.** For every Rs 1 spent, you get Rs 1.185 in benefits.

---

### Problem 5.2 — BCR with Operating Costs
**Q:** A dam costs Rs 200 crore to build. Annual maintenance is Rs 5 crore. Annual irrigation benefits are Rs 40 crore. Project life = 30 years. At i = 8%, find BCR.

**Given:** Initial cost = 200 cr, A_maint = 5 cr, A_benefit = 40 cr, n = 30, i = 8%
**Required:** BCR

**Which formula?** BCR = PW(Benefits) / PW(Costs)

- Both maintenance and benefits are annuities → use annuity formula for each
- Initial cost is already in present

**Solution:**
```
(1.08)^30 = 10.0627

PW of benefits = 40 × [(1.08)^30 - 1] / [0.08 × (1.08)^30]
               = 40 × [10.0627 - 1] / [0.08 × 10.0627]
               = 40 × 9.0627 / 0.8050
               = 40 × 11.2578
               = Rs 450.31 crore

PW of maintenance = 5 × 11.2578 = Rs 56.29 crore

Total PW of costs = 200 + 56.29 = Rs 256.29 crore

BCR = 450.31 / 256.29 = 1.757
```

**Decision:** BCR > 1 → **Accept.**

---

## 6. Uniform Gradient Cash Flow

### Problem 6.1 — Gradient to Present Worth
**Q:** Maintenance costs are Rs 5,000 in Year 1, increasing by Rs 1,000 each year for 6 years. Find the present worth of all maintenance costs at i = 8%.

**Given:** Base A = 5,000, G = 1,000, n = 6, i = 8% = 0.08
**Required:** P

**Which formulas?**
- Base annuity (A_base = 5,000) → `P_base = A × [(1+i)^n - 1] / [i(1+i)^n]`
- Gradient (G = 1,000) → `P_grad = G × [(1+i)^n - i×n - 1] / [i² × (1+i)^n]`
- Total P = P_base + P_grad

**Solution:**
```
(1.08)^6 = 1.5869

P_base = 5,000 × [1.5869 - 1] / [0.08 × 1.5869]
       = 5,000 × 0.5869 / 0.12695
       = 5,000 × 4.6229
       = Rs 23,115

P_grad = 1,000 × [1.5869 - 0.08×6 - 1] / [0.08² × 1.5869]
       = 1,000 × [1.5869 - 0.48 - 1] / [0.0064 × 1.5869]
       = 1,000 × 0.1069 / 0.010156
       = 1,000 × 10.526
       = Rs 10,526

Total P = 23,115 + 10,526 = Rs 33,641
```

---

### Problem 6.2 — Gradient to Annual Worth
**Q:** Operating costs start at Rs 10,000 in Year 1, increase by Rs 2,000 each year for 5 years. Find the equivalent uniform annual cost at i = 10%.

**Given:** A_base = 10,000, G = 2,000, n = 5, i = 10% = 0.10
**Required:** Equivalent A (total)

**Which formulas?**
- Gradient → Annual: `A_grad = G × [1/i - n / ((1+i)^n - 1)]`
- Total A = A_base + A_grad

**Solution:**
```
(1.10)^5 = 1.6105

A_grad = 2,000 × [1/0.10 - 5 / (1.6105 - 1)]
       = 2,000 × [10 - 5 / 0.6105]
       = 2,000 × [10 - 8.190]
       = 2,000 × 1.810
       = Rs 3,620

Total A = 10,000 + 3,620 = Rs 13,620/year
```

The increasing costs are equivalent to paying Rs 13,620 every year for 5 years.

---

## 7. Earned Value Analysis (EVA)

### Problem 7.1 — Full EVA Calculation

**Q:** A software project has a total budget of Rs 10,00,000 (BAC) and is planned to be completed in 5 months. At the end of Month 3, the project manager collects the following data:

- Planned budget for work scheduled by Month 3: Rs 6,00,000
- Work actually completed: 50% of the total project
- Actual money spent so far: Rs 5,50,000

Calculate all EVA metrics and interpret the project health.

**Given:**
- BAC = Rs 10,00,000
- PV = Rs 6,00,000 (planned value by Month 3)
- % work completed = 50%
- AC = Rs 5,50,000

**Step 1 — Find EV (Earned Value)**

```
EV = % complete × BAC
   = 0.50 × 10,00,000
   = Rs 5,00,000
```

Interpretation: You've completed work worth Rs 5,00,000 at budget rates.

**Step 2 — Schedule Variance (SV)**

```
SV = EV - PV
   = 5,00,000 - 6,00,000
   = -Rs 1,00,000
```

**Interpretation:** Negative → Behind schedule. You planned to deliver Rs 6L worth of work but only delivered Rs 5L.

**Step 3 — Cost Variance (CV)**

```
CV = EV - AC
   = 5,00,000 - 5,50,000
   = -Rs 50,000
```

**Interpretation:** Negative → Over budget. You spent Rs 5.5L but only got Rs 5L worth of work done.

**Step 4 — Schedule Performance Index (SPI)**

```
SPI = EV / PV
    = 5,00,000 / 6,00,000
    = 0.833
```

**Interpretation:** < 1 → Behind schedule. You're progressing at 83.3% of the planned rate. Only 0.83 days of work done for every 1 day planned.

**Step 5 — Cost Performance Index (CPI)**

```
CPI = EV / AC
    = 5,00,000 / 5,50,000
    = 0.909
```

**Interpretation:** < 1 → Over budget. For every Rs 1 spent, you're earning only Rs 0.91 in value.

**Step 6 — Estimate at Completion (EAC)**

```
EAC = BAC / CPI
    = 10,00,000 / 0.909
    = Rs 11,00,000
```

**Interpretation:** If current cost performance continues, the project will cost Rs 11L instead of the planned Rs 10L — a Rs 1L overrun.

**Step 7 — Estimate to Complete (ETC)**

```
ETC = EAC - AC
    = 11,00,000 - 5,50,000
    = Rs 5,50,000
```

**Interpretation:** You still need Rs 5.5L more to finish the project.

**Step 8 — To-Complete Performance Index (TCPI)**

```
TCPI = (BAC - EV) / (BAC - AC)
     = (10,00,000 - 5,00,000) / (10,00,000 - 5,50,000)
     = 5,00,000 / 4,50,000
     = 1.111
```

**Interpretation:** > 1 → You need to perform at 111.1% efficiency (unlikely) to stay within the original budget. The project is in trouble.

---

### Problem 7.2 — Identifying Which Metric to Use

**Q:** At Month 2 of a 6-month project (BAC = Rs 6,00,000), you have:
- Planned: 3 modules each worth Rs 1,00,000
- Actually completed: 2 modules
- Actually spent: Rs 2,50,000

Compute all metrics.

**Step 1 — Find the 3 core numbers**

```
PV = 3 modules × 1,00,000 = Rs 3,00,000 (planned work)
EV = 2 modules × 1,00,000 = Rs 2,00,000 (completed work at budget rate)
AC = Rs 2,50,000 (actual money spent)
```

**Step 2 — Variances**

```
SV = 2,00,000 - 3,00,000 = -Rs 1,00,000 → behind
CV = 2,00,000 - 2,50,000 = -Rs 50,000    → over budget
```

**Step 3 — Indices**

```
SPI = 2,00,000 / 3,00,000 = 0.667 → way behind
CPI = 2,00,000 / 2,50,000 = 0.800 → overspending
```

**Step 4 — Forecasts**

```
EAC = 6,00,000 / 0.80 = Rs 7,50,000
ETC = 7,50,000 - 2,50,000 = Rs 5,00,000
TCPI = (6,00,000 - 2,00,000) / (7,50,000 - 2,50,000) = 4,00,000 / 5,00,000 = 0.80
```

**Note on TCPI:** Here TCPI = 0.80 because EAC is already revised. It means "maintain 80% efficiency to meet the revised budget" — easier than the original target.

---

### Problem 7.3 — Interpreting Project Health (No Calculation)

**Q:** Match each scenario to the project status:

| Scenario | SV | CV | SPI | CPI | Status |
|---|---|---|---|---|---|
| A | +50,000 | +20,000 | 1.2 | 1.1 | **Ahead & under budget** ✅ |
| B | -30,000 | +10,000 | 0.8 | 1.05 | **Behind but under budget** |
| C | +40,000 | -25,000 | 1.15 | 0.85 | **Ahead but over budget** |
| D | -60,000 | -40,000 | 0.7 | 0.75 | **Behind & over budget** ❌ |

**Interpretation:**
- **Scenario A:** Ideal. You're ahead of schedule and costing less than planned.
- **Scenario B:** Behind schedule but spending efficiently. Might need more resources.
- **Scenario C:** Ahead of schedule but costing more. Could be from crashing (adding resources).
- **Scenario D:** Worst case. Behind and over budget. Needs immediate corrective action.

---

### Quick Reference — EVA Formula Cheat Sheet

| Metric | Formula | Meaning |
|---|---|---|
| **PV** | Planned work × budget rate | What should be done |
| **EV** | % complete × BAC | What is actually done (in Rs) |
| **AC** | Actual invoices/timesheets | What was spent |
| **SV** | EV - PV | Schedule variance (+ good) |
| **CV** | EV - AC | Cost variance (+ good) |
| **SPI** | EV / PV | Schedule efficiency (>1 good) |
| **CPI** | EV / AC | Cost efficiency (>1 good) |
| **EAC** | BAC / CPI | Forecast final cost |
| **ETC** | EAC - AC | Money still needed |
| **TCPI** | (BAC - EV) / (BAC - AC) | Efficiency needed to hit budget |
| **TCPI (revised)** | (BAC - EV) / (EAC - AC) | Efficiency needed to hit revised budget |
