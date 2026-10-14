SELECT E.name AS Employee
FROM Employee E
LEFT JOIN Employee M
ON E.managerId = M.id
WHERE E.salary > M.salary