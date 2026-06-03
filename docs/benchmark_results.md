# **Benchmark Results**

The following measurements were generated using 5 trials per test on each input size.
Algorithms were tested on **random input** and **worst-case input** (descending order).
Execution time is measured in **milliseconds (ms)**.

---

## **📏 Input Sizes**

* 1 000
* 10 000
* 20 000
* 50 000
* 100 000
* 200 000

Quadratic algorithms (Selection & Insertion Sort) were skipped for arrays above **20 000**, as their running time becomes excessively large.

---

# **📊 Benchmark Table**

### Combined results for all algorithms and sizes

*(— means not tested for this size)*

<img width="1707" height="1101" alt="chart" src="https://github.com/user-attachments/assets/8aff20cb-74d6-4526-aac6-c56c965e4692" />


| Algorithm         | 1k rand | 1k worst | 10k rand | 10k worst | 20k rand | 20k worst | 50k rand | 50k worst | 100k rand | 100k worst | 200k rand | 200k worst |
| ----------------- | ------- | -------- | -------- | --------- | -------- | --------- | -------- | --------- | --------- | ---------- | --------- | ---------- |
| **SelectionSort** | 2.310   | 1.823    | 135.878  | 136.213   | 542.037  | 541.811   | —        | —         | —         | —          | —         | —          |
| **InsertionSort** | 2.065   | 1.352    | 13.480   | 26.881    | 53.854   | 107.945   | —        | —         | —         | —          | —         | —          |
| **MergeSort**     | 0.165   | 0.116    | 1.986    | 1.178     | 3.588    | 1.493     | 8.530    | 4.458     | 23.339    | 13.514     | 37.572    | 15.344     |
| **QuickSort**     | 0.098   | 0.067    | 1.084    | 0.688     | 2.221    | 1.410     | 5.914    | 3.619     | 12.689    | 7.753      | 27.636    | 16.264     |


---

# **📈 Observations**

### ✔ QuickSort consistently shows the best performance on random data

Its average-case O(n log n) behavior dominates.

### ✔ MergeSort remains extremely stable

Worst-case and average times differ little due to the deterministic structure.

### ✔ InsertionSort performs well on small inputs

But becomes impractically slow beyond 20k elements.

### ✔ SelectionSort is the slowest algorithm

O(n²) time dominates quickly; unsuitable for real workloads.

### ✔ MergeSort vs QuickSort scaling

* QuickSort wins on random input.
* MergeSort shows more stable worst-case behavior.
* At large sizes (100k–200k), the difference becomes more apparent.

---

# **📌 Conclusion**

For any realistically large array size:

➡ **Use MergeSort or QuickSort** — both scale efficiently.

➡ **Avoid InsertionSort & SelectionSort** except for educational or tiny inputs.
