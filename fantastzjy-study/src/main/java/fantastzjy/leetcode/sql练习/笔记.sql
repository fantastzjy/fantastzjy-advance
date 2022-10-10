1
、from子句中on条件主要用来连接表
，其他不属于连接表的条件可以使用where子句来指定
；
     join连接分为三种
，1内连接
，2外连接
，3交叉连接
；
     1
：inner join
，默认
，所以可以省略inner关键字
     2
：left outer join
，左外连接
，结果表中除了匹配行外
，还包括左表有而右表中不匹配的行
，对于这样的行
，右表选择列置为null
        right outer join
，右外连接
，结果表中除了匹配行外
，还包括右表有而左表中不匹配的行
，对于这样的行
，左表选择列置为null
        natural join
，自然连接
，分为natural left outer join和natural right outer join
，语义定义与inner join相同
     3
：cross join
，交叉连接
，实际上就是将两个表进行笛卡尔积运算
，结果表的行数等于两表行数之积


2
、ifnull(a,b)函数解释
：
    如果value1不是空
，结果返回a
    如果value1是空
，结果返回b
    对于本题的sql就是
：
    如果没有第二高的成绩
，返回空值
，所以这里用判断空值的函数
（ifnull
）函数来处理特殊情况
。
select ifnull(第2步的sql, null) as '语文课第二名成绩';
我们把第2步的sql语句套入上面的sql语句
，
本题最终sql如下
：
select ifnull(
               (select max(distinct 成绩)
                from 成绩表
                where 成绩 < (select max(成绩) from 成绩表 where 课程 = '语文')
                  and 课程 = '语文')
           , null) as '语文课第二名成绩';

链接
：
https://leetcode-cn.com/problems/second-highest-salary/solution/tu-jie-sqlmian-shi-ti-ru-he-cha-zhao-di-ngao-de-sh/


 3
、mysql中isnull,ifnull,nullif的用法如下
：
  isnull(expr) 的用法
： 如expr 为null
，那么isnull() 的返回值为 1
，否则返回值为 0
。 mysql>
select isnull(1 + 1);
-> 0 mysql>
select isnull(1 / 0);
-> 1 使用= 的null 值对比通常是错误的
。
  isnull() 函数同 is null比较操作符具有一些相同的特性
。请参见有关is null 的说明
。
  IFNULL(expr1,expr2)的用法
：
  假如expr1 不为 NULL
，则 IFNULL() 的返回值为 expr1; 否则其返回值为
expr2
。IFNULL()的返回值是数字或是字符串
，具体情况取决于其所使用的语境
。
    mysql>
SELECT IFNULL(1, 0);
-> 1
     mysql>
SELECT IFNULL(NULL, 10);
-> 10
     mysql>
SELECT IFNULL(1 / 0, 10);
-> 10
     mysql>
SELECT IFNULL(1 / 0, 'yes');
->   'yes


