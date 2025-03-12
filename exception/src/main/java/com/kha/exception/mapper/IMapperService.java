package com.kha.exception.mapper;


public interface IMapperService<S, T> {
    T map(S from, Class<T> to);
}
