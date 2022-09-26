package diefenathaeler.matheus.springsecuritytrain.service;

import diefenathaeler.matheus.springsecuritytrain.dto.request.BookRequest;
import diefenathaeler.matheus.springsecuritytrain.dto.response.BookResponse;
import diefenathaeler.matheus.springsecuritytrain.mapper.BookMapper;
import diefenathaeler.matheus.springsecuritytrain.model.Book;
import diefenathaeler.matheus.springsecuritytrain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper mapper;

    public BookResponse create(BookRequest bookRequest) {
        Book book = mapper.toModel(bookRequest);
        return mapper.toResponse(bookRepository.save(book));
    }

    public List<BookResponse> findAll(){
        List<Book> books = bookRepository.findAll();
        return mapper.toResponseList(books);
    }
}

