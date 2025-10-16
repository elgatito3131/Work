# LeetCode Technical Interview Preparation Roadmap
**Goal:** Master common interview patterns for government contractor and defense industry software engineering positions
**Timeline:** 8-12 weeks (adaptable based on interview schedule)
**Target:** 75-100 problems (focus on Easy/Medium, quality over quantity)

---

## INTERVIEW LANDSCAPE FOR DEFENSE CONTRACTORS

### What to Expect:

**Government Contractors (Northrop, Lockheed, Raytheon, Booz Allen, SAIC, etc.):**
- **Less LeetCode-heavy** than FAANG companies
- Focus on **practical problem-solving** over algorithmic tricks
- More emphasis on **systems knowledge, databases, and fundamentals**
- Questions often relate to **real-world scenarios**
- Behavioral questions are **equally or more important**

**Typical Technical Interview Structure:**
1. **Phone Screen (45-60 min):**
   - 1-2 Easy/Medium coding problems
   - Basic data structures and algorithms
   - May include system design concepts

2. **Technical Interview (1-2 hours):**
   - 2-3 Medium problems (rarely Hard)
   - Discussion of past projects
   - System design fundamentals
   - Database/SQL questions (especially for backend roles)
   - C/C++ specific questions (for systems roles)

3. **On-site/Final Round:**
   - Mix of coding, system design, behavioral
   - Team fit assessment
   - Technical depth in specific areas

### Key Differences from FAANG Interviews:
- ✅ More emphasis on explaining thought process
- ✅ More practical, less algorithmic puzzles
- ✅ Systems knowledge valued highly
- ✅ Database knowledge tested more frequently
- ✅ Behavioral/team fit weighted heavily
- ❌ Less dynamic programming than FAANG
- ❌ Rarely see "Hard" problems
- ❌ Less time pressure (more discussion-oriented)

---

## PREPARATION STRATEGY

### Phase 1: Foundations (Weeks 1-2)
**Goal:** Master fundamental data structures and basic algorithms
**Problems:** 20-25 Easy problems
**Time Commitment:** 1-2 hours/day

### Phase 2: Core Patterns (Weeks 3-6)
**Goal:** Learn and practice common interview patterns
**Problems:** 40-50 Medium problems
**Time Commitment:** 1.5-2 hours/day

### Phase 3: Advanced Practice & Mock Interviews (Weeks 7-8)
**Goal:** Solidify knowledge, practice under pressure
**Problems:** 15-20 additional problems + mock interviews
**Time Commitment:** 2-3 hours/day

### Phase 4: Maintenance (Ongoing)
**Goal:** Stay sharp while actively interviewing
**Problems:** 2-3 problems per week
**Time Commitment:** 30-60 min/day

---

## PHASE 1: FOUNDATIONS (Weeks 1-2)

### Week 1: Arrays, Strings, Hash Tables

**Topics to Master:**
- Array traversal and manipulation
- Two-pointer technique
- Hash maps for O(1) lookup
- String manipulation
- Basic mathematical operations

**Problems (LeetCode Easy):**

**Arrays:**
1. **Two Sum** (LC #1) - Hash map fundamentals
2. **Best Time to Buy and Sell Stock** (LC #121) - Single pass algorithm
3. **Contains Duplicate** (LC #217) - Hash set usage
4. **Product of Array Except Self** (LC #238) - Medium but fundamental
5. **Maximum Subarray** (LC #53) - Kadane's algorithm

**Strings:**
6. **Valid Anagram** (LC #242) - Character counting
7. **Valid Palindrome** (LC #125) - Two pointers
8. **Longest Substring Without Repeating Characters** (LC #3) - Medium, sliding window
9. **Group Anagrams** (LC #49) - Medium, hash map + sorting

**Key Learnings:**
- When to use hash map vs. array for counting
- Two-pointer patterns
- Time-space tradeoffs

**Practice Schedule:**
- **Monday:** Problems 1-2 (Arrays intro)
- **Tuesday:** Problems 3-4 (Arrays continued)
- **Wednesday:** Problem 5 + review
- **Thursday:** Problems 6-7 (Strings intro)
- **Friday:** Problems 8-9 (Strings advanced)
- **Weekend:** Review all problems, redo difficult ones

---

### Week 2: Linked Lists, Stacks, Queues

**Topics to Master:**
- Linked list traversal and manipulation
- Fast & slow pointer technique
- Stack LIFO operations
- Queue FIFO operations
- Monotonic stack pattern

**Problems:**

**Linked Lists:**
10. **Reverse Linked List** (LC #206) - Classic fundamental
11. **Merge Two Sorted Lists** (LC #21) - Merging technique
12. **Linked List Cycle** (LC #141) - Fast & slow pointers
13. **Remove Nth Node From End** (LC #19) - Medium, two pointers
14. **Reorder List** (LC #143) - Medium, multiple techniques

**Stacks/Queues:**
15. **Valid Parentheses** (LC #20) - Stack fundamentals
16. **Min Stack** (LC #155) - Design problem
17. **Daily Temperatures** (LC #739) - Medium, monotonic stack
18. **Implement Queue using Stacks** (LC #232) - Design problem

**Key Learnings:**
- Dummy node technique for linked lists
- Fast & slow pointer pattern
- When to use stack for parsing/matching
- Stack-based optimization patterns

**Practice Schedule:**
- **Monday:** Problems 10-11 (Linked list basics)
- **Tuesday:** Problems 12-13 (Linked list pointers)
- **Wednesday:** Problem 14 + review
- **Thursday:** Problems 15-16 (Stack basics)
- **Friday:** Problems 17-18 (Stack advanced)
- **Weekend:** Review Phase 1, redo challenging problems

---

## PHASE 2: CORE PATTERNS (Weeks 3-6)

### Week 3: Binary Search & Sorting

**Topics to Master:**
- Binary search pattern and variations
- Search space reduction
- Sorting algorithms (know how they work)
- Custom comparators

**Problems:**

**Binary Search:**
19. **Binary Search** (LC #704) - Template
20. **Search in Rotated Sorted Array** (LC #33) - Medium, modified binary search
21. **Find Minimum in Rotated Sorted Array** (LC #153) - Medium
22. **Search a 2D Matrix** (LC #74) - Medium, 2D binary search
23. **Koko Eating Bananas** (LC #875) - Medium, binary search on answer

**Sorting:**
24. **Merge Intervals** (LC #56) - Medium, sorting + merging
25. **Meeting Rooms** (LC #252) - Easy (Premium) - or similar non-premium
26. **Sort Colors** (LC #75) - Medium, three-pointer technique

**Key Learnings:**
- Binary search template (avoid off-by-one errors)
- When problem can be solved with binary search
- Sorting as preprocessing step

---

### Week 4: Trees & Recursion

**Topics to Master:**
- Tree traversal (inorder, preorder, postorder, level-order)
- Depth-first search (DFS)
- Breadth-first search (BFS)
- Recursion patterns
- Tree properties (height, diameter, paths)

**Problems:**

**Tree Traversal:**
27. **Invert Binary Tree** (LC #226) - Easy, recursion practice
28. **Maximum Depth of Binary Tree** (LC #104) - Easy, DFS
29. **Same Tree** (LC #100) - Easy, comparison
30. **Binary Tree Level Order Traversal** (LC #102) - Medium, BFS

**Tree Properties:**
31. **Diameter of Binary Tree** (LC #543) - Easy but tricky
32. **Balanced Binary Tree** (LC #110) - Easy
33. **Lowest Common Ancestor of BST** (LC #235) - Medium
34. **Validate Binary Search Tree** (LC #98) - Medium, important pattern
35. **Kth Smallest Element in BST** (LC #230) - Medium, inorder traversal

**Tree Construction:**
36. **Construct Binary Tree from Preorder and Inorder** (LC #105) - Medium, recursion

**Key Learnings:**
- DFS vs BFS when to use which
- Recursion base cases and return values
- Tree property calculations
- BST properties and operations

---

### Week 5: Graphs & Dynamic Programming (Intro)

**Topics to Master:**
- Graph representation (adjacency list)
- DFS and BFS on graphs
- Connected components
- Basic DP (overlapping subproblems, memoization)

**Problems:**

**Graphs:**
37. **Number of Islands** (LC #200) - Medium, DFS/BFS classic
38. **Clone Graph** (LC #133) - Medium, DFS with hash map
39. **Pacific Atlantic Water Flow** (LC #417) - Medium, DFS from boundaries
40. **Course Schedule** (LC #207) - Medium, cycle detection (topological sort)

**Dynamic Programming (Easy Start):**
41. **Climbing Stairs** (LC #70) - Easy, DP introduction
42. **House Robber** (LC #198) - Medium, 1D DP
43. **Coin Change** (LC #322) - Medium, classic DP
44. **Longest Increasing Subsequence** (LC #300) - Medium, important pattern

**Key Learnings:**
- Graph traversal patterns
- When to use visited set
- Recognizing DP problems (optimal substructure)
- Memoization vs tabulation

---

### Week 6: Sliding Window, Two Pointers, Greedy

**Topics to Master:**
- Sliding window pattern (fixed and variable size)
- Two pointers (same direction, opposite direction)
- Greedy choice property

**Problems:**

**Sliding Window:**
45. **Best Time to Buy and Sell Stock** (LC #121) - revisit with sliding window view
46. **Longest Substring Without Repeating Characters** (LC #3) - revisit
47. **Minimum Window Substring** (LC #76) - Hard but important, skip if time-constrained
48. **Longest Repeating Character Replacement** (LC #424) - Medium, sliding window

**Two Pointers:**
49. **3Sum** (LC #15) - Medium, two pointers after sorting
50. **Container With Most Water** (LC #11) - Medium, greedy two pointers
51. **Trapping Rain Water** (LC #42) - Hard, but classic (optional)

**Greedy:**
52. **Jump Game** (LC #55) - Medium, greedy approach
53. **Jump Game II** (LC #45) - Medium
54. **Gas Station** (LC #134) - Medium

**Key Learnings:**
- Recognizing sliding window opportunities
- Fixed vs variable window size
- Two pointer movement strategies
- When greedy works (and when it doesn't)

---

## PHASE 3: ADVANCED PRACTICE & MOCK INTERVIEWS (Weeks 7-8)

### Week 7: Mixed Practice + System Design Basics

**LeetCode:**
- Do 10-15 **Medium** problems you haven't seen
- Focus on areas you're weakest
- Redo any problems you struggled with
- Practice explaining your approach out loud

**System Design Study:**
- **Topics to know for entry-level:**
  - Client-server architecture
  - RESTful API design
  - Database schema design
  - Caching concepts (when and why)
  - Load balancing basics
  - Horizontal vs vertical scaling

**Resources:**
- Read "System Design Primer" on GitHub
- Watch YouTube videos on system design basics
- Practice designing simple systems (URL shortener, cache, chat app)

**Mock Interviews:**
- Do 2-3 mock interviews on Preplaced.in or with friends
- Practice on whiteboard or text editor (not IDE)
- Focus on communication and thought process

---

### Week 8: Interview Simulation & Confidence Building

**Activities:**
- **Monday-Wednesday:** Do 1-2 timed problems daily (45 min each)
- **Thursday:** Full mock interview (2 hours)
- **Friday:** Review weak areas, redo difficult problems
- **Weekend:** Relax, light review, prepare mentally

**Behavioral Prep:**
- Prepare STAR method answers for common questions
- Practice explaining past projects
- Prepare questions to ask interviewers

---

## PROBLEM-SOLVING FRAMEWORK (USE IN EVERY INTERVIEW)

### Step 1: Understand the Problem (5 minutes)
- Restate the problem in your own words
- Ask clarifying questions:
  - What are the input constraints? (size, range, edge cases)
  - What should I return if input is empty/invalid?
  - Are there any special requirements? (space, time)
- Work through 2-3 examples (including edge cases)

### Step 2: Plan Your Approach (5-10 minutes)
- **Think out loud** - don't go silent
- Start with brute force approach
  - State the time and space complexity
  - Discuss why it might not be optimal
- Propose optimized approach
  - Explain the intuition
  - Discuss time and space complexity
  - Consider tradeoffs
- **Get interviewer's feedback** before coding

### Step 3: Code the Solution (15-20 minutes)
- Write clean, readable code
- Use meaningful variable names
- Explain as you code
- Handle edge cases
- Don't worry about perfect syntax - communicate if unsure

### Step 4: Test Your Code (5-10 minutes)
- Walk through your code with the examples
- Test edge cases:
  - Empty input
  - Single element
  - All same elements
  - Negative numbers (if applicable)
- Fix any bugs you find
- Discuss potential improvements

### Step 5: Analyze Complexity
- State time complexity with explanation
- State space complexity with explanation
- Discuss if further optimization is possible

---

## COMMON PATTERNS CHEAT SHEET

### 1. **Sliding Window**
**When to use:** Contiguous subarray/substring problems, "longest", "shortest", "contains"
**Template:**
```python
left = 0
for right in range(len(arr)):
    # expand window by adding arr[right]
    while window_invalid():
        # shrink window from left
        left += 1
    # update result
```
**Example problems:** LC #3, #76, #424, #567

---

### 2. **Two Pointers**
**When to use:** Sorted array, palindrome, pair sum, merging
**Template:**
```python
left, right = 0, len(arr) - 1
while left < right:
    if condition:
        # move pointers based on condition
    elif other_condition:
        left += 1
    else:
        right -= 1
```
**Example problems:** LC #15, #11, #125, #167

---

### 3. **Fast & Slow Pointers**
**When to use:** Linked list cycle, find middle, detect patterns
**Template:**
```python
slow = fast = head
while fast and fast.next:
    slow = slow.next
    fast = fast.next.next
    if slow == fast:
        # cycle detected
```
**Example problems:** LC #141, #142, #143, #876

---

### 4. **Binary Search**
**When to use:** Sorted array search, "find minimum/maximum satisfying condition"
**Template:**
```python
left, right = 0, len(arr) - 1
while left <= right:
    mid = left + (right - left) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```
**Example problems:** LC #704, #33, #153, #875

---

### 5. **DFS (Depth-First Search)**
**When to use:** Tree/graph traversal, explore all paths, backtracking
**Template:**
```python
def dfs(node, visited):
    if not node or node in visited:
        return
    visited.add(node)
    # process node
    for neighbor in node.neighbors:
        dfs(neighbor, visited)
```
**Example problems:** LC #200, #417, #105, #543

---

### 6. **BFS (Breadth-First Search)**
**When to use:** Shortest path, level-order traversal, minimum steps
**Template:**
```python
queue = deque([start])
visited = {start}
while queue:
    node = queue.popleft()
    # process node
    for neighbor in node.neighbors:
        if neighbor not in visited:
            visited.add(neighbor)
            queue.append(neighbor)
```
**Example problems:** LC #102, #107, #200, #286

---

### 7. **Dynamic Programming**
**When to use:** Overlapping subproblems, optimal substructure, "maximum/minimum", counting
**Template:**
```python
# 1D DP
dp = [base_case] * (n + 1)
for i in range(1, n + 1):
    dp[i] = function_of(dp[i-1], dp[i-2], ...)

# 2D DP
dp = [[0] * (n + 1) for _ in range(m + 1)]
for i in range(1, m + 1):
    for j in range(1, n + 1):
        dp[i][j] = function_of(dp[i-1][j], dp[i][j-1], ...)
```
**Example problems:** LC #70, #198, #322, #300

---

## MUST-KNOW PROBLEMS (DEFENSE CONTRACTOR FOCUS)

### **Top 25 for Defense Contractor Interviews:**

**Arrays & Hashing (High Priority):**
1. Two Sum (LC #1)
2. Group Anagrams (LC #49)
3. Product of Array Except Self (LC #238)

**Linked Lists:**
4. Reverse Linked List (LC #206)
5. Merge Two Sorted Lists (LC #21)
6. Linked List Cycle (LC #141)

**Stacks:**
7. Valid Parentheses (LC #20)
8. Min Stack (LC #155)

**Binary Search:**
9. Binary Search (LC #704)
10. Search in Rotated Sorted Array (LC #33)

**Trees:**
11. Maximum Depth of Binary Tree (LC #104)
12. Same Tree (LC #100)
13. Invert Binary Tree (LC #226)
14. Binary Tree Level Order Traversal (LC #102)
15. Validate Binary Search Tree (LC #98)

**Graphs:**
16. Number of Islands (LC #200)
17. Clone Graph (LC #133)

**Dynamic Programming:**
18. Climbing Stairs (LC #70)
19. House Robber (LC #198)
20. Coin Change (LC #322)

**Sliding Window:**
21. Longest Substring Without Repeating Characters (LC #3)
22. Best Time to Buy and Sell Stock (LC #121)

**Two Pointers:**
23. 3Sum (LC #15)
24. Container With Most Water (LC #11)

**Strings:**
25. Valid Palindrome (LC #125)

---

## LANGUAGE-SPECIFIC CONSIDERATIONS

### **For Python (Recommended for LeetCode):**
**Pros:**
- Concise syntax
- Built-in data structures (dict, set, deque)
- Easy to write quickly
- Good for interviews

**Key Libraries:**
```python
from collections import deque, defaultdict, Counter
import heapq
```

**Common Idioms:**
```python
# Dictionary with default value
freq = defaultdict(int)

# Counter for character/element counting
count = Counter(s)

# Queue for BFS
queue = deque([start])

# Min heap
heapq.heappush(heap, value)
```

---

### **For Java (If Required):**
**Key Classes:**
```java
HashMap<K, V>
HashSet<T>
ArrayList<T>
LinkedList<T>
PriorityQueue<T>
Queue<T> (interface)
Stack<T>
Arrays.sort()
Collections.sort()
```

---

### **For C++ (Systems Roles):**
**Key Containers:**
```cpp
vector<T>
unordered_map<K, V>
unordered_set<T>
queue<T>
stack<T>
priority_queue<T>
sort()
```

---

## COMMON MISTAKES TO AVOID

1. **Going silent** - Always think out loud
2. **Jumping into code immediately** - Plan first, code second
3. **Not asking clarifying questions** - Shows poor communication
4. **Ignoring edge cases** - Test thoroughly
5. **Poor variable names** - Use meaningful names
6. **Not discussing complexity** - Always analyze time/space
7. **Giving up too quickly** - Ask for hints if stuck
8. **Not testing code** - Walk through with examples
9. **Optimizing prematurely** - Start with brute force, then optimize
10. **Not engaging with interviewer** - Interview is a conversation

---

## ADDITIONAL PREP FOR DEFENSE CONTRACTORS

### **SQL/Database Questions (Important!):**
**Study:**
- JOINs (INNER, LEFT, RIGHT, FULL OUTER)
- Aggregations (GROUP BY, HAVING, COUNT, SUM, AVG)
- Subqueries and CTEs
- Window functions (ROW_NUMBER, RANK, PARTITION BY)
- Indexes and query optimization concepts

**Practice:**
- LeetCode Database problems (Premium)
- HackerRank SQL challenges
- SQLZoo exercises

**Sample Question:**
"Write a SQL query to find the second highest salary from an Employee table."

---

### **Systems/C++ Questions (For Systems Roles):**
**Study:**
- Pointers and memory management
- Pass by value vs reference
- Stack vs heap memory
- Virtual functions and polymorphism
- Memory leaks and debugging

**Sample Questions:**
- "Explain the difference between malloc and new"
- "What happens when you delete an object twice?"
- "How do you prevent memory leaks in C++?"

---

### **Behavioral Questions (VERY Important):**
**Prepare STAR responses for:**
- Tell me about a time you worked on a team
- Describe a challenging technical problem you solved
- Tell me about a time you had a disagreement with a team member
- Describe a project you're proud of
- Tell me about a time you failed and what you learned
- Why do you want to work here?
- Why should we hire you?
- Where do you see yourself in 5 years?

**Your Strong Examples:**
- Patriot Hacks leadership (teamwork, deadline pressure)
- Street Solutions internship (professional SDLC)
- Peer tutoring (communication, mentoring)
- Academic recovery (resilience, growth)
- CS 468 projects (technical depth, security focus)

---

## RESOURCES

**LeetCode:**
- LeetCode.com (obviously!)
- LeetCode Patterns by Sean Prashad (GitHub)
- NeetCode.io (150 problem list with video explanations)

**Books:**
- "Cracking the Coding Interview" by Gayle Laakmann McDowell
- "Elements of Programming Interviews" (Python/Java/C++)

**YouTube Channels:**
- NeetCode (excellent explanations)
- Back To Back SWE
- Kevin Naughton Jr.

**Practice Platforms:**
- HackerRank (good for SQL)
- CodeSignal (company assessments)
- Pramp (mock interviews)

**System Design:**
- System Design Primer (GitHub)
- Grokking the System Design Interview

---

## PROGRESS TRACKER

### Week 1: Arrays, Strings, Hashing
- [ ] Problems 1-9 completed
- [ ] Patterns understood
- [ ] Review completed

### Week 2: Linked Lists, Stacks, Queues
- [ ] Problems 10-18 completed
- [ ] Fast & slow pointer mastered
- [ ] Review completed

### Week 3: Binary Search, Sorting
- [ ] Problems 19-26 completed
- [ ] Binary search template memorized
- [ ] Review completed

### Week 4: Trees & Recursion
- [ ] Problems 27-36 completed
- [ ] Tree traversals mastered
- [ ] Review completed

### Week 5: Graphs & DP Intro
- [ ] Problems 37-44 completed
- [ ] Graph patterns understood
- [ ] Basic DP concepts clear

### Week 6: Sliding Window, Two Pointers, Greedy
- [ ] Problems 45-54 completed
- [ ] All patterns mastered
- [ ] Review completed

### Week 7: Mixed Practice & System Design
- [ ] 10-15 additional problems
- [ ] System design topics studied
- [ ] Mock interviews completed

### Week 8: Final Prep
- [ ] Weak areas reinforced
- [ ] Confidence built
- [ ] Ready to interview!

---

**Remember:** Defense contractors value problem-solving process and communication more than perfect solutions. Focus on:
1. Clear communication
2. Structured thinking
3. Handling of edge cases
4. Practical, working solutions

**You've got this!** Your strong CS fundamentals from GMU + focused practice = interview success.

---

**Last Updated:** October 2025
**Next Review:** Weekly progress check every Monday
