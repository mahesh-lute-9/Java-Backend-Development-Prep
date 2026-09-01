# 📈 Progress Log

A running, day-by-day record of my Java Backend Development / Spring Boot learning journey. Updated as I go — newest entry at the bottom.

**Legend:** ✅ Done · 🔄 In progress · ⏳ Planned

---

## Summary

| # | Topic | Folder | Status |
|---|---|---|---|
| 1 | First Spring Boot Application | `01_first_SpringBoot_Application` | ✅ |
| 2 | Maven Fundamentals | `02_MavenDemo` | ✅ |
| 3 | Core Concepts | `03_CoreDemo` | ✅ |
| 4 | Spring Core — IoC & DI | `04_SpringCoreDemo` | ✅ |
| 5 | Bean Scope | `05_CircularDependency` | ✅ |
| 6 | Circular Dependency & Bean Initialization | `05_CircularDependency` | ✅ |
| 7 | Spring Bean Lifecycle | `06_BeanLifeCycle` | ✅ |
| 8 | Spring XML-Based Configuration | `07_XMLConfiguration` | ✅ |
| 9 | *Next topic* | — | ⏳ |

---

## Log

### First Spring Boot Application
- Set up project via Spring Initializr
- Understood project structure, `@SpringBootApplication`, embedded server basics
- **Folder:** `01_first_SpringBoot_Application`
- **Status:** ✅ Done

### Maven Fundamentals
- Build lifecycle (compile, test, package, install)
- `pom.xml`, dependency management, plugins
- **Folder:** `02_MavenDemo`
- **Status:** ✅ Done

### Core Concepts
- Foundational concepts underpinning Spring's design
- **Folder:** `03_CoreDemo`
- **Status:** ✅ Done

### Spring Core: IoC & Dependency Injection
- IoC container, bean lifecycle basics
- Constructor vs. setter vs. field injection
- **Folder:** `04_SpringCoreDemo`
- **Status:** ✅ Done

### Bean Scope
- Singleton vs. prototype (and web-aware scopes)
- When each scope matters in real applications
- **Folder:** `05_CircularDependency`
- **Status:** ✅ Done

### Circular Dependency & Bean Initialization
- How Spring detects and resolves circular dependencies
- Bean initialization order, `@PostConstruct`, `@Lazy` as a workaround
- **Folder:** `05_CircularDependency`
- **Status:** ✅ Done

### Spring Bean Lifecycle
- Full bean lifecycle: instantiation → dependency injection → initialization → destruction
- `InitializingBean` / `DisposableBean` interfaces vs. `@PostConstruct` / `@PreDestroy`
- Where `BeanPostProcessor` fits in
- **Folder:** `06_BeanLifeCycle`
- **Status:** ✅ Done

### Spring XML-Based Configuration
- Defining beans in XML instead of annotations (`<bean>`, `<property>`, `<constructor-arg>`)
- Comparing XML config vs. annotation-based config vs. Java config
- When XML config still shows up in legacy/enterprise codebases
- **Folder:** `07_XMLConfiguration`
- **Status:** ✅ Done

### *Next up*
- Topic: TBD
- **Folder:** TBD
- **Status:** ⏳ Planned

---

## 🎯 Milestone: Interview Prep Sprint
Deferred until the full concept series is complete. Will revisit every topic above through a pure interview lens — rapid recall, edge cases, and mock Q&A.

**Status:** ⏳ Not started

---

*Template for new entries:*
```
### Topic Name
- Key point 1
- Key point 2
- **Folder:** `folder_name`
- **Status:** ✅ / 🔄 / ⏳
```
