SELECT c.customer_id
FROM Customer c
left join Product p
on c.product_key = p.product_key
group by c.customer_id
HAVING COUNT(DISTINCT c.product_key) = (SELECT COUNT(*) FROM Product)