# LeetCode Quick Reference Notes

Important notes that we have learned throughout this journey. They have to be digestable quick refreshers that I can fall back on when I forget things.

For example:
- HashMap is a key value data structure in which we use in Two Sum
- HashSet is a wrapper of HashMap that we can use for Longest Consecutive Sequence that only keeps unique values and not duplicates

---

## Data Structures

### HashMap
- **What:** Key-value data structure for fast lookups
- **Time:** O(1) average for get/put/containsKey
- **When to use:** Need to store and quickly retrieve associated data
- **Example use:** Two Sum - store complement → index mapping
```java
HashMap<Integer, Integer> map = new HashMap<>();
map.put(key, value);
map.containsKey(key);
map.get(key);
```

### HashSet
- **What:** Collection that only stores unique values (no duplicates)
- **Built on:** Wrapper around HashMap (uses keys only, ignores values)
- **Time:** O(1) average for add/contains/remove
- **How contains() is O(1):**
  - Uses hash function to compute index: `hash(value) % bucketSize`
  - Mod (%) keeps result small (within array bounds)
  - Creates "buckets" for quick retrieval without searching entire collection
  - Example: hash(42) % 16 might give bucket index 10
- **When to use:** Need to check existence or eliminate duplicates
- **Example use:**
  - Contains Duplicate - compare set size to array length
  - Longest Consecutive Sequence - O(1) lookups for consecutive numbers
```java
HashSet<Integer> set = new HashSet<>();
set.add(value);
set.contains(value);
set.size();
```

---

## Common Patterns & Techniques

### Direct Boolean Return (Contains Duplicate)
**Problem:** Check if array has duplicates
**Technique:** Compare HashSet size to array length
- Add all elements to HashSet (duplicates automatically ignored)
- Return `set.size() < array.length` directly as boolean
- **Why it works:** If sizes differ, duplicates must exist
- **Key insight:** Can return comparison result directly without if/else

### Array Multiplication Pattern (Product Except Self)
**Problem:** Get product of all elements except current index
**Technique:** Create two arrays that multiply element-wise
- `left[i]` = product of all elements before index i
- `right[i]` = product of all elements after index i
- `result[i]` = left[i] × right[i]
- **Key insight:** Can multiply corresponding indices from two separate arrays
- **Optimization:** Store left products in result array, calculate right on-the-fly

### Complement Pattern (Two Sum)
**Problem:** Find two numbers that add up to target
**Technique:** Store complements as you iterate
- For each number, check if it exists in map (meaning we've seen its complement)
- If not, store (target - current) → current_index
**Why it works:** Avoids nested loops by using O(1) lookup

### Left/Right Products (Product Except Self)
**Problem:** Get product of all elements except current
**Technique:** Calculate products from left and right separately
- Left products: product of all elements before index i
- Right products: product of all elements after index i
- Result[i] = left[i] × right[i]
**Optimization:** Use output array for left products, calculate right on-the-fly

### Sequence Start Detection (Longest Consecutive)
**Problem:** Find longest consecutive sequence in unsorted array
**Technique:** Only count from the START of sequences
- Add all numbers to HashSet for O(1) lookups
- For each number, check if (num - 1) exists
- If NOT exists → it's the start of a sequence, start counting
- If EXISTS → skip (will be counted as part of another sequence)
**Why O(n):** Each number processed at most twice (once in loop, once in counting)

### Sorting for Comparison (Valid Anagram)
**Problem:** Check if two strings have same characters
**Technique:** Convert strings to char arrays, sort, then compare
- Step 1: `s.toCharArray()` - break string into individual character elements
- Step 2: `Arrays.sort()` - sort both char arrays alphabetically
- Step 3: `Arrays.equals()` - compare if both sorted arrays match
- **Why it works:** Anagrams have same characters → when sorted, become identical
- **Edge case:** Different lengths → automatically false (different character counts)
**Trade-off:** Simple but O(n log n) - can optimize to O(n) with frequency counter

---

## Complexity Analysis Tips

### Space Complexity Rules
- **Output array doesn't count** toward space complexity (per problem statement)
- **Recursive call stack counts** as O(h) where h is max depth
- **Fixed-size arrays** (like `int[26]` for letters) count as O(1)

### Common Time Complexities
- **O(1):** HashMap/HashSet operations (average)
- **O(n):** Single pass through array
- **O(n log n):** Sorting
- **O(n²):** Nested loops

### Identifying O(n) with Nested Loops
Even with nested loops, can still be O(n) if:
- Each element processed at most constant times
- Inner loop doesn't reset for each outer iteration
**Example:** Longest Consecutive - while loop doesn't reprocess counted numbers

---

## Decision Framework

### When to use HashMap vs HashSet?
- **HashMap:** Need to associate values (key → value mapping)
- **HashSet:** Only need to check existence or uniqueness

### When to sort vs use hash table?
- **Sort:** Need ordered data, or simple implementation (O(n log n))
- **Hash table:** Need O(n) time, don't need ordering

### When to use multiple passes vs single pass?
- **Multiple passes:** Simpler logic, still O(n) if constant passes
- **Single pass:** More optimal in practice, but may be complex

---

## Common Pitfalls

### HashMap Edge Cases
- Check if key exists before `.get()` to avoid null
- Duplicate keys → only last value stored
- Use `getOrDefault()` for default values

### Array Index Errors
- Off-by-one errors in loops
- Accessing negative indices
- Going out of bounds

### Integer Overflow
- Product/sum of large numbers may overflow
- Use `long` if needed

---

## Problem-Solving Strategy

1. **Understand the problem**
   - Read carefully, note constraints
   - Work through examples by hand

2. **Identify the pattern**
   - Have I seen similar before?
   - What data structure fits?

3. **Start with brute force**
   - Get a working solution first
   - Identify bottlenecks

4. **Optimize**
   - Can I eliminate nested loops with hash table?
   - Can I reduce passes through data?
   - Can I save space?

5. **Test edge cases**
   - Empty input
   - Single element
   - Duplicates
   - Negative numbers

---

*Last updated: After completing 5/150 problems*
