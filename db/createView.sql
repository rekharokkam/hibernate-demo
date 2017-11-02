create or replace
 view v_user_credential as

select fu.USER_ID, FIRST_NAME, LAST_NAME, username, password from finances_user fu
join credential c on fu.USER_ID = c.USER_ID
where c.USER_ID = fu.USER_ID