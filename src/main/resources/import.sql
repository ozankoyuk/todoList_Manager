insert into todo_list(id, name ) values (1, 'ToDo List 1');
--insert into todo_list(id, name ) values (2, 'Test List 2');

insert into todo_item(id, name, todo_list_id, completed) values (1, 'TodoItem 1', 1, FALSE);
insert into todo_item(id, name, todo_list_id, completed) values (2, 'TodoItem 2', 1, FALSE);
insert into todo_item(id, name, todo_list_id, completed) values (3, 'TodoItem 3', 1, FALSE);

--insert into todo_item(id, name, todo_list_id, completed ) values (4, 'Item A', 2, FALSE);
--insert into todo_item(id, name, todo_list_id, completed ) values (5, 'Item B', 2, FALSE);
--insert into todo_item(id, name, todo_list_id, completed ) values (6, 'Item C', 2, FALSE);