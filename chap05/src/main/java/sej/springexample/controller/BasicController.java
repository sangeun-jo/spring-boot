package sej.springexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sej.springexample.model.Todo;
import sej.springexample.model.TodoResource;
import sej.springexample.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {
    // 매번 다른 long 타입 Todo 인스턴스를 생성하게 해줌. 웹에서 요청할 때마다 다른 Todo 인스턴스를 생성해서 오류생기지 않도록 하는 역할
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/todo")
    public Todo basic() {
        return new Todo(counter.incrementAndGet(), "라면 사오기");
    }

    @RequestMapping(value = "/todop", method = RequestMethod.POST)
    // Requestparam 어노테이션 사용시, value를 키로 해서 클라이언트로부터 응답 수신 가능
    public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle) {
        return new Todo(counter.incrementAndGet(), todoTitle);
    }

    @RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
    public Todo getPath(@PathVariable int todoId) {
        Todo todo1 = new Todo(1L, "문서쓰기");
        Todo todo2 = new Todo(2L, "기획회의");
        Todo todo3 = new Todo(3L, "운동");

        Map<Integer, Todo> todoMap = new HashMap<>();
        todoMap.put(1, todo1);
        todoMap.put(2, todo2);
        todoMap.put(3, todo3);

        return todoMap.get(todoId);
    }

    // 주소창에서 title 입력받아서 title 이랑 실행 URL 반환
    @RequestMapping(value = "/todoh", method = RequestMethod.GET)
    public ResponseEntity<TodoResource> geth (@RequestParam(value = "todoTitle") String todoTitle) {
        TodoResource todoResource = new TodoResource(todoTitle);
        todoResource.add(linkTo(methodOn(BasicController.class).geth(todoTitle)).withSelfRel());
        return new ResponseEntity(todoResource, HttpStatus.OK);
    }

}
