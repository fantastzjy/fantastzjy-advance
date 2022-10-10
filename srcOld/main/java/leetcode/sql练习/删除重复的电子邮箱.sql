总结 按邮箱分组 每组找到id最小的
min()函数里面要写上列名
mysql规定不能从一个表里查出来数据在删掉数据，所以用了一个临时表


思路：子查询出重复的邮箱的最小id  然后删除不在id列表中的
1、-- 子查询
delete from person
         where id not in
                 (select id from
                                (select min(id) as id from person group by email) as temp
                 )

思路：子查询出相等的邮箱然后删除id大的
2、--  自身查询    delete使用别名的时候，要在delete和from间加上删除表的别名，这样才是正确的写法。
DELETE
p1
 FROM
     Person p1,Person p2
 WHERE
     p1.Email = p2.Email AND p1.Id > p2.Id


 作者
：LeetCode
 链接
：https://leetcode-cn.com/problems/delete
-duplicate-emails/solution/shan-chu-zhong-fu-de-dian-zi-you-xiang-by-leetcode/
 来源
：力扣
（LeetCode
）
 著作权归作者所有
。商业转载请联系作者获得授权
，非商业转载请注明出处
。


编写一个 SQL 查询
，来删除 Person 表中所有重复的电子邮箱
，重复的邮箱里只保留 Id 最小 的那个
。
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id 是这个表的主键。
例如
，在运行你的查询语句之后
，上面的 Person 表应返回以下几行:
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
提示
：
    执行 SQL 之后
，输出是整个 Person 表
。
    使用 delete
语句
。
https://leetcode-cn.com/problems/delete
-duplicate-emails

