select depid.name, emp, salary
from emp
         left join dept on emp.dpid = dept,
     id
where (depid, salary)
          in
      (select depid, salary(max)
       from emp
       group by depid)