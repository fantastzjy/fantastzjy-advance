select d.name AS Department,a.name AS Employee,a.Salary
from (
select *,
      dense_rank() over(partition by departmentid
                    order by salary desc) as t from Employee
) as a,department as d
WHERE a.departmentid = d.id and t<=3


--猴子题解   没有部门姓名    还需要联合查询 在查询出部门名
select DepartmentId, Name, Salary
from (select *,
             dense_rank() over (partition by DepartmentId
                       order by Salary desc) as ranking
      from Employee) as a
where ranking <= 3;

链接
：
https://leetcode-cn.com/problems/department-top-three-salaries/solution/tu-jie-sqlmian-shi-ti-jing-dian-topnwen-ti-by-houz/
