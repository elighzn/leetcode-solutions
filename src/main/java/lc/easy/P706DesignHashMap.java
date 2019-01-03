package lc.easy;


public class P706DesignHashMap {

  class MyHashMap {

    Integer[] map = new Integer[1000000];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
      map[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public int get(int key) {
      if (map[key] == null)
        return -1;
      return map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
      map[key] = null;
    }
  }

  /**
   * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
   * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
   */

  public void run() {
    MyHashMap hashMap = new MyHashMap();
    hashMap.put(1, 1);
    hashMap.put(2, 2);
    hashMap.get(1); // returns 1
    hashMap.get(3); // returns -1 (not found)
    hashMap.put(2, 1); // update the existing value
    hashMap.get(2); // returns 1
    hashMap.remove(2); // remove the mapping for 2
    hashMap.get(2); // returns -1 (not found)
  }

  public static void main(String[] args) {
    P706DesignHashMap p = new P706DesignHashMap();
    p.run();
  }

}
