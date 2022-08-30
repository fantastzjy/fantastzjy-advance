select a.name Employee
from employee a ,employee b  --默认内连接
where
    a.ManagerId is not null  --不加这个判断也可 因为没有id是null的
    and a.ManagerId =b.id
    and a.salary > b.salary


    --上面的呢方法默认是内连接  没有区别
    两种方法都是内连接，在MySQL中没区别；
    不过使用JOIN ON会效率更高点 因为JOIN 运算优先级高于逗号

SELECT a.NAME AS Employee
FROM Employee AS a
         JOIN Employee AS b
              ON a.ManagerId = b.Id
                  AND a.Salary > b.Salary
;

作者
：
LeetCode
链接
：https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/solution/chao-guo-jing-li-shou-ru-de-yuan-gong-by-leetcode/
来源
：力扣
（LeetCode
）
著作权归作者所有
。商业转载请联系作者获得授权
，非商业转载请注明出处
。