package com.kha.exception.mapper.impl;

import com.kha.exception.mapper.IMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperServiceImpl<S, T> implements IMapperService<S, T> {
    private final ModelMapper modelMapper;

    public MapperServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public T map(S from, Class<T> to) {
        return modelMapper.map(from, to);
    }
}
