-- 答案二：  不用join
SELECT Department.NAME AS Department,
       Employee.NAME   AS Employee,
       Salary
FROM Employee,
     Department
WHERE Employee.DepartmentId = Department.Id
  AND (Employee.DepartmentId, Salary)
    IN (SELECT DepartmentId, max(Salary)
        FROM Employee
        GROUP BY DepartmentId)


    作者：callmePicacho
链接：https://leetcode-cn.com/problems/department-highest-salary/solution/bu-men-gong-zi-zui-gao-de-yuan-gong-by-little_bird/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


-- 答案一：官方
SELECT Department.name AS 'Department', Employee.name AS 'Employee', Salary
FROM Employee
         JOIN
     Department ON Employee.DepartmentId = Department.Id
WHERE (Employee.DepartmentId, Salary) IN
      (SELECT DepartmentId,
              MAX(Salary)
       FROM Employee
       GROUP BY DepartmentId)
;



Employee
表包含所有员工信息
，每个员工有其对应的 Id, salary 和 department Id
。
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
Department 表包含公司所有部门的信息
。
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
编写一个 SQL 查询
，找出每个部门工资最高的员工
。对于上述表
，您的 SQL 查询应返回以下行
（行的顺序无关紧要
）。
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Jim      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
解释
：
Max 和 Jim 在 IT 部门的工资都是最高的
，Henry 在销售部的工资最高
。
来源
：力扣
（LeetCode
）
链接
：https://leetcode-cn.com/problems/department-highest-salary
著作权归领扣网络所有
。商业转载请联系官方授权
，非商业转载请注明出处
。