package todoList_manager.todolist;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ozan Koyuk
 * @since 08/18
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="todo_list")
public class TodoList {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "list",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<TodoItem> items = new ArrayList<>();


    public TodoList(String name) {
        this.name = name;
    }

    public static TodoList from(TodoListRequest todoListRequest) {
        return new TodoList(todoListRequest.getName());
    }

    public void merge(TodoListRequest request) {
        setName(request.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoItem> getItems() {
        return items;
    }

    public void setItems(List<TodoItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
