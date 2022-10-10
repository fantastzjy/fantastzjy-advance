1
、--思路  子查询结果作为临时表 再从临时表中查数据
select email
from (select email, count(id) num from person group by email) temp
where num > 1;
思考
：
子查询需要起一个临时表名
     count是从查询结果中计算 某一列/某种条件筛选 的行数   group by 的条件

2
、方法二
：使用 GROUP BY 和 HAVING 条件
向 GROUP BY 添加条件的一种更常用的方法是使用 HAVING 子句
，该子句更为简单高效
。

select Email
from Person
group by Email
having count(Email) > 1;

思考
：
使用group by和having
。还需要记得优先顺序
。where > group by > having > order by

3
、自连接   笨办法哦
。使用自联结
。 自己查自己然后去重
select distinct p1.Email
from Person as p1,
     Person as p2
where p1.Email = p2.Email
  and p1.Id!=p2.Id;



作者
：
LeetCode
链接
：https://leetcode-cn.com/problems/duplicate-emails/solution/cha-zhao-zhong-fu-de-dian-zi-you-xiang-by-leetcode/
来源
：力扣
（LeetCode
）
著作权归作者所有
。商业转载请联系作者获得授权
，非商业转载请注明出处
。