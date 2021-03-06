package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandom_380 {
  public static void main(String[] args) {
    RandomizedSet r = new RandomizedSet();
    System.out.println(r.remove(0));
    System.out.println(r.remove(0));
    System.out.println(r.insert(0));
    System.out.println(r.getRandom());
    System.out.println(r.remove(0));
    System.out.println(r.insert(0));
  }

  static class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
      this.map = new HashMap<>();
      this.list = new ArrayList<>();
      this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if (map.containsKey(val)) {
        return false;
      }
      int index = list.size();
      list.add(index, val);
      map.put(val, index);
      return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if (!this.map.containsKey(val)) {
        return false;
      }

      int index = map.get(val);
      //swap the element to delete with the last element
      int lastVal = list.get(list.size() - 1);
      list.set(index, lastVal);
      //delete the last element
      list.remove(list.size() - 1);
      //remove the deleted element
      map.remove(val);
      //update the index for lastVal
      map.put(lastVal, index);
      return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      if (list.size() == 0) {
        return -1;
      }
      int index = random.nextInt(list.size());
      return list.get(index);
    }
  }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
