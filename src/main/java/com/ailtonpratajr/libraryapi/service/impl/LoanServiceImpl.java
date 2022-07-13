package com.ailtonpratajr.libraryapi.service.impl;

import com.ailtonpratajr.libraryapi.api.dto.LoanFilterDTO;
import com.ailtonpratajr.libraryapi.exception.BusinessException;
import com.ailtonpratajr.libraryapi.model.entity.Loan;
import com.ailtonpratajr.libraryapi.model.entity.repository.LoanRepository;
import com.ailtonpratajr.libraryapi.service.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class LoanServiceImpl implements LoanService {
    private LoanRepository repository;

    public LoanServiceImpl(LoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Loan save(Loan loan) {
        if(repository.existsByBookAndNotReturned(loan.getBook())) {
            throw new BusinessException("Book already loaned");

        }
        return repository.save(loan);
    }

    @Override
    public Optional<Loan> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Loan update(Loan loan) {
        return repository.save(loan);
    }

    @Override
    public Page<Loan> find(LoanFilterDTO filterDTO, Pageable pageable) {
        return null;
    }


}
