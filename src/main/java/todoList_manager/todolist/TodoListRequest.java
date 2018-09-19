package todoList_manager.todolist;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ozan Koyuk
 * @since 08/18
 */
@Data
@NoArgsConstructor
public class TodoListRequest {

    private String name;

    public TodoListRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
