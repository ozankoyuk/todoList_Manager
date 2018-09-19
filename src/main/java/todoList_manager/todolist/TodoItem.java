package todoList_manager.todolist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

/**
 * @author Ozan Koyuk
 * @since 08/18
 */

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"list"})
@Table(name="todo_item")
public class TodoItem {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean completed;

    // try EAGERly
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TODO_LIST_ID")
    @JsonIgnore
    private TodoList list;

    public TodoItem(String name, TodoList list) {
        this.name = name;
        this.list = list;
    }

    public static TodoItem from(TodoItemRequest todoItemRequest, TodoList todoList) {
        return new TodoItem(todoItemRequest.getName(), todoList);

    }

    public void merge(TodoItemRequest request) {
        this.name = request.getName();
        this.completed = request.isCompleted();
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoList getList() {
        return list;
    }



}
