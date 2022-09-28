package diefenthaeler.matheus.springsecuritytraining.mapper;

import diefenthaeler.matheus.springsecuritytraining.dto.request.BookRequest;
import diefenthaeler.matheus.springsecuritytraining.dto.response.BookResponse;
import diefenthaeler.matheus.springsecuritytraining.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toModel(BookRequest bookRequest);

    BookResponse toResponse(Book book);
    List<BookResponse> toResponseList(List<Book> books);

}
