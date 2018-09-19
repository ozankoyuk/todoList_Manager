package todoList_manager.todolist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

/**
 * @author Ozan Koyuk
 * @since 08/18
 */
@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Long> {

    TodoList findOneById(Long id);

    @Transactional
    void deleteById(Long id);
}
