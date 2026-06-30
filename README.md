# Java Backend Developer Prep — A Complete Journey

Daily/weekly log of preparation for Java backend developer roles at top tech 
companies. Covers SQL & DBMS, DSA, Java + Spring Boot, and System Design 
fundamentals — tracked from day one as I build toward interview-ready depth.

This repo is also meant to double as a revision guide later (for myself, and 
for anyone else following a similar Java backend roadmap) — not just a diary 
of what I did, but a reference for *why* things work the way they do.

## 🎯 Goal
Land a Java backend developer role at a top product-based company as a fresher, 
with strong fundamentals across querying, database theory, problem-solving, 
and backend system design.

## 📖 How to use this repo
- **New here and want the roadmap?** Start with the section below — it lists 
  resources in the order I'm following them.
- **Want SQL/DBMS theory and patterns?** Check `dbms/notes.md` for concept 
  summaries, and `sql/` (organized by topic) for solved problems with notes 
  on *why* each approach was used.
- **Want to see active progress?** [`progress.md`](./progress.md) has the 
  daily/weekly log.
- **Once a topic phase wraps up**, a short revision/cheat-sheet summary will 
  be added per topic — common patterns, gotchas, and quick-reference notes — 
  more useful than scrolling through daily logs.

## 🗺️ Roadmap

### ✅ Currently Active — SQL & DBMS (8-10 hrs/week)

#### SQL
| Purpose | Resource |
|---|---|
| 🎥 Video / Concept | [Apna College — SQL Playlist](https://www.youtube.com/@ApnaCollegeOfficial) |
| 📖 Theory Reference | [GeeksforGeeks — SQL](https://www.geeksforgeeks.org/sql-tutorial/) |
| 💻 Applied Practice | [DataLemur](https://datalemur.com/) |
| 🔥 Interview Drilling | [LeetCode SQL — Top 50](https://leetcode.com/studyplan/top-sql-50/) |

#### DBMS
| Purpose | Resource |
|---|---|
| 🎥 Video / Concept | [Apna College — DBMS Playlist](https://www.youtube.com/@ApnaCollegeOfficial) |
| 📋 Interview Topic Checklist | [TakeUforward — DBMS Sheet](https://takeuforward.org/) |
| 📖 Deep Dive Reference | [GeeksforGeeks — DBMS](https://www.geeksforgeeks.org/dbms/) |

> 💡 **How to use the DBMS sheet:** Go topic by topic on TakeUforward's sheet. 
> Watch Apna College for the concept, use GFG to go deeper when needed, then 
> practice explaining each topic out loud in 2-3 sentences — that's the actual 
> interview skill.

### 🔜 Up Next — DSA
- [Striver's A2Z DSA Sheet](https://takeuforward.org/) — primary problem sheet
- [LeetCode](https://leetcode.com/) — timed practice once patterns are learned

### 🔜 Up Next — Java + Spring Boot
- **Foundation already in progress →** [java-learning-journey](https://github.com/mahesh-lute-9/java-learning-journey) 
  *(Core Java basics to JVM internals — active repo)*
- [Telusko](https://www.youtube.com/@Telusko) — Spring Boot fundamentals
- [in28Minutes](https://www.youtube.com/@in28minutes) — REST APIs practical
- [Baeldung](https://www.baeldung.com/) — reference while building
- **Goal:** 2 portfolio projects (REST API + JWT auth, DB-backed CRUD app)

### 🔜 Up Next — System Design Basics
- [Gaurav Sen](https://www.youtube.com/@GauravSensei) (YouTube)
- [System Design Primer](https://github.com/donnemartin/system-design-primer) (GitHub)

## 📈 Progress
See [`progress.md`](./progress.md) for the daily/weekly log — what's been 
covered, problems solved, and notes on weak areas.

## 🗂️ Repo Structure

```
backend-dev-prep/
├── README.md                    # overview + roadmap + how to use
├── progress.md                  # daily/weekly log
├── sql/
│   ├── joins/
│   ├── aggregations/
│   ├── window-functions/
│   └── subqueries/
├── dbms/
│   └── notes.md                 # normalization, ACID, indexing notes
├── dsa/
│   ├── arrays/
│   ├── linked-lists/
│   ├── trees/
│   └── dp/
└── projects.md                  # links to separate Spring Boot project repos
```
---

## 📌 Notes
- SQL solutions are organized by topic under `sql/`, each named for what it 
  solves (e.g. `second-highest-salary.sql`), with a short comment on the 
  approach used — not just the query, but the reasoning.
- DSA and Java/Spring Boot folders are scaffolded now and will fill in as 
  those tracks become active.
- Standalone Spring Boot projects live in their own dedicated repos (with 
  proper setup instructions, tech stack, etc.) and are linked from 
  `projects.md` here.

---
*Following along? Feel free to fork this approach or reach out.*
