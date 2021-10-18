1、方法一：使用子查询和 LIMIT 子句
算法
将不同的薪资按降序排序，然后使用 LIMIT 子句获得第二高的薪资。

SELECT DISTINCT
    Salary AS SecondHighestSalary
FROM
    Employee
ORDER BY Salary DESC
LIMIT 1 OFFSET 1

然而，如果没有这样的第二最高工资，这个解决方案将被判断为 “错误答案”，因为本表可能只有一项记录。为了克服这个问题，我们可以将其作为临时表。
SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary
;
---解析
    1、为什么使用临时表能解决null值问题？  因为 select NULL
       假设我们有如图所示的数据，offset 1会超出范围
       查询的结果为
       {"headers": ["SecondHighestSalary"], "values": []}
       而实际上预期结果为
       {"headers": ["SecondHighestSalary"], "values": [[null]]}

    2、为什么select后面可以不接from单独用
       因为  子查询可以在任意地方使用。相当于查询的列。在oracle中只写查询列没有查询表需要加上 from dual（伪表）。而mysql不用写
    3、LIMIT 子句 限制结果数量

    第一个参数开始的位置（从0开始）  第二个参数返回的条数
    省略第一个参数表示索引从0开始  获取条数
    limit 5 从0开始返回5条数据
    limit 0,5 从0开始返回5条数据


2、方法二：使用 IFNULL 和 LIMIT 子句
解决 “NULL” 问题的另一种方法是使用 “IFNULL” 函数，如下所示。
SELECT
    IFNULL(
      (SELECT DISTINCT Salary
       FROM Employee
       ORDER BY Salary DESC
        LIMIT 1 OFFSET 1),
    NULL) AS SecondHighestSalary

链接：https://leetcode-cn.com/problems/second-highest-salary/solution/di-er-gao-de-xin-shui-by-leetcode/


编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/second-highest-salary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。