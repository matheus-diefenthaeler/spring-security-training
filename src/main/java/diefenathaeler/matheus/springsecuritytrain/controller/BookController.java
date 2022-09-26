package diefenathaeler.matheus.springsecuritytrain.controller;

import diefenathaeler.matheus.springsecuritytrain.dto.request.BookRequest;
import diefenathaeler.matheus.springsecuritytrain.dto.response.BookResponse;
import diefenathaeler.matheus.springsecuritytrain.service.BookService;
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
