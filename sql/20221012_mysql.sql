select * from emp;

select ename, job
from emp;

-- null을 원하는 값으로 치환한다. ifnull(원본컬럼, 대치값) 
select sal, ifnull(comm, 0)
from emp;

select concat(ename, ' is a ', job) newName
from emp