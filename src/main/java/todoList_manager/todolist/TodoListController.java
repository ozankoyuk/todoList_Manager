package todoList_manager.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ozan Koyuk
 * @since 08/18
 */
@RestController
public class TodoListController {

    @Autowired
    private TodoListRepository repository;

    @Autowired
    private TodoItemRepository itemRepository;

    //** POST OPERATIONS **//
    /**
     * @param todoListRequest
     * @return new created To-Do list
     */
    @PostMapping("/lists")
    public ResponseEntity<TodoListCreatedResponse> create(@RequestBody TodoListRequest todoListRequest) {
        TodoList todoList = repository.save(TodoList.from(todoListRequest));
        return new ResponseEntity<>(TodoListCreatedResponse.from(todoList), HttpStatus.CREATED);
    }

    /**
     * @param id
     * @param todoItemRequest
     * @return newly created To-Do object
     */
    @PostMapping("/lists/{id}/items")
    public ResponseEntity<TodoItemCreatedResponse> createItem(@PathVariable("id") Long id, @RequestBody TodoItemRequest todoItemRequest) {
        TodoList todoList = repository.findOneById(id);
        TodoItem todoItem = itemRepository.save(TodoItem.from(todoItemRequest, todoList));
        return new ResponseEntity<>(TodoItemCreatedResponse.from(todoItem), HttpStatus.CREATED);
    }


    //** GET OPERATIONS **//
    /**
     * @param ()
     * @return all To-Do items
     */
    @GetMapping("/lists")
    public ResponseEntity<Iterable<TodoList>> list() {
        List<TodoList> temp= new ArrayList<TodoList>();

        List<TodoList> allByOwner;
        repository.findAll().forEach(temp::add);
        allByOwner = temp;

        return new ResponseEntity<>(allByOwner, HttpStatus.OK);
    }

    /**
     * @param id
     * @return To-Do list with specific input id
     */
    @GetMapping("/lists/{id}")
    public ResponseEntity<TodoList> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(repository.findOneById(id), HttpStatus.OK);
    }


    //** DELETE OPERATIONS **//

    /**
     * @param id
     * @return remove To-Do list with specific id
     */
    @DeleteMapping("/lists/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * @param id
     * @param itemId
     * @return remove a specific To-Do object from a specific list
     */
    @DeleteMapping("/lists/{id}/items/{itemId}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id,
                                         @PathVariable("itemId") Long itemId) {
        TodoList todoList = repository.findOneById(id);
        itemRepository.deleteByIdAndList(itemId, todoList);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //** UPDATE OPERATIONS **//
    /**
     * @param id
     * @param request
     * @return update a To-Do list
     */
    @PutMapping("/lists/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id,
                                         @RequestBody TodoListRequest request) {
        TodoList todoList = repository.findOneById(id);
        todoList.merge(request);
        repository.save(todoList);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * @param id
     * @param itemId
     * @param request
     * @return update a To-Do item from a list
     */
    @PutMapping("/lists/{id}/items/{itemId}")
    public ResponseEntity<String> updateItem(@PathVariable("id") Long id,
                                             @PathVariable("itemId") Long itemId,
                                             @RequestBody TodoItemRequest request) {

        TodoList todoList = repository.findOneById(id);
        System.out.println("list->>> " + todoList.toString());

        TodoItem todoItem = itemRepository.findOneByIdAndList(itemId, todoList);
        System.out.println(todoItem.toString());

        todoItem.merge(request);
        itemRepository.save(todoItem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
