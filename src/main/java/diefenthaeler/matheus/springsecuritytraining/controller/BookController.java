package diefenthaeler.matheus.springsecuritytraining.controller;

import diefenthaeler.matheus.springsecuritytraining.dto.request.BookRequest;
import diefenthaeler.matheus.springsecuritytraining.dto.response.BookResponse;
import diefenthaeler.matheus.springsecuritytraining.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest bookRequest, UriComponentsBuilder uriComponentsBuilder){
        BookResponse bookResponse = bookService.create(bookRequest);
        URI uri = uriComponentsBuilder.path("/book/{id}").buildAndExpand(bookResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(bookResponse);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll(){
        List<BookResponse> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

}
