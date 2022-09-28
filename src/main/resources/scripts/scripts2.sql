create procedure getAllUsers()
begin
	select * from Users;
end

call getAllUsers();