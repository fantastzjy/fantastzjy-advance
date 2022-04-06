--my  麻烦了  不能用名字做筛选条件   因为会出现重名  只有id主键不会重复
select name Customers
from Customers
where id in
        (
        select id
        from Customers
        where
            id not in
            ( select Customers.id
              from Customers , Orders
              where Customers.id=Orders.CustomerId )
        )

2、官方答案 直接找不在orders表中出现的id即可

select customers.name as 'Customers'
from customers
where customers.id not in
      (
          select customerid
          from orders
      );


作者：LeetCode
链接：https://Leetcode-cn.com/problems/customers-who-never-order/solution/cong-bu-ding-gou-de-ke-hu-by-Leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。