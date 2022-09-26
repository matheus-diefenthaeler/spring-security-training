package diefenathaeler.matheus.springsecuritytrain.mapper;

import diefenathaeler.matheus.springsecuritytrain.dto.request.BookRequest;
import diefenathaeler.matheus.springsecuritytrain.dto.response.BookResponse;
import diefenathaeler.matheus.springsecuritytrain.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toModel(BookRequest bookRequest);

    BookResponse toResponse(Book book);
    List<BookResponse> toResponseList(List<Book> books);

}
