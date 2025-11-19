# Sorting Algorithms Benchmark (Java)

This project provides a benchmarking framework for classic sorting algorithms:
Selection Sort, Insertion Sort, Merge Sort, and Quick Sort.  
It supports:

- Benchmarking on a random array
- Benchmarking on a user-provided array
- Scalability tests on growing input sizes
- Comparison of random-case and worst-case performance
- JIT warmup to improve timing accuracy

## 🚀 Features

- Canonical, reference implementations of 4 sorting algorithms
- Automated timing with nanosecond precision
- Validation of sorting correctness
- Multi-trial averaging
- Worst-case (reversed array) tests
- Optional manual input mode
- Easily extendable with new algorithms

## 📊 Benchmark Results
See `/docs/BENCHMARK_RESULTS.md` for the full benchmark table.

## 📁 Documentation

All documentation is available in `/docs`:

- **PROJECT_OVERVIEW.md** — high-level description
- **ALGORITHMS.md** — all sorting algorithms and theory
- **BENCHMARK_RESULTS.md** — full results table

## 📝 License

MIT License.