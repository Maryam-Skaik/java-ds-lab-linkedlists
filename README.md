<h1 align="center">🔗 Java Data Structures Lab – Linked Lists Module</h1>

![Course](https://img.shields.io/badge/DS%20Lab-Week%202-%2373c2fb)
![Language](https://img.shields.io/badge/Java-Source_Code-%23e57373)
![Topic](https://img.shields.io/badge/Topic-Linked%20Lists-%23ffb74d)
![Level](https://img.shields.io/badge/Level-Beginner%20%2F%20Intro-%2381c784)
![Purpose](https://img.shields.io/badge/Purpose-Teaching-%234fc3f7)

This repository contains lecture examples, slides, activity skeletons, assignments, and solutions for the **Linked Lists Module** of the Java Data Structures Lab.
Linked lists are pointer-based collections that provide dynamic sizing and efficient pointer updates for insertion/deletion operations compared with fixed-size arrays.

---

## 📌 Prerequisites (what students should know before this lab)
- Java basics: classes, objects, generics, `null` handling.  
- Arrays and index-based access (previous lecture).  
- Basic Big-O intuition (constant vs. linear time).

---

## 📌 Module Objectives

By the end of this module students will be able to:

1. Explain the structure of Node-based lists and differences between SLL, DLL and CLL.
2. Implement SLL operations: `insertAtHead`, `insertAtTail`, `deleteByValue`, `traverse/print`.  
3. Implement DLL operations: maintain both `prev` and `next`, `head` and `tail`; traverse forward/backward; safe deletion. 
4. Implement CLL (activity): circular linking, traversal termination, deletion edge-cases.
5. Compare algorithmic cost and memory trade-offs vs arrays and when to prefer each structure.

---

## ▶ Lecture Video

**[DS Lab: Linked Lists — Dynamic Structures (Lecture 02)](https://youtu.be/RocGGEeBOQ0)**  

---

## 📚 Lecture Slides (PDF)

**[Lecture 02 - Linked Lists.pdf](src/chapters/Lecture%2002%20-%20Linked%20Lists.pdf)**

Covers:
- Motivation & use-cases
- SLL, DLL, CLL definitions + diagrams
- Step-by-step examples and edge-cases
- Activity instructions (CLL)

---

## 📁 Repository Structure (recommended)

```bash
java-ds-lab-linkedlists/
│
├── src/
│   ├── examples/                 # Lecture example code
│   │   ├── SingleLinkedList.java
│   │   └── DoubleLinkedList.java
│   │
│   ├── activities/               # Student practice activities (solutions uploaded later)
│   │   ├── Activity01_CountNodesSLL.java
│   │   ├── Activity02_PrintNthFromEndSLL.java
│   │   ├── Activity03_SwapNodesDLL.java
│   │   └── Activity04_BasicCLL.java
│   │
│   └── chapters/                 # Lecture chapters (PDF)
│       └── Lecture 02 - Linked Lists.pdf
│
├── assignments/                  # Assignment descriptions & future solutions
│   └── README.md                 # Students must watch the video to know the tasks
│
└── README.md
```

---

## 💡 Key Concepts Demonstrated

### ✔ Motivation: Why Linked Lists?

Arrays are simple but limited:

- Fixed size → must predict capacity
- Insert/delete in the middle → elements must shift manually
- Memory must be contiguous → may cause wasted or insufficient space

Linked Lists solve these issues:

- Dynamic growth → no need for fixed size
- Efficient insertion and deletion → no shifting required
- Memory can be scattered → nodes linked via pointers

---

### ✔ Node (abstract)

A `Node<T>` usually stores:

- T element — data
- Node<T> next — pointer to next node
- optionally Node<T> prev — pointer to previous node (DLL)

---

### ✔ Singly Linked List (SLL)

- Node contains:
  - Data
  - Next pointer → points to the next node
- Head → first node (null if empty)
- Last node points to **NULL**
- Core operations:
  - Insert at head
  - Insert at tail
  - Delete by value
  - Traverse / print list

> Time Complexity:
>
> - Insertion at head → O(1)
> - Insertion at tail → O(n)
> - Deletion → O(n)
> - Traversal → O(n)

---

## ✔ Doubly Linked List (DLL)

- Node contains:
  - Data
  - Next pointer → forward
  - Prev pointer → backward
- Head → first node, Tail → last node
- Supports **forward and backward traversal**
- Core operations:
  - Insert at head / tail
  - Traverse forward / backward
  - Delete a node
> Time Complexity:
> 
> - Insert at head/tail → O(1)
> - Deletion → O(n)
> - Traversal → O(n)

---

## ✔ Circular Linked List (CLL)

- Last node points back to head → forms a loop
- Can be single circular (only next pointer) or double circular (next & prev pointers)
- Core operations:
  - Insert at head / tail
  - Traverse all nodes
  - Delete a node
> Time Complexity:
>   
> - All basic operations → O(n)

---

### Simple ASCII diagrams

SLL:

```css
head -> [10 | *] -> [20 | *] -> [30 | null]
```

DLL:

```css
null <- [10 | * | *] <-> [20 | * | *] <-> [30 | * | *] -> null
```

CLL:

```css
head -> [10] -> [20] -> [30] -+
   ^                          |
   +--------------------------+
```

---

## 📘 Example Code Explanation

### ⭐ SingleLinkedList.java

Implements a **Singly Linked List (SLL)**. Key functions:

- `insertAtHead(Node<T> node)`  
  Inserts a new node at the beginning of the list.  
  **Time complexity:** O(1). Updates the head pointer to the new node.

- `insertAtTail(Node<T> node)`  
  Inserts a new node at the end of the list.  
  **Time complexity:** O(n). Traverses the list to find the last node, then links the new node.

- `deleteByValue(T element)`  
  Deletes the first node containing the specified value.  
  **Time complexity:** O(n). Handles deletion of head, middle, or tail nodes safely.

- `printList()`  
  Traverses the list from head to tail and prints each element, ending with `NULL`.  
  Demonstrates traversal and node linking.

> This class shows how dynamic memory allocation works compared to arrays and highlights pointer-based operations.

---

### ⭐ DoubleLinkedList.java

Implements a **Double Linked List (DLL)**. Key functions:

- `insertAtHead(Node<T> node)`  
  Inserts a new node at the beginning of the list. Updates both head and tail if the list was empty.  
  **Time complexity:** O(1). Sets the new node’s next to old head and updates previous link.

- `insertAtTail(Node<T> node)`  
  Inserts a new node at the end. Updates tail pointer and sets previous link.  
  **Time complexity:** O(1).

- `deleteByValue(T element)`  
  Deletes the first node containing the specified value.  
  Handles deletion of head, tail, or a middle node. Updates next and prev pointers accordingly.  
  **Time complexity:** O(n).

- `TraverseForward()`  
  Prints nodes from head → tail using next pointers. Demonstrates forward traversal.

- `TraverseBackward()`  
  Prints nodes from tail → head using prev pointers. Demonstrates backward traversal.

> This class highlights **bidirectional traversal** and flexible deletion, making it easier to manipulate nodes than in singly linked lists.

---

Students should run the `main` methods in both classes to **visualize insertion, deletion, and traversal operations step by step**.

---

## 📘 API Summary

### SingleLinkedList<T>

```java
public void insertAtHead(Node<T> node);   // O(1)
public void insertAtTail(Node<T> node);   // O(n) unless tail kept
public void deleteByValue(T element);     // O(n)
public void printList();                  // O(n)
```

### DoubleLinkedList<T>

```java
public void insertAtHead(Node<T> node);   // O(1)
public void insertAtTail(Node<T> node);   // O(1) with tail
public void deleteByValue(T element);     // O(n) to find; O(1) to unlink
public void traverseForward();            // O(n)
public void traverseBackward();           // O(n)
```

### CircularLinkedList<T> (activity)

```java
public void insertAtEnd(T element);       // O(n) or O(1) if last pointer
public void traverse();                   // O(n) (stop after full cycle)
public void deleteByValue(T element);     // O(n) — careful with single-node case
```

---

## 📘 Activities (Practice Problems)

Activities are **for practice in this week’s lab**.
**Solutions will be uploaded in a recorded video later.**

### ⭐ Activity 01 – Count Nodes in SLL

- Count total nodes in a singly linked list
- Practice **traversal and node counting**

### ⭐ Activity 02 – Print Nth Node from End in SLL

- Find and print the nth node from the end
- Practice **two-pointer or counting techniques**

## ⭐ Activity 03 – Swap Two Nodes in DLL

- Swap positions of two nodes (by value) in a double linked list
- Practice **pointer manipulation**

### ⭐ Activity 04 – Basic Circular Linked List

- Implement a CLL with:
  - Insert at head and tail
  - Traverse all nodes
  - Delete a node

---

## ▶ Activity Solutions Video

Will provide step-by-step solutions for all four activities:

**[Activity Solutions – Linked Lists Lecture](https://www.youtube.com/watch?v=-tBJQsVmDho)**

---

## ▶ Assignment Video

Assignments for this module are provided through a dedicated recorded video.

Students must:

1. Watch the assignment video in full  
2. Write down the tasks  
3. Implement the solutions independently  
4. Submit on Moodle

The assignment video and instructions are available in the **assignments/** folder.  
[Click here to view the assignments README](assignments/README.md)

---

## ▶ How to Run

Clone the repository:

```bash
git clone https://github.com/Maryam-Skaik/java-ds-lab-linkedlists.git
```

Open in NetBeans, VS Code, or IntelliJ, then run any file inside:

- [src/examples/](src/examples/)
- [src/activities/](src/activities/)

---

## 🎓 Learning Outcome

Students will understand:

- How to represent dynamic data structures using nodes and pointers
- Differences between SLL, DLL, and CLL
- Efficient insertion, deletion, and traversal operations
- How linked lists compare to arrays for dynamic operations
- Foundation for advanced data structures in upcoming modules

---

## 📝 License

This project is provided for educational use in the Java Data Structures Lab.
