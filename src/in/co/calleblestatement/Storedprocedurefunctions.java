//
//# Stored Procedure (in)
//
//mysql> delimiter &&
//mysql> create procedure empIn(in c int)
//    -> begin
//    -> select * from emp where id = c;
//    -> end &&
//    
//mysql> set @input = 11;
//
//mysql> call empIn(@input);
//
//========================================================== 
//
//# Stored Procedure (out)
//
//mysql> delimiter &&
//mysql> create procedure empOut(out c int)
//    -> begin
//    -> select salary into c from emp where id = 10;
//    -> end &&
//    
//mysql> call empOut(@output);
//
//mysql> select @output;    
//  
//==========================================================  
//    
//# Stored Procedure (inout)
//
//mysql> delimiter &&
//mysql> create procedure empInOut(inout c int)
//    -> begin
//    -> select salary into c from emp where id = c;
//    -> end &&
//    
//mysql> set @inout = 1;
//
//mysql> call empInOut(@inout);
//
//mysql> select @inout;
//    
//========================================================== 
//
//# Stored Function
//
//mysql> delimiter &&
//mysql> create function square(num int)
//    -> returns int
//    -> deterministic
//    -> begin
//    -> declare result int;
//    -> set result = num * num;
//    -> return result;
//    -> end &&
//    
//mysql> select square(10);
