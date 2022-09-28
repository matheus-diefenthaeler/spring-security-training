package diefenthaeler.matheus.springsecuritytraining.service;

import diefenthaeler.matheus.springsecuritytraining.dto.request.BookRequest;
import diefenthaeler.matheus.springsecuritytraining.dto.response.BookResponse;
import diefenthaeler.matheus.springsecuritytraining.mapper.BookMapper;
import diefenthaeler.matheus.springsecuritytraining.model.Book;
import diefenthaeler.matheus.springsecuritytraining.repository.BookRepository;
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

