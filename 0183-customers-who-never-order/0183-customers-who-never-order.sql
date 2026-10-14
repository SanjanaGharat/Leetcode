SELECT C.name AS Customers
FROM Customers C
LEFT JOIN Orders o
ON C.id = o.customerID
WHERE o.customerID IS NULL ;