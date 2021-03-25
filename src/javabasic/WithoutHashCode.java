package javabasic;

import java.util.HashMap;

//debug 解决 为什么重写要重写equals 和 hashcode

class Key {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Key(Integer id) {
        this.id = id;
    }
    //故意先注释掉equals和hashCode方法
    //@Override
    //  public boolean equals(Object o) {
    //      if (o == null || !(o instanceof Key))
    //      { return false; }
    //      else
    //      { return this.getId().equals(((Key) o).getId());}
    //  }

      @Override
      public int hashCode()
      { return id.hashCode(); }
}

public class WithoutHashCode {
    public static void main(String[] args) {
        Key k1 = new Key(1);
        Key k2 = new Key(1);
        HashMap<Key, String> hm = new HashMap<Key, String>();
        hm.put(k1, "Key with id is 1");
        String s = hm.get(k2);
        System.out.println(hm.get(k2));
    }
}