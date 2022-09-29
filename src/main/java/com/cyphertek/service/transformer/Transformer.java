package com.cyphertek.service.transformer;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Transformer<T, A> {

    private final Function<T, A> fromDto;

    private final Function<A, T> fromEntity;

    public Transformer(Function<T, A> fromDto, Function<A, T> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final A convertFromDto(final T dto) {
        return fromDto.apply(dto);
    }

    public final List<A> createFromDtos(final Collection<T> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    public final T convertFromEntity(final A entity) {
        return fromEntity.apply(entity);
    }

    public final List<T> createFromEntities(final Collection<A> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
}
