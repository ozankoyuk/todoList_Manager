package todoList_manager.todolist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

/**
 * @author Ozan Koyuk
 * @since 08/18
 */
@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
    TodoItem findOneByIdAndList(Long id, TodoList todoList);

    @Transactional
    void deleteByIdAndList(Long id, TodoList todoList);
}
