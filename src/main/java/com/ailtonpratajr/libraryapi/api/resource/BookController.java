package com.ailtonpratajr.libraryapi.api.resource;

import com.ailtonpratajr.libraryapi.api.dto.BookDTO;
import com.ailtonpratajr.libraryapi.model.entity.Book;
import com.ailtonpratajr.libraryapi.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService service;
    private ModelMapper modelMapper;

    public BookController(BookService service, ModelMapper mapper) {
        this.service = service;
        this.modelMapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO dto){

        Book entity = modelMapper.map(dto, Book.class);
        entity = service.save(entity);
        return modelMapper.map(entity, BookDTO.class);
    }
}
