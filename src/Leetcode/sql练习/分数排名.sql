解法二
：
使用窗口函数
select score,
       dense_rank() over(order by Score desc) as Ranking
from Scores;
注意
，
mysql版本8已至此窗口函数这个功能
，虽然在leetcode上运行不成功
，可能的原因是后台的mysql数据库版本不是最新的
。
链接
：https://Leetcode-cn.com/problems/rank-scores/solution/tu-jie-sqlmian-shi-ti-jing-dian-pai-ming-wen-ti-by/


解法一
：
MySQL 不能直接用rank是关键字  要加引号
子查询通过与主查询查询出的分数产生关联   主查询先查询出分数再根据分数去子查询
select a.Score score,
       (select count(distinct score) from scores b where b.Score >= a.Score) as 'rank'
from scores a
order by score desc

-- 上面答案解析
拆分成两个部分写
最后的结果包含两个部分，第一部分是降序排列的分数，第二部分是每个分数对应的排名。

1、第一部分不难写：
select a.Score as Score
from Scores a
order by a.Score DESC

2、比较难的是第二部分。假设现在给你一个分数X，如何算出它的排名Rank呢？
我们可以”先提取出大于等于X的所有分数集合H，将H去重后的元素个数就是X的排名“。比如你考了99分，但最高的就只有99分，那么去重之后集合H里就只有99一个元素，个数为1，因此你的Rank为1。
先提取集合H：-------------my  一定要是大于等于才是   如果只有大于他的 则排名不准确
select b.Score from Scores b where b.Score >= X;
我们要的是集合H去重之后的元素个数，因此升级为：
select count(distinct b.Score) from Scores b where b.Score >= X as Rank;

3、而从结果的角度来看，第二部分的Rank是对应第一部分的分数来的，所以这里的X就是上面的a.Score，把两部分结合在一起为：
select a.Score                                                                 as Score,
       (select count(distinct b.Score) from Scores b where b.Score >= a.Score) as Rank
from Scores a
order by a.Score DESC
    链接：https://Leetcode-cn.com/problems/rank-scores/solution/fen-cheng-liang-ge-bu-fen-xie-hui-rong-yi-hen-duo-/

编写一个 SQL 查询来实现分数排名。
如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）：
+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+

重要提示：对于 MySQL 解决方案，如果要转义用作列名的保留字，可以在关键字之前和之后使用撇号。例如 `Rank`

来源：力扣（LeetCode）
链接：https://Leetcode-cn.com/problems/rank-scores
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。